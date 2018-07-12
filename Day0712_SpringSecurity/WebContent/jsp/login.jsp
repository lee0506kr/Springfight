<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<c:url value="/member/login" var="loginUrl"/>
	<form name= "frm" action="${loginUrl}" method = "post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<fieldset>
			
			<legend>Please Login</legend>
			<label for = "username">사용자 이름 :</label> 
			<input type="text" id = "username" name="username" value="${username}"/>
			<label for = "password">비밀번호  :</label> 
			<input  type="password" id = "password" name="password" />		
			<div>
				<input type="submit" value="Login">
			</div>
		</fieldset>
	</form>
		<c:if test="${param.error !=null}">
			<div>
				<p style="color:red">아이디 또는 비밀번호를 확인하세요.</p>
			</div>
		</c:if>
		<c:if test="${param.logout !=null}">
			<div>
				<p style="color:red">로그아웃 하였습니다.</p>
			</div>
		</c:if>
</body>
</html>
