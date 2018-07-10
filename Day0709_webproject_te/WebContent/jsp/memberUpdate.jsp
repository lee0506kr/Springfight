
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="post">
		<p><label>아이디: <input type="text" name = "id" readonly="readonly" value="${member.ID}"></label></p>
		<p><label>비&nbsp;&nbsp;&nbsp;번: <input type="password" name = "pw"></label></p>
		<p><label>이&nbsp;&nbsp;&nbsp;름: <input type="text" name = "name" value="${member.NAME}"></label></p> 
		<p><label>이메일: <input type="text" name = "email" value=""></label></p>
		<p><label>가입일: <input type="text" name = "regDate" readonly="readonly" value="${member.REG_DATE}"></label></p>
		<input type="submit" value="수정하기">
		<input type="reset" value="다시작성">
	</form>
</body>
</html>