var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
var passwdRule = /^[A-Za-z0-9]{6,12}$/;

function emptyCheck(target1,target2,comment) {
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	if(var1.value==""){
		var2.style.borderColor="red";
		var2.style.color="red";
		var2.value = comment;
		return false;
	}
}
function resetSelect(target1,target2,comment){
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	if(var1.value==""||var1.value==comment){
		var2.style.color="#808080";
		var2.value="";
	}
}
function passwdCheck(target1,target2,comment) {
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	if(var1.value==""){
		var1.type="text";
		var1.style.borderColor="red";
		var1.style.color="red";
		var1.value = comment;
		return false;
	}else if(!passwdRule.test(var1)){
		var1.type="text";
		var1.style.borderColor="red";
		var1.style.color="red";
		var1.value = "6~12자리로 입력해 주세요";
		return false;
	}
}
function resetpasswdSelect(target1,target2,comment){
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	if(var1.value==""||var1.value==comment||var1.value=="6~12자리로 입력해 주세요"){
		var1.type="password";
		var1.style.color="#808080";
		var1.value="";
	}
}
function emailCheck(target1,comment){
	var1 = document.getElementById(target1);
	if(var1.value==""){
		var1.style.borderColor="red";
		var1.style.color="red";
		var1.value = comment;
		return false;
	}
	else if(!emailRule.test(var1)){
		var1.style.color="red";
		var1.style.borderColor="red";
		var1.value = "이메일 양식에 맞지 않습니다.";
		return false;
	}
	
}
function emailResetCheck(target1,comment){
	var1 = document.getElementById(target1);
	if(var1.value==""||var1.value==comment||var1.value=="이메일 양식에 맞지 않습니다."){
		var1.style.color="#808080";
		var1.value="";
	}
}