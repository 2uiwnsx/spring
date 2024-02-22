<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
	</head>
	<body>
	    <h1>파일 업로드</h1>
	    
	    <form method="POST" action="/file/add_ok.do" enctype="multipart/form-data">
	    	<table class="vertical">
	    		<tr>
	    			<th>파일</th>
	    			
	    			<td><input type="file" name="attach"></td>
	    		</tr>
	    	</table>
	    	
	    	<div><button>업로드</button></div>
	    </form>
	</body>
</html>