<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<html><head><title>�Խ���</title></head><body>
	<div class="w3-center">
		<p class="w3-left" style="padding-left: 30px;">></p>
		<div class="w3-container ">
			<b>�ۻ���</b><br>
			<form method="POST" name="deleteForm" action="<%=request.getContextPath() %>/board/deletePro">
			<input type="hidden" name="num" value="${num }">
			<input	type="hidden" name="pageNum" value="${pageNum }">
				<table class="table-bordered" width="360">
	<tr height="30"><td align=center><b>��й�ȣ�� �Է��� �ּ���.</b></td></tr>
	<tr height="30"><td align=center>��й�ȣ : <input type="password" name="passwd"
							size="8" maxlength="12"></td>
					</tr>
					<tr height="30">
						<td align=center><input type="submit" value="�ۻ���">
							<input type="button" value="�۸��"
							onclick="document.location.href='<%=request.getContextPath() %>/board/list?pageNum=${pageNum }'">
						</td>
		</tr></table></form>	</div>	</div></body></html>
