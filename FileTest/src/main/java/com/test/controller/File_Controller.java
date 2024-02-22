package com.test.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDirectory;
import com.test.model.FileDAO;
import com.test.model.LocDTO;
import com.test.model.PicDTO;

@Controller
public class File_Controller {
	
	@Autowired
	private FileDAO dao;
	
	@GetMapping(value = "/add.do")
	public String add() {

		return "add";

	}
	
	@PostMapping(value = "/add_ok.do")
	public String add_ok(HttpServletRequest req, MultipartFile attach, Model model) {
		
		try {
			
			String path = req.getRealPath("/resources/files");
			
			String fileName = UUID.randomUUID() + "_" + attach.getOriginalFilename();
			
			attach.transferTo(new File(path + "\\" + fileName));
			
			model.addAttribute("fileName", fileName);
			model.addAttribute("originalFileName", attach.getOriginalFilename());
			
		} catch (Exception e) {

			e.printStackTrace();

		}

		return "add_ok";

	}
	
	@ResponseBody
	@GetMapping(value = "/download.do", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(HttpServletRequest req, @RequestHeader("User-Agent") String userAgent, String fileName) {

		String path = req.getRealPath("/resources/files");
		
		Resource resource = new FileSystemResource(path + "\\" + fileName);

		if (resource.exists() == false) {
			
			return (new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
		}

		String resourceName = resource.getFilename();
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);

		HttpHeaders headers = new HttpHeaders();
		
		try {

			String downloadName = null;

			if (userAgent.contains("Trident")) {
				
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", " ");
			
			} else if (userAgent.contains("Edge")) {
				
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");
			
			} else {
				
				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
			
			}

			headers.add("Content-Disposition", "attachment; filename=" + downloadName);

		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
			
		}

		return (new ResponseEntity<Resource>(resource, headers, HttpStatus.OK));
		
	}
	
	@GetMapping(value = "/multi/list.do")
	public String list(Model model) {
		
		List<LocDTO> list = dao.list();
		
		model.addAttribute("list", list);

		return "multi/list";

	}
	
	@GetMapping(value = "/multi/add.do")
	public String multiAdd() {

		return "multi/add";

	}
	
	@PostMapping(value = "/multi/add_ok.do")
	public String multi_add_ok(HttpServletRequest req, MultipartFile[] attach, LocDTO dto) {

		dto.setPicList(new ArrayList<PicDTO>());
		
		for (MultipartFile file : attach) {
			
			try {
				
				String path = req.getRealPath("/resources/files");
				
				String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
				
				file.transferTo(new File(path + "\\" + fileName));

				PicDTO picDto = new PicDTO();
				
				picDto.setFileName(fileName);
				
				dto.getPicList().add(picDto);
				
			} catch (Exception e) {

				e.printStackTrace();

			}
			
		}
		
		int result = dao.add(dto);
		
		if (result > 0) {
			
			return "redirect:/multi/list.do";
			
		} else {
			
			return "redirect:/multi/add.do";
			
		}

	}
	
	@GetMapping(value = "/multi/view.do")
	public String view(HttpServletRequest req, String seq, Model model) {
		
		LocDTO dto = dao.view(seq);
		
		model.addAttribute("dto", dto);
		
		PicDTO picDto = dto.getPicList().get(0);
		
		if (picDto != null) {
			
			try {
				
				File file = new File(req.getRealPath("/resources/files/" + picDto.getFileName()));

				Metadata metadata = ImageMetadataReader.readMetadata(file);
				
				GpsDirectory gps = metadata.getFirstDirectoryOfType(GpsDirectory.class);
				
				if (gps.containsTag(GpsDirectory.TAG_LATITUDE) && gps.containsTag(GpsDirectory.TAG_LONGITUDE)) {
					
					double lat = gps.getGeoLocation().getLatitude();
					double lng = gps.getGeoLocation().getLongitude();
					
					model.addAttribute("lat", lat);
					model.addAttribute("lng", lng);
					
				}

			} catch (Exception e) {

				e.printStackTrace();

			}
			
		}

		return "multi/view";

	}

}
