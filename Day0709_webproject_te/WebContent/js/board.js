function open_win(url,name){
	window.open(url,name,"width=500, height=350");
}

function boardCheck(formname){
	var form = $("#"+formname);
	//title검사
	if(!(form.find('input[name="name"]').val().trim())){
		alert("이름을 작성하세요");
		return false;
	}
	if(!(form.find('input[name="pass"]').val().trim())){
		alert("비밀번호를 작성하세요");
		return false;
	}
	var email = form.find('input[name="email"]').val();
	if(!email.trim()){
		alert("이메일을 작성하세요");
		return false;
	}else{
		if(!verifyEmail(email)){
			alert("이메일 형식에 맞지 않습니다.");
			return false;
		}
	}
}

function verifyEmail(email){
	 var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	 if(email.match(regExp) != null){
		 return true;
	 }else{
		 return false;
	 }
}




