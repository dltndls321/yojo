<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<script>

$(document).ready(function(){
	$("#total").empty();
	$('#search').click( function(){
		$("#festival").empty();
		var pageNum = 1;
		var areaCode = $("#areacode option:selected").val();
		var date = $("#date-picker").val();
		$.ajax({        
	        url: 'festival.do',
	        dataType: 'json',
	        type: 'get',
	        data : {"areaCode" : areaCode, "eventStartDate" :date, "pageNum" : pageNum},
	        success: function(data){
	        	$("#total").html(data[2].pagedata.count);
	        	$("#festival").html(data[0].festCont);	
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
	var date = $("#date-picker").val();
	$.ajax({        
        url: 'festival.do',
        dataType: 'json',
        type: 'get',
        data : {"areaCode" : areaCode, "eventStartDate" :date, "pageNum" : pageNum},
        success: function(data){
        	$("#festival").html(data[0].festCont);	
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

				<h2>Festival</h2><span></span>
				<p style="font-weight: bold;">총 축제 수:&nbsp;&nbsp;&nbsp;<a id ="total" style="color: #f91942; font-weight: bold;"></a><p>
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
				<!-- Date Range Picker - docs: http://www.daterangepicker.com/ -->
					<div class="main-search-input-item">
						<input type="text" id="date-picker" placeholder="Date" readonly="readonly">
					</div>

				<button class="button" id = "search">Search</button>
			</div>
		</div>
		<!-- Search Section / End -->


		<div class="col-md-12">

		


			<div class="row" id ="festival">

				<!-- Listing Item -->
				
					
			
				<!-- Listing Item / End -->

				

			</div>

			<!-- Pagination -->
			<div class="clearfix"></div>
			<div class="row">
				<div class="col-md-12">
					<!-- Pagination -->
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