<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
	</head>
	<body>
		<%@ include file="/WEB-INF/inc/header.jsp" %>
	    
	    <h2>Info Page</h2>
	    
	    <div class="message" title="principal">
	    	<div><sec:authentication property="principal" /></div>
	    </div>
	    <div class="message" title="MemberDTO">
	    	<div><sec:authentication property="principal.dto" /></div>
	    </div>
	    <div class="message" title="아이디">
	    	<div><sec:authentication property="principal.username" /></div>
	    	<div><sec:authentication property="principal.dto.id" /></div>
	    </div>
	    <div class="message" title="권한">
	    	<div><sec:authentication property="principal.dto.authList" /></div>
	    </div>
	</body>
</html>