var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
var passwdRule = /^[A-Za-z0-9]{6,12}$/;

/*빈공간 체크*/
function emptyCheck(target1,target2,comment) {
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	if(var1.value==""){
		var2.style.borderColor="red";
		var2.style.color="red";
		var2.value = comment;
		return false;
	}
	else if(var1.value!=""||var1.value!=comment){
		var2.style.borderColor="blue";
		
	}
}
/*빈공간 초기화*/
function resetSelect(target1,target2,comment){
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	if(var1.value==""||var1.value==comment||var1.value=="이미 존재하는 아이디 입니다."){
		var2.style.color="#808080";
		var2.value="";
	}
}
/*비밀번호체크*/
function passwdCheck(target1,target2,comment) {
	
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	if(var1.value==""){
		var1.type="text";
		var1.style.borderColor="red";
		var1.style.color="red";
		var1.value = comment;
		return false;
	}else if(!passwdRule.test(var1.value)){
		var1.type="text";
		var1.style.borderColor="red";
		var1.style.color="red";
		var1.value = "6~12자리로 입력해 주세요";
		return false;
	}
}
/*비밀번호 중복 체크*/
function passwdOverlapCheck(target1,target2){
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	if(var1.value!=var2.value ){
		var2.type="text";
		var2.style.borderColor="red";
		var2.style.color="red";
		var2.value = "동일한 비밀번호를 입력해 주세요.";
		return false;
	}
}
/*비밀번호초기화*/
function resetpasswdSelect(target1,target2,comment){
	
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	if(var1.value==""||var1.value==comment||var1.value=="6~12자리로 입력해 주세요"||var1.value=="동일한 비밀번호를 입력해 주세요."){
		var1.type="password";
		var1.style.color="#808080";
		var1.value="";
	}
}

/*이메일중복,유효성 체크*/
function EmailOverlapCheck(target1,comment){
	var1 = document.getElementById(target1);
	if(var1.value==""){
		var1.style.borderColor="red";
		var1.style.color="red";
		var1.value = comment;
		return false;
	}
	else if(!emailRule.test(var1.value)){
		var1.style.color="red";
		var1.style.borderColor="red";
		var1.value = "이메일 양식에 맞지 않습니다.";
		return false;
	}else{
		$.ajax({
			url : '/member/EmailOverlapCheck',
			type : 'post',
			data: {'email' : var1.value},
			success:function(data){
				if(data == '1'){
					var1.style.color="red";
					var1.style.borderColor="red";
					var1.value = "이미 존재하는 이메일 입니다.";
				}
				else if(data == '0'){
					var1.style.borderColor="blue";
				}
			},
			error: function (XMLHttpRequest, textStatus, errorThrown){
	        	alert('서버와의 통신이 원할하지 않습니다.\n다시 시도 해 주십시오.' );
	        }
	});
	}
}

/*이메일 초기화*/
function emailResetCheck(target1,comment){
	
	var1 = document.getElementById(target1);
	if(var1.value==""||var1.value==comment||var1.value=="이메일 양식에 맞지 않습니다."||var1.value=="이미 존재하는 이메일 입니다."){
		var1.style.color="#808080";
		var1.value="";
	}
}

/*한글체크*/
function hangul(target1){
	var1 = document.getElementById(target1);
	if((event.keyCode < 12592) || (event.keyCode > 12687)){
		var1.style.display = "inline";
		event.returnValue = false;
	}
}

/*아이디중복,유효성 체크*/
function IDOverlapCheck(target1,target2,comment){
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	if(var1.value==""){
		var2.style.borderColor="red";
		var2.style.color="red";
		var2.value = comment;
		return false;
	}else{
		$.ajax({
			url : '/member/IDOverlapCheck',
			type : 'post',
			data: {'id' : var1.value},
			success:function(data){
				if(data == '1'){
					var1.style.color="red";
					var1.style.borderColor="red";
					var1.value = "이미 존재하는 아이디 입니다.";
				}
				else if(data == '0'){
					var2.style.borderColor="blue";
				}
			},
			error: function (XMLHttpRequest, textStatus, errorThrown){
	        	alert('서버와의 통신이 원할하지 않습니다.\n다시 시도 해 주십시오.' );
	        }
	});
	}
}


