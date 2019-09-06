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
						$.each(
								data,
										function(key, value) {
											a += '<div class="replyArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
											a += '<div class="replyInfo'+ value.replyNum +'">'
													+ '댓글번호 : '
													+ value.replyNum
													+ ' / 작성자 : '
													+ value.memNum;
											 a += '<a onclick="replyUpdate('
													+ value.replyNum + ',\''
													+ value.content
													+ '\');"> 수정 </a>'; 
											a += '<a onclick="replyDelete('
													+ value.replyNum
													+ ');"> 삭제 </a> </div>';
											
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


	<!-- Titlebar
================================================== -->
<div id="titlebar" class="gradient">
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<h2><i class="sl sl-icon-plus"></i>자유게시판</h2>

			</div>
		</div>
	</div>
</div>

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
	<div class="row">
						<!-- Post Navigation -->
			<ul id="posts-nav" class="margin-top-0 margin-bottom-45">
			<c:choose>
				<c:when test="${board.nextboardNum==0}">다음글이 없습니다.</c:when>
				<c:otherwise><li class="next-post"><a href='/board/content?boardNum=${board.nextboardNum}'><span>다음글</span></a></li></c:otherwise>
				</c:choose>
				<c:choose>
				<c:when test="${board.prevboardNum==0}">이전글이 없습니다.</c:when>
				<c:otherwise><li class="prev-post"><a href='/board/content?boardNum=${board.prevboardNum}'><span>이전글 </span></a></li></c:otherwise>
				</c:choose>
			</ul>

		</div>
			<!-- Related Posts / End -->



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

<!-- Content / End -->





