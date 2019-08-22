<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="dashboard-content">

		<!-- Titlebar -->
		<div id="titlebar">
			<div class="row">
				<div class="col-md-12">
					<h2>Bookings</h2>
					<!-- Breadcrumbs -->
					<nav id="breadcrumbs">
						<ul>
							<li><a href="/main/main">Home</a></li>
							<li><a href="/admin/main">Admin</a></li>
							<li>Bookings</li>
						</ul>
					</nav>
				</div>
			</div>
		</div>

		<div class="row">
			
			<!-- Listings -->
			<div class="col-lg-12 col-md-12">
				<div class="dashboard-list-box margin-top-0">
					
					<!-- Booking Requests Filters  -->
					<div class="booking-requests-filter">

						<!-- Sort by -->
						<div class="sort-by">
							<div class="sort-by-select">
								<select data-placeholder="Default order" class="chosen-select-no-single">
									<option>All Listings</option>	
									<option>Trip</option>
									<option>Course</option>
								</select>
							</div>
						</div>

						<!-- Date Range -->
						<div id="booking-date-range">
						    <span></span>
						</div>
					</div>

					<!-- Reply to review popup -->
					<div id="small-dialog" class="zoom-anim-dialog mfp-hide">
						<div class="small-dialog-header">
							<h3>Send Message</h3>
						</div>
						<div class="message-reply margin-top-0">
							<textarea cols="40" rows="3" placeholder="Your Message to Kathy"></textarea>
							<button class="button">Send</button>
						</div>
					</div>

					<h4>Booking List</h4>
					<ul>

						<li class="pending-booking">
							<div class="list-box-listing bookings">
								<div class="list-box-listing-img"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&s=120" alt=""></div>
								<div class="list-box-listing-content">
									<div class="inner">
										<h3>출발 에서 도착 <span class="booking-status pending">Pending</span></h3>

										<div class="inner-booking-list">
											<h5>Booking Date:</h5>
											<ul class="booking-list">
												<li class="highlighted">2019/08/22 - 2019/08/30</li>
											</ul>
										</div>			

										<div class="inner-booking-list">
											<h5>Profile:</h5>
											<ul class="booking-list">
												<li>이혜연</li>
												<li>hyeyeon8752@naver.com</li>
												<li>01068230650</li>
											</ul>
										</div>

										<a href="#small-dialog" class="rate-review popup-with-zoom-anim"><i class="sl sl-icon-envelope-open"></i> Send Message</a>

									</div>
								</div>
							</div>
							<!-- <div class="buttons-to-right">
								<a href="#" class="button gray reject"><i class="sl sl-icon-close"></i> Reject</a>
								<a href="#" class="button gray approve"><i class="sl sl-icon-check"></i> Approve</a>
							</div> -->
						</li>

						<li class="approved-booking">
							<div class="list-box-listing bookings">
								<div class="list-box-listing-img"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&s=120" alt=""></div>
								<div class="list-box-listing-content">
									<div class="inner">
										<h3>코스 제목 <span class="booking-status">Underway</span></h3>

										<div class="inner-booking-list">
											<h5>Booking Date:</h5>
											<ul class="booking-list">
												<li class="highlighted">2019/08/21 - 2019/08/23</li>
											</ul>
										</div>		

										<div class="inner-booking-list">
											<h5>Profile:</h5>
											<ul class="booking-list">
												<li>송은희</li>
												<li>enuy@namver.com</li>
												<li>01068230650</li>
											</ul>
										</div>

										<a href="#small-dialog" class="rate-review popup-with-zoom-anim"><i class="sl sl-icon-envelope-open"></i> Send Message</a>

									</div>
								</div>
							</div>
						</li>

						<li class="canceled-booking">
							<div class="list-box-listing bookings">
								<div class="list-box-listing-img"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&s=120" alt=""></div>
								<div class="list-box-listing-content">
									<div class="inner">
										<h3>코스 제목 <span class="booking-status">Canceled</span></h3>

										<div class="inner-booking-list">
											<h5>Booking Date:</h5>
											<ul class="booking-list">
												<li class="highlighted">2019/08/10 - 2019/08/15</li>
											</ul>
										</div>	

										<div class="inner-booking-list">
											<h5>Profile:</h5>
											<ul class="booking-list">
												<li>이승해</li>
												<li>winsun@naver.com</li>
												<li>01068230650</li>
											</ul>
										</div>

									</div>
								</div>
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