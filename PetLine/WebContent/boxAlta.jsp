<%@page import="petline.util.PetLineUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Box's</title>
<link rel="stylesheet" type="text/css" href="<%= PetLineUtils.getURL() %>css/PetLine.css">
<script type="text/javascript" src="<%= PetLineUtils.getURL() %>js/main.js" ></script>
</head>
<body style="background-image:url('./img/fondo.png');">
<form method="post" name="form1" id="form1" action="AltaBox.do">
		<p class="title">Alta de Box</p>
		<br>
		<table class=table2 >
			<tr>
				<td class=etiqueta>C�digo de Box</td>
				<td>&nbsp;<input type="text" name="codigo" id="codigo"  onkeypress="return soloNumerosLetras();" /></td>
			<tr>
			<tr>
				<td class=etiqueta>Descripci�n</td>
				<td>&nbsp;<input type="text" name="descripcion" id="descripcion"/></td>
			<tr>
		</table>
		<br>
		<input type="button" class="buttons" value="Agregar" onclick="validarAltaBox();">
		&nbsp;<input type="button" class="buttons" value="Cancelar" onclick="history.back();">
</form>
</body>
</html>    

    