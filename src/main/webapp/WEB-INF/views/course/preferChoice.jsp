<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Titlebar
================================================== -->
<div id="titlebar" class="gradient">
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<h2><i class="sl sl-icon-plus"></i>Your Prefer</h2>

			</div>
		</div>
	</div>
</div>


<!-- Content
================================================== -->


<!-- Container -->
<div class="container">

		<div class="row">
			<div class="col-lg-12">


				<div id="add-listing" class="separated-form">

					<!-- Section -->
					<div class="add-listing-section">

						<!-- Headline -->
						<div class="add-listing-headline">
							<h3><i class="sl sl-icon-doc"></i>Trip info</h3>
						</div>

						<!-- Row -->
						<div class="row with-forms">
							<!-- City -->
								<div class="col-md-6">
									<h5>여행 지역</h5>
									<select class="chosen-select-no-single" >
											<option value = "">지역 선택</option>	
											<option value ="1">서울</option>
											<option value ="2">인천</option>
											<option value ="3">대전</option>
											<option value ="4">대구</option>
											<option value ="5">광주</option>
											<option value ="6">부산</option>
											<option value ="7">울산</option>
											<option value ="8">세종특별자치시</option>
											<option value ="31">경기도</option>
											<option value ="32">강원도</option>
											<option value ="33">충청북도</option>
											<option value ="34">충청남도</option>
											<option value ="35">경상북도</option>
											<option value ="36">경상남도</option>
											<option value ="37">전라북도</option>
											<option value ="38">전라남도</option>
											<option value ="39">제주도</option>
									</select>
								</div>

							<!-- Date Range Picker - docs: http://www.daterangepicker.com/ -->
					<div class="col-md-6">
						<h5>여행 날짜</h5>
						<input type="text" id="date-picker" placeholder="Date" readonly="readonly">
					</div>

						</div>
						<!-- Row / End -->

					</div>
					<!-- Section / End -->

					<!-- Section -->
					<div class="add-listing-section margin-top-45">

						<!-- Headline -->
						<div class="add-listing-headline">
							<h3><i class="sl sl-icon-location"></i>Private prefer</h3>
						</div>

						<div class="submit-section">
							
							<!-- Checkboxes -->
						<h5 class="margin-top-30 margin-bottom-10">선호 관광지<span>(optional)</span></h5>
						<div class="checkboxes in-row margin-bottom-20">
					
							<input id="A01010100" type="checkbox" name="check">
							<label for="A01010100">공원</label>

							<input id="A01010400" type="checkbox" name="check">
							<label for="A01010400">산</label>

							<input id="A01010500" type="checkbox" name="check">
							<label for="A01010500">자연생태관광지</label>

							<input id="A01010600" type="checkbox" name="check">
							<label for="A01010600">자연휴양림</label>

							<input id="A01010700" type="checkbox" name="check" >
							<label for="A01010700">수목원</label>

							<input id="A01010800" type="checkbox" name="check" >
							<label for="A01010800">폭포</label>

							<input id="A01010900" type="checkbox" name="check">
							<label for="A01010900">계곡</label>	

							<input id="A01011000" type="checkbox" name="check">
							<label for="A01011000">약수터</label>
							
							<input id="A01011100" type="checkbox" name="check">
							<label for="A01011100">해안절경</label>
							
							<input id="A01011200" type="checkbox" name="check">
							<label for="A01011200">해수욕장</label>
							
							<input id="A01011300" type="checkbox" name="check">
							<label for="A01011300">섬</label>
							
							<input id="A01011400" type="checkbox" name="check">
							<label for="A01011400">항구/포구</label>
							
							<input id="A01011500" type="checkbox" name="check">
							<label for="A01011500">어촌</label>
							
							<input id="A01011600" type="checkbox" name="check">
							<label for="A01011600">등대</label>
							
							<input id="A01011700" type="checkbox" name="check">
							<label for="A01011700">호수</label>
							
							<input id="A01011800" type="checkbox" name="check">
							<label for="A01011800">강</label>
							
							<input id="A01011900" type="checkbox" name="check">
							<label for="A01011900">동굴</label>
						</div>
						<!-- Checkboxes / End -->
						<!-- Checkboxes -->
						<h5 class="margin-top-30 margin-bottom-10">선호 음식<span>(optional)</span></h5>
						<div class="checkboxes in-row margin-bottom-20">
					
							<input id="A01010100" type="checkbox" name="check">
							<label for="A01010100">한식</label>

							<input id="A01010400" type="checkbox" name="check">
							<label for="A01010400">산</label>

							<input id="A01010500" type="checkbox" name="check">
							<label for="A01010500">자연생태관광지</label>

							<input id="A01010600" type="checkbox" name="check">
							<label for="A01010600">자연휴양림</label>

							<input id="A01010700" type="checkbox" name="check" >
							<label for="A01010700">수목원</label>

							<input id="A01010800" type="checkbox" name="check" >
							<label for="A01010800">폭포</label>

							<input id="A01010900" type="checkbox" name="check">
							<label for="A01010900">계곡</label>	

							<input id="A01011000" type="checkbox" name="check">
							<label for="A01011000">약수터</label>
							
							<input id="A01011100" type="checkbox" name="check">
							<label for="A01011100">해안절경</label>
						</div>

						</div>
					</div>
					<!-- Section / End -->


					

					<a href="#" class="button preview">Preview <i class="fa fa-arrow-circle-right"></i></a>

				</div>
			</div>

		</div>

	</div>
	<!-- Content / End -->
<!-- Container / End -->
