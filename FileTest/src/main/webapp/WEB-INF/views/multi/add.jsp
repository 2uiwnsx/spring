<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
		<style>
			input[name="attach"] {
				display: none;
			}
			#zone {
				width: 576px;
				height: 150px;
				background-color: #EFEFEF;
				border: 1px solid #CCC;
				border-radius: 3px;
				overflow: auto;
				padding: 1rem;
			}
			#zone .item {
				display: flex;
				justify-content: space-between;
				font-size: 14px;
				margin: 5px 10px;
			}
		</style>
	</head>
	<body>
	    <h1>장소 <small>등록</small></h1>
	    
	    <form method="POST" action="/file/multi/add_ok.do" enctype="multipart/form-data">
	    	<table class="vertical">
	    		<tr>
	    			<th>제목</th>
	    			
	    			<td><input type="text" name="subject" class="full" required></td>
	    		</tr>
	    		<tr>
	    			<th>내용</th>
	    			
	    			<td><textarea name="content" class="full" required></textarea></td>
	    		</tr>
	    		<tr>
	    			<th>파일</th>
	    			
	    			<td>
	    				<input type="file" name="attach" multiple>
	    				
	    				<div id="zone"></div>
	    			</td>
	    		</tr>
	    	</table>
	    	
	    	<div>
	    		<button type="submit" class="add">등록</button>
	    		<button type="button" class="back" onclick="location.href='/file/multi/list.do';">취소</button>
	    	</div>
	    </form>
	
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script>
			$('#zone').on('dragenter', function (e) {
				e.preventDefault();
				e.stopPropagation();
			}).on('dragover', function (e) {
				e.preventDefault();
				e.stopPropagation();
			}).on('dragleave', function (e) {
				e.preventDefault();
				e.stopPropagation();
			}).on('drop', function (e) {
				e.preventDefault();
				e.stopPropagation();
				
				$(this).html('');
				
				const files = e.originalEvent.dataTransfer.files;
				
				$('input[name="attach"]').prop('files', files);
					
				let temp = '';
				
				for (let i = 0; i < files.length; i++) {
					let fileName = files[i].name;
					let fileSize = files[i].size / 1024 / 1024;
					
					fileSize = (fileSize < 1) ? fileSize.toFixed(2) : fileSize.toFixed(2);
					
					temp += `
						<div class="item">
							<span>\${fileName}</span>
							<span>\${fileSize}MB</span>
						</div>
					`;
				}
				
				$(this).append(temp);
			});
		</script>
	</body>
</html>