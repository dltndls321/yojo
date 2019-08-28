<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<script>

	
</script>
</head>
<body>
	
		<table class="content">
			<colgroup>
				<col width="15%" />
				<col width="35%" />
				<col width="25%" />
				<col width="55%" />
			</colgroup>
			<caption>게시글 상세</caption>
			<form name="form1" method="post" action="/board/update/${list.boardNum}">
			
			<tbody>
				<tr>
					<th scope="row">글 번호</th>
					<td>${list.boardNum }
					<input type="hidden" id="boardNum" name="boardNum" value="${list.boardNum }">
					</td>
					<th scope="row">조회수</th>
					<td>${list.readcount }
					<input type="hidden" id="readcount" name="readcount" value="${list.readcount }">
					</td>
				</tr>
				<tr>
					<th scope="row">작성자</th>
					<td>${list.writer }
					<input type="hidden" id="writer" name="writer" value="${list.writer }">
					
					</td>
					<th scope="row">작성시간</th>
					<td>${list.regdate }
					</td>
				</tr>
				<tr>
					<th scope="row">제목</th>
					<td colspan="3">${list.subject }
				<input type="hidden" id="subject" name="subject" value="${list.subject }">	
					</td>
				</tr>
				
				<tr>
					<td>
					<div style="height: 300px; margin: 10px; display: inline-block">${list.content }
					<input type="hidden" id="content" name="content" value="${list.content }">	
					
					</div>
					</td>
				</tr>
					<tr>	
					<td>		
					<input type="hidden" id="passwd" name="passwd" value="${list.passwd }">	
					</td>
					</tr>
			</tbody>
			
			<tr height="30">
				<td colspan="4" class="w3-center">
			 <div class="form-group">
			 
          <input type="submit" value="수정" >
			</form>

			<form action="/board/delete/${list.boardNum}">
			<input type="submit" value="삭제" >
			</form> 
              <input type="button" value="글목록" onclick="document.location.href='/board/boardlist?pageNum=${pageNum}'"> 
      </div>
<%-- 		<input type="button" value="글수정" onclick="document.location.href='/board/update?boardNum=${list.boardNum}'">
		<input type="button" value="글삭제" onclick="document.location.href='/board/delete?boardNum=${list.boardNum}'">
		<input type="button" value="답글쓰기" onclick="document.location.href='${pageContext.request.contextPath}/board/writeUploadForm?boardNum=${list.boardNum}&pageNum=${pageNum}&ref=${list.ref}&reStep=${list.reStep}&reLevel=${list.reLevel}'">
		<input type="button" value="글목록" onclick="document.location.href='/board/boardlist?pageNum=${pageNum}'"></td> --%>
			</tr>
	
		</table>
	
</body>
</html>



