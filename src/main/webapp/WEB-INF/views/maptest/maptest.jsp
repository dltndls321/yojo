<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
    
.overlaybox {position:absolute;width:360px;height:230px;background:url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/box_movie.png') no-repeat;padding:15px 10px;}
.overlaybox div, ul {overflow:hidden;margin:0;padding:0;}
.overlaybox li {list-style: none;}
.overlaybox .boxtitle {color:#fff;font-size:16px;font-weight:bold;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png') no-repeat right 120px center;margin-bottom:8px;}
.overlaybox .first {position:absolute;width:247px;height:136px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/thumb.png') no-repeat;margin-bottom:8px;}
.first .text {color:#fff;font-weight:bold;}
.first .triangle {position:absolute;width:48px;height:48px;top:0;left:0;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/triangle.png') no-repeat; padding:6px;font-size:18px;}
.first .movietitle {position:absolute;width:100%;bottom:0;background:rgba(0,0,0,0.4);padding:7px 15px;font-size:14px;}
.overlaybox ul {width:247px;}
.overlaybox li {position:relative;margin-bottom:2px;background:#2b2d36;padding:5px 10px;color:#aaabaf;line-height: 1;}
.overlaybox li span {display:inline-block;}
.overlaybox li .number {font-size:16px;font-weight:bold;}
.overlaybox li .title {font-size:13px;}
.overlaybox ul .arrow {position:absolute;margin-top:8px;right:25px;width:5px;height:3px;background:url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/updown.png') no-repeat;} 
.overlaybox li .up {background-position:0 -40px;}
.overlaybox li .down {background-position:0 -60px;}
.overlaybox li .count {position:absolute;margin-top:5px;right:15px;font-size:10px;}
.overlaybox li:hover {color:#fff;background:#d24545;}
.overlaybox li:hover .up {background-position:0 0px;}
.overlaybox li:hover .down {background-position:0 -20px;}   
</style>
</head>
<body>


<div id="map" style="width:100%;height:800px;"></div>




<!--스크립트 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=13cd4e6df49574ac7ccc468bb2a978a2&libraries=services"></script>
<script>




var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng("${centerY}", "${centerX}"), // 지도의 중심좌표
        level: 7 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    

var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();


var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png', // 마커이미지의 주소입니다    
imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
  
//마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다

var iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

//리스트 주소 받아오기
//주소로 좌표를 검색합니다

	
<c:forEach items="${foodList}" var="foodLists" >	
geocoder.addressSearch("${foodLists.address}", function(result, status) {
	
	
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
            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${foodLists.foodname}"+
            '<center><a href="#" onclick="foodSet1(\''+"${foodLists.foodname}"+'\')">맛집1로 설정</a><br><a href="#" onclick="foodSet2(\''+"${foodLists.foodname}"+'\')">맛집2로 설정</a>'+
            '<br><a href="#" onclick="foodSet3(\''+"${foodLists.foodname}"+'\')">맛집3으로 설정</a></center></div>',
            removable : iwRemoveable
        });
        
       
        /* infowindow.open(map, marker); */
        marker.setMap(map,marker);
        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다

      //마커에 마우스오버 이벤트를 등록합니다
      kakao.maps.event.addListener(marker, 'click', function() {
        // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
          infowindow.open(map, marker);
      });

     
    } 
   
});    
</c:forEach>

<c:forEach items="${festList}" var="festLists" >	
geocoder.addressSearch("${festLists.area}", function(result, status) {
	imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png', // 마커이미지의 주소입니다    
	imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
	imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
	
    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords,
            image: markerImage // 마커이미지 설정 
        });
		
        // 인포윈도우로 장소에 대한 설명을 표시합니다
      
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${festLists.subject}"+
            '<center><a href="#" onclick="festSet1(\''+"${festLists.subject}"+'\')">축제1로 설정</a><br><a href="#" onclick="festSet2(\''+"${festLists.subject}"+'\')">축제2로 설정</a></center></div>'
            ,removable : iwRemoveable
        });
        
       
        /* infowindow.open(map, marker); */
        marker.setMap(map,marker);
        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다

      //마커에 마우스오버 이벤트를 등록합니다
      kakao.maps.event.addListener(marker, 'click', function() {
        // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
          infowindow.open(map, marker);
      });

      
    } 
   
});    
</c:forEach>


//spot
<c:forEach items="${spotList}" var="spotLists" >	
geocoder.addressSearch("${spotLists.area}", function(result, status) {
	imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png', // 마커이미지의 주소입니다    
	imageSize = new kakao.maps.Size(24, 35), // 마커이미지의 크기입니다
	imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
	// 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords,
            image: markerImage // 마커이미지 설정 
        });
		
        // 인포윈도우로 장소에 대한 설명을 표시합니다
      
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"${spotLists.name}"+
            '<center><a href="#" onclick="spotSet1(\''+"${spotLists.name}"+'\')">관광지1로 설정</a></center></div>'
            ,removable : iwRemoveable
        });
        
       
        /* infowindow.open(map, marker); */
        marker.setMap(map,marker);
        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다

      //마커에 마우스오버 이벤트를 등록합니다
      kakao.maps.event.addListener(marker, 'click', function() {
        // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
          infowindow.open(map, marker);
      });

      
    } 
   
});    
</c:forEach>


var sw = new kakao.maps.LatLng("${swX}", "${swY}"), // 사각형 영역의 남서쪽 좌표
ne = new kakao.maps.LatLng("${neX}",  "${neY}"); // 사각형 영역의 북동쪽 좌표

//사각형을 구성하는 영역정보를 생성합니다
//사각형을 생성할 때 영역정보는 LatLngBounds 객체로 넘겨줘야 합니다
var rectangleBounds = new kakao.maps.LatLngBounds(sw, ne);

//지도에 표시할 사각형을 생성합니다
var rectangle = new kakao.maps.Rectangle({
bounds: rectangleBounds, // 그려질 사각형의 영역정보입니다
strokeWeight: 4, // 선의 두께입니다
strokeColor: '#75B8FA', // 선의 색깔입니다
strokeOpacity: 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
strokeStyle: 'shortdashdot', // 선의 스타일입니다
fillColor: '#FF8AEF', // 채우기 색깔입니다
fillOpacity: 0.5 // 채우기 불투명도 입니다
});

//지도에 사각형을 표시합니다
rectangle.setMap(map);



//커스텀 오버레이에 표시할 내용입니다     
//HTML 문자열 또는 Dom Element 입니다 
var content = document.createElement('div');
content.className = 'overlaybox';
content.innerHTML = '<div class="overlaybox">' +
 '    <div class="boxtitle">코스 설정목록</div>' +
 '    <ul>' +
 '        <li class="up">' +
 '            <span class="number">1</span>' +
 '            <span class="title" id="span1">맛집1</span>' +
 '        </li>' +
 '        <li>' +
 '            <span class="number">2</span>' +
 '            <span class="title" id="span2">맛집2</span>' +
 '        </li>' +
 '        <li>' +
 '            <span class="number">3</span>' +
 '            <span class="title" id="span3">맛집3</span>' +
 '        </li>' +
 '        <li>' +
 '            <span class="number">4</span>' +
 '            <span class="title" id="span4">축제1</span>' +
 '        </li>' +
 '        <li>' +
 '            <span class="number">5</span>' +
 '            <span class="title" id="span5">축제2</span>' +
 '        </li>'+
 '        <li>' +
 '            <span class="number">6</span>' +
 '            <span class="title" id="span6">관광지1</span>' +
 '        </li><a href="#"onClick="history.back()" style=" color: white;">&nbsp;범위설정다시하기</a><a href="#" style="float: right; color: white;">설정완료</a>' +
 '    </ul>' +
 '</div>';


 

//커스텀 오버레이를 생성합니다
var customOverlay = new kakao.maps.CustomOverlay({
 map: map,
 position: new kakao.maps.LatLng("${centerY}", "${centerX}")  ,
 content: content,
 xAnchor: 0.3,
 yAnchor: 0.91
});

var startX, startY, startOverlayPoint;

//커스텀 오버레이에 mousedown이벤트를 등록합니다 
addEventHandle(content, 'mousedown', onMouseDown);

//mouseup 이벤트가 일어났을때 mousemove 이벤트를 제거하기 위해
//document에 mouseup 이벤트를 등록합니다 
addEventHandle(document, 'mouseup', onMouseUp);

//커스텀 오버레이에 mousedown 했을 때 호출되는 핸들러 입니다 
function onMouseDown(e) {
 // 커스텀 오버레이를 드래그 할 때, 내부 텍스트가 영역 선택되는 현상을 막아줍니다.
 if (e.preventDefault) {
     e.preventDefault();
 } else {
     e.returnValue = false;
 }

 var proj = map.getProjection(), // 지도 객체로 부터 화면픽셀좌표, 지도좌표간 변환을 위한 MapProjection 객체를 얻어옵니다 
     overlayPos = customOverlay.getPosition(); // 커스텀 오버레이의 현재 위치를 가져옵니다

 // 커스텀오버레이에서 마우스 관련 이벤트가 발생해도 지도가 움직이지 않도록 합니다
 kakao.maps.event.preventMap();

 // mousedown된 좌표를 설정합니다 
 startX = e.clientX; 
 startY = e.clientY;

 // mousedown됐을 때의 커스텀 오버레이의 좌표를
 // 지도 컨테이너내 픽셀 좌표로 변환합니다 
 startOverlayPoint = proj.containerPointFromCoords(overlayPos);

 // document에 mousemove 이벤트를 등록합니다 
 addEventHandle(document, 'mousemove', onMouseMove);       
}

//커스텀 오버레이에 mousedown 한 상태에서 
//mousemove 하면 호출되는 핸들러 입니다 
function onMouseMove(e) {
 // 커스텀 오버레이를 드래그 할 때, 내부 텍스트가 영역 선택되는 현상을 막아줍니다.
 if (e.preventDefault) {
     e.preventDefault();
 } else {
     e.returnValue = false;
 }

 var proj = map.getProjection(),// 지도 객체로 부터 화면픽셀좌표, 지도좌표간 변환을 위한 MapProjection 객체를 얻어옵니다 
     deltaX = startX - e.clientX, // mousedown한 픽셀좌표에서 mousemove한 좌표를 빼서 실제로 마우스가 이동된 픽셀좌표를 구합니다 
     deltaY = startY - e.clientY,
     // mousedown됐을 때의 커스텀 오버레이의 좌표에 실제로 마우스가 이동된 픽셀좌표를 반영합니다 
     newPoint = new kakao.maps.Point(startOverlayPoint.x - deltaX, startOverlayPoint.y - deltaY), 
     // 계산된 픽셀 좌표를 지도 컨테이너에 해당하는 지도 좌표로 변경합니다 
     newPos = proj.coordsFromContainerPoint(newPoint);

 // 커스텀 오버레이의 좌표를 설정합니다 
 customOverlay.setPosition(newPos);
}

//mouseup 했을 때 호출되는 핸들러 입니다 
function onMouseUp(e) {
 // 등록된 mousemove 이벤트 핸들러를 제거합니다 
 removeEventHandle(document, 'mousemove', onMouseMove);
}

//target node에 이벤트 핸들러를 등록하는 함수힙니다  
function addEventHandle(target, type, callback) {
 if (target.addEventListener) {
     target.addEventListener(type, callback);
 } else {
     target.attachEvent('on' + type, callback);
 }
}

//target node에 등록된 이벤트 핸들러를 제거하는 함수힙니다 
function removeEventHandle(target, type, callback) {
 if (target.removeEventListener) {
     target.removeEventListener(type, callback);
 } else {
     target.detachEvent('on' + type, callback);
 }
}


//목록에 리스트추가 함수
function foodSet1(name){
	document.getElementById("span1").innerHTML=name;
}
function foodSet2(name){
	document.getElementById("span2").innerHTML=name;
}
function foodSet3(name){
	document.getElementById("span3").innerHTML=name;
}
function festSet1(name){
	document.getElementById("span4").innerHTML=name;
}
function festSet2(name){
	document.getElementById("span5").innerHTML=name;
}
function spotSet1(name){
	document.getElementById("span6").innerHTML=name;
}


</script>
</body>
</html>