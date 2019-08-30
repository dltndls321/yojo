<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="page-wrapper">
		<div class="container-fluid">
			<div class="col-lg-8" align="center">

				<div class="col-lg-12">
					<h1 class="page-header"></h1>
					<h1 class="page-header"></h1>
					
				</div>
				<div class="row">
					<div class="col-lg-12"></div>
				</div>
				<div class="panel panel-default">
					<div class="panel-body">
						<form method="POST" name="deleteForm" action="/board/deletePro">
			<input type="hidden" name="boardNum" value="${boardNum }">
			<input	type="hidden" name="pageNum" value="${pageNum }">
				<table class="table-bordered" width="360">
	<tr height="30"><td align=center><b>비밀번호를 입력해 주세요.</b></td></tr>
	<tr height="30"><td align=center>비밀번호 : <input type="password" name="passwd"
							size="8" maxlength="12"></td>
					</tr>
					<tr height="30">
						<td align=center><input type="submit" value="글삭제">
						
							<input type="button" value="글목록" style="max-width: 70px;"
							onclick="document.location.href='<%=request.getContextPath() %>/board/boardlist?pageNum=${pageNum }'">
							</td>
							</tr>
							</table>
							</form>
							
					</div>
				</div>
			</div>
		</div>
	</div>
