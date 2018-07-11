<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value ="<%=request.getContextPath()%>"></c:set>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script type="text/javascript" src= "${contextPath}/js/sockjs.js"></script>
<script type="text/javascript" src= "${contextPath}/js/stomp.js"></script>
<script type="text/javascript">
	var sock;
	var stompClient = null;
	function connect(){
		sock = new SockJS("http://localhost:8081/Day0711_WebSocket/chat");
		//sock으로 연결하는게 아니라 sockjs 기반으로 stomp를 이용해서 연결
		stompClient = Stomp.over(sock);
		stompClient.connect({},function(){
			//서버로 부터 메시지가 들어오면 처리 하겠다....특정 url 메시지에 대해 구독
			//서버가 해당 url 로 메시지를 보내면  메시지를 처리
			//stompClient.subscribe(url,function);
			stompClient.subscribe("/topic/msg/${param.memberid}",function(message){
				console.log("Message : " + message);
				var data = JSON.parse(message.body);
				console.log("Message.body : " + data);
				console.log("data.body : " + data.body);
				//console.log("Message : " + data.message);
				addMessage(data.body);
			});
		});
	};
	
	function addMessage(msgText){
		var allChat =  $("#chatArea").val();
		allChat = allChat + "\n상대방:" + msgText;
		$("#chatArea").val(allChat);
	};
	function sendMessage(msgText){
		//메시지 보내기  
		//   /client/greeting
		var targetid = $("#targetUser").val();
		
// 		var msg = {
// 				type : "chat",
// 				target : $("#targetUser").val(),
// 				message : msgText
// 			}
// 		stompClient.send("/client/greeting/${param.memberid}/"+targetid,{},JSON.stringify(msg));
		stompClient.send("/client/greeting/${param.memberid}/"+targetid,{},msgText);
		
	};
	$(function(){
		connect();
		$("#btn_send").on("click",function(){
			var chatMsg = $("#chatMsg").val();
			sendMessage(chatMsg);
			$("#chatMsg").val("");
		});
		
	});
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stomp</title>
</head>
<body>
	접속한 사용자 : ${param.memberid }<br>
	 <textarea rows="5" cols="30" id = "chatArea"></textarea><br>
	 메시지 : <input type="text" id = "chatMsg"><br>
	 대상아이디 : <input type="text" id = "targetUser"><br>	
	<input type="button" value = "전송" id = "btn_send">
</body>
</html>







