<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<div class="dashboard-content">

		<!-- Titlebar -->
		<div id="titlebar">
			<div class="row">
				<div class="col-md-12">
					<h2>Admin Main</h2>
					<!-- Breadcrumbs -->
					<nav id="breadcrumbs">
						<ul>
							<li><a href="/main/main">Home</a></li>
							<li>Admin</li>
						</ul>
					</nav>
				</div>
			</div>
		</div>

		<!-- Notice -->
		<!-- <div class="row">
			<div class="col-md-12">
				<div class="notification success closeable margin-bottom-30">
					<p>Your listing <strong>Hotel Govendor</strong> has been approved!</p>
					<a class="close" href="#"></a>
				</div>
			</div>
		</div> -->

		<!-- Content -->
		<div class="row">
		
		<!-- Item -->
			<div class="col-lg-3 col-md-6">
				<div class="dashboard-stat color-2">
					<div class="dashboard-stat-content"><h4> ${nowuser}</h4> <span>접속중인 회원수</span></div>
					<div class="dashboard-stat-icon"><i class="im im-icon-Line-Chart"></i></div>
				</div>
			</div>
			
			<!-- Item -->
			<div class="col-lg-3 col-md-6">
				<div class="dashboard-stat color-3">
					<div class="dashboard-stat-content"><h4> ${totalmember}</h4> <span>총 회원 수</span></div>
					<div class="dashboard-stat-icon"><i class="im im-icon-Add-UserStar"></i></div>
				</div>
			</div>

			<!-- Item -->
			<div class="col-lg-3 col-md-6">
				<div class="dashboard-stat color-1">
					<div class="dashboard-stat-content"><h4> ${totalboard}</h4> <span>총 게시글 수</span></div>
					<div class="dashboard-stat-icon"><i class="im im-icon-Map2"></i></div>
				</div>
			</div>

			<!-- Item -->
			<div class="col-lg-3 col-md-6">
				<div class="dashboard-stat color-1">
					<div class="dashboard-stat-content"><h4> ${totalreview}</h4> <span>총 리뷰 수</span></div>
					<div class="dashboard-stat-icon"><i class="im im-icon-Map2"></i></div>
				</div>
			</div>
		</div>


		<div class="row">
			
			<!-- Recent Activity -->
			<div class="col-lg-6 col-md-12">
				<div class="dashboard-list-box with-icons margin-top-20">
					<h4>New Board</h4>
					<ul>

						<li>
							<i class="list-box-icon sl sl-icon-layers"></i> 출발 에서 도착  on <strong><a href="#">TripInfo</a></strong>
							<div class="buttons-to-right">
								<a href="/admin/" class="button gray">View Detail</a>
							</div>
						</li>

						<li>
							<i class="list-box-icon sl sl-icon-star"></i> 게시판 제목 <div class="numerical-rating" data-rating="5.0"></div> on <strong><a href="#">Board</a></strong>
							<div class="buttons-to-right">
								<a href="/admin/" class="button gray">View Detail</a>
							</div>
						</li>

						<li>
							<i class="list-box-icon sl sl-icon-heart"></i> 댓글 <div class="numerical-rating" data-rating="5.0"></div> on <strong><a href="#">Reply</a></strong>
							<div class="buttons-to-right">
								<a href="/admin/" class="button gray">View Detail</a>
							</div>
						</li>
						
					</ul>
				</div>
			</div>
			
			<!-- Invoices -->
			<div class="col-lg-6 col-md-12">
				<div class="dashboard-list-box invoices with-icons margin-top-20">
					<h4>New Member</h4>
					<ul>
						<c:forEach items="${dateMembermodel }" var="dateMembermodels">
						<li><i class="list-box-icon sl sl-icon-doc"></i>
							<strong>${dateMembermodels.id }</strong>
							<ul>
								<li class="paid">${dateMembermodels.name }</li>
								<li>MemNum: ${dateMembermodels.memnum }</li>
								<li>Date: <fmt:formatDate value="${dateMembermodels.regdate }" pattern="yyyy년 MM월 dd일" /></li>
							</ul>
							<div class="buttons-to-right">
								<a href="/admin/memberProfile/${dateMembermodels.memnum}" class="button gray">View Info</a>
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