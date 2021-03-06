<%@page import="petline.util.PetLineUtils"%>
<%@page import="org.apache.axis.utils.StringUtils"%><html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = request.getParameter("message");
%>		
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PetLine</title>
<link rel="stylesheet" type="text/css" href="<%= PetLineUtils.getURL() %>css/PetLine.css">
<script type="text/javascript" src="<%= PetLineUtils.getURL() %>js/main.js" ></script>
<script type="text/javascript">
function validarForm(){
	var user = document.getElementById("userName");
	var pass = document.getElementById("password");
	if(trim(user.value) == '' ){
		alert("Debe ingresar el usuario");
		user.focus();
		return;
	} else if (trim(pass.value) == '' ) {
		alert("Debe ingresar la contraseņa");
		pass.focus();
		return;
	}
	document.form.submit();
}

function ocultarMsg(){
	div = document.getElementById("message");
	div.innerHTML="&nbsp;";
}
</script>
</head>
<body onLoad="document.form.userName.focus();" style="background-image:url('<%= PetLineUtils.getURL() %>img/fondo.png');">
<form method="post" name="form" id="form" action="login.do">
	<p class="header"><img src="<%= PetLineUtils.getURL() %>img/petLineLogo.png"></p>
	<br>
	<p id="message" class="error"><%= (!StringUtils.isEmpty(msg)?msg:"&nbsp;") %></p>
	<br>
	<table class=table>
		<tr>
			<td colspan="4"><br><br></td>
		</tr>
		<tr height=25px>
			<td width=25px>&nbsp;&nbsp;</td>
			<td class="etiqueta" width=175px>Usuario</td>
			<td><input type="text" width=175px name="userName" id="userName" autocomplete="off" onkeypress="return soloLetras();" maxlength=10></td>
			<td width=25px>&nbsp;</td>
		</tr>
		<tr height=25px>
			<td>&nbsp;&nbsp;</td>
			<td class="etiqueta">Clave</td>
			<td><input type="password" name="password" id="password" onFocus="ocultarMsg();" onkeydown="if(event.keyCode==13){validarForm();}" autocomplete="off"  onkeypress="return soloNumerosLetras();" maxlength=10></td>
			<td>&nbsp;</td>
		</tr>
		<tr height=25px>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr height=25px>
			<td>&nbsp;</td>
			<td colspan="2" align=center><a style="cursor:hand;" onclick="validarForm();" ><img src="<%= PetLineUtils.getURL() %>img/key.png" border=0 onmouseover="this.src='<%= PetLineUtils.getURL() %>img/keyhover.png';" onmouseout="this.src='<%= PetLineUtils.getURL() %>img/key.png';"></a></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="4"><br><br></td>
		</tr>
	</table>
	<br>
	<p align=center ><a href="./registrarUsuario.jsp">Registrarse</a></p>
	<br>
	<p align=center ><a target="_blank" href="<%= PetLineUtils.getURL() %>doc/ManualUsuario.pdf">Ayuda</a>&nbsp;<a target="_blank" href="https://www.facebook.com/PetLineSystem">Contactenos</a></p>
</form>
</body>
</html>