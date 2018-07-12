<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 권한에 따른 화면 보이기  -->
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<security:authentication property="principal" var="check"/>
	</security:authorize>
	<c:choose>
		<c:when test="${empty check}">
			일반유저 입니다. 
		</c:when>
		<c:otherwise>
			어드민입니다. 
		</c:otherwise>
	</c:choose>
	<form id = "logoutForm" action="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" 	value = "${_csrf.token}" > 
		<input type="submit" value="로그아웃">
	</form>
</body>
</html>





