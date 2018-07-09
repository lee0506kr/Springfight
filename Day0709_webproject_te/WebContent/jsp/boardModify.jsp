<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setAttribute("contextPath", request.getContextPath());%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/board.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<div class="wrap" align = "center">
		<h1>게시글 수정</h1>
		<form name= "frm" action="modify" id = "modifyForm">
			<input type="hidden" name="NUM" value="${board.NUM}">
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="NAME" value="${board.NAME}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="PASS" >*필수(게시글 수정,삭제 시 필요합니다.)</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="EMAIL" value ="${board.EMAIL }" readonly="readonly">*필수</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="TITLE" value ="${board.TITLE }"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="15" cols="70" name="CONTENT" >
							${board.TITLE }
						</textarea>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="수정">
			<input type="reset" value="다시작성">
			<input type="button" value="목록" 
			onclick="location.href='boardList'">
		</form>
	</div>
</body>
</html>