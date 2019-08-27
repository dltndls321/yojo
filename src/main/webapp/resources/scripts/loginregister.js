var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
var passwdRule = /^[A-Za-z0-9]{6,12}$/;

/*빈공간 체크*/
function emptyCheck(target1,target2,comment) {
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	if(var1.value==""||var1.value=="동일한 비밀번호를 입력해 주세요."){
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
function resetSelectPhone(target1,target2,comment){
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	if(var1.value==""){
		var1.style.color="#808080";
		var2.innerHTML = "";
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
	else{
		var1.style.borderColor="blue";
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
	var2 = document.getElementById("emailRegister");
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
				if(data == '3'){
					$('#emailRegister').val("이미 존재하는 이메일 입니다.");
					$('#emailRegister').css('color','red');
					$('#emailRegister').css('borderColor','red');
					
				}
				else if(data == '2'){
					$('#emailRegister').css('borderColor','blue');
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
/*키입력 방지*/
function donotkeyin(){
	event.returnValue = false;
}

/*한글체크*/
function hangul(target1){
	var1 = document.getElementById(target1);
	if((event.keyCode < 12592) || (event.keyCode > 12687)){
		var1.style.display = "inline";
		event.returnValue = false;
	}
}
function hangul2(){
	if((event.keyCode < 12592) || (event.keyCode > 12687)){
		event.returnValue = false;
	}
}
/*아이디중복,유효성 체크*/
function IDOverlapCheck(target1,comment){
	var1 = document.getElementById(target1);
	var2 = document.getElementById("idRegister");
	if(var1.value==""){
		var1.style.borderColor="red";
		var1.style.color="red";
		var1.value = comment;
		return false;
	}else{
		$.ajax({
			url : '/member/IDOverlapCheck',
			type : 'post',
			data: {'id' : var2.value},
			success:function(data){
				if(data == '1'){
					var2.style.color="red";
					var2.style.borderColor="red";
					var2.value = "이미 존재하는 아이디 입니다.";
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
function onclickRegister(target1,target2,target3,target4,target5,target6,target7,target8,target9,target10,target11,target12,target13,target14,target15){
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	var3 = document.getElementById(target3);
	var4 = document.getElementById(target4);
	var5 = document.getElementById(target5);
	var6 = document.getElementById(target6);
	var7 = document.getElementById(target7);
	var8 = document.getElementById(target8);
	var9 = document.getElementById(target9);
	var10 = document.getElementById(target10);
	var11 = document.getElementById(target11);
	var12 = document.getElementById(target12);
	var13 = document.getElementById(target13);
	var14 = document.getElementById(target14);
	var15 = document.getElementById(target15);
	if(var1.value == ""||var1.value=='이름을 입력하세요.'){
		var1.type="text";
		var1.style.borderColor="red";
		var1.style.color="red";
		var1.value = "이름을 입력하세요."
		return false;
	}else if(var2.value == ""||var3.value==''||var4.value==''|| var15.value=='전화번호를 입력하세요.'){
		var15.innerHTML ="전화번호를 입력하세요."
		return false;
	}else if(var5.value == ""||var6.value == ""||var7.value == ""||var7.value == "주소를 입력하세요."){
		var7.type="text";
		var7.style.borderColor="red";
		var7.style.color="red";
		var7.value = "주소를 입력하세요."
		return false;
	}else if(var8.value == ""||var9.value==''||var8.value == "주민번호를 입력하세요."){
		var8.value == "주민번호를 입력하세요."
		return false;
	}else if(var10.value == ""||var10.value=='아이디를 입력하세요.'||var10.value=="이미 존재하는 아이디 입니다."){
		return false;
	}else if(var11.value == ""||var11.value=='이메일을 입력하세요.'||var11.value=='이메일을 입력하세요.'||var11.value=="이미 존재하는 이메일 입니다."){
		return false;
	}else if(var12.value == ""||var12.value=='비밀번호를 입력하세요.'||var12.value=="6~12자리로 입력해 주세요"||var12.value=="동일한 비밀번호를 입력해 주세요."){
		return false;
	}else if(var13.value == ""||var13.value=='비밀번호를 입력하세요.'||var13.value=="6~12자리로 입력해 주세요"||var13.value=="동일한 비밀번호를 입력해 주세요."){
		return false;
	}else{
		var14.submit();
	}
	
}
function onclickloginSubmit(target1,target2,target3){
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	var3 = document.getElementById(target3);
	if(var1.value == ""||var1.value=='아이디를 입력하세요.'){
		$('#idLogin').val('아이디를 입력하세요.');
		$('#idLogin').css('color','red');
		$('#idLogin').css('borderColor','red');
		return false;
	}else if(var2.value == ""||var2.value=='비밀번호를 입력하세요.'){
		var2.type="text";
		$('#passwdLogin').val('비밀번호를 입력하세요.');
		$('#passwdLogin').css('color','red');
		$('#passwdLogin').css('borderColor','red');
		return false;
	}else{
		$.ajax({
			url : '/member/loginCheck',
			type : 'post',
			data: {'id' : var1.value,'passwd' : var2.value},
			success:function(data){
				if(data == '0'){
					$('#idLogin').css('color','red');
					$('#idLogin').css('borderColor','red');
					$('#idLogin').val('아이디가 존재하지 않습니다.');
				}
				else if(data == '1'){
					var2.type="text";
					$('#passwdLogin').val('비밀번호가 다릅니다.');
					$('#passwdLogin').css('color','red');
					$('#passwdLogin').css('borderColor','red');
				}else if(data == '2'){
					var3.submit();
				}
			},
			error: function (XMLHttpRequest, textStatus, errorThrown){
	        	alert('서버와의 통신이 원할하지 않습니다.\n다시 시도 해 주십시오.' );
	        }
	});
	}
}

function onclickColorChange(target1){
	var1 = document.getElementById(target1);
	var1.style.color="#808080";
	var1.style.borderColor="#DBDBDB";
	var1.value="";
	var1.type="password";
}

function onclickUpdate(target1,target2,target3,target4,target5,target6){
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	var3 = document.getElementById(target3);
	var4 = document.getElementById(target4);
	var5 = document.getElementById(target5);
	var6 = document.getElementById(target6);
}