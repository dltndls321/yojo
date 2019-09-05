<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				Popular Categories
				<span>Browse <i>the most desirable</i> categories</span>
			</h3>
		</div>

	</div>
</div>


<!-- Content
================================================== -->
<div class="container">
	<div class="row">

		<div class="col-md-12">
			<h3 class="headline centered margin-top-75">
				Browse Categories
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
				<a href="listings-list-with-sidebar.html" class="category-small-box">
					<i class="im im-icon-Hamburger"></i>
					<h4>Eat & Drink</h4>
					<span class="category-box-counter">12</span>
				</a>

				<!-- Box -->
				<a href="listings-list-with-sidebar.html" class="category-small-box">
					<i class="im  im-icon-Sleeping"></i>
					<h4>Hotels</h4>
					<span class="category-box-counter">32</span>
				</a>

				<!-- Box -->
				<a href="listings-list-with-sidebar.html" class="category-small-box">
					<i class="im im-icon-Shopping-Bag"></i>
					<h4>Shops</h4>
					<span class="category-box-counter">11</span>
				</a>

				<!-- Box -->
				<a href="listings-list-with-sidebar.html" class="category-small-box">
					<i class="im im-icon-Cocktail"></i>
					<h4>Nightlife</h4>
					<span class="category-box-counter">15</span>
				</a>

				<!-- Box -->
				<a href="listings-list-with-sidebar.html" class="category-small-box">
					<i class="im im-icon-Electric-Guitar"></i>
					<h4>Events</h4>
					<span class="category-box-counter">21</span>
				</a>

				<!-- Box -->
				<a href="listings-list-with-sidebar.html" class="category-small-box">
					<i class="im im-icon-Dumbbell"></i>
					<h4>Fitness</h4>
					<span class="category-box-counter">28</span>
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

			<!-- Item -->
			<div class="fw-carousel-review">
				<div class="testimonial-box">
					<div class="testimonial">Bring to the table win-win survival strategies to ensure proactive domination. At the end of the day, going forward, a new normal that has evolved from generation is on the runway heading towards a streamlined cloud solution user generated content.</div>
				</div>
				<div class="testimonial-author">
					<img src="images/happy-client-01.jpg" alt="">
					<h4>Jennie Smith <span>Eat</span></h4>
				</div>
			</div>
			
			<!-- Item -->
			<div class="fw-carousel-review">
				<div class="testimonial-box">
					<div class="testimonial">Capitalize on low hanging fruit to identify a ballpark value added activity to beta test. Override the digital divide with additional clickthroughs from DevOps. Nanotechnology immersion along the information highway will close the loop.</div>
				</div>
				<div class="testimonial-author">
					<img src="images/happy-client-02.jpg" alt="">
					<h4>Tom Baker <span>Clothing Store Owner</span></h4>
				</div>
			</div>

			<!-- Item -->
			<div class="fw-carousel-review">
				<div class="testimonial-box">
					<div class="testimonial">Leverage agile frameworks to provide a robust synopsis for high level overviews. Iterative approaches to corporate strategy foster collaborative thinking to further the overall value proposition. Organically grow the holistic world view.</div>
				</div>
				<div class="testimonial-author">
					<img src="images/happy-client-03.jpg" alt="">
					<h4>Jack Paden <span>Restaurant Owner</span></h4>
				</div>
			</div>

		</div>
	</div>
	<!-- Categories Carousel / End -->

</section>
