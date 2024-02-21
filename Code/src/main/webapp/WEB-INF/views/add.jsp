<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
	</head>
	<body>
	    <h1>Code <small>add</small></h1>
	    
	    <form method="POST" action="/code/add_ok.do">
	    	<table class="vertical">
	    		<tr>
	    			<th>제목</th>
	    			
	    			<td><input type="text" name="subject" class="full" required></td>
	    		</tr>
	    		<tr>
	    			<th>코드</th>
	    			
	    			<td><textarea name="code" class="full" required></textarea></td>
	    		</tr>
	    		<tr>
	    			<th>언어</th>
	    			
	    			<td>
	    				<select name="language">
	    					<option value="java">Java</option>
	    					<option value="sql">SQL</option>
	    					<option value="html">HTML</option>
	    					<option value="css">CSS</option>
	    					<option value="js">JavaScript</option>
	    				</select>
	    			</td>
	    		</tr>
	    	</table>
	    	
	    	<div>
	    		<button type="submit" class="add">등록</button>
	    		<button type="button" class="back" onclick="location.href='/code/list.do';">취소</button>
	    	</div>
	    </form>
	</body>
</html>