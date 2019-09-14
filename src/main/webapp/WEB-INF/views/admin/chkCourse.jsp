<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<div class="dashboard-content">

		<!-- Titlebar -->
		<div id="titlebar">
			<div class="row">
				<div class="col-md-12">
					<h2>Course</h2>
					
				</div>
			</div>
		</div>

		<div class="row">
			<!-- Listings -->
			<div class="col-lg-2 col-md-12">
				
			</div>
			<!-- Listings -->
			<div class="col-lg-8 col-md-12">

				<div class="dashboard-list-box margin-top-0">

					<h4>${title}</h4> 

					<ul>
					<li>테마 : ${theme}<br/>
						여행기간 : 
						<fmt:formatDate value="${startdate}" pattern="yyyy년 MM월 dd일" />
						~
						<fmt:formatDate value="${enddate}" pattern="yyyy년 MM월 dd일" /><br/>
						지역코드 : ${area}<br/>
						음식코드 : ${arrayfood}<br/>
						관광지코드 : ${arrayspot}
					
					</li>
						<li>
							<div class="comments listing-reviews">
								<ul>
									<li>
										<div class="avatar"><img src="/resources/images/food.png" alt="" /></div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">
												${food[0]}
											</div>
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
											<div class="comment-by">
											${spot[0]} 
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
											<div class="comment-by">
											
											${food[1]} 
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
											<div class="comment-by">
											${spot[1]} 
											</div>
											
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
											<div class="comment-by">
											${food[2]} 
											</div>
											
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
											<div class="comment-by">
											${fest}
											</div>
											
										</div>

									</li>
								</ul>
							</div>
						</li>

					</ul>
				</div>

			
			</div>

			<!-- Listings -->
			<div class="col-lg-2 col-md-12">
				
			</div>


			<!-- Copyrights -->
			<div class="col-md-12">
				<div class="copyrights">© 2019 Listeo. All Rights Reserved.</div>
			</div>
		</div>

	</div>