<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
    function execDaumPostcode1() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                  
                
                } else {
                  
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode1').value = data.zonecode;
                document.getElementById("address11").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress1").focus();
            }
       
        }).open();
        
    }
</script>
<!-- Content
	================================================== -->
	<div class="dashboard-content">

		<!-- Titlebar -->
		<div id="titlebar">
			<div class="row">
				<div class="col-md-12">
					<h2>추가 정보 입력</h2>
					
				</div>
			</div>
		</div>

		<div class="row">

			<!-- Profile -->
			<form action="/member/kakaoregisterDone" id = "kakaoMember">
			<div class="col-lg-12 col-md-12">
				<div class="dashboard-list-box margin-top-0">
					<h4 class="gray">Profile Details</h4>
					<div class="dashboard-list-box-static">
						
	
						<!-- Details -->
						<div class="my-profile">

							
							<input name="name" value="${memberInfo.name }" type="hidden"id="nameUpdate">
							<input name="email" value="${memberInfo.email }" type="hidden">
							<input name="tokken" value="${memberInfo.tokken }" type="hidden">
							<input name="status" value="${memberInfo.status }" type="hidden">
							<input name="id" value="${memberInfo.id }" type="hidden">
							<label>번호</label>
							<input maxlength="3" type="text" class="input-text" name="phone1" id="phoneRegister11" value="" onblur="" onfocus="resetSelectPhone('phoneRegister11','phoneRegisterWarn','')" style="width: 130px;display: inline;"/> -
									
									
									<input maxlength="4" type="text" class="input-text" name="phone2" id="phoneRegister22" value="" onblur="" onfocus="resetSelectPhone('phoneRegister11','phoneRegisterWarn','')" style="width : 130px;display: inline;"/> -
									
									
									<input maxlength="4" type="text" class="input-text" name="phone3" id="phoneRegister33" value="" onblur="" onfocus="resetSelectPhone('phoneRegister11','phoneRegisterWarn','')" style="width: 130px;display: inline;"/>

							<label>주민번호</label>
							<input  maxlength="6" type="text" class="input-text" name="jumin1" id="juminRegister11" value="" onblur="emptyCheck('juminRegister11','juminRegister11','주민번호를 입력하세요.')" onfocus="resetSelect('juminRegister11','juminRegister11','주민번호를 입력하세요.')" style="width: 260px;display: inline;"/>-
									<input  maxlength="1" type="text" class="input-text" name="jumin2" id="juminRegister22" value="" onblur="emptyCheck('juminRegister22','juminRegister22','')" onfocus="resetSelect('juminRegister22','juminRegister22','')" style=" width: 50px; display: inline;padding-left: 5px;"/>● ● ● ● ● ●
							<label>비밀번호</label>
							<input class="input-text" type="password" name="passwd" id="passwdRegister1" onblur="passwdCheck('passwdRegister1','passwd2Register1','비밀번호를 입력하세요.')" onfocus="resetpasswdSelect('passwdRegister1','passwdRegister1','비밀번호를 입력하세요.')"/>
							<label>비밀번호 확인</label>
							<input class="input-text" type="password" name="passwd2" id="passwd2Register1" onblur="passwdOverlapCheck('passwdRegister1','passwd2Register1');emptyCheck('passwd2Register1','passwd2Register1','비밀번호를 입력하세요.')" onfocus="resetpasswdSelect('passwd2Register1','passwd2Register1','비밀번호를 입력하세요.')"/>
							<label>주소</label>
							<input type="text" class="input-text" name="postcode" id="postcode1" value="" onblur="" onfocus="" placeholder="우편번호" onkeypress="donotkeyin();"/>									
							<input type="text" class="input-text" name="address1" id="address11" value="" onblur="" onfocus="" placeholder="주소" onkeypress="donotkeyin();"/>									
							<input type="text" class="input-text" name="detailAddress" id="detailAddress1" value="" onblur="emptyCheck('detailAddress1','detailAddress1','주소를 입력하세요.')" onfocus="resetSelect('detailAddress1','detailAddress1','주소를 입력하세요.')" placeholder="상세주소"/>							
							</div>
							<button class="button border fw margin-top-10"  type="button" onclick="execDaumPostcode1()" >주소찾기</button>
							<br/>
							<br/>
							<br/>
							<br/>
							<br/>
						<input type="button" id="updateSubmit" class="button border fw margin-top-10" onclick="onclickKakao('phoneRegister11','phoneRegister22','phoneRegister33','juminRegister11','juminRegister22','postcode1','address11','detailAddress1','kakaoMember','passwdRegister1','passwd2Register1');" value="추가 정보 입력">

					</div>
				</div>
			</div>
			</form>

			
		</div>

	</div>
	<!-- Content / End -->