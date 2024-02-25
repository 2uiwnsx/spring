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
		
		<table>
			<tr>
				<td><input type="text" name="name" class="full" placeholder="이름" required></td>
			</tr>
			<tr>
				<td><input type="text" name="age" class="full" placeholder="나이" required></td>
			</tr>
			<tr>
				<td>
					<select name="gender">
						<option value="m">남자</option>
						<option value="f">여자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="text" name="address" class="full" placeholder="주소" required></td>
			</tr>
		</table>
		
		<div>
			<button type="button" class="add" onclick="add();">등록</button>
			<button type="button" class="list" onclick="location.href='/client/list.do';">취소</button>
		</div>
		
		<script>
			function add() {
				let obj = {
					name: $('input[name="name"]').val(),
					age: $('input[name="age"]').val(),
					gender: $('select[name="gender"]').val(),
					address: $('input[name="address"]').val()
				};
				
				$.ajax({
					type: 'POST',
					url: 'http://localhost:8100/rest/address',
					headers: {
						'Content-Type': 'application/json'
					},
					dataType: 'json',
					data: JSON.stringify(obj),
					success: response => {
						if (response == 1) {
							location.href = '/client/list.do';
						} else {
							alert('등록에 실패했습니다.');
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