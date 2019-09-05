<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
$(document).ready(function(){
	$("#total").empty();
	$('#search').click( function(){
		$("#food").empty();
		
		var pageNum = 1;
		var areaCode = $("#areacode option:selected").val();
		var foodCode = $("#foodcode option:selected").val();
		
		$.ajax({        
	        url: 'food.do',
	        dataType: 'json',
	        type: 'get',
	        data : {"areaCode" : areaCode, "foodCode" :foodCode, "pageNum" : pageNum},
	        success: function(data){
	        	$("#total").html(data[2].pagedata.count);
	        	$("#food").html(data[0].foodCont);	
	        	$("#paging").html(data[1].pagingdata);
	        },
	        error: function(XMLHttpRequest, textStatus, errorThrown) { 
	                alert("검색 결과가 없습니다.");
	        }
	        });	
});
});
function goChange(num){
	pageNum = num;
	
	var areaCode = $("#areacode option:selected").val();
	var foodCode = $("#foodcode option:selected").val();
	$.ajax({        
        url: 'food.do',
        dataType: 'json',
        type: 'get',
        data : {"areaCode" : areaCode, "foodCode" :foodCode, "pageNum" : pageNum},
        success: function(data){
        	$("#food").html(data[0].foodCont);	
        	$("#paging").html(data[1].pagingdata);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) { 
                alert("검색 결과가 없습니다.");
        }
        });	
}


</script>
<!-- Titlebar
================================================== -->
<div id="titlebar" class="gradient">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>RESTAURANT</h2>
				<p style="font-weight: bold;">총 음식점 수:&nbsp;&nbsp;&nbsp;<a id ="total" style="color: #f91942; font-weight: bold;"></a><p>
			</div>
		</div>
	</div>
</div>


<!-- Content
================================================== -->
<div class="container">
	<div class="row">
		
		<!-- Search -->
		<div class="col-md-12">
			<div class="main-search-input gray-style margin-top-0 margin-bottom-10">

				<div class="main-search-input-item">
					<select data-placeholder="All Categories" class="chosen-select" id="areacode" >
						<option value = "">지역 선택</option>	
						<option value ="1">서울</option>
						<option value ="2">인천</option>
						<option value ="3">대전</option>
						<option value ="4">대구</option>
						<option value ="5">광주</option>
						<option value ="6">부산</option>
						<option value ="7">울산</option>
						<option value ="8">세종특별자치시</option>
						<option value ="31">경기도</option>
						<option value ="32">강원도</option>
						<option value ="33">충청북도</option>
						<option value ="34">충청남도</option>
						<option value ="35">경상북도</option>
						<option value ="36">경상남도</option>
						<option value ="37">전라북도</option>
						<option value ="38">전라남도</option>
						<option value ="39">제주도</option>
					</select>
				</div>
				
				<div class="main-search-input-item">
					<select data-placeholder="All Categories" class="chosen-select" id="foodcode" >
						<option value = "">관광지 분류</option>	
						<option value ="A05020100">한식</option>
						<option value ="A05020200">양식</option>
						<option value ="A05020300">일식</option>
						<option value ="A05020400">중식</option>
						<option value ="A05020500">아시아음식점</option>
						<option value ="A05020600">패밀리레스토랑</option>
						<option value ="A05020700">이색음식점</option>
						<option value ="A05020800">채식음식점</option>
						<option value ="A05020900">바 / 카페</option>
					</select>
				</div>
		

				<button class="button" id = "search">Search</button>
			</div>
		</div>
		<!-- Search Section / End -->


		<div class="col-md-12">

			<div class="row" id ="food">

				<!-- Listing Item -->
	
				<!-- Listing Item / End -->

			</div>

			<!-- Pagination -->
			<div class="clearfix"></div>
			<div class="row">
				<div class="col-md-12">
					<div class="pagination-container margin-top-20 margin-bottom-40">
						<nav class="pagination">
							<ul id ="paging">
								
							</ul>
						</nav>
					</div>
				</div>
			</div>
			<!-- Pagination / End -->

		</div>

	</div>
</div>