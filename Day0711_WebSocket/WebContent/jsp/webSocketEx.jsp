<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value ="<%=request.getContextPath()%>"></c:set>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script type="text/javascript" src= "${contextPath}/js/sockjs.js"></script>	
	
<script type="text/javascript">
	//연결하고, 송신, 수신 
	var ws;
	function connect(){
		alert("연결요청!!");
		ws = new WebSocket('ws://localhost:8081/Day0711_WebSocket/chat');
		
		ws.onopen = function(){
			//연결되었을 때 동작하는 함수
			console.log("연결됨!");
			register();
		};
		ws.onmessage = function(evt){
			//메시지를 받았을 때 동작
			var data = evt.data;
			console.log("메시지 받음");
// 			console.log("받은 데이터 : " + data);
			addMessage(data);
			
		};
		ws.onclose = function(){
			//연결이 끊겼을 때 동작
			console.log("연결이 끊김");
		};
		
	};
	
	function register(){
		//서버에 현재 사용중인 사용자 정보 등록
		//로그인하고 session 혹은 request에 속성으로 userid
		//로그인 구현안했으니까 param을 넘기도록 합니다...
		var msg = {
			type : "register",
			memberid : '${param.memberid}'
		}
// 		alert("123123: "+ msg.memberid);
		ws.send(JSON.stringify(msg));
	}
	
	function send(msgText){
		//입력받은 메시지 전달
// 		var msg = msgText;
		var msg = {
			type : "chat",
			target : $("#targetUser").val(),
			message : msgText
			
		}
		ws.send(JSON.stringify(msg));
// 		ws.send(msg);
	};
	function addMessage(msgText){
		var allChat =  $("#chatArea").val();
		allChat = allChat + "\n ${param.memberid}:"  + msgText;
		$("#chatArea").val(allChat);
	};
	$(function(){
		//alert("123123");
		connect();
		$("#btn_send").on("click",function(){
			var msg = $("#chatMsg").val();
			//textarea에 메시지 추가 
			var allChat =  $("#chatArea").val();
			allChat = allChat + "\n나:" + msg;
			$("#chatArea").val(allChat);
			$("#chatMsg").val("");
			send(msg);
		});
		
		//alert("234234");
	});
	
</script>	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1. 웹소켓 연결 요청
	     2. 메시 전달
	     3. 메시지 수신
	 -->
	 접속한 사용자 : ${param.memberid }<br>
	 <textarea rows="5" cols="30" id = "chatArea"></textarea><br>
	 메시지 : <input type="text" id = "chatMsg"><br>
	 대상아이디 : <input type="text" id = "targetUser"><br>
	 <input type="button" value = "전송" id = "btn_send">
	 
</body>
</html>







