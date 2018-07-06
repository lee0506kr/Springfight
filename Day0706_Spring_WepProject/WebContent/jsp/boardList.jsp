<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%request.setAttribute("contextPath", request.getContextPath());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/board.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>
	<div class = "wrap" align="center">
		<table class= "list">
			<tr>
				<td colspan="5">
					<a href="boardWrite">게시글 등록</a>			
				</td>
			</tr>
			<tr>
				<th>번호</th>			
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>

		<c:forEach items="${viewData.boardList}" var="board">
				<tr>
					<td>${board.NUM}</td>
					<td><a href="boardView?num=${board.NUM}">${board.TITLE}</a></td>
					<td>${board.NAME}</td>
					<td>${board.WRITEDATE}</td>
					<td align="center">${board.READCOUNT}</td>
				</tr>
			</c:forEach>
			
		</table>	
		<br>

		<!-- 처음 이전  1 2 3 4 5 6 7 8 9 10 다음  마지막 -->
		<!-- 1 2 3 4 5 다음 마지막 -->
		<!-- 처음 이전    11  12  13     20 -->

		<c:if test="${viewData.startPage !=1 }">
			<a href="boardList?page=1">[처음]</a>
			<a href="boardList?page=${viewData.startPage-1}">[이전]</a>
		</c:if>


		<c:forEach var="pageNum"
			begin="${viewData.startPage}"
			end="${viewData.endPage < viewData.pageTotalCount ? viewData.endPage : viewData.pageTotalCount}">


			<!-- 	choose = switch -->
			<c:choose>
				<c:when test="${pageNum == viewData.currentPage}">
					<b>[${pageNum}]</b>
				</c:when>
			

				<c:otherwise>
					<a href="boardList?page=${pageNum}">[${pageNum}]</a>
				</c:otherwise>
			</c:choose>


		</c:forEach>


		<c:if test="${viewData.endPage < viewData.pageTotalCount}">
			<a href="boardList?page=${viewData.endPage+1}">[다음]</a>
			<a href="boardList?page=${viewData.pageTotalCount}">[마지막]</a>
		</c:if>
		
	</div>

</body>
</html>