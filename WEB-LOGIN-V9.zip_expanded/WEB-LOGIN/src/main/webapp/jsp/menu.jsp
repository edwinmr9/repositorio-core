<%-- FRAGMENTO DE PAGINA - MENU APLICACION --%>

<%-- TLD DE ETIQUETAS PERSONALIZADAS --%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<%-- CARGAMOS PROPERTIES CON EL IDIOMA SELECCIONADO --%>
<fmt:setBundle basename="${sessionScope.idioma_elegido}" />

<%-- BOTON DE FIN DE SESION --%>
<form action="Servlet_Finalizar" method="post">
	<fmt:message key="menu.bot.salir" var="boton_salir" />
	<input type="submit" value="${boton_salir}">
</form>