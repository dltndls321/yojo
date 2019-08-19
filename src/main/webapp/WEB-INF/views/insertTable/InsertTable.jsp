<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>테이블 삽입</title>
</head>
<body>
<form action="/insert.do">
<a>이름 : </a><input type="text" name="name"><br/>
<a>번호 : </a><input type="number" name="num"><br/>
<input type="submit" value="데이터 insert">
</form>
</body>
</html>