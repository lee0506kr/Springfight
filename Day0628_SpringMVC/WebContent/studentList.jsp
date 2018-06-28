<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생 정보</title>
</head>
<body>

	<c:forEach items="${studentList}" var="student">
	
	이름: ${student.name}<br>
	번호: ${student.num}<br>
	학년: ${student.grade}<br>
	<hr/>
	
	</c:forEach>


</body>
</html>