<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>네이버 책검색</title>
</head>
<body>
	<form action="bookSearch">
		<input type="text" name="keyword"> <input type="submit"
			value="검색">
	</form>
	
	<c:forEach items="${bookList}" var="book">

		<img src="${book.image}">
	제목:${book.title}<br>
	가격:${book.price}<br>
	출판사:${book.publisher}<br>
	내용:${book.description}<br>
	<a href="${book.link}">상세보기</a><br>
	<hr>
	</c:forEach>

</body>
</html>




