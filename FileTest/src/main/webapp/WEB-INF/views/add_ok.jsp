<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
	</head>
	<body>
	    <h1>결과</h1>
	    
	    <div class="message" title="파일명"><a href="/file/resources/files/${fileName}" download>${fileName}</a></div>
	    <div class="message" title="파일명"><a href="/file/download.do?fileName=${fileName}">${originalFileName}</a></div>
	</body>
</html>