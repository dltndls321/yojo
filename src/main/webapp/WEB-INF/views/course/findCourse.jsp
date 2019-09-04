<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Titlebar
================================================== -->
<div id="titlebar" class="gradient">
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<h2><i class="sl sl-icon-check"></i>Your Course</h2>

			</div>
		</div>
	</div>
</div>
<!-- Content
================================================== -->


<!-- Container -->
<div class="container">

		<div class="row">
			
			<!-- Listings -->
			<div class="col-lg-6 col-md-12">

				<div class="dashboard-list-box margin-top-0">


					<h4>Course</h4> 

					<ul>
						<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="/resources/images/food.png" alt="" /></div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">${adminCourse.course1}  
												<div class="star-rating" data-rating="${avg1}"></div>
											</div>
											<p>${food1.area}</p>	
										</div>
									</li>
								</ul>
							</div>
						</li>

						<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="/resources/images/spot.png" alt="" /> </div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">${adminCourse.course2}
												<div class="star-rating" data-rating="${avg4}"></div>
											</div>
											<p>${spot1.area}</p>
											
										</div>
									</li>
								</ul>
							</div>
						</li>

						<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="/resources/images/food.png" alt="" /></div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">${adminCourse.course3} 
												<div class="star-rating" data-rating="${avg2}"></div>
											</div>
											<p>${food2.area}</p>
										</div>
									</li>
								</ul>
							</div>
						</li>

						<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="/resources/images/spot.png" alt="" /> </div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">${adminCourse.course4}
												<div class="star-rating" data-rating="${avg5}"></div>
											</div>
											<p>${spot2.area}</p>
										</div>

									</li>
								</ul>
							</div>
						</li>
						<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="/resources/images/food.png" alt="" /> </div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">${adminCourse.course5}
												<div class="star-rating" data-rating="${avg3}"></div>
											</div>
											<p>${food3.area}</p>
											
										</div>

									</li>
								</ul>
							</div>
						</li>
							<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="/resources/images/festival.png" alt="" /> </div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">${adminCourse.course6}
												<div class="star-rating" data-rating="${avg6}"></div>
											</div>
											<p>${fest1.area}</p>
										</div>

									</li>
								</ul>
							</div>
						</li>

					</ul>
				</div>

				

			</div>

			<!-- Listings -->
			<div class="col-lg-6 col-md-12">
				<div class="dashboard-list-box margin-top-0">
					<h4>Course Map</h4>
					<!-- Map -->
		<div id="map-container">
		    <div id="map" data-map-scroll="true">
		        <!-- map goes here -->
		    </div>
		</div>
				</div>
			</div>

</div>
	</div>