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
	    
	    <h2>Login Page</h2>
	    
	    <form method="POST" action="/spring/login">
	    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	    
	    	<div><input type="text" name="username" placeholder="아이디" required></div>
	    	<div><input type="password" name="password" placeholder="비밀번호" required></div>
	    	<div><button class="in">로그인</button></div>
	    </form>
	</body>
</html>