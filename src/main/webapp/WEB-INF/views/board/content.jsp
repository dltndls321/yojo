<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.text.SimpleDateFormat"%>

<html>
<head>
<title>�Խ���</title>
</head>

<body>
	<br>
	<br>
	<b>�۳��� ����</b>
	<div class="w3-container w3-display-middle">
		<table class="w3-table-all">
			<tr height="30">
				<td align="center">�۹�ȣ</td>
				<td align="center">${article.num}</td>
				<td>��ȸ��</td>
				<td align="center">${article.readcount}</td>
			</tr>
			<tr height="30">
				<td>�ۼ���</td>
				<td align="center">${article.writer}</td>
				<td align="center">�ۼ���</td>
				<td align="center" align="center">${article.reg_date}</td>
			</tr>
			<tr height="30">
				<td align="center">������</td>
				<td align="center" colspan="3">${article.subject}</td>
			</tr>
			<tr height="30">
				<td align="center">�۳���</td>
				<td align="left" colspan="3"><pre>${article.content}</pre></td>
			</tr>
			<tr height="30">
				<td align="center">�̹���</td>
				<td align="left" colspan="3">
				<img src="<%=request.getContextPath() %>/images/${article.filename}"></td>
			</tr>
			<tr height="30">
				<td colspan="4" class="w3-center"><input type="button"
					value="�ۼ���"
					onclick="document.location.href='<%=request.getContextPath()%>/board/update?num=${article.num}&pageNum=${pageNum}'">
					&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="�ۻ���"
					onclick="document.location.href='<%=request.getContextPath()%>/board/delete?num=${article.num}&pageNum=${pageNum}'">
					&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="��۾���"
					onclick="document.location.href
					='${pageContext.request.contextPath}/board/writeForm?num=${article.num}&pageNum=${pageNum}&ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}'">
					&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="�۸��"
					onclick="document.location.href='<%=request.getContextPath()%>/board/list?pageNum=${pageNum}'"></td>
			</tr>
		</table>



	</div>
</body>
</html>

