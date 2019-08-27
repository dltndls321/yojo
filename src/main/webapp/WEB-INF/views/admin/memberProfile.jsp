<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<form action="/admin/updateMember" id="updateMember">
			<div class="col-lg-6 col-md-12">
				<div class="dashboard-list-box margin-top-0">
					<h4 class="gray">Member Profile</h4>
					<div class="dashboard-list-box-static">
						
						<!-- Avatar -->
						<!-- <div class="edit-profile-photo">
							<img src="images/user-avatar.jpg" alt="">
							<div class="change-photo-btn">
								<div class="photoUpload">
								    <span><i class="fa fa-upload"></i> Upload Photo</span>
								    <input type="file" class="upload" />
								</div>
							</div>
						</div> -->
	
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
							<input value="${memberInfo.phone }" type="text" id="phone" name="phone">
							
							<label>Jumin</label>
							<input value="${memberInfo.jumin }" type="text" id="jumin1" name="jumin1"> - 
							<input value="${memberInfo.jumin }" type="text" id="jumin2" name="jumin2">
							
							<label>Address</label>
							<input type="text" class="input-text" name="postcode" id="postcode" value="${memberDetailInfo.postcode }" onblur="" onfocus="" placeholder="우편번호" onkeypress="donotkeyin();"/>									
							<input type="text" class="input-text" name="address1" id="address1" value="${memberDetailInfo.address1 }" onblur="" onfocus="" placeholder="주소" onkeypress="donotkeyin();"/>									
							<input type="text" class="input-text" name="detailAddress" id="detailAddress" value="${memberDetailInfo.detailAddress }" onblur="emptyCheck('detailAddress','detailAddress','주소를 입력하세요.')" onfocus="resetSelect('detailAddress','detailAddress','주소를 입력하세요.')" placeholder="상세주소"/>							
							</div>
							<button class="button border fw margin-top-10"  type="button" onclick="execDaumPostcode()" >주소찾기</button>
							<input value="${memberInfo.address }" type="text" id="address" name="address">

							<label>Email</label>
							<input value="${memberInfo.email }" type="text" id="email" name="email">
							
							<label>RegDate</label>
							<input value="${memberInfo.regdate }" type="text">

							<label>Notes</label>
							<textarea name="notes" id="notes" cols="30" rows="10">추가정보</textarea>

						</div>
	
						<button class="button margin-top-15" type="submit">Save</button>

					</div>
				</div>
			</div>
			</form>
			
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
					<h4 class="gray">Change Password</h4>
					<div class="dashboard-list-box-static">

						<!-- Change Password -->
						<div class="my-profile">
							<label class="margin-top-0">Current Password</label>
							<input type="text" value="0000" name="" id="">

							<label>New Password</label>
							<input type="text" name="" id="">

							<label>Confirm New Password</label>
							<input type="text" name="" id="">

							<button class="button margin-top-15">Change Password</button>
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