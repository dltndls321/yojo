<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>°Ô½ÃÆÇ</title>
</head>

<p class="w3-left" style="padding-left: 30px;">${board}></p>
<div class="w3-container w3-center">
	<b>±Û¾²±â</b> <br>
	<form method="post" name="writeform" enctype="multipart/form-data"
		action="writePro">

		<input type="hidden" name="boardNum" value="${boardNum}"> 
		<input type="hidden" name="ref" value="${ref}"> 
		<input type="hidden" name="reStep" value="${reStep}"> 
		<input type="hidden" name="reLevel" value="${reLevel}">

		<table class="w3-table-all" style="width: 70%;">
			<tr>

			</tr>
			<tr>
				<td width="70" align="center">ÀÌ ¸§</td>
				<td width="330"><input type="text" size="10" maxlength="10"
					name="writer"></td>
			</tr>
			<tr>
				<td width="70" align="center">Á¦ ¸ñ</td>
				<td width="330"><input type="text" size="10" maxlength="10"
					name="subject"></td>
			</tr>

			<tr>
				<td width="70" align="center">³» ¿ë</td>
				<td width="330"><textarea name="content" rows="13" cols="40"></textarea>
				</td>
			</tr>

			<tr>
				<td width="70" align="center">file</td>
				<td width="330"><input type="file" size="40" maxlength="30"
					name="uploadfile"></td>
			</tr>


			<tr>
				<td width="70" align="center">ºñ¹Ð¹øÈ£</td>
				<td width="330"><input type="password" size="8" maxlength="12"
					name="passwd"></td>
			</tr>
			<tr>
<<<<<<< HEAD
				<td colspan=2 align="center"><input type="submit" value="ê¸€ì“°ê¸°">
					<input type="reset" value="ë‹¤ì‹œìž‘ì„±"> <input type="button"
					value="ëª©ë¡ë³´ê¸°" OnClick="window.location='list?pageNum=${pageNum}'">
=======
				<td colspan=2 align="center"><input type="submit" value="±Û¾²±â">
					<input type="reset" value="´Ù½ÃÀÛ¼º"> <input type="button"
					value="¸ñ·Ïº¸±â" OnClick="window.location='list?pageNum=${pageNum}'">
>>>>>>> parent of ec3ca44... ì»¤ë°‹ 08-27
				</td>
			</tr>
		</table>

	</form>
</div>




</body>
</html>
