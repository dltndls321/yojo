<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<!-- Titlebar
================================================== -->
<div id="titlebar" class="gradient">
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<div class="user-profile-titlebar">
					<div class="user-profile-avatar"><img src="images/user-profile-avatar.jpg" alt=""></div>
					<div class="user-profile-name">
						<h2> ${memberInfo.name}</h2>
						<c:if test="${memberInfo.status ne 1}">
						<div class="star-rating" data-rating="${avg}">
							<div class="rating-counter"> ${reviewListsize + spotreviewListsize}개 리뷰했어요! (${avg})</div>
						</div>
						</c:if>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>



<!-- Content
================================================== -->
<div class="container">
	<div class="row sticky-wrapper">


		<!-- Sidebar
		================================================== -->
		<div class="col-lg-4 col-md-4 margin-top-0">
				
			<!-- Verified Badge -->
			<c:choose>
				<c:when test="${memberInfo.status eq 1}">
					<div class="verified-badge with-tip" data-tip-content="Account has been verified and belongs to the person or organization represented."style="background-color: red;">
						<i class="sl sl-icon-user-unfollow"></i> 이메일을 확인해 주세요.
					</div>
				</c:when>
				<c:otherwise>
					<div class="verified-badge with-tip" data-tip-content="Account has been verified and belongs to the person or organization represented.">
						<i class="sl sl-icon-user-following"></i> 인증되었습니다.
					</div>
				</c:otherwise>
			</c:choose>
			

			<!-- Contact -->
			<div class="boxed-widget margin-top-30 margin-bottom-50">
				<h3>회원 정보</h3>
				<ul class="listing-details-sidebar">
					<li><i class="fa fa-home"></i> 주소 : ${memberInfo.address}</a></li>
					<li><i class="sl sl-icon-phone"></i> 번호 : ${memberInfo.phone}</li>
					<li><i class="fa fa-envelope-o"></i> 이메일 : ${memberInfo.email}</a></li>
					<%-- <li><i class="fa fa-envelope-o"></i> <a href="#">빨간색 : ${memberInfo.email}</a></li> --%>
				</ul>
				<c:if test="${memberInfo.status ne 1}">
				<br/>
				<br/>
				<a href="/member/updateMember" class="button"><i class="sl sl-icon-user"></i> 회원정보 수정</a>
				</c:if>
			</div>
			<!-- Contact / End-->

		</div>
		<!-- Sidebar / End -->


		<!-- Content
		================================================== -->
		<c:choose>
			<c:when test="${memberInfo.status ne 1}">
			<div class="col-lg-8 col-md-8 padding-left-30">

			<h3 class="margin-top-0 margin-bottom-40">게시판</h3>
			<!-- Listings Container -->
			<div class="row">
			<c:if test="${!empty boardList }">
			<c:forEach items="${boardList }" var="boardLists">
				<!-- Listing Item -->
				<div class="col-lg-12 col-md-12">
					<div class="listing-item-container list-layout">
						<a href="listings-single-page.html" class="listing-item">
							<!-- Image -->
							<div class="listing-item-image">
								<img src="${boardLists.fname }" alt="" style="width: 194px;height: 220px;">
							</div>
							
							<!-- Content -->
							
							<div class="listing-item-content">
							<div class="listing-item-inner">
									<h3>${boardLists.subject }</h3>
									<span>${boardLists.regdate }</span>
								</div>
							</div>
							
						</a>
					</div>
				</div>
				</c:forEach>
			</c:if>
			<c:if test="${empty boardList }">
				<div class="col-lg-12 col-md-12">
					<div class="listing-item-container list-layout">
						<a class="listing-item">
							<div class="listing-item-content">
							<div class="listing-item-inner">
									<h3>작성한 글이 없습니다.</h3>
								</div>
							</div>
							
						</a>
					</div>
				</div>
			</c:if>
			
				<!-- Listing Item / End -->
				<div class="col-md-12 browse-all-user-listings">
					<a href="#">Browse All Listings <i class="fa fa-angle-right"></i> </a>
				</div>

			</div>
			<!-- Listings Container / End -->

				
			<!-- Reviews -->
			<div id="listing-reviews" class="listing-section">
				<h3 class="margin-top-60 margin-bottom-20">리뷰 목록</h3>

				<div class="clearfix"></div>

				<!-- Reviews -->
				<section class="comments listing-reviews">
					<h4 class="margin-top-60 margin-bottom-20">축제 리뷰</h4>
					<c:if test="${!empty festList }">
					<ul>
					
					<c:forEach var="festlists" items="${festList}" varStatus="status">
						<li>
							<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
							<div class="comment-content"><div class="arrow-comment"></div>
								<div class="comment-by"> ${festlists.name} <div class="comment-by-listing"></div> <span class="date"><fmt:formatDate value="${reviewList[status.index].regDate }" pattern="yyyy년 MM월 dd일" /> </span>
									<div class="star-rating" data-rating="${reviewList[status.index].star }"></div>
								</div>
								<p> ${reviewList[status.index].fReview} </p>
								
								<div class="review-images mfp-gallery-container">
									<a href="images/review-image-01.jpg" class="mfp-gallery"><img src="images/review-image-01.jpg" alt=""></a>
								</div>
							</div>
						</li>
					</c:forEach>
					 </ul>
					 </c:if>
					 <c:if test="${empty festList }">
						<div class="col-lg-12 col-md-12">
							<div class="listing-item-container list-layout">
								<a class="listing-item">
									<div class="listing-item-content">
									<div class="listing-item-inner">
											<h3>작성한 글이 없습니다.</h3>
										</div>
									</div>
									
								</a>
							</div>
						</div>
					 </c:if>
				</section>
				<c:if test="${!empty festList }">
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
				<!-- Pagination / End -->
				</c:if>
				<div class="clearfix"></div>
				
				<!-- Reviews -->
				<section class="comments listing-reviews">
					<h4 class="margin-top-60 margin-bottom-20">관광지 리뷰</h4>
					<c:if test="">
					<ul>
					<c:forEach var="spotLists" items="${spotList}" varStatus= "status">
						<li>
							<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
							<div class="comment-content"><div class="arrow-comment"></div>
								<div class="comment-by"> ${spotLists.name} <div class="comment-by-listing"></div> <span class="date"><fmt:formatDate value="${spotReviewList[status.index].regDate }" pattern="yyyy년 MM월 dd일" /> </span>
									<div class="star-rating" data-rating="${spotReviewList[status.index].star }"></div>
								</div>
								<p> ${spotReviewList[status.index].sReview} </p>
								
								<div class="review-images mfp-gallery-container">
									<a href="images/review-image-01.jpg" class="mfp-gallery"><img src="images/review-image-01.jpg" alt=""></a>
								</div>
							</div>
						</li>
					</c:forEach>
					 </ul>
					 </c:if>
					 <c:if test="${empty spotList}">
					 	<div class="col-lg-12 col-md-12">
							<div class="listing-item-container list-layout">
								<a class="listing-item">
									<div class="listing-item-content">
									<div class="listing-item-inner">
											<h3>작성한 글이 없습니다.</h3>
										</div>
									</div>
									
								</a>
							</div>
						</div>
					 </c:if>
				</section>

				<!-- Pagination -->
				<div class="clearfix"></div>
				<c:if test="${!empty spotList}">
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
				</c:if>
				<div class="clearfix"></div>
				<!-- Pagination / End -->
			</div>
		</div>
			</c:when>
			<c:otherwise>
			<div class="col-lg-8 col-md-8 padding-left-30">
			<h3 class="margin-top-0 margin-bottom-40">인증 번호 입력</h3>
			<!-- Listings Container -->
				<div class="row">
					<!-- Listing Item -->
					<div class="col-lg-12 col-md-12">
						<div class="listing-item-container list-layout">
							<a class="listing-item">
								<!-- Content -->
								<div class="listing-item-content">
									<div class="listing-item-inner">
										<input class="input-text" type="text" id="emailok" name="emailok">
										<button class="button border fw margin-top-10" onclick="emailok();">인증번호 확인</button>
									</div>
								</div>
							</a>
						</div>
					</div>
					<!-- Listing Item / End -->
				</div>
			<!-- Listings Container / End -->
		</div>
			</c:otherwise>
		</c:choose>
		
	</div>
</div>