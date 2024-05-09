package com.eventos;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Seguimiento_Sesion
 *
 */
@WebListener
public class Seguimiento_Sesion implements HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public Seguimiento_Sesion() {
		System.out.println("CREACION DEL TRATAMIENTO DEL EVENTO DE CICLO DE VIDA de SESION");
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent evento) {
		System.out.println("CREADA SESION ID .... "+     evento.getSession().getId());
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent evento) {
		System.out.println("DESTRUIDA SESION ID .... "+     evento.getSession().getId());
	}

}
