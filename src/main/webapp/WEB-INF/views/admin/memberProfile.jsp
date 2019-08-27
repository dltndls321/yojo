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
							<input value="${memberInfo.phone }" type="text" id="phone" name="phone">
							
							<label>Jumin</label>
							<input value="${memberInfo.jumin }" type="text" id="jumin" name="jumin">
							
							<label>Address</label>
							<input value="${memberInfo.address }" type="text" id="address" name="address">

							<label>Email</label>
							<input value="${memberInfo.email }" type="text" id="email" name="email">
							
							<label>RegDate</label>
							<input value="${memberInfo.regdate }" type="text" id="regdate" name="regdate">

							<label>Notes</label>
							<textarea name="notes" id="notes" cols="30" rows="10">추가정보</textarea>

						</div>
	
						<button class="button margin-top-15">Save</button>

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