package com.test.model;

import java.util.List;

import lombok.Data;

@Data
public class LocDTO {
	
	private String seq;
	private String subject;
	private String content;
	private String regdate;
	
	private int picCount;
	private List<PicDTO> picList;

}
