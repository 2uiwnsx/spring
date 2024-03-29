<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
	</head>
	<body>
	    <h1>데이터 전송 <small>단일값</small></h1>
	    
	    <form method="POST" action="/spring/ex05_ok.do">
	    	<div><input type="text" name="data"></div>
	    	<div><input type="submit" value="전송"></div>
	    </form>
	    
	    <h1>데이터 전송 <small>복합값</small></h1>
	    
	    <form method="POST" action="/spring/ex05_ok.do">
	    	<input type="hidden" name="seq" value="5">
	    	
	    	<div>이름 <input type="text" name="name"></div>
	    	<div>나이 <input type="text" name="age"></div>
	    	<div>주소 <input type="text" name="address"></div>
	    	<div><input type="submit" value="전송"></div>
	    </form>
	    
	    <h1>데이터 전송 <small>다중값</small></h1>
	    
	    <form method="POST" action="/spring/ex05_ok.do">
	    	<div><input type="checkbox" name="cb" value="red"> 빨강</div>
	    	<div><input type="checkbox" name="cb" value="blue"> 파랑</div>
	    	<div><input type="checkbox" name="cb" value="yellow"> 노랑</div>
	    	<div><input type="checkbox" name="cb" value="black"> 검정</div>
	    	<div><input type="checkbox" name="cb" value="green"> 초록</div>
	    	<div><input type="submit" value="전송"></div>
	    </form>
	</body>
</html>