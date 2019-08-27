<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(document).ready(function () {
    $("input:radio[name=rating]").click(function () {
      var star = $(this).val();
      alert(star)
      $('#add-comment').prepend("<input type='hidden' name = 'star' value =" + star +">")
      
    });

 
  });

</script>
<!-- Slider
================================================== -->

<div class="listing-slider mfp-gallery-container margin-bottom-0">
<c:forEach items="${img }" var="imges" varStatus="status">
	<a href="${img[status.index]}" data-background-image="${img[status.index]}" class="item mfp-gallery"></a>
</c:forEach>
</div>


<!-- Content
================================================== -->
<div class="container">
	<div class="row sticky-wrapper">
		<div class="col-lg-12 col-md-12 padding-right-30">

			<!-- Titlebar -->
			<div id="titlebar" class="listing-titlebar">
				<div class="listing-titlebar-title">
					<h2>${title}<span class="listing-tag">Services</span></h2>
					<span>
						<a href="#listing-location" class="listing-address">
							<i class="fa fa-map-marker"></i>
							${addr1}
						</a>
					</span>
					<div class="star-rating" data-rating="5">
						<div class="rating-counter"><a href="#listing-reviews">(12 reviews)</a></div>
					</div>
				</div>
			</div>

			<!-- Listing Nav -->
			<div id="listing-nav" class="listing-nav-container">
				<ul class="listing-nav">
					<li><a href="#listing-overview" class="active">Overview</a></li>
					<li><a href="#listing-pricing-list">Detail</a></li>
					<li><a href="#listing-location">Location</a></li>
					<li><a href="#listing-reviews">Reviews</a></li>
					<li><a href="#add-review">Add Review</a></li>
				</ul>
			</div>
			
			<!-- Overview -->
			<div id="listing-overview" class="listing-section">

				<!-- Description -->

				${overview}
				
				
				<!-- Listing Contacts -->
				<div class="listing-links-container">

					<ul class="listing-links contact-links">
						<li><a href="tel:12-345-678" class="listing-links"><i class="fa fa-phone"></i> ${tel}</a></li>
						<li><i class="fa fa-link"></i> ${link }</li>
					</ul>
					<div class="clearfix"></div>

			
					<div class="clearfix"></div>

				</div>
				<div class="clearfix"></div>
			</div>


			<!-- Food Menu -->
			<div id="listing-pricing-list" class="listing-section">
				<h3 class="listing-desc-headline margin-top-70 margin-bottom-30">Detail</h3>

					<div class="pricing-list-container">
						
						<!-- Food List -->
						<h4>Detail Info</h4>
						<ul>
							<li>
								<h5>연령제한</h5>
								<p>${agelimit}</p>
								
							</li>
							<li>
								<h5>요금</h5>
								<span>${fee}</span>
							</li>
							<li>
								<h5>행사기간</h5>
								<p>${fdate1} ~ ${fdate2}</p>					
							</li>
						</ul>

					</div>

			</div>
			<!-- Food Menu / End -->

		
			<!-- Location -->
			<div id="listing-location" class="listing-section">
				<h3 class="listing-desc-headline margin-top-60 margin-bottom-30">Location</h3>

				<div id="singleListingMap-container">
					<div id="singleListingMap" data-latitude="40.70437865245596" data-longitude="-73.98674011230469" data-map-icon="im im-icon-Hamburger"></div>
					<a href="#" id="streetView">Street View</a>
				</div>
			</div>
				
			<!-- Reviews -->
			<div id="listing-reviews" class="listing-section">
				<h3 class="listing-desc-headline margin-top-75 margin-bottom-20">Reviews <span>(12)</span></h3>

				<!-- Rating Overview -->
				<div class="rating-overview">
					<div class="rating-overview-box">
						<span class="rating-overview-box-total">4.2</span>
						<span class="rating-overview-box-percent">out of 5.0</span>
						<div class="star-rating" data-rating="5"></div>
					</div>

					<div class="rating-bars">
							<div class="rating-bars-item">
								<span class="rating-bars-name">Service <i class="tip" data-tip-content="Quality of customer service and attitude to work with you"></i></span>
								<span class="rating-bars-inner">
									<span class="rating-bars-rating" data-rating="4.2">
										<span class="rating-bars-rating-inner"></span>
									</span>
									<strong>4.2</strong>
								</span>
							</div>
							<div class="rating-bars-item">
								<span class="rating-bars-name">Value for Money <i class="tip" data-tip-content="Overall experience received for the amount spent"></i></span>
								<span class="rating-bars-inner">
									<span class="rating-bars-rating" data-rating="2.8">
										<span class="rating-bars-rating-inner"></span>
									</span>
									<strong>2.8</strong>
								</span>
							</div>
							<div class="rating-bars-item">
								<span class="rating-bars-name">Location <i class="tip" data-tip-content="Visibility, commute or nearby parking spots"></i></span>
								<span class="rating-bars-inner">
									<span class="rating-bars-rating" data-rating="3.7">
										<span class="rating-bars-rating-inner"></span>
									</span>
									<strong>3.7</strong>
								</span>
							</div>
							<div class="rating-bars-item">
								<span class="rating-bars-name">Cleanliness <i class="tip" data-tip-content="The physical condition of the business"></i></span>
								<span class="rating-bars-inner">
									<span class="rating-bars-rating" data-rating="4.0">
										<span class="rating-bars-rating-inner"></span>
									</span>
									<strong>4.5</strong>
								</span>
							</div>
					</div>
				</div>
				<!-- Rating Overview / End -->


				<div class="clearfix"></div>

				<!-- Reviews -->
				<section class="comments listing-reviews">
					<ul>
						<li>
							<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
							<div class="comment-content"><div class="arrow-comment"></div>
								<div class="comment-by">Kathy Brown <i class="tip" data-tip-content="Person who left this review actually was a customer"></i> <span class="date">June 2019</span>
									<div class="star-rating" data-rating="5"></div>
								</div>
								<p>Morbi velit eros, sagittis in facilisis non, rhoncus et erat. Nam posuere tristique sem, eu ultricies tortor imperdiet vitae. Curabitur lacinia neque non metus</p>
								
								<div class="review-images mfp-gallery-container">
									<a href="images/review-image-01.jpg" class="mfp-gallery"><img src="images/review-image-01.jpg" alt=""></a>
								</div>
								<a href="#" class="rate-review"><i class="sl sl-icon-like"></i> Helpful Review <span>12</span></a>
							</div>
						</li>

						<li>
							<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /> </div>
							<div class="comment-content"><div class="arrow-comment"></div>
								<div class="comment-by">John Doe<span class="date">May 2019</span>
									<div class="star-rating" data-rating="4"></div>
								</div>
								<p>Commodo est luctus eget. Proin in nunc laoreet justo volutpat blandit enim. Sem felis, ullamcorper vel aliquam non, varius eget justo. Duis quis nunc tellus sollicitudin mauris.</p>
								<a href="#" class="rate-review"><i class="sl sl-icon-like"></i> Helpful Review <span>2</span></a>
							</div>
						</li>

						<li>
							<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
							<div class="comment-content"><div class="arrow-comment"></div>
								<div class="comment-by">Kathy Brown<span class="date">June 2019</span>
									<div class="star-rating" data-rating="5"></div>
								</div>
								<p>Morbi velit eros, sagittis in facilisis non, rhoncus et erat. Nam posuere tristique sem, eu ultricies tortor imperdiet vitae. Curabitur lacinia neque non metus</p>
								
								<div class="review-images mfp-gallery-container">
									<a href="images/review-image-02.jpg" class="mfp-gallery"><img src="images/review-image-02.jpg" alt=""></a>
									<a href="images/review-image-03.jpg" class="mfp-gallery"><img src="images/review-image-03.jpg" alt=""></a>
								</div>
								<a href="#" class="rate-review"><i class="sl sl-icon-like"></i> Helpful Review <span>4</span></a>
							</div>
						</li>

						<li>
							<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /> </div>
							<div class="comment-content"><div class="arrow-comment"></div>
								<div class="comment-by">John Doe<span class="date">May 2019</span>
									<div class="star-rating" data-rating="5"></div>
								</div>
								<p>Commodo est luctus eget. Proin in nunc laoreet justo volutpat blandit enim. Sem felis, ullamcorper vel aliquam non, varius eget justo. Duis quis nunc tellus sollicitudin mauris.</p>
								<a href="#" class="rate-review"><i class="sl sl-icon-like"></i> Helpful Review</a>
							</div>

						</li>
					 </ul>
				</section>

				<!-- Pagination -->
				<div class="clearfix"></div>
				<div class="row">
					<div class="col-md-12">
						<!-- Pagination -->
						<div class="pagination-container margin-top-30">
							<nav class="pagination">
								<ul>
									<li><a href="#" class="current-page">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#"><i class="sl sl-icon-arrow-right"></i></a></li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
				<!-- Pagination / End -->
			</div>


			<!-- Add Review Box -->
			<div id="add-review" class="add-review-box">

				<!-- Add Review -->
				<h3 class="listing-desc-headline margin-bottom-10">후기 작성하기</h3>
				<p class="comment-notes">다른 회원분들을 위해 후기를 작성해 주세요!</p>

				<!-- Subratings Container -->
				<div class="sub-ratings-container">

					<!-- Subrating #1 -->
					<div class="add-sub-rating">
						<div class="sub-rating-title">rating <i class="tip" data-tip-content="Quality of customer service and attitude to work with you"></i></div>
						<div class="sub-rating-stars">
							<!-- Leave Rating -->
							<div class="clearfix"></div>
							<form class="leave-rating">
								<input type="radio" name="rating" id="rating-5" value="5"/>
								<label for="rating-5" class="fa fa-star"></label>
								<input type="radio" name="rating" id="rating-4" value="4"/>
								<label for="rating-4" class="fa fa-star"></label>
								<input type="radio" name="rating" id="rating-3" value="3"/>
								<label for="rating-3" class="fa fa-star"></label>
								<input type="radio" name="rating" id="rating-2" value="2"/>
								<label for="rating-2" class="fa fa-star"></label>
								<input type="radio" name="rating" id="rating-1" value="1"/>
								<label for="rating-1" class="fa fa-star"></label>
							</form>
						</div>
					</div>

					

				</div>
				<!-- Subratings Container / End -->

				<!-- Review Comment -->
				<form id="add-comment" class="add-comment" action ="/festival/review">
					<fieldset>
						<input type="hidden" name="subject" value="${title}">
						<input type="hidden" name="area" value="${addr1}">
						<input type="hidden" name="fdate1" value="${fdate1}" >
						<input type="hidden" name="fdate2" value="${fdate2}">
						<input type="hidden" name="link" value='${link}'>
						<input type="hidden" name="fmapx" value="${mapx}">
						<input type="hidden" name="fmapy" value="${mapy}">
						
						<div>
							<label>Review:</label>
							<textarea cols="40" rows="3" id ="review" name = "fReview"></textarea>
						</div>

					</fieldset>

					<input type="submit" class="button" id ="writeReview">Submit Review</button>
					<div class="clearfix"></div>
				</form>

			</div>
			<!-- Add Review Box / End -->


		</div>

	</div>
</div>
