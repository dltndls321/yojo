<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
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
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                	 document.getElementById("sample6_extraAddress").value = '';
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
<header id="header-container">
	<!-- Header -->
	<div id="header">
		<div class="container">
			
			<!-- Left Side Content -->
			<div class="left-side">
				
				<!-- Logo -->
				<div id="logo">
					<a href="/main/main"><img src="/resources/images/logo.png" alt=""></a>
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
								<li><a href="festival">Festival</a></li>
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
			<c:if test="${empty SessionMemberMemnum }">
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
								<label for="phoneLabel">번호:<a id="phoneRegisterWarn" style="color: red;"></a>
								<br>
									
									<input maxlength="3" type="text" class="input-text" name="phone1" id="phoneRegister1" value="" onblur="emptyCheck('phoneRegister1','phoneRegister1','')" onfocus="resetSelectPhone('phoneRegister1','phoneRegisterWarn','전화번호를 입력하세요.')" style="width: 130px;display: inline;"/> -
									
									
									<input maxlength="4" type="text" class="input-text" name="phone2" id="phoneRegister2" value="" onblur="emptyCheck('phoneRegister2','phoneRegister2','')" onfocus="resetSelectPhone('phoneRegister2','phoneRegisterWarn','전화번호를 입력하세요.')" style="width : 130px;display: inline;"/> -
									
									
									<input maxlength="4" type="text" class="input-text" name="phone3" id="phoneRegister3" value="" onblur="emptyCheck('phoneRegister3','phoneRegister3','')" onfocus="resetSelectPhone('phoneRegister3','phoneRegisterWarn','전화번호를 입력하세요.')" style="width: 130px;display: inline;"/>
									
								</label>
								
							</p>
							
								
							<p class="form-row form-row-wide">
								<label for="addressLabel">주소:
									<input type="text" class="input-text" name="postcode" id="postcode" value="" onblur="" onfocus="" placeholder="우편번호"  onkeypress="donotkeyin()"/>									
									<input type="text" class="input-text" name="address1" id="address1" value="" onblur="" onfocus="" placeholder="주소"  onkeypress="donotkeyin()"/>									
									<input type="text" class="input-text" name="detailAddress" id="detailAddress" value="" onblur="emptyCheck('detailAddress','detailAddress','주소를 입력하세요.')" onfocus="resetSelect('detailAddress','detailAddress','주소를 입력하세요.')" placeholder="상세주소"/>
									<input type="text" id="sample6_extraAddress" placeholder="참고항목" style="display: none;">
								</label>
							</p>
							<button class="button border fw margin-top-10"  type="button" onclick="execDaumPostcode()" >주소찾기</button>
							<br/>
							<br/>
							
							<p class="form-row form-row-wide">
								<label for="juminLabel">주민번호:
								<br/>
									<input  maxlength="6" type="text" class="input-text" name="jumin1" id="juminRegister1" value="" onblur="emptyCheck('juminRegister1','juminRegister1','주민번호를 입력하세요.')" onfocus="resetSelect('juminRegister1','juminRegister1','주민번호를 입력하세요.')" style="width: 260px;display: inline;"/>-
									<input  maxlength="1" type="text" class="input-text" name="jumin2" id="juminRegister2" value="" onblur="emptyCheck('juminRegister2','juminRegister2','')" onfocus="resetSelect('juminRegister2','juminRegister2','')" style=" width: 50px; display: inline;padding-left: 5px;"/>● ● ● ● ● ●
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
							<button name="register" class="button border fw margin-top-10" id="registerSubmit" type="button" onclick="onclickRegister('nameRegister','phoneRegister1','phoneRegister2','phoneRegister3','postcode','address1','detailAddress','juminRegister1','juminRegister2','idRegister','emailRegister','passwdRegister','passwd2Register','registerForm','phoneRegisterWarn')">회원가입</button>
							<!-- <input type="submit" class="button border fw margin-top-10" name="register" value="회원가입" /> -->
	
							</form>
						</div>

					</div>
				</div>
			</div>
			<!-- Sign In Popup / End -->
			</c:if>
			<c:if test="${not empty SessionMemberMemnum }">
			<!-- Right Side Content / End -->
			<div class="right-side">
				<div class="header-widget">
					<!-- User Menu -->
					<div class="user-menu">
						<div class="user-name"><span><img src="images/dashboard-avatar.jpg" alt=""></span> ${SessionMemberName}님, 안녕하세요. </div>
						<ul>
							
							<li><a href="/member/profile"><i class="im im-icon-Male"></i> Profile</a></li>
							<li><a href="/member/logout"><i class="sl sl-icon-power"></i> Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- Right Side Content / End -->
			</c:if>
			
		</div>
	</div>
	<!-- Header / End -->

</header>
<div class="clearfix"></div>