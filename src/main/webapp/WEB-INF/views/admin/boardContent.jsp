<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="/resources/css/invoice.css">
</head> 

<body>

<!-- Print Button -->
<a href="javascript:window.print()" class="print-button">Print this Content</a>

<!-- Invoice -->
<div id="invoice">

	<!-- Header -->
	<div class="row">
		<div class="col-md-6">
			<div id="logo"><img src="/resources/images/logo.png" alt=""></div>
		</div>

		<div class="col-md-6">	

			<p id="details">
				<strong>Num:</strong> ${boardModel.boardNum } <br>
				<strong>Read Count</strong> ${boardModel.readcount } <br>
			</p>
		</div>
	</div>


	<!-- Client & Supplier -->
	<div class="row">
		<div class="col-md-12">
			<h2>${boardModel.subject }</h2>
		</div>

		<div class="col-md-6">	
			<strong class="margin-bottom-5"></strong>
			<p>
				<strong>Writer:</strong> ${boardModel.writer } <br>
				<strong>Date:</strong> ${boardModel.regdate } <br>
			</p>
		</div>

		<div class="col-md-6">	
			<strong class="margin-bottom-5"></strong>
			<p>
				<strong>Password:</strong> ${boardModel.passwd } <br>
			</p>
		</div>
	</div>


	<!-- Invoice -->
	<div class="row">
		<div class="col-md-12">
			<p>
				<strong>사진 넣는곳</strong> <br>
			</p>
		</div>
		
		<div class="row" style="margin-left: 30px; margin-right: 30px;">
		<div class="col-md-12">
			<p>
				<strong>Content:</strong> <br/> <br/> ${boardModel.content } <br>
			</p>
		</div>
		
		
	</div>
		
</div>

</body>
</html>
