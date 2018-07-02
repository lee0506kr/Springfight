<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일</th>
		</tr>
		<c:forEach items="${memberList}" var="member">
			<tr>
				<td>${member.id }</td>
				<td>${member.name }</td>
				<td>${member.email }</td>
				<td>${member.regDate }</td>
				
			</tr>
		</c:forEach>
		
		
		
		
		
	</table>
</body>
</html>