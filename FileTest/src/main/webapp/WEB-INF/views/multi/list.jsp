<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
		<style>
			th:first-child {
				width: 50px;
			}
			th:nth-child(2) {
				width: auto;
			}
			th:nth-child(3) {
				width: 140px;
			}
			th:last-child {
				width: 180px;
			}
			td:nth-child(3) span {
				float: left;
			}
		</style>
	</head>
	<body>
	    <h1>장소 <small>목록</small></h1>
	    
	    <table>
	    	<tr>
	    		<th>번호</th>
	    		<th>제목</th>
	    		<th>파일</th>
	    		<th>날짜</th>
	    	</tr>
	    	<c:forEach var="dto" items="${list}">
	    		<tr>
	    			<td>${dto.seq}</td>
	    			<td><a href="/file/multi/view.do?seq=${dto.seq}">${dto.subject}</a></td>
	    			<td>
						<c:forEach var="i" begin="1" end="${dto.picCount}">
							<span class="material-symbols-outlined">imagesmode</span>
						</c:forEach>
					</td>
	    			<td>${dto.regdate}</td>
	    		</tr>
	    	</c:forEach>
	    </table>
	    
	    <div><button type="button" class="add" onclick="location.href='/file/multi/add.do';">등록</button></div>
	</body>
</html>