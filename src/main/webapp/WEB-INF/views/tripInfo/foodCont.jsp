
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<script>
$(document).ready(function () {
    $("input:radio[name=rating]").click(function () {
      var star = $(this).val();
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
					<h2>${title}<span class="listing-tag">food</span></h2>
					<span>
						<a href="#listing-location" class="listing-address">
							<i class="fa fa-map-marker"></i>
							${addr1}
						</a>
					</span>
					<div class="star-rating" data-rating="${avg}">
						<div class="rating-counter"><a href="#listing-reviews">(${size} reviews)</a></div>
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
						<li><a href="tel:12-345-678" class="listing-links"><i class="fa fa-phone"></i> ${infocenter}</a></li>
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
								<h5>대표메뉴</h5>
								<p>${firstmenu}</p>
								
							</li>
							<li>
								<h5>취급메뉴</h5>
								<p>${treatmenu}</p>
								
							</li>
							<li>
								<h5>신용카드 가능 여부</h5>
								<p>${chkcard}</p>
							</li>
							<li>
								<h5>금연/흡연</h5>
								<p>${smoking}</p>
							</li>
							<li>
								<h5>포장가능</h5>
								<p>${packing}</p>
							</li>
							<li>
								<h5>주차가능</h5>
								<p>${parking}</p>
							</li>
							<li>
								<h5>이용시간</h5>
								<p>${opentime}</p>					
							</li>
							<li>
								<h5>쉬는날</h5>
								<p>${restdate}</p>					
							</li>
						</ul>

					</div>

			</div>
			<!-- Food Menu / End -->

		
			<!-- Location -->
			<div id="listing-location" class="listing-section">
				<h3 class="listing-desc-headline margin-top-60 margin-bottom-30">Location</h3>

				<div id="singleListingMap-container">
					<div id="singleListingMap" data-latitude="40.70437865245596" data-longitude="-73.98674011230469" data-map-icon="im im-icon-Hamburger">
					<div id="map" style="width:100%;height:350px;"></div> </div>
					<a href="#" id="streetView">Street View</a>
				</div>
			</div>
		<c:if test="${not empty reviewList}">
			<!-- Reviews -->
			<div id="listing-reviews" class="listing-section">
				<h3 class="listing-desc-headline margin-top-75 margin-bottom-20">Reviews <span></span></h3>

				<!-- Rating Overview -->
				<div class="rating-overview">
					<div class="rating-overview-box">
						<span class="rating-overview-box-total">${avg}</span>
						<span class="rating-overview-box-percent">out of 5.0</span>
						<div class="star-rating" data-rating="${avg}"></div>
					</div>

					<div class="rating-bars">
							<div class="rating-bars-item">
								<span class="rating-bars-name">${size}명의 회원이 평가하였습니다 </span>
								<span class="rating-bars-inner">
									<span class="rating-bars-rating" data-rating="${avg}">
										<span class="rating-bars-rating-inner"></span>
									</span>
									<strong>${avg}</strong>
								</span>
							</div>
							<div class="glyph fs1">
							<div class="clearfix bshadow0 pbs">
							<span class="im im-icon-${emotion}"></span><span class="mls"></span>
							</div>
							</div>
							
							
							
					</div>
				</div>
				<!-- Rating Overview / End -->


				<div class="clearfix"></div>

				<!-- Reviews -->
				<section class="comments listing-reviews">
					<ul>
					<c:forEach var="review" items="${reviewList }" varStatus="status">
						<li>
							<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
							<div class="comment-content"><div class="arrow-comment"></div>
								<div class="comment-by">${memList[status.index]} <i class="tip" data-tip-content="Person who left this review actually was a customer"></i> <span class="date"><fmt:formatDate value="${review.regDate}" pattern="yyyy년 MM월 dd일" /></span>
									<div class="star-rating" data-rating="${review.star}"></div>
								</div>
								<p>${review.fdReview }</p>
							</div>
						</li>
					</c:forEach>
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
			</c:if>
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
						<div class="sub-rating-title">rating <i class="tip" data-tip-content="1-5개까지 설정하실 수 있습니다."></i></div>
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
				<form id="add-comment" class="add-comment" action ="/food/review">
					<fieldset>
						<input type="hidden" name="name" value="${title}">
						<input type="hidden" name="area" value="${addr1}">
						<input type="hidden" name="foodx" value="${mapx}">
						<input type="hidden" name="foody" value="${mapy}">
						<input type="hidden" name="typeid" value="${typeid}">
						<input type="hidden" name="contid" value="${contid}">
						<div>
							<label>Review:</label>
							<textarea cols="40" rows="3" id ="review" name = "fdReview"></textarea>
						</div>

					</fieldset>

					<input type="submit" class="button" id ="writeReview"></button>
					<div class="clearfix"></div>
				</form>

			</div>
			<!-- Add Review Box / End -->


		</div>

	</div>
</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=13cd4e6df49574ac7ccc468bb2a978a2&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch("${addr1}", function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${title}"+'</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>