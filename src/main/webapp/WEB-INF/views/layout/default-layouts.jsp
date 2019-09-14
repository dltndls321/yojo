<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<tiles:insertAttribute name="head"/>
</head>

<body>

<!-- Wrapper -->
<div id="wrapper">

<!-- Header Container
================================================== -->

	<tiles:insertAttribute name="header"/>



<!-- Header Container / End -->


<tiles:insertAttribute name="content"/>


<!-- Footer
================================================== -->
<tiles:insertAttribute name="footer"/>
</div>
<!-- Wrapper / End -->


<!-- Scripts
================================================== -->
<tiles:insertAttribute name="script"/>




</body>
</html>