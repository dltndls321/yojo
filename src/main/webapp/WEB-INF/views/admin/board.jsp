<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="dashboard-content">

		<!-- Titlebar -->
		<div id="titlebar">
			<div class="row">
				<div class="col-md-12">
					<h2>Board</h2>
					<!-- Breadcrumbs -->
					<nav id="breadcrumbs">
						<ul>
							<li><a href="/main/main">Home</a></li>
							<li><a href="/admin/main">Admin</a></li>
							<li>Board</li>
						</ul>
					</nav>
				</div>
			</div>
		</div>

		<div class="row">
			
			<!-- Listings -->
			<div class="col-lg-12 col-md-12">
				<div class="dashboard-list-box margin-top-0">
					<h4>게시판 이름</h4>
					<ul>
						<c:forEach items="${boardlist}" var="boardlist">
						<li>
							<div class="list-box-listing">
								<div class="list-box-listing-img"><img src='<c:out value="${boardlist.fname}" />' alt="" style="width: 150px;height: 100px;"></div>
								<div class="list-box-listing-content">
									<div class="inner">
										<h3><a href="/admin/boardContent/${boardlist.boardNum }">${boardlist.subject }</a></h3>
										<span>${boardlist.writer }</span>
										<span>${boardlist.regdate }</span>
									</div>
								</div>
							</div>
							<div class="buttons-to-right">
								<a href="/admin/boardDelete/${boardlist.boardNum }" class="button gray"><i class="sl sl-icon-close"></i> Delete</a>
							</div>
						</li>
						</c:forEach>
						
					</ul>
				</div>
			</div>

			<!-- Copyrights -->
			<div class="col-md-12">
				<div class="copyrights">© 2019 Listeo. All Rights Reserved.</div>
			</div>
		</div>

	</div>