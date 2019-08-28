<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script>
${"#btnInsert"}.click(function () {
	var subject = $("#subject").val();
	var content = $("#content").val();
	var writer = $("#writer").val();
	var passwd = $("#passwd").val();
	if (subject == " "){
		alert("제목을 입력해주세요")
		document.form.subject.focus();
		return;
	}
	if (content == " "){
		alert("제목을 입력해주세요")
		document.form.content.focus();
		return;
	}
	if (writer == " "){
		alert("제목을 입력해주세요")
		document.form.writer.focus();
		return;
	}
	if (passwd == " "){
		alert("제목을 입력해주세요")
		document.form.passwd.focus();
		return;
	}
})

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>boardList</title>
</head>

<body>

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
						<form method="post" name="writeUploadForm" enctype="multipart/form-data"
							action="writeUploadPro">

							<input type="hidden" name="boardid" value="${boardid}">
							
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
									<textarea class="form-control" id="content" name="content" 
									>${list.content }</textarea>
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
							
								<td width="600" align="left">
								<input type="file" size="40" maxlength="30" name="uploadfile"></td>
							</tr>
							
								<tr>
									<td colspan=2 align="center">
									<button class="btn btn-outline btn-primary" id="btnInsert" value="글쓰기">글쓰기</button>
									<input class="btn btn-outline btn-primary" type="reset" value="다시작성"> 
									<input class="btn btn-outline btn-primary" type="button" value="목록보기"
										OnClick="window.location='boardlist?pageNum=${pageNum}'"></td>

								</tr>
								</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>
