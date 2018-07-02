<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인입니다!!</title>
</head>
<body>
<h1>메인입니다</h1>
<h2><%=session.getAttribute("userid")%> 님 반갑습니다.!</h2>
<button onclick="location.href='memberList'">회원목록보기</button>
<button onclick="location.href='updateForm'">내 정보 수정</button>
<button onclick="location.href='logout'">로그아웃</button> 



</body>
</html>