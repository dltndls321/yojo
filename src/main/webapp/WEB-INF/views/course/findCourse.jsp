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


					<h4>Course Title <  ${adminCourse.subject} > </h4> 

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
	
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=13cd4e6df49574ac7ccc468bb2a978a2&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(("${food1.y}"/2+"${fest1.y}"/2), ("${food1.x}"/2+"${fest1.x}"/2)), // 지도의 중심좌표
        level: 7 // 지도의 확대 레벨
    };  



var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//선을 구성하는 좌표 배열입니다. 이 좌표들을 이어서 선을 표시합니다
var imageSrc = 'http://localimg.daum-img.net/localimages/07/2009/map/icon/blog_icon01_on.png', // 마커이미지의 주소입니다    
imageSize = new kakao.maps.Size(24, 35), // 마커이미지의 크기입니다
imageOption = {offset: new kakao.maps.Point(10, 29)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
  
//마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다

//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('${food1.area}', function(result, status) {

	
	
    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

       
        	imageSrc = 'http://localimg.daum-img.net/localimages/07/2009/map/icon/blog_icon01_on.png', // 마커이미지의 주소입니다    
        	imageSize = new kakao.maps.Size(24, 35), // 마커이미지의 크기입니다
        	imageOption = {offset: new kakao.maps.Point(10, 29)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
       
        
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords,
            image: markerImage // 마커이미지 설정 
        });
  

        // 인포윈도우로 장소에 대한 설명을 표시합니다
       
        	var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${food1.name}"+'</div>'
        });
       
        infowindow.open(map, marker);

        
    } 
});    

geocoder.addressSearch('${spot1.area}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        
        	imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png', // 마커이미지의 주소입니다    
        	imageSize = new kakao.maps.Size(24, 35), // 마커이미지의 크기입니다
        	imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
        	
        
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords,
            image: markerImage // 마커이미지 설정 
        });

  
		
        	var infowindow = new kakao.maps.InfoWindow({
    		content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${spot1.name}"+'</div>'	
        	});
    
        infowindow.open(map, marker);

        
    } 
});    

geocoder.addressSearch('${food2.area}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
       
        	imageSrc = 'http://localimg.daum-img.net/localimages/07/2009/map/icon/blog_icon01_on.png', // 마커이미지의 주소입니다    
        	imageSize = new kakao.maps.Size(24, 35), // 마커이미지의 크기입니다
        	imageOption = {offset: new kakao.maps.Point(10, 29)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
        
        
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords,
            image: markerImage // 마커이미지 설정 
        });

		
        	var infowindow = new kakao.maps.InfoWindow({
    		content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${food2.name}"+'</div>'	
        	});
    	
        infowindow.open(map, marker);


    } 
});

geocoder.addressSearch('${spot2.area}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
       
        	imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png', // 마커이미지의 주소입니다    
        	imageSize = new kakao.maps.Size(24, 35), // 마커이미지의 크기입니다
        	imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
        	// 마커 이미지를 생성합니다    
         
        
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords,
            image: markerImage // 마커이미지 설정 
        });

 
		
        	var infowindow = new kakao.maps.InfoWindow({
    		content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${spot2.name}"+'</div>'	
        	});
    	
        infowindow.open(map, marker);

        
    } 
});

geocoder.addressSearch('${food3.area}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        
        	imageSrc = 'http://localimg.daum-img.net/localimages/07/2009/map/icon/blog_icon01_on.png', // 마커이미지의 주소입니다    
        	imageSize = new kakao.maps.Size(24, 35), // 마커이미지의 크기입니다
        	imageOption = {offset: new kakao.maps.Point(10, 29)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
       
        
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords,
            image: markerImage // 마커이미지 설정 
        });

 
		
        	var infowindow = new kakao.maps.InfoWindow({
    		content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${food3.name}"+'</div>'	
        	});
    	
        infowindow.open(map, marker);

        
    } 
});

geocoder.addressSearch('${fest1.area}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        
        	imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png', // 마커이미지의 주소입니다    
        	imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
        	imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
        
        
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords,
            image: markerImage // 마커이미지 설정 
        });

       
		
        	var infowindow = new kakao.maps.InfoWindow({
    		content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${fest1.name}"+'</div>'	
        	});
        	
        
        infowindow.open(map, marker);


        
    } 
});
var linePath = [
	new kakao.maps.LatLng("${food1.y}", "${food1.x}"),
    new kakao.maps.LatLng("${spot1.y}", "${spot1.x}"),
    new kakao.maps.LatLng("${food2.y}", "${food2.x}"),
    new kakao.maps.LatLng("${spot2.y}", "${spot2.x}"),
    new kakao.maps.LatLng("${food3.y}", "${food3.x}"),
    new kakao.maps.LatLng("${fest1.y}", "${fest1.x}")
];

// 지도에 표시할 선을 생성합니다
var polyline = new kakao.maps.Polyline({
    path: linePath, // 선을 구성하는 좌표배열 입니다
    strokeWeight: 5, // 선의 두께 입니다
    strokeColor: '#FFAE00', // 선의 색깔입니다
    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
    strokeStyle: 'solid' // 선의 스타일입니다
});

// 지도에 선을 표시합니다 
polyline.setMap(map);  



</script>