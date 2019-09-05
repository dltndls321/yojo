<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Banner
================================================== -->
<div class="main-search-container" data-background-image="/resources/images/main-search-background-01.jpg">
	<div class="main-search-inner">

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>Find Nearby Attractions</h2>
					<h4>Expolore top-rated attractions, activities and more</h4>

					<div class="main-search-input">

						<div class="main-search-input-item">
							<input type="text" placeholder="What are you looking for?" value=""/>
						</div>

						<div class="main-search-input-item location">
							<div id="autocomplete-container">
								<input id="autocomplete-input" type="text" placeholder="Location">
							</div>
							<a href="#"><i class="fa fa-map-marker"></i></a>
						</div>

						<div class="main-search-input-item">
							<select data-placeholder="All Categories" class="chosen-select" >
								<option>All Categories</option>	
								<option>Shops</option>
								<option>Hotels</option>
								<option>Restaurants</option>
								<option>Fitness</option>
								<option>Events</option>
							</select>
						</div>

						<button class="button" onclick="window.location.href='listings-half-screen-map-list.html'">Search</button>

					</div>
				</div>
			</div>
		</div>

	</div>
</div>




<!-- Content
================================================== -->
<div class="container">
	<div class="row">

		<div class="col-md-12">
			<h3 class="headline centered margin-top-75">
				카테고리
			</h3>
		</div>

	</div>
</div>


<!-- Category Boxes -->
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="categories-boxes-container margin-top-5 margin-bottom-30">
				
				<!-- Box -->
				<a href="/food/list" class="category-small-box">
					<i class="im im-icon-Hamburger"></i>
					<h4>Eat</h4>
					<span class="category-box-counter">${foodCount }</span>
				</a>

				<!-- Box -->
				<a href="/festival/list" class="category-small-box">
					<i class="im im-icon-Electric-Guitar"></i>
					<h4>Festival</h4>
					<span class="category-box-counter">${festCount }</span>
				</a>

				<!-- Box -->
				<a href="/spot/list" class="category-small-box">
					<i class="im im-icon-Bridge"></i>
					<h4>Tourist Spot</h4>
					<span class="category-box-counter">${spotCount }</span>
				</a>

				<!-- Box -->
				<a href="/map/search" class="category-small-box">
					<i class="im im-icon-Arrow-TurnRight"></i>
					<h4>Route</h4>
					<span>직접 값을 설정하세요!</span>
				</a>

				<!-- Box -->
				<a href="/course/recommend" class="category-small-box">
					<i class="im im-icon-Business-Mens"></i>
					<h4>Recommand</h4>
					<span>관리자가 추천하는 코스!</span>
				</a>

				<!-- Box -->
				<a href="/board/list" class="category-small-box">
					<i class="im im-icon-Blackboard"></i>
					<h4>Notice</h4>
					<span>다양한 소식을 접하세요!</span>
				</a>

			</div>
		</div>
	</div>
</div>
<!-- Category Boxes / End -->



<section class="fullwidth margin-top-70 padding-top-75 padding-bottom-70" data-background-color="#f9f9f9">
	<!-- Info Section -->
	<div class="container">

		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<h3 class="headline centered">
					최근에 달린 리뷰
					<span class="margin-top-25">가장 최근에 달린 댓글들을 확인해 보세요!</span>
				</h3>
			</div>
		</div>

	</div>
	<!-- Info Section / End -->

	<!-- Categories Carousel -->
	<div class="fullwidth-carousel-container margin-top-20">
		<div class="testimonial-carousel testimonials">
			<c:if test="${!empty festreviewinfo }">
			<!-- Item -->
			<div class="fw-carousel-review">
				<div class="testimonial-box">
					<div class="testimonial">${festreviewinfo.fReview }</div>
				</div>
				<div class="testimonial-author">
					<img src="images/happy-client-01.jpg" alt="">
					<h4>${festmember.name } <span>Festival</span></h4>
				</div>
			</div>
			
			<!-- Item -->
			</c:if>
			<c:if test="${!empty foodreviewinfo }">
			<div class="fw-carousel-review">
				<div class="testimonial-box">
					<div class="testimonial">${foodreviewinfo.fdReview }</div>
				</div>
				<div class="testimonial-author">
					<img src="images/happy-client-02.jpg" alt="">
					<h4>${foodmember.name } <span>Eat</span></h4>
				</div>
			</div>
			</c:if>
			
			<c:if test="${!empty spotreviewinfo }">
			<!-- Item -->
			<div class="fw-carousel-review">
				<div class="testimonial-box">
					<div class="testimonial">${spotreviewinfo.sReview }</div>
				</div>
				<div class="testimonial-author">
					<img src="images/happy-client-03.jpg" alt="">
					<h4>${spotmember.name } <span>Tourist Spot</span></h4>
				</div>
			</div>
			</c:if>
			

		</div>
	</div>
	<!-- Categories Carousel / End -->

</section>
