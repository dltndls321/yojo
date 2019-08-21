<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title></head><body>
<div class="w3-container">
<span class="w3-center  w3-large">
		<h3>(전체 글:${count})	</h3>
	</span>
	<p class="w3-right w3-padding-right-large">
		<a href="<%=request.getContextPath() %>/board/writeForm?pageNum=${pageNum}">글쓰기</a>
	</p>
<c:if test="${count==0 }">
<table class="w3-table-all" width="700">
		<tr class="w3-grey">
			<td align="center" width="50">저장된 글이 없습니다</td>
		</tr></table></c:if> 

<c:if test="${count>0 }">

<table class="w3-table-all" width="700">
		<tr class="table table-striped" style="text-align: center; ">
			<th >번호</th>
			<th >제 목</th>
			<th >작성자</th>
			<th >작성일</th>
			<th >조 회</th>
	
		</tr>
<c:forEach   var="article"    items="${articleList }">
 
		<tr height="30">
			<td align="center" width="50"><c:out value="${number}"/></td>
			<c:set var="number"  value="${number-1 }"/>
			<td width="250">
		<c:if test="${article.re_level > 0 }">
			
				 <img src="<%=request.getContextPath() %>/images/level.gif"
				width="${5*article.re_level}" height="16">
				 <img src="<%=request.getContextPath() %>/images/re.gif">
				</c:if>
				
	
<a href="<%=request.getContextPath() %>/board/content?num=${article.num}&pageNum=${pageNum}">${article.subject}</a> 
	
	<c:if test="${article.readcount>= 5 }">
		 <img src="<%=request.getContextPath() %>/images/hot.gif" 
 border="0" height="16">
				</c:if>
			
			
			
			</td>
			<td align="center" width="100">${article.writer}</td>
			
			
			
			<td align="center" width="150">
			<fmt:formatDate type="date" value="${article.reg_date}" />
		
		
		
		</td>
			<td align="center" width="50">${article.readcount}</td>
			
		</tr>	
	</c:forEach>
	
	
	
	
</table>

  <div class="w3-center">
  <c:if test="${ startPage>bottomLine}">

    <a href="list?pageNum=${startPage - bottomLine}">[이전]</a> </c:if>
<c:forEach   var="i"  begin="${startPage }"   end="${endPage }">

     <a href="list?pageNum=${i}">[${i}] </a>
</c:forEach>

<c:if test="${ endPage<pageCount}">

<a href="list?pageNum=${startPage + bottomLine}">[다음]</a></c:if>
 
 
</div></c:if>
</div> 




</body>
</html>