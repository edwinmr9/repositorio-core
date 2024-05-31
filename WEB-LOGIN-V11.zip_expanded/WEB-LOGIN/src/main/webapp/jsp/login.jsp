<%-- FRAGMENTO DE PAGINA - LOGIN --%>

<%-- DIRECTIVAS DE JSP --%>
<%-- DEFINICION DE LA PAGINA --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- USO DE LAS ETIQUETAS PERSONALIZADAS --%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<%-- DEFINICION DE PROPERTIES A USAR EN LA PAGINA --%>
<fmt:setBundle basename="${sessionScope.idioma_elegido}" />
<%-- FORMULARIO DE LOGIN --%>
<form action="Servlet_Login" method="post">
	<table>
		<tr>
			<%-- RECUPERAR EL TEXTO ASOCIADO A LA CLAVE DADA --%>
			<td><fmt:message key="formu.login.eti.nombreusuario" /></td>
			<td><input type="text" name="nombre_usuario"
				value="${param.nombre_usuario}"></td>
			<%-- GESTION DINAMICA DEL MENSAJE DE ERROR DE NOMBRE --%>
			<td>${requestScope.error_nombre}</td>
		</tr>
		<tr>
			<td><fmt:message key="formu.login.eti.claveusario" /></td>
			<td><input type="password" name="clave_usuario"
				value="${param.clave_usuario}"></td>
			<%-- GESTION DINAMICA DEL MENSAJE DE ERROR DE CLAVE --%>
			<td>${requestScope.error_clave}</td>
		</tr>
		<tr>
			<%-- BOTON DE PETICION AL SERVIDOR --%>
			<td colspan="2"><fmt:message key="formu.login.bot.comprobar"
					var="boton" /> <input type="submit" name="comprobar"
				value="${boton}"></td>
		</tr>
	</table>
</form>
