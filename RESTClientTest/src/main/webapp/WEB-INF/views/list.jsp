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
	    
	    <div class="list full"></div>
	    <div><button type="button" class="add" onclick="location.href='/client/add.do';">등록</button></div>
		
		<script>
			$.ajax({
				type: 'GET',
				url: 'http://localhost:8100/rest/address',
				dataType: 'json',
				success: response => {
					$(response).each((index, item) => {
						let gender = (item.gender == 'm') ? 'male' : 'female';
						
						$('.list').append(`
							<div class="item" onclick="view(\${item.seq});">
						    	<div class="name">\${item.name} <span class="material-symbols-outlined \${gender}">\${gender}</span></div>
						    	<div class="address">\${item.address}</div>
					    	</div>
						`);
					});
				},
				error: function (jqXHR, textStatus, errorThrown) {
					console.log(jqXHR, textStatus, errorThrown);
				}
			});
			
			function view(seq) {
				location.href = '/client/view.do?seq=' + seq;
			}
		</script>
	</body>
</html>