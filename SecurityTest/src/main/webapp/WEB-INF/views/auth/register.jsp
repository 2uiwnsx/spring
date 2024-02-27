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
	    
	    <h2>Register Page</h2>
	    
	    <form method="POST" action="/spring/auth/register_ok.do">
	    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	    	
	    	<table class="vertical">
	    		<tr>
	    			<th>아이디</th>
	    			
	    			<td><input type="text" name="id" required></td>
	    		</tr>
	    		<tr>
	    			<th>비밀번호</th>
	    			
	    			<td><input type="password" name="pswd" required></td>
	    		</tr>
	    		<tr>
	    			<th>이름</th>
	    			
	    			<td><input type="text" name="name" required></td>
	    		</tr>
	    		<tr>
	    			<th>권한</th>
	    			
	    			<td>
						<select name="auth">
							<option value="1">회원</option>
							<option value="2">관리자</option>
						</select>
					</td>
	    		</tr>
	    	</table>
	    	
	    	<div><input type="submit" value="가입"></div>
	    </form>
	</body>
</html>