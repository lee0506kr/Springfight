<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src = "js/board.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새 글 작성</title>
<script type="text/javascript">
// 	$(function(){
// 		var writeName = $("#writeName");
// 		writeName.on("blur",function(){
// 			//alert("id : " + );
// 			blurCheck(writeName.attr("id"));
// 		});
// 	});

</script>
</head>
<body>
	<!-- 새 글쓰기 양식 작성 -->
	<div class="wrap" align = "center">
		<h1>게시글 등록</h1>
		<form name= "frm" action="write" id="writeForm" enctype="multipart/form-data" method="post">
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="NAME" id = "writeName">*필수</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="PASS">*필수(게시글 수정,삭제 시 필요합니다.)</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="EMAIL">*필수</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name = "file"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="TITLE"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="15" cols="70" name="CONTENT"></textarea>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="등록" onclick="return boardCheck('writeForm')">
			<input type="reset" value="다시작성">
			<input type="button" value="목록"  onclick="location.href='boardList'">
		</form>
	</div>
</body>
</html>










