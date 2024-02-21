<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
	</head>
	<body>
	    <h1>입력</h1>
	    
	    <form method="POST" action="/mybatis/add_ok.do">
	    	<table class="vertical">
	    		<tr>
	    			<th>이름</th>
	    			
	    			<td><input type="text" name="name" class="short" required></td>
	    		</tr>
	    		<tr>
	    			<th>나이</th>
	    			
	    			<td><input type="number" name="age" class="short" required></td>
	    		</tr>
	    		<tr>
	    			<th>주소</th>
	    			
	    			<td><input type="text" name="address" class="full" required></td>
	    		</tr>
	    		<tr>
	    			<th>성별</th>
	    			
	    			<td>
	    				<select name="gender">
	    					<option value="m">남자</option>
	    					<option value="f">여자</option>
	    				</select>
	    			</td>
	    		</tr>
	    	</table>
	    	
	    	<div><button>등록</button></div>
	    </form>
	</body>
</html>