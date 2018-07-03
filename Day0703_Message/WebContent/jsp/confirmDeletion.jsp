<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 사용자에게 비밀번호를 입력받아서  비밀번호 확인을 위한 로직으로 전달
	input type:hidden  화면에 보이지 않는 파라미터를 넘길 때 사용
	-->
	<h2>비밀번호 확인</h2>
	<form action = "pwCheck" method="post">
		<input type="hidden" name="id" value="${param.id}">
		<label for = "password">비밀번호</label>
		<input type="password" name="password" id= "password">
		<input type="submit" value="확인">
	</form>
</body>
</html>









