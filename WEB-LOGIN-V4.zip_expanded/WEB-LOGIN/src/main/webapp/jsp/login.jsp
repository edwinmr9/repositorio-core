<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- FORMULARIO DE LOGIN --%>
	<form action="Servlet_Login" method="post">
		<table>
			<tr>
				<td>Nombre usuario</td>
				<td><input type="text" name="nombre_usuario" value="${param.nombre_usuario}"></td>
				<%-- GESTION DINAMICA DEL MENSAJE DE ERROR DE NOMBRE --%>
				<td>${requestScope.error_nombre}</td>
			</tr>
			<tr>
				<td>Clave Usuario</td>
				<td><input type="password" name="clave_usuario" value="${param.clave_usuario}"></td>
					<%-- GESTION DINAMICA DEL MENSAJE DE ERROR DE CLAVE --%>
				<td>${requestScope.error_clave}</td>
			</tr>
			<tr>
				<td colspan="2">
				<%-- BOTON DE PETICION AL SERVIDOR --%>
				<input type="submit" name="Comprobar"></td>
			</tr>
		</table>
	</form>
</body>
</html>