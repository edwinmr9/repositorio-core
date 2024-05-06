package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.IUsuario_Fachada;
import com.modelo.Usuario_Fachada;
import com.modelo.Usuarios;

/**
 * Servlet implementation class Servlet_Login
 */
@WebServlet(description = "Operacion de comprobacion de credenciales", urlPatterns = { "/Servlet_Login" })
public class Servlet_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Login() {
		System.out.println("soy el constructor del servlet");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("SOY EL METODO INIT");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("SOY EL METODO DESTROY");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
			throws ServletException, IOException {
		// PROPIEDADES LOCALES DEL METODO
		boolean valido = true;
		String salida = "jsp/login.jsp";
		String error_nombre = null;
		String error_clave = null;
		// 1� CAPTURA DE PARAMETROS DE LA PETICION
		String nombre_usuario = peticion.getParameter("nombre_usuario");
		String clave_usuario = peticion.getParameter("clave_usuario");
		// 2� CONVERSION - NINGUNA NO ES NECESARIO
		// 3� VALIDACION
		if (valido) {
			if (nombre_usuario.isEmpty()) {
				// GESTION DE ERROR
				// ERROR DE NOMBRE VACIO
				valido = false;
				error_nombre = "EL NOMBRE ES OBLIGATORIO";
			}
			if (clave_usuario.equals("")) {
				// GESTION DE ERROR
				// ERROR DE CLAVE VACIA
				valido = false;
				error_clave = "LA CLAVE ES NECESARIA";
			} else if (clave_usuario.length() < 5) {
				// ERROR DE TAMAёO DE CARACTERES EN LA CLAVE
				valido = false;
				error_clave = "LA CLAVE DEBE DE SER MAYOR A 4 CARACTERES";
			}
		}
		// 4� LOGICA
		if (valido) {
			// ACCESO A LA CAPA MODELO PARA LA COMPROBACION DE CREDENCIALES
			IUsuario_Fachada usuario_fachada = new Usuario_Fachada();
			Usuarios usuario_consultado = usuario_fachada.consultar_PorNombre(nombre_usuario);
			// LOGICA DE COMPROBACION DE LAS CREDENCIALES
			if (usuario_consultado != null) {
				// NOMBRE DE USUARIO CORRECTO
				if (usuario_consultado.getPassword().equals(clave_usuario)) {
					System.out.println("DATOS VALIDOS");
					salida = "jsp/menu.jsp";
				} else {
					// CLAVE NO VALIDA PARA ESE USUARIO
					// ERROR DE CLAVE
//					System.out.println("CLAVE ERRONEA");
					error_clave = "LA CLAVE DADA NO PERTENECE AL USUARIO";
				}
			} else {
				// NOMBRE DE USUARIO INCORRECTO
				// ERROR DE NOMBRE
//				System.out.println("NO EXISTE NINGUN USUARIO CON ESE NOMBRE");
				error_nombre = "NO HAY NINGUN USUARIO REGISTRADO CON ESE NOMBRE";
			}
		}
		// LA POSIBLE INFORMACION ACERCA DE LOS ERRORES SE PASAN COMO ATRIBUTOS DE
		// PETICION A LA PAGINA JSP
		if (error_nombre != null || error_clave != null) {
			// INSERCION DE LOS MENSAJES DE ERROR EN EL MAPA DE ATRIBUTOS
			peticion.setAttribute("error_nombre", error_nombre);
			peticion.setAttribute("error_clave", error_clave);
		}

		// 5� NAVEGACION
		RequestDispatcher navegacion = peticion.getRequestDispatcher(salida);
		navegacion.forward(peticion, respuesta);
	}
}
