package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Proceso de establecimiento de idioma por defecto en la primera peticion de la
 * aplicacion.<BR/>
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 */
@WebFilter(description = "Deteccion de idioma de forma automatica", urlPatterns = { "/index.jsp" })
public class Filtro_Idioma implements Filter {
	// PROPIEDADES DE CLASE PARA SU FUNCIONAMIENTO
	private String idioma_defecto;

	/**
	 * Default constructor.
	 */
	public Filtro_Idioma() {
		System.out.println("CREACION DEL FILTRO DE IDIOMAS");
	}

	/**
	 * Establecemos el idioma por defecto. Se lee este valor del fichero de
	 * configuracion web.xml y se establece como opcion por defecto.
	 * 
	 * @param configuracion_filtro Acceso al fichero web.xml y los parametros de
	 *                             codiguracion que contiene.
	 * 
	 */
	public void init(FilterConfig configuracion_filtro) throws ServletException {
		// ESTABLECIMIENTO DE LA RUTA PARA EL RESOURCEBUNDLE CORRESPONDIENTE
		idioma_defecto = "com/idiomas/textos_"
				+ configuracion_filtro.getServletContext().getInitParameter("idioma_por_defecto");
	}

	/**
	 * Cargamos el idioma por defecto en base a la eleccion de idioma del navegador
	 * del cliente que hace la peticion. En caso de que no se tenga ese idioma se
	 * carga el idioma por defecto establecido en el metodo init.
	 * 
	 * @param peticion        Objeto que representa la peticion. En nuestro caso es
	 *                        un objeto HTTPSERVLETREQUEST.
	 * @param respuesta       Objeto que representa la peticion. En nuestro caso es
	 *                        un objeto HTTPSERVLETRESPONSE.
	 * @param cadena_peticion Objeto que nos permitira seguir la secuencia de la
	 *                        peticion una vez terminado el proceso.
	 */
	public void doFilter(ServletRequest peticion, ServletResponse respuesta, FilterChain cadena_peticion)
			throws IOException, ServletException {
		String idioma_elegido_peticion = idioma_defecto;
		// CASTEO AL TIPO REQUERIDO
		HttpServletRequest mi_request = null;
		if (peticion instanceof HttpServletRequest) {
			mi_request = (HttpServletRequest) peticion;
		}
		// SACAMOS DE LA PETICION EL IDIOMA PREFERIDO POR EL USUARIO
		String idioma_preferido = mi_request.getHeader("accept-language");
		// DIVIDIMOS EL TEXTO EN TANTOS IDIOMAS COMO NOS MANDEN EN LA PETICION
		String lista_idiomas[] = idioma_preferido.split(",");
		// ITERACION DEL CONTENIDO DE LA TABLA
		for (String idioma : lista_idiomas) {
			if (idioma.substring(0, 2).equals("es")) {
				// SELECCION DEL IDIOMA UNA VEZ ENCONTRADO
				idioma_elegido_peticion = "com/idiomas/textos_es";
				// SALIDA DEL BUCLE REPETITIVO
				break;
			}
			if (idioma.substring(0, 2).equals("en")) {
				idioma_elegido_peticion = "com/idiomas/textos_en";
				break;
			}
			if (idioma.substring(0, 2).equals("fr")) {
				idioma_elegido_peticion = "com/idiomas/textos_fr";
				break;
			}
		}
		// GUARDAMOS EN LA SESION EL IDIOMA PARA ESE USUARIO
		mi_request.getSession().setAttribute("idioma_elegido", idioma_elegido_peticion);
		// CONTINUA LA PETICION COMO CORRESPONDA
		cadena_peticion.doFilter(peticion, respuesta);
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("ELIMINACION DEL FILTRO DE IDIOMAS");
	}
}
