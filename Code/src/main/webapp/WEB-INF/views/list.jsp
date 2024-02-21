<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
		<style>
			#filter {
				text-align: right;
				padding-right: 2rem;
			}
			#filter input {
				background-color: #FFF;
			}
			#main {
				display: grid;
				grid-template-columns: repeat(3, 1fr);
			}
			.item {
				width: 240px;
				border: 1px solid #AAA;
				margin: 5px;
				cursor: pointer;
			}
			.item > div:first-child {
				padding: 0.5rem;
			}
			.item > div:nth-child(2) {
				display: flex;
				align-items: center;
				justify-content: center;
				min-height: 150px;
				border-top: 1px solid #AAA;
				border-bottom: 1px solid #AAA;
			}
			.item > div:last-child {
				text-align: right;
				padding: 0.5rem;
			}
		</style>
	</head>
	<body>
	    <h1>Code <small>list</small></h1>
	    
	    <div id="filter">
	    	<input type="button" value="Java" data-language="java" data-color="cornflowerblue" data-selected="0">
	    	<input type="button" value="SQL" data-language="sql" data-color="tomato" data-selected="0">
	    	<input type="button" value="HTML" data-language="html" data-color="gold" data-selected="0">
	    	<input type="button" value="CSS" data-language="css" data-color="yellowgreen" data-selected="0">
	    	<input type="button" value="JavaScript" data-language="js" data-color="orange" data-selected="0">
	    </div>
	    <div id="main">
	    	<c:forEach var="dto" items="${list}">
	    		<div class="item" onclick="location.href='/code/view.do?seq=${dto.seq}';">
	    			<c:choose>
	    				<c:when test="${dto.language == 'java'}">
	    					<c:set var="color" value="cornflowerblue" />
	    				</c:when>
	    				<c:when test="${dto.language == 'sql'}">
	    					<c:set var="color" value="tomato" />
	    				</c:when>
	    				<c:when test="${dto.language == 'html'}">
	    					<c:set var="color" value="gold" />
	    				</c:when>
	    				<c:when test="${dto.language == 'css'}">
	    					<c:set var="color" value="yellowgreen" />
	    				</c:when>
	    				<c:when test="${dto.language == 'js'}">
	    					<c:set var="color" value="orange" />
	    				</c:when>
	    				<c:otherwise>
	    					<c:set var="color" value="white" />
	    				</c:otherwise>
	    			</c:choose>
	    			
	    			<div style="background-color: ${color};">${dto.language}</div>
	    			<div>${dto.subject}</div>
	    			<div>${dto.regdate}</div>
	    		</div>
	    	</c:forEach>
	    </div>
	    <div><button type="button" class="add" onclick="location.href='/code/add.do';">등록</button></div>
	
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script>
			$('#filter > input').click(function () {
				if ($(this).data('selected') == 0) {
					$(this).data('selected', '1');
					$(this).css('background-color', $(this).data('color'));
				} else {
					$(this).data('selected', '0');
					$(this).css('background-color', '#FFF');
				}
				
				let param = '';
				
				$('#filter > input').each(function (index, item) {
					if ($(item).data('selected') == '1') {
						param += 'language=' + $(item).data('language') + '&';
					}
				});
			
				location.href = '/code/list.do?' + param;
			});
			
			<c:forEach var="lang" items="${language}">
				$('#filter input[data-language="${lang}"]').data('selected', '1');
				$('#filter input[data-language="${lang}"]').css('background-color', $('#filter input[data-language="${lang}"]').data('color'));
			</c:forEach>
		</script>
	</body>
</html>