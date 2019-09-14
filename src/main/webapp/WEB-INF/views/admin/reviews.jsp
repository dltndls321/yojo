<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<div class="col-lg-4 col-md-12">

				<div class="dashboard-list-box margin-top-0">

					<h4>Food Reviews</h4> 

					<ul>
					<c:forEach items="${foodReview}" var="foodReview">
						<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">${foodReview.memNum}<div class="comment-by-listing">on <a href="#"> ${foodReview.foodNum} </a></div> <span class="date">${foodReview.regDate}</span>
												<div class="star-rating" data-rating="${foodReview.star}"></div>
											</div>
											<p>${foodReview.fdReview}</p>										
										</div>
									</li>
								</ul>
							</div>
						</li>
					</c:forEach>
					</ul>
				</div>

			

			</div>

			<!-- Listings -->
			<div class="col-lg-4 col-md-12">

				<div class="dashboard-list-box margin-top-0">

					<h4>Festival Reviews</h4> 

					<ul>
				<c:forEach items="${festReview}" var="festReview">
						<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">${festReview.memNum}<div class="comment-by-listing">on <a href="#"> ${festReview.festNum} </a></div> <span class="date">${festReview.regDate}</span>
												<div class="star-rating" data-rating="${festReview.star}"></div>
											</div>
											<p>${festReview.fReview}</p>
										</div>
									</li>
								</ul>
							</div>
						</li>
					</c:forEach>
					</ul>
				</div>

			

			</div>
						<!-- Listings -->
			<div class="col-lg-4 col-md-12">

				<div class="dashboard-list-box margin-top-0">

					<h4>Spot Reviews</h4>

					<ul>
			<c:forEach items="${spotReview}" var="spotReview">
						<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">${spotReview.memNum}<div class="comment-by-listing">on <a href="#"> ${spotReview.spotNum} </a></div> <span class="date">${spotReview.regDate}</span>
												<div class="star-rating" data-rating="${spotReview.star}"></div>
											</div>
											<p>${spotReview.sReview}</p>
										</div>
									</li>
								</ul>
							</div>
						</li>
					</c:forEach>
					</ul>
				</div>

				
			</div>


			<!-- Copyrights -->
			<div class="col-md-12">
				<div class="copyrights">© 2019 Listeo. All Rights Reserved.</div>
			</div>
		</div>

	</div>