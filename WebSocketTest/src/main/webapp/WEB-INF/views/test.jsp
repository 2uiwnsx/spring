<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
	</head>
	<body>
	    <h1>WebSocket <small>연결 테스트</small></h1>
	    
	    <div>
	    	<button type="button" id="openBtn" class="in">연결</button>
	    	<button type="button" id="closeBtn" class="out">종료</button>
	    </div>
	    
	    <hr>
	    
	    <div>
	    	<input type="text" id="msg" class="long">
	    	
	    	<button type="button" id="msgBtn">전송</button>
	    </div>
	    <div class="message full"></div>
	
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script>
			function log(msg) {
				$('.message').append(`
					<div>[\${new Date().toLocaleTimeString()}] \${msg}</div>		
				`);
			}
			
			let ws;
			
			$('#openBtn').click(function () {
				ws = new WebSocket('ws://localhost:8100/socket/test-server.do');

				ws.onopen = function (evt) {
					log('서버와 연결되었습니다.');
				};
				
				ws.onmessage = function (evt) {
					log("수신한 메시지: " + evt.data);
				};
				
				ws.onerror = function (evt) {
					log('발생한 에러: ' + evt.message);
				};
				
				ws.onclose = function (evt) {
					log('서버와의 연결이 종료되었습니다.');
				};
			});

			$('#msgBtn').click(function () {
				ws.send($('#msg').val());
				
				log('메시지를 전송했습니다.');
				
				$('#msg').val('');
			});
			
			$('#closeBtn').click(function () {
				ws.close();
			});
		</script>
	</body>
</html>