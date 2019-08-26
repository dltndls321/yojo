<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>

<html>
<head>
<title>게시판</title>
</head>

<body>
	<br>
	<br>
	<b>글내용 보기</b>
	<div class="w3-container w3-display-middle">
		<table class="w3-table-all">
			<tr height="30">
				<td align="center">글번호</td>
				<td align="center">${article.num}</td>
				<td>조회수</td>
				<td align="center">${article.readcount}</td>
			</tr>
			<tr height="30">
				<td>작성자</td>
				<td align="center">${article.writer}</td>
				<td align="center">작성일</td>
				<td align="center" align="center">${article.reg_date}</td>
			</tr>
			<tr height="30">
				<td align="center">글제목</td>
				<td align="center" colspan="3">${article.subject}</td>
			</tr>
			<tr height="30">
				<td align="center">글내용</td>
				<td align="left" colspan="3"><pre>${article.content}</pre></td>
			</tr>
			<tr height="30">
				<td align="center">이미지</td>
				<td align="left" colspan="3">
				<img src="<%=request.getContextPath() %>/images/${article.filename}"></td>
			</tr>
			<tr height="30">
				<td colspan="4" class="w3-center"><input type="button"
					value="글수정"
					onclick="document.location.href='<%=request.getContextPath()%>/board/update?num=${article.num}&pageNum=${pageNum}'">
					&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="글삭제"
					onclick="document.location.href='<%=request.getContextPath()%>/board/delete?num=${article.num}&pageNum=${pageNum}'">
					&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="답글쓰기"
					onclick="document.location.href
					='${pageContext.request.contextPath}/board/writeForm?num=${article.num}&pageNum=${pageNum}&ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}'">
					&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="글목록"
					onclick="document.location.href='<%=request.getContextPath()%>/board/list?pageNum=${pageNum}'"></td>
			</tr>
		</table>



	</div>
</body>
</html>

