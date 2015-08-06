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
<form method="post" name="form1" id="form1" action="./trackerMasc.jsp">
		<p class="title">Eliminar Asignaci�n de Tracker-Mascota</p>
		<br>
		<table class=table2 >
			<tr>
				<td class=etiqueta>Mascota</td>
				<td>
					<select name="mascota" id="mascota" disabled>
						<option value=""></option>
						<option value="1" selected>Donato</option>
					</select>
				</td>
			<tr>
			<tr>
				<td class=etiqueta>Descripcion Tracker</td>
				<td>&nbsp;<input type="text" name="descripcion" id="descripcion" value="<%= request.getParameter("descripcion") %>" disabled/></td>
			<tr>					
			<tr>
				<td class=etiqueta>Temperatura Minima</td>
				<td>&nbsp;<input type="text" name="tempMin" id="tempMin" value="<%= request.getParameter("tempMin") %>" disabled/></td>
			<tr>
			<tr>
				<td class=etiqueta>Temperatura Maxima</td>
				<td>&nbsp;<input type="text" name="tempMax" id="tempMax" value="<%= request.getParameter("tempMax") %>" disabled/></td>
			<tr>			
		</table>
		<br>
		<input type="button" class="buttons" value="Eliminar" onclick="document.form1.submit()">
</form>
</body>
</html>    

    