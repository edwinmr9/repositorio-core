package com.etiquetas;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Etiqueta basica para la creacion del base href.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 17-4-2023.
 * 
 */
public class Ruta_DinamicaAplicacion extends TagSupport {

	/**
	 * PROCESO DE CREACION DE LA RUTA EXTERNA DEL SERVIDOR DE FORMA DINAMICA.
	 * 
	 * @return Como continuar con el procesamiento de la pagina. Controlado/definido
	 *         por constantes de clase.
	 */
	@Override
	public int doEndTag() throws JspException {
		// RECIBIMOS EL CONTEXTO DE PETICION PARA SU USO
		HttpServletRequest peticion = (HttpServletRequest) pageContext.getRequest();
		// CALCULAMOS LA RUTA DINAMICAMENTE PARA PASARSELO A LA PAGINA
		StringBuilder salida = new StringBuilder();
		salida.append(peticion.getScheme() + "://" + peticion.getServerName() + ":" + peticion.getServerPort()
				+ peticion.getContextPath() + "/");
		// ESCRIBIR EL HTML PARA LA PAGINA JSP
		System.out.println("CLASE RUTA DINAMICA APLICACION");
		try {
			pageContext.getOut().append("<base href='" + salida.toString() + "'/>");
		} catch (IOException e) {
			System.out.println("ERROR EN LA CREACION DE LA RUTA DINAMICA DEL SERVIDOR");
			e.printStackTrace();
		} 
		// CONTINUA EVALUANDOSE EL RESTO DE LA PAGINA
		return EVAL_PAGE;
	}

}
