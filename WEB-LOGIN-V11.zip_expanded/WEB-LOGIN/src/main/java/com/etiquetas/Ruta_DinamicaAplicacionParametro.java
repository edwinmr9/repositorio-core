package com.etiquetas;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.util.ITraza_Log;

public class Ruta_DinamicaAplicacionParametro extends SimpleTagSupport {
	// PROPIEDAD DE CLASE RECIBIDA POR INYECCION DE DEPENDENCIAS
	private HttpServletRequest contexto_peticion;
	// REGISTRO EN EL SISTEMA DE LOG
//	private Logger log = Logger.getLogger(getClass());
//	private INiveles_Log log = new Traza_Log();
	private ITraza_Log log;
	

	public Ruta_DinamicaAplicacionParametro() {
		log.registro("SE CREA EL OBJETO DE LA ETIQUETA RUTA DINAMICA CON PARAMETRO");
	}

//	@Override
	public void doTag() throws JspException, IOException {
		log.registro("SE INVOCA EL METODO DOTAG");
		// CALCULAMOS LA RUTA DINAMICAMENTE PARA PASARSELA A LA PAGINA
		String path = contexto_peticion.getContextPath();
		String basePath = contexto_peticion.getScheme() + "://" + contexto_peticion.getServerName() + ":"
				+ contexto_peticion.getServerPort() + path + "/";
		// ESCRIBIR EL HTML PARA LA PAGINA JSP
		try {
			this.getJspContext().getOut().append("<base href='" + basePath + "'/>");
//			log.registro("la etiqueta de html creada es .. " + "<base href='" + basePath + "'/>");
			log.registro("la etiqueta de html creada es .. " + "<base href='" + basePath + "'/>");
		} catch (IOException e) {
			// ERROR EN PROCESO DE SALIDA
			e.printStackTrace();
		}
	}

	// ACCESORES PARA EL SERVIDOR Y QUE PUEDA REALIZAR LA INYECCION DE DEPENDENCIAS.
	public void setContexto_peticion(HttpServletRequest contexto_peticion) {
		this.contexto_peticion = contexto_peticion;
		log.registro("SE INVOCA EL METODO PARA LA INYECCION DE DEPENDENCIAS");
//			log.registro("se inyecta el valor desde la pagina");
	}

}
