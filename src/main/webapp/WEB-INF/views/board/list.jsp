<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="w3-container">
		<span class="w3-center  w3-large"> </span>
		<p class="w3-right w3-padding-right-large">
			<a href="<%=request.getContextPath()%>/board/writeForm?">글쓰기</a>
		</p>


		

		<table class="table table-striped table-bordered table-hover" width="700">
			<tr class="table table-striped" style="text-align: center;">
				<th>번호</th>
				<th>제 목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조 회</th>

			</tr>
			<c:forEach var="list" items="${AllList }">

				<tr height="30">
					<td align="center" width="50">${list.boardNum }</td>
					
					<td width="250">${list.subject }</td>
					<td align="center" width="100">${list.writer}</td>



					<td align="center" width="150"><fmt:formatDate type="date"
							value="${list.regdate}" /></td>
					<td align="center" width="50">${list.readcount}</td>

				</tr>
			</c:forEach>




		</table>


	</div>




</body>
</html>