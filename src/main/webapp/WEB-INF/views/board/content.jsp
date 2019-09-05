<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>

<script>
	var boardNum = '${list.boardNum}'; //게시글 번호
	var memNum = '${list.memNum}'; //유저 번호

	$('[name=replyInsertBtn]').click(function() { //댓글 등록 버튼 클릭시 
		var insertData = $('[name=replyInsertForm]').serialize(); //replyInsertForm의 내용을 가져옴
		replyInsert(insertData); //Insert 함수호출(아래)
	});

	//댓글 목록 
	function replyList() {
		$
				.ajax({
					url : '/reply/list',
					type : 'get',
					data : {
						'boardNum' : boardNum
					},
					success : function(data) {
						var a = '';
						$
								.each(
										data,
										function(key, value) {
											a += '<div class="replyArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
											a += '<div class="replyInfo'+ value.replyNum +'">'
													+ '댓글번호 : '
													+ value.replyNum
													+ ' / 작성자 : '
													+ value.memNum;
											if (value.memNum=='memNum') {
											 a += '<a onclick="replyUpdate('
													+ value.replyNum + ',\''
													+ value.content
													+ '\');"> 수정 </a>'; 
											a += '<a onclick="replyDelete('
													+ value.replyNum
													+ ');"> 삭제 </a> </div>';
											}
											a += '<div class="replyContent'+ value.replyNum +'"> <p> 내용 : '
													+ value.content + '</p>';
											a += '</div></div>';
										});

						$(".replyList").html(a);
					}
				});
	}

	//댓글 등록
	function replyInsert(insertData) {
		content = $('#dcontent').val();
		$.ajax({
			url : '/reply/insert',
			type : 'get',
			data : {
				'boardNum' : boardNum,
				'content' : content,
				'memNum' : memNum
			},
			success : function(data) {
				if (data == 1) {
					replyList(); //댓글 작성 후 댓글 목록 reload
					$('[name=content]').val('');
				}
			}
		});
	}

	//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
	function replyUpdate(replyNum, content) {
		var a = '';
		a += '<div class="input-group">';
		a += '<input type="text" class="form-control" name="content_'+replyNum+'" value="'+content+'"/>';
		a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="replyUpdate2('
				+ replyNum + ');">수정</button> </span>';
		a += '</div>';
		$('.replyContent' + replyNum).html(a);

	}

	//댓글 수정
	function replyUpdate2(replyNum) {
		alert("content_" + replyNum);
		var updateContent = $('[name=content_' + replyNum + ']').val();

		$.ajax({
			url : '/reply/update',
			type : 'post',
			data : {
				'content' : updateContent,
				'replyNum' : replyNum
			},
			success : function(data) {
				if (data == 1)
					replyList(boardNum); //댓글 수정후 목록 출력 
			}
		});
	}

	//댓글 삭제 
	function replyDelete(replyNum) {
		$.ajax({
			url : '/reply/delete/' + replyNum,
			type : 'post',
			success : function(data) {
				if (data == 1)
					replyList(boardNum); //댓글 삭제후 목록 출력 
			}
		});
	}

	$(document).ready(function() {
		replyList(); //페이지 로딩시 댓글 목록 출력 
	});
</script>

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
							style="width: auto; height: auto;"
							action="/board/update/${list.boardNum}">
							<input type="hidden" id="subject" name="subject"
								value="${list.subject }"> <input type="hidden"
								id="passwd" name="passwd" value="${list.passwd }"> <input
								type="hidden" id="content" name="content"
								value="${list.content }"> <input type="hidden"
								id="writer" name="writer" value="${list.writer }"> <input
								type="hidden" id="readcount" name="readcount"
								value="${list.readcount }"> <input type="hidden"
								id="boardNum" name="boardNum" value="${list.boardNum }">
							<!-- Img -->
							<table>
								<tr height="30">
									<td align="center" style="width: auto; height: auto;"><img
										src='<c:out value="${list.fname}"/>'style="width: 772.5px;height: 500px;"></td>
								</tr>
							</table>
					</div>


					<h3>${list.subject }</h3>

					<ul class="post-meta">
						<li>${list.regdate }</li>
						<li><a href="#">글쓴이: ${list.writer }</a></li>
					</ul>


					<p>${list.content }</p>



					<!-- Share Buttons -->
					<c:if test="${sessionScope.memNum == list.memNum}">
						<input type="submit" value="수정"
							style="max-width: 100px; min-width: 99px;">
						<input type="button" value="글삭제"
							onclick="document.location.href='<%=request.getContextPath()%>/board/delete/${list.boardNum}'"
							style="max-width: 100px;">
					</c:if>
					<input type="button" value=" 글목록"
						onclick="document.location.href='/board/boardlist?pageNum=${pageNum}'"
						style="max-width: 100px;">


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

								</ul>

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

								</ul>

							</div>
						</div>
					</a>
				</div>
				<!-- Blog post Item / End -->

			</div>
			<!-- Related Posts / End -->


			<div class="margin-top-50"></div>

			<!-- Reviews -->
			<form name="replyInsertForm">
				<div class="input-group">
					<input type="hidden" name="boardNum" value="${list.boardNum}" /> <input
						type="hidden" name="memNum" value="${list.memNum }" /> <input
						type="text" class="form-control" id="dcontent" name="content"
						placeholder="내용을 입력하세요."> <span class="input-group-btn">
						<button class="btn btn-default" type="button"
							name="replyInsertBtn" onclick="replyInsert()">등록</button>
					</span>
				</div>
			</form>

		</div>
		<div class="container">

			<section class="comments">
				<h4></h4>
				<h4 class="headline margin-bottom-35">
					Comments <span class="comments-amount"></span>
				</h4>




			</section>
			<div class="container">

				<c:if test="${sessionScope.boardNum==list.boardNum }">
					<div class="replyList"></div>
				</c:if>

			</div>

		</div>

	</div>
	<!-- Reply Form {s} -->

	<div class="my-3 p-3 bg-white rounded shadow-sm"
		style="padding-top: 10px"></div>

	<!-- Reply Form {e} -->



	<!-- Reply List {s}-->

	<div class="my-3 p-3 bg-white rounded shadow-sm"
		style="padding-top: 10px">

		<h6 class="border-bottom pb-2 mb-0"></h6>

		<div id="replyList"></div>

	</div>

	<!-- Reply List {e}-->

</div>




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



