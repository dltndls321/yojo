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
						<h2>자유게시판</h2>
						<!-- Breadcrumbs -->
						<nav id="breadcrumbs">

							<ul>
								<li><a href="#">Home</a></li>
								<li><a href="#">게시판</a></li>
								<li>자유게시판</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
			<!-- 검색 기능 폼 -->
				<form name="form2" method="post" action="${path }/board/boardlist">
					<select name="searchOption" style="width: 150px; height: 30px;">
					<option value="subject"<c:out value="${searchOption == 'subject'?'selected':''}"/>>제목</option>			
					<option value="writer"<c:out value="${searchOption == 'writer'?'selected':''}"/>>이름</option>			
					<option value="content"<c:out value="${searchOption == 'content'?'selected':''}"/>>내용</option>			
					</select>
					<input name="keyword" style="width: 150px; height: 30px;" value="${keyword }">	
					<input type="submit" value="조회">
					
							<!-- 게시물 수 -->
					
					${scount}개의 게시물이 있습니다.
					
					</form>
				
					
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

						<c:forEach items="${boardlist}" var="list">
							<div class="list-box-listing">
								<div class="list-box-listing-img">
									<a
										href="<%=request.getContextPath()%>/board/content?boardNum=${list.boardNum}">
										
										<img  src='<c:out value="${list.fname}" /> ' ">
									</a>
								</div>
								<div class="list-box-listing-content">
									<div class="inner">
										<table>
											<tr>
												<td width="140px"><div>
														<h3></h3>
													</div></td>
												<td width="180px"><div>
														<a
															href="<%=request.getContextPath()%>/board/content?boardNum=${list.boardNum}">${list.boardNum}</a>
													</div></td>
												<td width="220px"><div>
														<a
															href="<%=request.getContextPath()%>/board/content?boardNum=${list.boardNum}">
															${list.subject}</a>
													</div></td>

												<td width="270px"><a
													href="<%=request.getContextPath()%>/board/content?boardNum=${list.boardNum}">${list.writer}</a></td>
												<td width="300px"><div>
														<fmt:formatDate type="date" value="${list.regdate}" />
													</div></td>
												<td width="15%"><div>${list.readcount}</div></td>
												

											</tr>

										</table>
									</div>

								</div>
							</div>
						</c:forEach>
					</div>

					<div class="buttons-to-right"></div>
					<div class="pagination-container margin-top-30 margin-bottom-0">
						<nav class="pagination">
							<ul>
								<c:if test="${ startPage>bottomLine}">
									<li><a
										href="/board/boardlist?pageNum=${startPage - bottomLine}"><i
											class="sl sl-icon-arrow-left"></i></a></li>
								</c:if>
								<c:forEach var="i" begin="${startPage }" end="${endPage }">
									<li><a href="/board/boardlist?pageNum=${i}"
										class="current-page">${i }</a></li>

								</c:forEach>
								<c:if test="${ endPage<pageCount}">
									<li><a
										href="/board/boardlist?pageNum=${startPage + bottomLine}"><i
											class="sl sl-icon-arrow-right"></i></a></li>
								</c:if>

							</ul>
						</nav>
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


