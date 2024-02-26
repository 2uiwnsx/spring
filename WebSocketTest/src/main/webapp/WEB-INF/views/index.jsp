<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
	</head>
	<body>
	    <h1>WebSocket <small>채팅</small></h1>
	    
	    <div>
	    	<div class="group">
	    		<label>대화명</label>
	    		
	    		<input type="text" name="name" id="name" class="short">
	    		
	    		<button type="button" class="in" style="margin-left: 10px">접속</button>
	    	</div>
	    </div>
	    
	    <hr>
	    
	    <div>
	    	<button type="button" class="in" data-name="강아지">강아지</button>
	    	<button type="button" class="in" data-name="고양이">고양이</button>
	    	<button type="button" class="in" data-name="병아리">병아리</button>
	    	<button type="button" class="in" data-name="호랑이">호랑이</button>
	    	<button type="button" class="in" data-name="돌고래">돌고래</button>
	    </div>
		
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script>
			$('.in').click (function () {
				let name = $('#name').val();
				
				if ($(event.target).data('name') != undefined) {
					name = $(event.target).data('name');
				}
				
				let child = window.open('/socket/chat.do', 'chat', 'width=404,height=510');
				
				child.addEventListener('load', function () {
					child.connect(name);
				});
				
				$('#name').prop('readOnly', true);
				
				$('.in').css('opacity', 0.5).prop('disabled', true);
			});
		</script>
	</body>
</html>