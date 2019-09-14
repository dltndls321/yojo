<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>boardList</title>



<div class="page-wrapper">
	<div class="container-fluid">
		<div class="col-lg-8">

			<div class="col-lg-12">
				<h1 class="page-header">수정</h1>
			</div>
			<div class="row">
				<div class="col-lg-12"></div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">게시판 수정</div>
				<div class="panel-body">
					<form method="post" name="updateForm" enctype="multipart/form-data"
						action="/board/updatePro">

						<input type="hidden" name="boardid" value="${list.boardid}"> <input
							type="hidden" name="boardNum" value="${list.boardNum}">

						<div class="row form-group">

							<label class="col-lg-2">제목</label>
							<div class="col-lg-8">

								<input type="text" class="form-control" id="subject"
									name="subject" min="1" max="3" value="${list.subject }">
							</div>
						</div>
						<div class="row form-group">

							<label class="col-lg-2">이름</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="writer"
									name="writer" min="1" max="3" value="${list.writer }">
							</div>
						</div>

						<div class="row form-group">
							<label class="col-lg-2">내용</label>
							<div class="col-lg-8">
								<textarea class="form-control" id="content" name="content">${list.content }</textarea>
							</div>
						</div>
						<div class="row form-group">

							<label class="col-lg-2">비밀번호</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="passwd"
									name="passwd" min="1" max="3"> <input type="hidden"
									id="passwd" name="passwd" value="${list.passwd }">
							</div>
						</div>
						<div class="row form-group">

							<table>
								
							</table>
						</div>
						<table>


							<tr>
								<td colspan=5 align="center"><input type="submit"
									value="수정" style="max-width: 100px; min-width: 99px;">
									<input type="reset" value="다시입력" style="max-width: 100px;">
									</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>




