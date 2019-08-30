<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="dashboard-content">

		<!-- Titlebar -->
		<div id="titlebar">
			<div class="row">
				<div class="col-md-12">
					<h2>리뷰</h2>
					<!-- Breadcrumbs -->
					<nav id="breadcrumbs">
						<ul>
							<li><a href="/main/main">Home</a></li>
							<li><a href="/admin/main">Admin</a></li>
							<li>Reviews</li>
						</ul>
					</nav>
				</div>
			</div>
		</div>

		<div class="row">
			
			<!-- Listings -->
			<div class="col-lg-6 col-md-12">

				<div class="dashboard-list-box margin-top-0">

					<!-- Sort by -->
					<div class="sort-by">
						<div class="sort-by-select">
							<select data-placeholder="Default order" class="chosen-select-no-single">
								<option>All Listings</option>	
								<option>Food Reviews</option>
								<option>Spot Reviews</option>
								<option>Festival Reviews</option>
							</select>
						</div>
					</div>

					<h4>Trip Reviews</h4> 

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
											<div class="comment-by"> 누가쓴  <div class="comment-by-listing">on <a href="#"> 뭐에대한 </a></div> <span class="date">2019/08/22</span>
												<div class="star-rating" data-rating="5"></div>
											</div>
											<p>쏘ㅑㄹ라쏘ㅑㄹ라 쏘ㅑㄹ라쏘ㅑㄹ라 쏘ㅑㄹ라쏘ㅑㄹ라</p>
											
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
											<div class="comment-by"> 누가쓴 <div class="comment-by-listing">on <a href="#"> 뭐에대한 </a></div> <span class="date">2019/08/22</span>
												<div class="star-rating" data-rating="4"></div>
											</div>
											<p>쏘ㅑㄹ라쏘ㅑㄹ라 쏘ㅑㄹ라쏘ㅑㄹ라 쏘ㅑㄹ라쏘ㅑㄹ라</p>
											<a href="#small-dialog" class="rate-review popup-with-zoom-anim"><i class="sl sl-icon-action-undo"></i> Reply to this review</a>
										</div>
									</li>
								</ul>
							</div>
						</li>

					</ul>
				</div>

				<!-- Pagination -->
				<div class="clearfix"></div>
				<div class="pagination-container margin-top-30 margin-bottom-0">
					<nav class="pagination">
						<ul>
							<li><a href="#" class="current-page">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#"><i class="sl sl-icon-arrow-right"></i></a></li>
						</ul>
					</nav>
				</div>
				<!-- Pagination / End -->

			</div>

			<!-- Listings -->
			<div class="col-lg-6 col-md-12">

				<div class="dashboard-list-box margin-top-0">

					<!-- Sort by -->
					<div class="sort-by">
						<div class="sort-by-select">
							<select data-placeholder="Default order" class="chosen-select-no-single">
								<option>All Listings</option>	
								<option>Food Reviews</option>
								<option>Spot Reviews</option>
								<option>Festival Reviews</option>
							</select>
						</div>
					</div>

					<h4>Course Reviews</h4> 

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
											<div class="comment-by"> 누가쓴  <div class="comment-by-listing">on <a href="#"> 뭐에대한 </a></div> <span class="date">2019/08/22</span>
												<div class="star-rating" data-rating="5"></div>
											</div>
											<p>쏘ㅑㄹ라쏘ㅑㄹ라 쏘ㅑㄹ라쏘ㅑㄹ라 쏘ㅑㄹ라쏘ㅑㄹ라</p>
											
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
											<div class="comment-by"> 누가쓴 <div class="comment-by-listing">on <a href="#"> 뭐에대한 </a></div> <span class="date">2019/08/22</span>
												<div class="star-rating" data-rating="4"></div>
											</div>
											<p>쏘ㅑㄹ라쏘ㅑㄹ라 쏘ㅑㄹ라쏘ㅑㄹ라 쏘ㅑㄹ라쏘ㅑㄹ라</p>
											<a href="#small-dialog" class="rate-review popup-with-zoom-anim"><i class="sl sl-icon-action-undo"></i> Reply to this review</a>
										</div>
									</li>
								</ul>
							</div>
						</li>

					</ul>
				</div>

				<!-- Pagination -->
				<div class="clearfix"></div>
				<div class="pagination-container margin-top-30 margin-bottom-0">
					<nav class="pagination">
						<ul>
							<li><a href="#" class="current-page">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#"><i class="sl sl-icon-arrow-right"></i></a></li>
						</ul>
					</nav>
				</div>
				<!-- Pagination / End -->

			</div>


			<!-- Copyrights -->
			<div class="col-md-12">
				<div class="copyrights">© 2019 Listeo. All Rights Reserved.</div>
			</div>
		</div>

	</div>