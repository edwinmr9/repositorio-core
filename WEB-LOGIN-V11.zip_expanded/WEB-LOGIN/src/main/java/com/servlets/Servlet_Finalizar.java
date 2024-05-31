package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.Usuarios;

/**
 * Servlet implementation class Servlet_Finalizar Cierre se sesion de usuario al
 * terminar su proceso con el programa.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 */
@WebServlet(description = "Proceso de cierre de sesion del usuario", urlPatterns = { "/Servlet_Finalizar" })
public class Servlet_Finalizar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Proceso de cierre de la aplicacion.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
			throws ServletException, IOException {
		// RESERVADO PARA CUALQUIER PROCESO DE FINALIZACION O CIERRE

		// CREACION DE MENSAJE PERSONALIZADO DE DESPEDIDA
		Usuarios usuario_sesion = ((Usuarios) peticion.getSession().getAttribute("usuario"));
		String despedida = "Hasta la proxima ";
		if (usuario_sesion != null) {
			despedida = despedida + usuario_sesion.getNombreUsuario();
		}
		peticion.setAttribute("despedida", despedida);
		// FINALIZAMOS LA SESION DEL USUARIO
		peticion.getSession().setMaxInactiveInterval(5);

		// NAVEGACION A LA PAGINA DE SALIDA
		RequestDispatcher salida = peticion.getRequestDispatcher("jsp/salida.jsp");
		salida.forward(peticion, respuesta);
	}

}
