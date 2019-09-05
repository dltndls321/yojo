<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script>
	$
	{
		"#btnInsert"
	}
	click(function() {
		var subject = $("#subject").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
		var passwd = $("#passwd").val();
		if (subject == " ") {
			alert("제목을 입력해주세요")
			document.form.subject.focus();
			return;
		}
		if (content == " ") {
			alert("제목을 입력해주세요")
			document.form.content.focus();
			return;
		}
		if (writer == " ") {
			alert("제목을 입력해주세요")
			document.form.writer.focus();
			return;
		}
		if (passwd == " ") {
			alert("제목을 입력해주세요")
			document.form.passwd.focus();
			return;
		}
	})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>boardList</title>
</head>

<body>

	<div class="page-wrapper">
		<div class="container-fluid">
			<div class="col-lg-8">
				<!--게시판 넓이 -->
				<div class="col-lg-12">
					<h1 class="page-header"></h1>
				</div>
				<div class="row">
					<div class="col-lg-12"></div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading"></div>
					<div class="panel-body">
						<form method="post" name="writeUploadForm"
							enctype="multipart/form-data" action="/board/writeUploadPro">

							<input type="hidden" name="boardid" value="${boardid}">

							<div class="row form-group">

								<label class="col-lg-2">제목</label>
								<div class="col-lg-8">
									<input type="text" class="form-control" id="subject"
										name="subject" min="1" max="3">
								</div>
							</div>
							<div class="row form-group">

								<label class="col-lg-2">이름</label>
								<div class="col-lg-8">
									<input type="text" class="form-control" id="writer"
										name="writer" min="1" max="3">
								</div>
							</div>

							<div class="row form-group">
								<label class="col-lg-2">내용</label>
								<div class="col-lg-8">
									<textarea class="form-control" id="content" name="content"></textarea>
								</div>
							</div>
							<div class="row form-group">

								<label class="col-lg-2">비밀번호</label>
								<div class="col-lg-8">
									<input type="text" class="form-control" id="passwd"
										name="passwd" min="1" max="3">
								</div>
							</div>
							<table>

								<tr>
									<td width="70" align="center"></td>
									<td width="260"><input type="file" size="40"
										maxlength="30" name="uploadfile"
										style="border: none; border-right: 0px; border-top: 0px; boder-left: 0px; boder-bottom: 0px;"></td>
								</tr>
								<tr>
									<td colspan=2 align="center"><input type=submit
										id="btnInsert" value="글쓰기"
										style="max-width: 100px; min-width: 33px;"> <input
										type="reset" value="다시작성" style="max-width: 100px;"> <input
										type="button" value="목록보기"
										OnClick="window.location='boardlist?pageNum=${pageNum}'"
										style="max-width: 100px;"></td>


								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>