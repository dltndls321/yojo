<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<script>

$(document).ready(function(){
	$('#search').click( function(){
		var areaCode = $("#areacode option:selected").val();
		var date = $("#date-picker").val();
		$.ajax({        
	        url: 'festival.do',
	        type: 'get',
	        data : {"areaCode" : areaCode, "eventStartDate" :date},
	        success: function(data){
	            	$('#festival').html(data);
	            },
	            error: function(XMLHttpRequest, textStatus, errorThrown) { 
	                alert("Status: " + textStatus); alert("Error: " + errorThrown);
	        }
	        });	
	});
});

</script>
<!-- Titlebar
================================================== -->
<div id="titlebar" class="gradient">
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<h2>Listings</h2><span>Grid Layout With Sidebar</span>

				<!-- Breadcrumbs -->
				<nav id="breadcrumbs">
					<ul>
						<li><a href="#">Home</a></li>
						<li>Listings</li>
					</ul>
				</nav>

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
							<ul>
								<li><a href="#" class="current-page">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#"><i class="sl sl-icon-arrow-right"></i></a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
			<!-- Pagination / End -->

		</div>

	</div>
</div>