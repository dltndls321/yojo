<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<div class="dashboard-content">

		<!-- Titlebar -->
		<div id="titlebar">
			<div class="row">
				<div class="col-md-12">
					<h2>Customer Center</h2>
					<!-- Breadcrumbs -->
					<nav id="breadcrumbs">
						<ul>
							<li><a href="/main/main">Home</a></li>
							<li><a href="/abmin/main">Admin</a></li>
							<li>Member List</li>
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
						<h4>Member List</h4>
					</div>
					
					<div class="messages-inbox">

						<ul>
						
						<c:forEach var="member" items="${memberList }">
						
							<li class="unread">
								<a href="/admin/memberProfile/${member.memnum }">
									<div class="message-avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>

									<div class="message-by">
										<div class="message-by-headline">
											<h5>${member.id}
												
												 <i>new</i>
											</h5>
											<span><fmt:formatDate value="${member.regdate }" pattern="yyyy년 MM월 dd일" /></span>
										</div>
										<p> ${member.name }, ${member.phone}, ${member.address } </p>
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
								<li><a href="/admin/memberList?pageNum=${startPage - bottomLine}"><i class="sl sl-icon-arrow-left"></i></a></li>
							</c:if>
							<c:forEach   var="i"  begin="${startPage }"   end="${endPage }">
								<li><a href="/admin/memberList?pageNum=${i}" class="current-page">${i }</a></li>
							 	
							</c:forEach>
							<c:if test="${ endPage<pageCount}">
								<li><a href="/admin/memberList?pageNum=${startPage + bottomLine}"><i class="sl sl-icon-arrow-right"></i></a></li>
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