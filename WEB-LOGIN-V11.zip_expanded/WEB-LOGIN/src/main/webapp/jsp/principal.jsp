<%-- PAGINA PLANTILLA DE LA APLICACION - UNICA VISTA DEL PROGRAMA --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- TLD DE ETIQUETAS PERSONALIZADAS --%>
<%@ taglib uri="http://com.jsg" prefix="jsg"%>

<!DOCTYPE html>
<html>
<head>

<%-- <jsg:ruta_servidor/> --%>
	<jsg:ruta-parametro contexto_peticion="${pageContext.request}"/>

<%-- *** PETICION DE RECURSOS ADICIONALES AL SERVIDOR *** --%>
<%-- HOJAS DE ESTILOS --%>
<link rel="stylesheet" type="text/css" href="css/estilos.css" />
</head>
<body>

	<%-- DEFINICION DE ZONAS EN LA PLANTILLA DE LA VISTA --%>
	<div id="banner">
		<%-- CONTENIDO FIJO --%>
		<jsp:include page="/jsp/idiomas.jsp" />
	</div>
	<div id="menu">
		<%-- CONTENIDO FIJO --%>
		<jsp:include page="/jsp/menu.jsp" />
	</div>
	<div id="cuerpo">
		<%-- CONTENIDO VARIABLE --%>
		<jsp:include page="/jsp/${param.tarea}" />
	</div>

</body>
</html>