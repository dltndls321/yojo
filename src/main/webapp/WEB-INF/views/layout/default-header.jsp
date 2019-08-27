<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header id="header-container">

	<!-- Header -->
	<div id="header">
		<div class="container">
			
			<!-- Left Side Content -->
			<div class="left-side">
				
				<!-- Logo -->
				<div id="logo">
					<a href="index.html"><img src="/resources/images/logo.png" alt=""></a>
				</div>

				<!-- Mobile Navigation -->
				<div class="mmenu-trigger">
					<button class="hamburger hamburger--collapse" type="button">
						<span class="hamburger-box">
							<span class="hamburger-inner"></span>
						</span>
					</button>
				</div>

				<!-- Main Navigation -->
				<nav id="navigation" class="style-1">
					<ul id="responsive">

						<li><a  href="#">Course</a>
							<ul>
								<li><a href="index.html">Recommand</a></li>
								<li><a href="index-2-airbnb.html">Route</a></li>

							</ul>
						</li>

						

						<li><a href="#">TripInfo</a>
							<ul>
								<li><a href="dashboard.html">Eat</a></li>
								<li><a href="/festival/list">Festival</a></li>
								<li><a href="dashboard-bookings.html">Tourist Spot</a></li>
							</ul>
						</li>

						<li><a href="#">Community</a>
							<ul>
								<li><a href="dashboard.html">Notice</a></li>
								<li><a href="dashboard-messages.html">Free Board</a></li>
								<li><a href="dashboard-bookings.html">Q&A</a></li>
							</ul>
						</li>
						
					</ul>
				</nav>
				<div class="clearfix"></div>
				<!-- Main Navigation / End -->
				
			</div>
			<!-- Left Side Content / End -->


			<!-- Right Side Content / End -->
			<div class="right-side">
				<div class="header-widget">
					<a href="#sign-in-dialog" class="sign-in popup-with-zoom-anim button border with-icon"><i class="sl sl-icon-login"></i> Sign In</a>
				</div>
			</div>
			<!-- Right Side Content / End -->

			<!-- Sign In Popup -->
			<div id="sign-in-dialog" class="zoom-anim-dialog mfp-hide">

				<div class="small-dialog-header">
					<h3>로그인/회원가입</h3>
				</div>

				<!--Tabs -->
				<div class="sign-in-form style-1">

					<ul class="tabs-nav">
						<li class=""><a href="#tab1">로그인</a></li>
						<li><a href="#tab2">회원가입</a></li>
					</ul>

					<div class="tabs-container alt">

						<!-- Login -->
						<div class="tab-content" id="tab1" style="display: none;">
							<form method="post" class="login" id="loginForm" action="/member/loginmember">

								<p class="form-row form-row-wide">
									<label for="username">아이디:
										<i class="im im-icon-Male"></i>
										<input type="text" class="input-text" name="id" id="idLogin" value="" onclick="onclickColorChange('idLogin')"/>
									</label>
								</p>

								<p class="form-row form-row-wide">
									<label for="password">비밀번호:
										<i class="im im-icon-Lock-2"></i>
										<input class="input-text" type="password" name="passwd" id="passwdLogin" onclick="onclickColorChange('passwdLogin')"/>
									</label>
									<span class="lost_password">
										<a href="#" >Lost Your Password?</a>
									</span>
								</p>

								<div class="form-row">
									<button name="login" class="button border fw margin-top-10" id="loginSubmit" type="button" onclick="onclickloginSubmit('idLogin','passwdLogin','loginForm')">로그인</button>
									<div class="checkboxes margin-top-10">
										<input id="remember-me" type="checkbox" name="check">
										<label for="remember-me">Remember Me</label>
									</div>
								</div>
								
							</form>
						</div>

						<!-- Register -->
						<div class="tab-content" id="tab2" style="display: none;">

							<form method="post" id="registerForm" class="register" action="/member/registemember">
							
							<p class="form-row form-row-wide">
								<label for="nameLabel" >이름:<a id="nameRegisterWarn" style="color: red; display: none;" >한글로만 입력 가능합니다.</a>
									<i class="im im-icon-Male"></i>
									<input type="text" class="input-text" name="name" id="nameRegister" value="" onblur="emptyCheck('nameRegister','nameRegister','이름을 입력하세요.')" onfocus="resetSelect('nameRegister','nameRegister','이름을 입력하세요.')" onkeypress="hangul('nameRegisterWarn');"/>
								</label>
							</p>
							
							<p class="form-row form-row-wide">
								<label for="phoneLabel">번호:
									<i class="im im-icon-Phone"></i>
									<input type="text" class="input-text" name="phone" id="phoneRegister" value="" onblur="emptyCheck('phoneRegister','phoneRegister','전화번호를 입력하세요.')" onfocus="resetSelect('phoneRegister','phoneRegister','전화번호를 입력하세요.')"/>
								</label>
							</p>
								
							<p class="form-row form-row-wide">
								<label for="addressLabel">주소:
									<i class="im im-icon-Address-Book"></i>
									<input type="text" class="input-text" name="address" id="addressRegister" value="" onblur="emptyCheck('addressRegister','addressRegister','주소를 입력하세요.')" onfocus="resetSelect('addressRegister','addressRegister','주소를 입력하세요.')"/>
								</label>
							</p>
							
							<p class="form-row form-row-wide">
								<label for="juminLabel">주민번호:
									<i class="im im-icon-Credit-Card3"></i>
									<input type="text" class="input-text" name="jumin" id="juminRegister" value="" onblur="emptyCheck('juminRegister','juminRegister','주민번호를 입력하세요.')" onfocus="resetSelect('juminRegister','juminRegister','주민번호를 입력하세요.')"/>
								</label>
							</p>
								
							<p class="form-row form-row-wide">
								<label for="idLabel">아이디:
									<i class="im im-icon-Male"></i>
									<input type="text" class="input-text" name="id" id="idRegister" value="" onblur="IDOverlapCheck('idRegister','아이디를 입력하세요.')" onfocus="resetSelect('idRegister','idRegister','아이디를 입력하세요.')" onkeypress=""/>
								</label>
							</p>
								
							<p class="form-row form-row-wide">
								<label for="emailLabel">이메일:
									<i class="im im-icon-Mail"></i>
									<input type="text" class="input-text" name="email" id="emailRegister" value="" onblur="EmailOverlapCheck('emailRegister','이메일을 입력하세요.')" onfocus="emailResetCheck('emailRegister','이메일을 입력하세요.')"/>
								</label>
							</p>
							
							

							<p class="form-row form-row-wide">
								<label for="passwdLabel">비밀번호:
									<i class="im im-icon-Lock-2"></i>
									<input class="input-text" type="password" name="passwd" id="passwdRegister" onblur="passwdCheck('passwdRegister','passwd2Register','비밀번호를 입력하세요.')" onfocus="resetpasswdSelect('passwdRegister','passwdRegister','비밀번호를 입력하세요.')"/>
								</label>
							</p>

							<p class="form-row form-row-wide">
								<label for="passwd2Label">비밀번호 확인:
									<i class="im im-icon-Lock-2"></i>
									<input class="input-text" type="password" name="passwd2" id="passwd2Register" onblur="passwdOverlapCheck('passwdRegister','passwd2Register');emptyCheck('passwd2Register','passwd2Register','비밀번호를 입력하세요.')" onfocus="resetpasswdSelect('passwd2Register','passwd2Register','비밀번호를 입력하세요.')"/>
								</label>
							</p>
							<button name="register" class="button border fw margin-top-10" id="registerSubmit" type="button" onclick="onclickRegister('nameRegister','phoneRegister','addressRegister','juminRegister','idRegister','emailRegister','passwdRegister','passwd2Register','registerForm')">회원가입</button>
							<!-- <input type="submit" class="button border fw margin-top-10" name="register" value="회원가입" /> -->
	
							</form>
						</div>

					</div>
				</div>
			</div>
			<!-- Sign In Popup / End -->

		</div>
	</div>
	<!-- Header / End -->

</header>
<div class="clearfix"></div>