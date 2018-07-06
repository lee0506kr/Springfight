<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%request.setAttribute("contextPath", request.getContextPath());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/board.css">
<script type="text/javascript" src="${contextPath}/js/board.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- ajax file upload -->
</head>
<body>
	
	<div class ="wrap" align ="center">
		<h1>게시글 상세보기 </h1>
		<table>
			<tr>
				<th>작성자</th>
				<td>${board.NAME}</td>
				<th>이메일</th>
				<td>${board.EMAIL}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${board.WRITEDATE}</td>
				<th>조회수</th>
				<td>${board.READCOUNT}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${board.TITLE}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">${board.CONTENT}</td>
			</tr>
		</table>
		<br><br><br>
		<input type="button" value = "수정"
		 onclick="open_win('board?command=board_check_pass_form&num=${board.NUM}','update')">
		<input type="button" value = "삭제"
		onclick="open_win('boardCheckPass?num=${board.NUM}','delete')">
		<input type="button" value = "목록"
		 onclick="location.href='boardList'">
		<input type="button" value = "새글쓰기"
		 onclick="location.href='boardWrite'">
	</div>
</body>
</html>





