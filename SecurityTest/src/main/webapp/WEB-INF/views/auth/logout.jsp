<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
	</head>
	<body>
		<%@ include file="/WEB-INF/inc/header.jsp" %>
	    
	    <h2>Logout Page</h2>
	    
	    <form method="POST" action="/spring/auth/logout.do">
	    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	    	
	    	<div><button class="out">로그아웃</button></div>
	    </form>
	</body>
</html>