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
<div class="dashboard-content">

		<!-- Titlebar -->
		<div id="titlebar">
			<div class="row">
				<div class="col-md-12">
					<h2>Member Profile</h2>
					<!-- Breadcrumbs -->
					<nav id="breadcrumbs">
						<ul>
							<li><a href="/main/main">Home</a></li>
							<li><a href="admin/main">Admin</a></li>
							<li>Member Profile</li>
						</ul>
					</nav>
				</div>
			</div>
		</div>

		<div class="row">

			<!-- Profile -->
			
			<div class="col-lg-6 col-md-12">
				<div class="dashboard-list-box margin-top-0">
				<form action="/admin/updateMember/${memberInfo.memnum }" id="updateMember" method="post">
					<h4 class="gray">Member Profile</h4>
					<div class="dashboard-list-box-static">
						
						<!-- Avatar -->
						<div class="edit-profile-photo">
							<img src="images/user-avatar.jpg" alt="">
							<div class="change-photo-btn">
								<div class="photoUpload">
								    <span><i class="fa fa-upload"></i> Upload Photo</span>
								    <input type="file" class="upload" />
								</div>
							</div>
						</div>
	
						<!-- Details -->
						<div class="my-profile">
						
							<label>ID</label>
							<input value="${memberInfo.id }" type="text" id="id" name="id">
							
							<label>Password</label>
							<input value="${memberInfo.passwd }" type="text" id="passwd" name="passwd">

							<label>Name</label>
							<input value="${memberInfo.name }" type="text" id="name" name="name">

							<label>Phone</label>
							<input maxlength="3" type="text" class="input-text" name="phone1" id="phone1" value="${memberDetailInfo.phone1 }" onblur="" onfocus="" style="width: 130px;display: inline;"/> -
							<input maxlength="4" type="text" class="input-text" name="phone2" id="phone2" value="${memberDetailInfo.phone2 }" onblur="" onfocus="" style="width : 130px;display: inline;"/> -
							<input maxlength="4" type="text" class="input-text" name="phone3" id="phone3" value="${memberDetailInfo.phone3 }" onblur="" onfocus="" style="width: 130px;display: inline;"/>
							
							<label>Jumin</label>
							<input value="${memberDetailInfo.jumin1 }" type="text" id="jumin1" name="jumin1" style="width: 200px; display: inline;"> - 
							<input value="${memberDetailInfo.jumin2 }" type="text" id="jumin2" name="jumin2" style="width: 200px; display: inline;">
							
							<label>Address</label>
							<input type="text" class="input-text" name="postcode" id="postcode" value="${memberDetailInfo.postcode }" onblur="" onfocus="" placeholder="우편번호" onkeypress="donotkeyin();"/>									
							<input type="text" class="input-text" name="address1" id="address1" value="${memberDetailInfo.address1 }" onblur="" onfocus="" placeholder="주소" onkeypress="donotkeyin();"/>									
							<input type="text" class="input-text" name="detailAddress" id="detailAddress" value="${memberDetailInfo.detailAddress }" onblur="emptyCheck('detailAddress','detailAddress','주소를 입력하세요.')" onfocus="resetSelect('detailAddress','detailAddress','주소를 입력하세요.')" placeholder="상세주소"/>							
							
							<button class="button border fw margin-top-10"  type="button" onclick="execDaumPostcode()" style="margin-bottom: 20px">주소찾기</button>

							<label>Email</label>
							<input value="${memberInfo.email }" type="text" id="email" name="email">
							
							<label>RegDate</label>
							<input value="${memberInfo.regdate }" type="text">

							<label>Notes</label>
							<textarea name="notes" id="notes" cols="30" rows="10">추가정보</textarea>

						</div>
	
						<button class="button margin-top-15" type="submit">Save</button>
					</form>
					<input type="button" class="button margin-top-15" onclick="location.href='/admin/deleteMember/${memberInfo.memnum}'" value="Delete" style="width: 90px; height: 42px;" />
					</div>
				</div>
			</div>
			
			
			<div class="col-lg-6 col-md-12">
				<div class="dashboard-list-box margin-top-0">
					<h4 class="gray">Member Tastes</h4>
					<div class="dashboard-list-box-static">

						<div class="my-profile">
							<div class="col-lg-6">
								<label class="margin-top-0">Companion</label>
								<input type="text" value="이" name="" id="">

								<label>Prefer Style</label>
								<input type="text" value="지" name="" id="">
	
								<label>Prefer Place</label>
								<input type="text" value="까" name="" id="">
							</div>
							
							<div class="col-lg-6">
								<label class="margin-top-0">Prefer Festival</label>
								<input type="text" value="거" name="" id="">

								<label>Prefer Food</label>
								<input type="text" value="울" name="" id="">
	
								<label>Prefer Spot</label>
								<input type="text" value="?" name="" id="">
							</div>

							<button class="button margin-top-15">Save</button>
						</div>

					</div>
				</div>
			</div>

			<!-- Change Password -->
			<div class="col-lg-6 col-md-12" style="margin-top: 80px;">
				<div class="dashboard-list-box margin-top-0">
					<h4>${memberInfo.id }'s Post</h4>
					<ul>
						<li>
							<div class="list-box-listing">
								<div class="list-box-listing-img"><a href="#"><img src="images/listing-item-01.jpg" alt=""></a></div>
								<div class="list-box-listing-content">
									<div class="inner">
										<h3><a href="#">글 제목</a></h3>
										<span>작성일</span>
										<div class="star-rating" data-rating="3.5">
											<div class="rating-counter">(12 Reply)</div>
										</div>
									</div>
								</div>
							</div>
							<div class="buttons-to-right">
								<a href="#" class="button gray"><i class="sl sl-icon-note"></i> Edit</a>
								<a href="#" class="button gray"><i class="sl sl-icon-close"></i> Delete</a>
							</div>
						</li>
					</ul>
				</div>
			</div>


			<!-- Copyrights -->
			<div class="col-md-12">
				<div class="copyrights">© 2019 Listeo. All Rights Reserved.</div>
			</div>

		</div>

	</div>