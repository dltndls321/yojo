<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>



<!-- Wrapper -->
<div id="wrapper">

	<!-- Header Container
================================================== -->



	<!-- Titlebar
================================================== -->


	<!-- Content
================================================== -->
	<div class="container">

		<!-- Blog Posts -->
		<div class="blog-page">
			<div class="row">


				<!-- Post Content -->
				<div class="col-lg-9 col-md-8 padding-right-30">


					<!-- Blog Post -->
					<div class="blog-post single-post">
						<form name="form1" method="post"
							action="/board/update/${list.boardNum}">
							<input type="hidden" id="subject" name="subject" value="${list.subject }"> 
							<input type="hidden" id="passwd" name="passwd" value="${list.passwd }"> 
								<input type="hidden"id="content" name="content" value="${list.content }"> 
								<input type="hidden" id="writer" name="writer" value="${list.writer }">
							<input type="hidden" id="readcount" name="readcount" value="${list.readcount }"> 
								<input type="hidden" id="boardNum" name="boardNum" value="${list.boardNum }">
							<!-- Img -->
							<table>
								<tr height="30">
									<td align="center"></td>
									<td align="left" colspan="3"><img
										src="<%=request.getContextPath() %>/fileSave/${list.fname}"></td>
								</tr>
							</table>

							<!-- Content -->
							<div class="post-content">

								<h3>${list.subject }</h3>

								<ul class="post-meta">
									<li>${list.regdate }</li>
									<li><a href="#">글쓴이: ${list.writer }</a></li>
									<li><a href="#">5 Comments</a></li>
								</ul>


								<p>${list.content }</p>



								<!-- Share Buttons -->
								
								<input type="submit" value="수정"
									style="max-width: 100px; min-width: 99px;">
									 <input
									type="button" value="글삭제"
									onclick="document.location.href='<%=request.getContextPath()%>/board/delete/${list.boardNum}'"
									style="max-width: 100px;"> <input type="button"
									value=" 글목록"
									onclick="document.location.href='/board/boardlist?pageNum=${pageNum}'"
									style="max-width: 100px;">
						</form>

						<div class="clearfix"></div>

					</div>
				</div>
				<!-- Blog Post / End -->


				<!-- Post Navigation -->
				<ul id="posts-nav" class="margin-top-0 margin-bottom-45">
					<li class="next-post"><a href="#"><span>다음글</span> 얌얌</a></li>
					<li class="prev-post"><a href="#"><span>이전글 </span>냠냠</a></li>
				</ul>





				<!-- Related Posts -->
				<div class="clearfix"></div>
				<h4 class="headline margin-top-25">최근 글</h4>
				<div class="row">

					<!-- Blog Post Item -->
					<div class="col-md-6">
						<a href="#" class="blog-compact-item-container">
							<div class="blog-compact-item">
								<img src="images/blog-compact-post-01.jpg" alt=""> <span
									class="blog-item-tag">Tips</span>
								<div class="blog-compact-item-content">
									<ul class="blog-post-tags">
										<li>22 August 2019</li>
									</ul>
									<h3>Hotels for All Budgets</h3>
									<p>Sed sed tristique nibh iam porta volutpat finibus. Donec
										in aliquet urneget mattis lorem. Pellentesque pellentesque.</p>
								</div>
							</div>
						</a>
					</div>
					<!-- Blog post Item / End -->

					<!-- Blog Post Item -->
					<div class="col-md-6">
						<a href="#" class="blog-compact-item-container">
							<div class="blog-compact-item">
								<img src="images/blog-compact-post-03.jpg" alt=""> <span
									class="blog-item-tag">Tips</span>
								<div class="blog-compact-item-content">
									<ul class="blog-post-tags">
										<li>10 August 2019</li>
									</ul>
									<h3>The Best Cofee Shops In Sydney Neighborhoods</h3>
									<p>Sed sed tristique nibh iam porta volutpat finibus. Donec
										in aliquet urneget mattis lorem. Pellentesque pellentesque.</p>
								</div>
							</div>
						</a>
					</div>
					<!-- Blog post Item / End -->

				</div>
				<!-- Related Posts / End -->


				<div class="margin-top-50"></div>

				<!-- Reviews -->
				<section class="comments">
					<h4 class="headline margin-bottom-35">
						Comments <span class="comments-amount">(5)</span>
					</h4>

					<ul>
						<li>
							<div class="avatar">
								<img
									src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70"
									alt="" />
							</div>
							<div class="comment-content">
								<div class="arrow-comment"></div>
								<div class="comment-by">
									Kathy Brown<span class="date">22 August 2019</span> <a href="#"
										class="reply"><i class="fa fa-reply"></i> Reply</a>
								</div>
								<p>Morbi velit eros, sagittis in facilisis non, rhoncus et
									erat. Nam posuere tristique sem, eu ultricies tortor imperdiet
									vitae. Curabitur lacinia neque non metus</p>
							</div>

							<ul>
								<li>
									<div class="avatar">
										<img
											src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70"
											alt="" />
									</div>
									<div class="comment-content">
										<div class="arrow-comment"></div>
										<div class="comment-by">
											Tom Smith<span class="date">22 August 2019</span> <a href="#"
												class="reply"><i class="fa fa-reply"></i> Reply</a>
										</div>
										<p>Rrhoncus et erat. Nam posuere tristique sem, eu
											ultricies tortor imperdiet vitae. Curabitur lacinia neque.</p>
									</div>
								</li>
								<li>
									<div class="avatar">
										<img
											src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70"
											alt="" />
									</div>
									<div class="comment-content">
										<div class="arrow-comment"></div>
										<div class="comment-by">
											Kathy Brown<span class="date">20 August 2019</span> <a
												href="#" class="reply"><i class="fa fa-reply"></i> Reply</a>
										</div>
										<p>Nam posuere tristique sem, eu ultricies tortor.</p>
									</div>

									<ul>
										<li>
											<div class="avatar">
												<img
													src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70"
													alt="" />
											</div>
											<div class="comment-content">
												<div class="arrow-comment"></div>
												<div class="comment-by">
													John Doe<span class="date">18 August 2019</span> <a
														href="#" class="reply"><i class="fa fa-reply"></i>
														Reply</a>
												</div>
												<p>Great template!</p>
											</div>
										</li>
									</ul>

								</li>
							</ul>

						</li>

						<li>
							<div class="avatar">
								<img
									src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70"
									alt="" />
							</div>
							<div class="comment-content">
								<div class="arrow-comment"></div>
								<div class="comment-by">
									John Doe<span class="date">18 August 2019</span> <a href="#"
										class="reply"><i class="fa fa-reply"></i> Reply</a>
								</div>
								<p>Commodo est luctus eget. Proin in nunc laoreet justo
									volutpat blandit enim. Sem felis, ullamcorper vel aliquam non,
									varius eget justo. Duis quis nunc tellus sollicitudin mauris.</p>
							</div>

						</li>
					</ul>

				</section>
				<div class="clearfix"></div>


				<!-- Add Comment -->
				<div id="add-review" class="add-review-box">

					<!-- Add Review -->
					<h3 class="listing-desc-headline margin-bottom-35">Add Review</h3>

					<!-- Review Comment -->
					<form id="add-comment" class="add-comment">
						<fieldset>

							<div class="row">
								<div class="col-md-6">
									<label>Name:</label> <input type="text" value="" />
								</div>

								<div class="col-md-6">
									<label>Email:</label> <input type="text" value="" />
								</div>
							</div>

							<div>
								<label>Comment:</label>
								<textarea cols="40" rows="3"></textarea>
							</div>

						</fieldset>

						<button class="button">Submit Comment</button>
						<div class="clearfix"></div>
					</form>

				</div>
				<!-- Add Review Box / End -->

			</div>
			<!-- Content / End -->

			<!-- Widget -->
			<div class="widget margin-top-40">
				<h3 class="margin-bottom-25">Social</h3>
				<ul class="social-icons rounded">
					<li><a class="facebook" href="#"><i class="icon-facebook"></i></a></li>
					<li><a class="twitter" href="#"><i class="icon-twitter"></i></a></li>
					<li><a class="gplus" href="#"><i class="icon-gplus"></i></a></li>
					<li><a class="linkedin" href="#"><i class="icon-linkedin"></i></a></li>
				</ul>

			</div>
			<!-- Widget / End-->

			<div class="clearfix"></div>
			<div class="margin-bottom-40"></div>
		</div>
	</div>
</div>
<!-- Sidebar / End -->


</div>

