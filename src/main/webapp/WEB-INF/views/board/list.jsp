<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Wrapper -->
<div id="wrapper">

	<div class="clearfix"></div>
	<!-- Header Container / End -->


	<!-- Dashboard -->
	<div id="dashboard">

		<div class="dashboard-content">

			<!-- Titlebar -->
			<div id="titlebar">
				<div class="row">
					<div class="col-md-12">
						<h2>게시판</h2>
						<!-- Breadcrumbs -->
						<nav id="breadcrumbs">

							<ul>
								<li><a href="#">Home</a></li>
								<li><a href="#">게시판</a></li>
								<li>공지사항</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>

			<div class="row">

				<!-- Listings -->
				<div class="col-lg-12 col-md-12">
					<div class="dashboard-list-box margin-top-0">
						<table class="table table-hover">
							<thead>
								<tr>
									<th><a class="fa fa-edit fa-fw"
										href="<%=request.getContextPath()%>/board/writeUploadForm?">Write</a></th>
									<th></th>
									<th></th>
									<th>No.</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>

								</tr>
							</thead>
						</table>
						<ul>

							<li><c:forEach items="${AllList}" var="list">
									<div class="list-box-listing">
										<div class="list-box-listing-img">
											<a href="#"> <img
												src="<%=request.getContextPath() %>/fileSave/${list.fname}">
											</a>
										</div>
										<div class="list-box-listing-content">
											<div class="inner">
												<table>
													<tr>
														<td width="110"><div>
																<h3></h3>
															</div></td>
														<td width="180"><div>
																<h3>${list.boardNum}</h3>
															</div></td>
														<td width="220"><div>
																<a
																	href="<%=request.getContextPath()%>/board/content?boardNum=${list.boardNum}">
																	${list.subject}</a>
															</div></td>

														<td width="250"><div>${list.writer}</div></td>
														<td width="325"><div>
																<fmt:formatDate type="date" value="${list.regdate}" />
															</div></td>
														<td><div>${list.readcount}</div></td>

													</tr>
												</table>
											</div>

										</div>
									</div>
								</c:forEach>
					</div>
					<div class="buttons-to-right">
						<a href="#" class="button gray"><i class="sl sl-icon-close"></i>
							Delete</a>
					</div>
					</li>


					</ul>
				</div>
			</div>


			<!-- Copyrights -->
			<div class="col-md-12">
				<div class="copyrights">© 2019 Listeo. All Rights Reserved.</div>
			</div>
		</div>

	</div>
	<!-- Content / End -->


</div>
<!-- Dashboard / End -->


</div>
<!-- Wrapper / End -->


