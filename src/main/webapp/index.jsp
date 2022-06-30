<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body background="imagenes/espacio.jpg">
<h2  style="color:white;"	>Login</h2>
<form action="login" method="post">
<table>
<tr>
	<td><label style="color:white;">Usuario</label></td>
	<td><input type="text" name="usuario"></td>
<tr/>
	<td><label style="color:white;">Password</label></td>
	<td><input type="password" name="password"></td>
<tr>
	
<tr/>
	<td><label></label></td>
	<td><button type ="submit"> Entrar</button></td>
</table>
</form>
<table>

	<tr>
		<td>
			<label> ${respuesta} </label>
		</td>
	</tr>
	<tr>
		<td style="color:white;"><a href="crearCuenta.jsp">Crear Cuenta Nueva</a></td>
		<td style="color:white;"><a href="recuperar.jsp">Recuperar Password</a></td>
	</tr>
	<tr>
		<td style="color:white;"><a href="#">Entrar con cuenta de Facebook</a></td>
		<td style="color:white;"><a href="#">Entrar con cuenta de Google</a></td>
	</tr>
</table>

</body>
</html>