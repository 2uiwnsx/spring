<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>Insert title here</title>
		<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	   
		<div class="list">
	   		<div></div>
	   		<div></div>
	   		<div></div>
	   		<div></div>
		</div>
		<div>
			<button type="button" class="del" onclick="del();">삭제</button>
			<button type="button" class="list" onclick="location.href='/client/list.do';">취소</button>
		</div>
		
		<script>
			$.ajax({
				type: 'GET',
				url: 'http://localhost:8100/rest/address/${seq}',
				dataType: 'json',
				success: response => {
					$('.list > div:first-child').text(response.name);
					$('.list > div:nth-child(2)').text(response.age);
					$('.list > div:nth-child(3)').text(response.gender);
					$('.list > div:last-child').text(response.address);
				},
				error: function (jqXHR, textStatus, errorThrown) {
					console.log(jqXHR, textStatus, errorThrown);
				}
			});
			
			function del() {
				$.ajax({
					type: 'DELETE',
					url: 'http://localhost:8100/rest/address/${seq}',
					dataType: 'json',
					success: response => {
						if (response == 1) {
							location.href = '/client/list.do';
						} else {
							alert('삭제에 실패했습니다.');
						}
					},
					error: function (jqXHR, textStatus, errorThrown) {
						console.log(jqXHR, textStatus, errorThrown);
					}
				});
			}
		</script>
	</body>
</html>