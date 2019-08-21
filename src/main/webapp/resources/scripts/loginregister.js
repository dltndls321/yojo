function emptyCheck(target1,target2,comment) {
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	if(var1.value==""){
		var2.style.borderColor="red";
		var2.style.color="red";
		var2.value = comment;
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
function emptyCheckPasswd(target1,target2,comment) {
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	if(var1.value==""){
		var2.type="text";
		var2.style.borderColor="red";
		var2.style.color="red";
		var2.value = comment;
	}
}
function resetSelectPasswd(target1,target2,comment){
	var1 = document.getElementById(target1);
	var2 = document.getElementById(target2);
	if(var1.value==""||var1.value==comment){
		var2.type="password";
		var2.style.color="#808080";
		var2.value="";
	}
}