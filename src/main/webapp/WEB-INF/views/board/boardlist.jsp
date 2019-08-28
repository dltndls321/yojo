<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>boardList</title>
</head>
<body>
	<div class="page-wrapper">
		<div class="container-fluid">
			<div class="col-lg-8">
				<!--게시판 넓이 -->
				<div class="col-lg-12">
					<h1 class="page-header">게시판관리</h1>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<a class="fa fa-edit fa-fw"
							href="<%=request.getContextPath()%>/board/writeUploadForm">게시판 작성</a>
					
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">게시판</div>
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>No.</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								
								</tr>
							</thead>
									
								<c:forEach items="${AllList}" var="list">
									<tr>
									
										<td align="center" width="100">${list.boardNum}</td>
										<td align="center" width="150"><a href="<%=request.getContextPath() %>/board/content?boardNum=${list.boardNum}"> ${list.subject}</a></td>
										<td align="center" width="100">${list.writer}</td>
										<td align="center" width="100">
										<fmt:formatDate type="date" value="${list.regdate}" /></td>
										<td align="center" width="50">${list.readcount}</td>
									</tr>
								</c:forEach>
							
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>