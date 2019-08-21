<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

하이
<c:forEach items="memberList" var="memberLists">
	<a> ${memberLists.name } </a><br/>
</c:forEach>
