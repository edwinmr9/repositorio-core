package com.etiquetas;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.modelo.Usuarios;

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
		
		// ****** PRIMERA LINEA DE LA CABECERA DEL MENU - TITULO
		// CREAR LAS ETIQUETAS DINAMICAS PARA LA PAGINA
		StringBuffer salida = new StringBuffer();
		salida.append("\n <tr><td>"+rb.getString("men.eti.prueba") +"</td></tr>\n");
		
		// ****** SEGUNDA LINEA DE LA CABECERA DEL MENU - NOMBRE USUARIO
		// RECOGE EL USUARIO DE LA SESION
		Usuarios usuario = (Usuarios) this.getJspContext().getAttribute("usuario", PageContext.SESSION_SCOPE);
		if (usuario != null) {
			// ESCRIBO EL NOMBRE DEL USUARIO CONECTADO
			salida.append("\n<tr><td align='center'><h3>" + usuario.getNombreUsuario() + "</td></tr></h3>\n");
		}
		// GESTION PARA TENER UNA UNICA HORA DE CONEXION
		Date hora_conexion = (Date) getJspContext().getAttribute("hora_conexion", PageContext.SESSION_SCOPE);
		// NO EXISTIRA SI ES LA PRIMERA VEZ DE LA SESION
		if (hora_conexion == null) {
			// SE CREA EL OBJETO Y SE GUARDA EN LA SESION PARA PROXIMAS PETICIONES
			hora_conexion = new Date();
			getJspContext().setAttribute("hora_conexion", hora_conexion, PageContext.SESSION_SCOPE);
		}
		// ****** TERCERA LINEA LINEA DE LA CABECERA DEL MENU - HORA CONEXION
		// HORA DEL MOMENTO
		salida.append("\n<tr><td align='center'>" + SimpleDateFormat.getTimeInstance().format(hora_conexion)
				+ "</td></tr>\n");
		// ESCRIBIMOS EN LA PAGINA HTML
		getJspContext().getOut().append(salida.toString());
	}

}
