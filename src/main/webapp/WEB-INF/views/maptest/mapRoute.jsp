<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<div id="map" style="width:100%;height:800px;"></div>   
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=13cd4e6df49574ac7ccc468bb2a978a2&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng("${Area0.y}", "${Area0.x}"), // 지도의 중심좌표
        level: 6 // 지도의 확대 레벨
    };  



var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//선을 구성하는 좌표 배열입니다. 이 좌표들을 이어서 선을 표시합니다


//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('${Area0.area}', function(result, status) {

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
            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${Area0.name}"+'</div>'
        });
       
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    

geocoder.addressSearch('${Area1.area}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

  
		
        	var infowindow = new kakao.maps.InfoWindow({
    		content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${Area1.name}"+'</div>'	
        	});
    
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    

geocoder.addressSearch('${Area2.area}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

		
        	var infowindow = new kakao.maps.InfoWindow({
    		content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${Area2.name}"+'</div>'	
        	});
    	
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});

geocoder.addressSearch('${Area3.area}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

 
		
        	var infowindow = new kakao.maps.InfoWindow({
    		content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${Area3.name}"+'</div>'	
        	});
    	
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});

geocoder.addressSearch('${Area4.area}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

 
		
        	var infowindow = new kakao.maps.InfoWindow({
    		content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${Area4.name}"+'</div>'	
        	});
    	
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});

geocoder.addressSearch('${Area5.area}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

       
		
        	var infowindow = new kakao.maps.InfoWindow({
    		content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${Area5.name}"+'</div>'	
        	});
    	
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});
var linePath = [
	new kakao.maps.LatLng("${Area0.y}", "${Area0.x}"),
    new kakao.maps.LatLng("${Area1.y}", "${Area1.x}"),
    new kakao.maps.LatLng("${Area2.y}", "${Area2.x}"),
    new kakao.maps.LatLng("${Area3.y}", "${Area3.x}"),
    new kakao.maps.LatLng("${Area4.y}", "${Area4.x}"),
    new kakao.maps.LatLng("${Area5.y}", "${Area5.x}")
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
</body>
</html>