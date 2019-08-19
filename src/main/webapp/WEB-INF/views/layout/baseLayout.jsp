<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<tiles:insertAttribute name="title"/>
<body>
<!-- Wrapper -->
<div id="wrapper">
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="Banner"/>
	<tiles:insertAttribute name="body"/>
	<tiles:insertAttribute name="footer"/>
	<tiles:insertAttribute name="Scripts"/>
</div>
</body>
</html>