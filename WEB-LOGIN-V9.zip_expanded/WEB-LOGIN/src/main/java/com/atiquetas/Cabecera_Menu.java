package com.atiquetas;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Etiqueta personalizada para la creacion de parte del menu de la aplicacion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.1
 * @since 17-4-2023.
 * 
 */
public class Cabecera_Menu extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// RECOJO EL IDIOMA ELEGIDO PARA PODER IDIOMATIZAR LOS TEXTOS
		String idioma_elegido = (String) this.getJspContext().getAttribute("idioma_elegido", PageContext.SESSION_SCOPE);
		ResourceBundle rb = ResourceBundle.getBundle(idioma_elegido);
		// CREAR LAS ETIQUETAS DINAMICAS PARA LA PAGINA
		StringBuffer salida = new StringBuffer();
		// HORA DEL MOMENTO
		salida.append(
				"\n<tr><td align='center'>" + SimpleDateFormat.getTimeInstance().format(new Date()) + "</td></tr>\n");
		// ESCRIBIMOS EN LA PAGINA HTML
		getJspContext().getOut().append(salida.toString());
	}

}
