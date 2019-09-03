<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="dashboard-content">

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

					<!-- Reply to review popup -->
					<div id="small-dialog" class="zoom-anim-dialog mfp-hide">
						<div class="small-dialog-header">
							<h3>Reply to review</h3>
						</div>
						<div class="message-reply margin-top-0">
							<textarea cols="40" rows="3"></textarea>
							<button class="button">Reply</button>
						</div>
					</div>

					<ul>

						<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">Kathy Brown <div class="comment-by-listing">on <a href="#">Burger House</a></div> <span class="date">June 2019</span>
												<div class="star-rating" data-rating="5"></div>
											</div>
											<p>Morbi velit eros, sagittis in facilisis non, rhoncus et erat. Nam posuere tristique sem, eu ultricies tortor imperdiet vitae. Curabitur lacinia neque non metus</p>
											
											<div class="review-images mfp-gallery-container">
												<a href="images/review-image-01.jpg" class="mfp-gallery"><img src="images/review-image-01.jpg" alt=""></a>
											</div>
											<a href="#small-dialog" class="rate-review popup-with-zoom-anim"><i class="sl sl-icon-action-undo"></i> Reply to this review</a>
										</div>
									</li>
								</ul>
							</div>
						</li>

						<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /> </div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">John Doe <div class="comment-by-listing">on <a href="#">Burger House</a></div> <span class="date">May 2019</span>
												<div class="star-rating" data-rating="4"></div>
											</div>
											<p>Commodo est luctus eget. Proin in nunc laoreet justo volutpat blandit enim. Sem felis, ullamcorper vel aliquam non, varius eget justo. Duis quis nunc tellus sollicitudin mauris.</p>
											<a href="#small-dialog" class="rate-review popup-with-zoom-anim"><i class="sl sl-icon-action-undo"></i> Reply to this review</a>
										</div>
									</li>
								</ul>
							</div>
						</li>

						<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">Kathy Brown <div class="comment-by-listing">on <a href="#">Burger House</a></div> <span class="date">June 2019</span>
												<div class="star-rating" data-rating="5"></div>
											</div>
											<p>Morbi velit eros, sagittis in facilisis non, rhoncus et erat. Nam posuere tristique sem, eu ultricies tortor imperdiet vitae. Curabitur lacinia neque non metus</p>
											
											<div class="review-images mfp-gallery-container">
												<a href="images/review-image-02.jpg" class="mfp-gallery"><img src="images/review-image-02.jpg" alt=""></a>
												<a href="images/review-image-03.jpg" class="mfp-gallery"><img src="images/review-image-03.jpg" alt=""></a>
											</div>
											<a href="#small-dialog" class="rate-review popup-with-zoom-anim"><i class="sl sl-icon-action-undo"></i> Reply to this review</a>
										</div>
									</li>
								</ul>
							</div>
						</li>

						<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /> </div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">John Doe <div class="comment-by-listing">on <a href="#">Burger House</a></div> <span class="date">May 2019</span>
												<div class="star-rating" data-rating="5"></div>
											</div>
											<p>Commodo est luctus eget. Proin in nunc laoreet justo volutpat blandit enim. Sem felis, ullamcorper vel aliquam non, varius eget justo. Duis quis nunc tellus sollicitudin mauris.</p>
											<a href="#small-dialog" class="rate-review popup-with-zoom-anim"><i class="sl sl-icon-action-undo"></i> Reply to this review</a>
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
					<h4>Your Reviews</h4>
					<ul>

						<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="images/reviews-avatar.jpg" alt="" /> </div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">Your review <div class="comment-by-listing own-comment">on <a href="#">Tom's Restaurant</a></div> <span class="date">May 2019</span>
												<div class="star-rating" data-rating="4.5"></div>
											</div>
											<p>Commodo est luctus eget. Proin in nunc laoreet justo volutpat blandit enim. Sem felis, ullamcorper vel aliquam non, varius eget justo. Duis quis nunc tellus sollicitudin mauris.</p>
											<a href="#" class="rate-review"><i class="sl sl-icon-note"></i> Edit</a>
										</div>

									</li>
								</ul>
							</div>
						</li>

						<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="images/reviews-avatar.jpg" alt="" /> </div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">Your review <div class="comment-by-listing own-comment">on <a href="#">Think Coffee</a></div> <span class="date">May 2019</span>
												<div class="star-rating" data-rating="5"></div>
											</div>
											<p>Commodo est luctus eget. Proin in nunc laoreet justo volutpat blandit enim. Sem felis, ullamcorper vel aliquam non, varius eget justo. Duis quis nunc tellus sollicitudin mauris.</p>
											<a href="#" class="rate-review"><i class="sl sl-icon-note"></i> Edit</a>
										</div>

									</li>
								</ul>
							</div>
						</li>

					</ul>
				</div>
			</div>

</div>
	</div>