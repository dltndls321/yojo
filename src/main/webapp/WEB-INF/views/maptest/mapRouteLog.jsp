<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="dashboard-content">

		<!-- Titlebar -->
		<div id="titlebar">
			<div class="row">
				<div class="col-md-12">
					<h2>Course Log</h2>
					<!-- Breadcrumbs -->
					<nav id="breadcrumbs">
						<ul>
							<li><a href="/main/main">Home</a></li>
							<li><a href="/abmin/main">Course</a></li>
							<li>Log</li>
						</ul>
					</nav>
				</div>
			</div>
		</div>

		<div class="row">
			
			<!-- Listings -->
			<div class="col-lg-12 col-md-12">

				<div class="messages-container margin-top-0">
					<div class="messages-headline">
						<h4>Course Log List</h4>
					</div>
					
					<div class="messages-inbox">

						<ul>
						
						<c:forEach var="Log" items="${CLog}" varStatus="status">
						
							<li class="unread">
								<a href="/map/route1/${Log.coursenum}/${Log.course1}/${Log.course2}/${Log.course3}/${Log.course4}/${Log.course5}/${Log.course6}">
									<div class="message-avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>

									<div class="message-by">
										<div class="message-by-headline">
											<h5>${Log.subject}
												<c:if test="${startdate le regdate[status.index] && regdate[status.index] le now }">
												 <i>new</i>
												 </c:if>
											</h5>
											<span><fmt:formatDate value="${Log.cdate }" pattern="yyyy년 MM월 dd일" /></span>
										</div>
										<p> 출발점 : ${Log.starting }, 도착점 : ${Log.destination} </p>
										
									</div>
								</a>
							</li>
							
						</c:forEach>
							<!-- <li class="unread">
								<a href="/admin/memberProfile">
									<div class="message-avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>

									<div class="message-by">
										<div class="message-by-headline">
											<h5>아이디 <i>new</i></h5>
											<span>가/입/일</span>
										</div>
										<p>신상정보? </p>
									</div>
								</a>
							</li> -->
							
						</ul>
						
					</div>
				</div>

				<!-- Pagination -->
				<div class="clearfix"></div>
				<div class="pagination-container margin-top-30 margin-bottom-0">
					<nav class="pagination">
						<ul>
							<c:if test="${ startPage>bottomLine}">
								<li><a href="/map/Log?pageNum=${startPage - bottomLine}"><i class="sl sl-icon-arrow-left"></i></a></li>
							</c:if>
							<c:forEach   var="i"  begin="${startPage }"   end="${endPage }">
								<li><a href="/map/Log?pageNum=${i}" class="current-page">${i }</a></li>
							 	
							</c:forEach>
							<c:if test="${ endPage<pageCount}">
								<li><a href="/map/Log?pageNum=${startPage + bottomLine}"><i class="sl sl-icon-arrow-right"></i></a></li>
							</c:if>
							
						</ul>
					</nav>
				</div>
				<!-- Pagination / End -->

			</div>

			<!-- Copyrights -->
			<div class="col-md-12">
				<div class="copyrights">© 2017 Listeo. All Rights Reserved.</div>
			</div>
		</div>

	</div>