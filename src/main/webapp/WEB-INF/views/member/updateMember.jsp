<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
							<input value="${memberInfo.name }" type="text">

							<label>번호</label>
							<input value="${memberInfo.phone }" type="text">

							<label>이메일</label>
							<input value="${memberInfo.email }" type="text">
							
							<label>주소</label>
							<input type="text" class="input-text" name="postcode" id="postcode" value="" onblur="" onfocus="" placeholder="우편번호" disabled="disabled"/>									
							<input type="text" class="input-text" name="address1" id="address1" value="" onblur="" onfocus="" placeholder="주소" disabled="disabled"/>									
							<input type="text" class="input-text" name="detailAddress" id="addressRegister" value="" onblur="emptyCheck('addressRegister','addressRegister','주소를 입력하세요.')" onfocus="resetSelect('addressRegister','addressRegister','주소를 입력하세요.')" placeholder="상세주소"/>							
							</div>
	
						<button class="button margin-top-15">회원정보 수정</button>

					</div>
				</div>
			</div>

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


			<!-- Copyrights -->
			<div class="col-md-12">
				<div class="copyrights">© 2019 Listeo. All Rights Reserved.</div>
			</div>

		</div>

	</div>
	<!-- Content / End -->