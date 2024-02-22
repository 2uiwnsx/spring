<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
		<style>
			th {
				width: 150px;
			}
			tr:first-child td:nth-child(2) {
				width: 150px;
			}
			tr:nth-child(3) td {
				height: 100px;
			}
			tr:nth-child(4) img {
				display: block;
				max-width: 700px;
				border: 1px solid #CCC;
				border-radius: 3px;
				padding: 5px;
				margin: 15px auto;
			}
			#map {
				width: 700px;
				height: 500px;
				border: 1px solid #CCC;
				border-radius: 3px;
				margin: 15px auto;
			}
		</style>
	</head>
	<body>
	    <h1>장소 <small>상세</small></h1>
	    
	    <table>
	    	<tr>
	    		<th>번호</th>
	    		
	    		<td>${dto.seq}</td>
	    		
	    		<th>날짜</th>
	    		
	    		<td>${dto.regdate}</td>
	    	</tr>
	    	<tr>
	    		<th>제목</th>
	    		
	    		<td colspan="3">${dto.subject}</td>
	    	</tr>
	    	<tr>
	    		<th>내용</th>
	    		
	    		<td colspan="3"><c:out value="${dto.content}"></c:out></td>
	    	</tr>
	    	<tr>
	    		<td colspan="4">
	    			<c:forEach var="picDto" items="${dto.picList}">
	    				<img src="/file/resources/files/${picDto.fileName}">
	    			</c:forEach>
	    		</td>
	    	</tr>
	    	<c:if test="${not empty lat}">
		    	<tr>
		    		<td colspan="4">
		    			<div id="map"></div>
		    		</td>
		    	</tr>
		    </c:if>
	    </table>
	    
	    <div><button type="button" class="back" onclick="location.href='/file/multi/list.do';">이전</button></div>
		
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aeb679ca6f4fc37a18d0b8a659787e47"></script>
		<script>
			<c:if test="${not empty lat}">
				const container = document.getElementById('map');
				const options = {
					center: new kakao.maps.LatLng(${lat}, ${lng}),
					level: 3
				};

				const map = new kakao.maps.Map(container, options);
				
				const marker = new kakao.maps.Marker({
					position: new kakao.maps.LatLng(${lat}, ${lng})
				});
				
				marker.setMap(map);
			</c:if>
		</script>
	</body>
</html>