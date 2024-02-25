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
	    <table>
		    <c:forEach var="dto" items="${list}">
		    	<tr>
		    		<td>${dto.name}</td>
		    		<td>${dto.age}</td>
		    		<td>${dto.gender}</td>
		    		<td>${dto.address}</td>
		    		<td>${dto.regdate}</td>
		    	</tr>
	    	</c:forEach>
	    </table>
	    
	    <hr>
	    
	    <div>${dto}</div>
	</body>
</html>