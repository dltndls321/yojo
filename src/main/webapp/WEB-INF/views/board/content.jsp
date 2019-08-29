<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="container">
	<div class="row sticky-wrapper">
		<div class="col-lg-8 col-md-8 padding-right-30">

			<!-- Titlebar -->
			<div id="titlebar" class="listing-titlebar"></div>


			<!-- Overview -->
			<div id="listing-overview" class="listing-section">


				<table class="content">
					<colgroup>
						<col width="15%" />
						<col width="35%" />
						<col width="25%" />
						<col width="55%" />
					</colgroup>

					<form name="form1" method="post"
						action="/board/update/${list.boardNum}">

						<tbody>
							<tr>
								<th scope="row">글 번호 :${list.boardNum }</th>
								<td><input type="hidden" id="boardNum" name="boardNum"
									value="${list.boardNum }"></td>
								<th scope="row">조회수: ${list.readcount }</th>
								<td><input type="hidden" id="readcount" name="readcount"
									value="${list.readcount }"></td>
							</tr>
							<tr>
								<th scope="row">작성자: ${list.writer }</th>
								<td><input type="hidden" id="writer" name="writer"
									value="${list.writer }"></td>
								<th scope="row">작성시간: ${list.regdate }</th>
								<td></td>
							</tr>
							<tr>
								<th scope="row">제목: ${list.subject }</th>
								<td colspan="3"><input type="hidden" id="subject"
									name="subject" value="${list.subject }"></td>
							</tr>

							<tr>
								<td>
									<div style="height: 300px; margin: 10px; display: inline-block">${list.content }
										<input type="hidden" id="content" name="content"
											value="${list.content }">

									</div>
									<tr height="30">
										<td align="center">이미지</td>
										<td align="left" colspan="3">
									<img src="<%=request.getContextPath() %>/fileSave/${list.fname}"></td>
									</tr>
							
							
							<tr>
								<td><input type="hidden" id="passwd" name="passwd"
									value="${list.passwd }"></td>
							</tr>
						</tbody>
					<tr height="30">
						<td colspan="4" class="w3-center">
							<div class="form-group">
								<form>
									<input type="submit" value="수정" style="max-width: 100px; min-width: 99px;"> 
									<input type="button"value="글삭제" onclick="document.location.href='<%=request.getContextPath()%>/board/delete/${list.boardNum}'" style="max-width: 100px;"> 
									<input type="button" value=" 글목록" onclick="document.location.href='/board/boardlist?pageNum=${pageNum}'"style="max-width: 100px;">
								</form>
								

							</div>
						</td>
					</tr>



					<!-- Listing Contacts -->
					<div class="listing-links-container"></div>
					<div class="clearfix"></div>
				</table>
			</div>


			<div class="clearfix"></div>

			<!-- Reviews -->
			<section class="comments listing-reviews">
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
								Kathy Brown <i class="tip"
									data-tip-content="Person who left this review actually was a customer"></i>
								<span class="date">June 2019</span>

							</div>
							<p>Morbi velit eros, sagittis in facilisis non, rhoncus et
								erat. Nam posuere tristique sem, eu ultricies tortor imperdiet
								vitae. Curabitur lacinia neque non metus</p>
							<a href="#" class="rate-review"><i class="sl sl-icon-like"></i>
								Helpful Review <span>12</span></a>
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
								John Doe<span class="date">May 2019</span>

							</div>
							<p>Commodo est luctus eget. Proin in nunc laoreet justo
								volutpat blandit enim. Sem felis, ullamcorper vel aliquam non,
								varius eget justo. Duis quis nunc tellus sollicitudin mauris.</p>
							<a href="#" class="rate-review"><i class="sl sl-icon-like"></i>
								Helpful Review <span>2</span></a>
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
								John Doe<span class="date">May 2019</span>

							</div>
							<p>Commodo est luctus eget. Proin in nunc laoreet justo
								volutpat blandit enim. Sem felis, ullamcorper vel aliquam non,
								varius eget justo. Duis quis nunc tellus sollicitudin mauris.</p>
							<a href="#" class="rate-review"><i class="sl sl-icon-like"></i>
								Helpful Review</a>
						</div>

					</li>
				</ul>
			</section>

			<!-- Pagination -->
			<div class="clearfix"></div>
			<div class="row">
				<div class="col-md-12">
					<!-- Pagination -->
					<div class="pagination-container margin-top-30">
						<nav class="pagination">
							<ul>
								<li><a href="#" class="current-page">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#"><i class="sl sl-icon-arrow-right"></i></a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
			<!-- Pagination / End -->
		</div>


	</div>


	<div class="col-lg-4 col-md-4 margin-top-75 sticky"></div>


</div>
</div>