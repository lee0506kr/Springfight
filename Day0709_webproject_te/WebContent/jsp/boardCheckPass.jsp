<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" type="text/css" href="css/board.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 확인</title>

</head>
<body>
	<!-- 비밀번호 확인 화면 -->
	<!-- 사용자에게 비밀번호를 입력받아서 서버로 전달 
	현재 페이지 호출 요청에는 파라미터에 게시글 번호가 포함되어 있음
	-->
	
	<div align="center">
		<h1>비밀번호 확인</h1>
		<form action="boardCheckPass" name ="frm" method = "post">
			<input type="hidden" name ="NUM" value = "${param.NUM}">
			<table>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="PASS" size="20"> </td>
				</tr>
			</table>
			<input type="submit" value="확인">
		</form>
	</div>
	${msg}
</body>
</html>