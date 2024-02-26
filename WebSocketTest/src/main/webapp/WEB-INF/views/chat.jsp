<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
		<style>
			body {
				overflow: hidden;
			}
			body > div {
				display: grid;
				grid-template-rows: repeat(12, 1fr);
				width: 400px;
				height: 510px;
				padding: 0;
				margin: 3px;
			}
			#header > h2 {
				padding: 5px;
				margin: 0;
				margin-bottom: 10px;
			}
			#list {
				grid-row-start: 2;
				grid-row-end: 12;
				border: 1px solid var(--border-color);
				overflow: scroll;
				padding: 0.5rem;
			}
			#list .item {
				font-size: 14px;
				margin: 15px 0;
			}
			#list .me {
				text-align: right;
			}
			#list .other {
				text-align: left;
			}
			#list .item > div:first-child {
				display: flex;
				justify-content: flex-end;
			}
			#list .other > div:first-child {
				flex-direction: row-reverse;
			}
			#list .item > div:last-child {
				font-size: 10px;
				color: #777;
				margin-top: 5px;
			}
			#list .item > div:first-child > div:first-child {
				font-size: 10px;
				color: #777;
				margin: 3px 5px;
			}
			#list .item > div:first-child > div:last-child {
				min-width: 100px;
				max-width: 250px;
				text-align: left;
				border: 1px solid var(--border-color);
				padding: 3px 7px;
			}
			#list .state > div:first-child > div:last-child {
				background-color: #EEE;
			}
			#list .msg img {
				width: 150px;
			}
			#list .me.msg > div:first-child > div:last-child {
				background-color: rgba(255, 99, 71, 0.2);
			}
			#list .other.msg > div:first-child > div:last-child {
				background-color: rgba(100, 149, 237, 0.2);
			}
			#msg {
				margin-top: 5px;
			}
		</style>
	</head>
	<body>
		<div>
			<div id="header"><h2>WebSocket <small>대화명</small></h2></div>
			<div id="list"></div>
			
			<input type="text" id="msg" placeholder="내용을 입력하세요.">
		</div>
		
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script>
			function scroll() {
				$('#list').scrollTop($('#list').outerHeight() + 300);
			}
			
			function print(sender, receiver, type, content, regdate) {
				let temp = `
					<div class="item \${receiver} \${type}">
						<div>
							<div>\${sender}</div>
							<div>\${content}</div>
						</div>
						<div>\${regdate}</div>
					</div>
				`;
				
				$('#list').append(temp);
				
				scroll();
			}
			
			function printEmoticon(sender, receiver, type, content, time) {
				let temp = `
					<div class="item \${receiver} \${type}">
						<div>
							<div>\${sender}</div>
							<div style="background-color: #FFF; border: 0;"><img src="/socket/resources/emoticon/\${content}.png"></div>
						</div>
						<div>\${regdate}</div>
					</div>
				`;
				
				$('#list').append(temp);

				setTimeout(scroll, 100);			
			}
			
			let ws;
		
			function connect(name) {
				window.name = name;
				
				$('#header small').text(window.name);
				
				ws = new WebSocket('ws://localhost:8100/socket/chat-server.do');
				
				ws.onopen = function (evt) {
					let message = {
						code: '1',
						sender: window.name,
						receiver: '',
						content: '',
						regdate: (new Date().toLocaleString())
					};
					
					ws.send(JSON.stringify(message));
					
					$('#msg').focus();
				};
				
				ws.onmessage = function (evt) {
					let message = JSON.parse(evt.data);
					
					if (message.code == '1') {
						print('', 'other', 'state', `[\${message.sender}]님이 들어왔습니다.`, message.regdate);
					} else if (message.code == '2') {
						print('', 'other', 'state', `[\${message.sender}]님이 나갔습니다.`, message.regdate);
					} else if (message.code == '3') {
						print(message.sender, 'other', 'msg', message.content, message.regdate);
					} else {
						printEmoticon(message.sender, 'other', 'msg', message.content, message.regdate);
					}
				}
			}
			
			$('#msg').keydown(function (evt) {
				if (evt.keyCode == 13) {
					let message = {
						code: '3',
						sender: window.name,
						receiver: '',
						content: $('#msg').val(),
						regdate: (new Date().toLocaleString())
					};
					
					if ($('#msg').val().startsWith('/')) {
						message.code = '4';
						message.content = message.content.substring(1);
					}
					
					ws.send(JSON.stringify(message));
					
					if (message.code == '3') {
						print(window.name, 'me', 'msg', message.content, message.regdate);
					} else if (message.code == '4') {
						printEmoticon(window.name, 'me', 'msg', message.content, message.regdate);
					}
					
					$('#msg').val('').focus();
				}
			});
			
			function disconnect() {
				let message = {
					code: '2',
					sender: window.name,
					receiver: '',
					content: '',
					regdate: (new Date().toLocaleString())
				};
				
				ws.send(JSON.stringify(message));
			}

			$(window).on('beforeunload', function () {
				disconnect();
				
				$(opener.document).find('.in').css('opacity', 1).prop('disabled', false);
			});
		</script>
	</body>
</html>