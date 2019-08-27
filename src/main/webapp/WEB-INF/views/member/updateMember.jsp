<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
    function execDaumPostcode() {
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
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address1").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
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
					<h2>회원정보 수정</h2>
					
				</div>
			</div>
		</div>

		<div class="row">

			<!-- Profile -->
			<form action="/member/updateMemberDone" id = "updateMember">
			<div class="col-lg-6 col-md-12">
				<div class="dashboard-list-box margin-top-0">
					<h4 class="gray">Profile Details</h4>
					<div class="dashboard-list-box-static">
						
						<!-- Avatar -->
						<div class="edit-profile-photo">
							<img src="/resources/images/user-avatar.jpg" alt="">
							<div class="change-photo-btn">
								<div class="photoUpload">
								    <span><i class="fa fa-upload"></i> Upload Photo</span>
								    <input type="file" class="upload" />
								</div>
							</div>
						</div>
	
						<!-- Details -->
						<div class="my-profile">

							<label>이름</label>
							<input name="name" value="${memberInfo.name }" type="text"id="nameUpdate"  onblur="emptyCheck('nameUpdate','nameUpdate','이름을 입력하세요.')" onfocus="resetSelect('nameUpdate','nameUpdate','이름을 입력하세요.')" onkeypress="hangul2();">

							<label>번호</label>
							<input maxlength="3" type="text" class="input-text" name="phone1" id="phoneRegister1" value="${memberDetailInfo.phone1 }" onblur="" onfocus="" style="width: 130px;display: inline;"/> -
									
									
									<input maxlength="4" type="text" class="input-text" name="phone2" id="phoneRegister2" value="${memberDetailInfo.phone2 }" onblur="" onfocus="" style="width : 130px;display: inline;"/> -
									
									
									<input maxlength="4" type="text" class="input-text" name="phone3" id="phoneRegister3" value="${memberDetailInfo.phone3 }" onblur="" onfocus="" style="width: 130px;display: inline;"/>

							<label>이메일</label>
							<input name="email" value="${memberInfo.email }" type="text" onkeypress="">
							
							<label>주소</label>
							<input type="text" class="input-text" name="postcode" id="postcode" value="${memberDetailInfo.postcode }" onblur="" onfocus="" placeholder="우편번호" onkeypress="donotkeyin();"/>									
							<input type="text" class="input-text" name="address1" id="address1" value="${memberDetailInfo.address1 }" onblur="" onfocus="" placeholder="주소" onkeypress="donotkeyin();"/>									
							<input type="text" class="input-text" name="detailAddress" id="detailAddress" value="${memberDetailInfo.detailAddress }" onblur="emptyCheck('detailAddress','detailAddress','주소를 입력하세요.')" onfocus="resetSelect('detailAddress','detailAddress','주소를 입력하세요.')" placeholder="상세주소"/>							
							</div>
							<button class="button border fw margin-top-10"  type="button" onclick="execDaumPostcode()" >주소찾기</button>
							<br/>
							<br/>
							<br/>
							<br/>
							<br/>
						<button id="updateSubmit" class="button border fw margin-top-10" onclick="">회원정보 수정</button>

					</div>
				</div>
			</div>
			</form>

			<!-- Change Password -->
			<div class="col-lg-6 col-md-12">
				<div class="dashboard-list-box margin-top-0">
					<h4 class="gray">비밀번호 변경</h4>
					<div class="dashboard-list-box-static">

						<!-- Change Password -->
						<div class="my-profile">
							<label class="margin-top-0">현재 비밀번호</label>
							<input type="password" value="${memberInfo.passwd }">

							<label>새 비밀번호</label>
							<input type="password">

							<label>비밀번호 확인</label>
							<input type="password">

							<button class="button margin-top-15">비밀번호 변경</button>
						</div>

					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- Content / End -->