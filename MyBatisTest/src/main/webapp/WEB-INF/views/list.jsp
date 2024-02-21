<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
	</head>
	<body>
	    <h1>결과</h1>
	    
	    <div class="message" title="insert() & update() & delete()">${result}</div>
	    <div class="message" title="selectOne()">${count}</div>
	    <div class="message" title="selectList()">${dto}</div>
	    <div class="list">
	    	<c:forEach var="name" items="${nameList}">
	    		<div>${name}</div>
	    	</c:forEach>
	    </div>
	    <div class="list">
	    	<c:forEach var="dto" items="${list}">
	    		<div>${dto.name} / ${dto.age} / ${dto.gender} / ${dto.address}</div>
	    	</c:forEach>
	    </div>
	    <div class="list">
	    	<c:forEach var="info" items="${infoList}">
	    		<div>${info}</div>
	    	</c:forEach>
	    </div>
	</body>
</html>