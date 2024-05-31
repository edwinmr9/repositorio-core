package com.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Traza_Log implements ITraza_Log {
	//REGISTRO DE LA PROPIEDAD 
	private static Logger log = Logger.getLogger(Traza_Log.class);
	
	// AÑADIDO OBJETO RESOURCE BUNDLE PARA LA OPCION DE MENSAJES DE TRAZA
	// PERSONALIZABLES
	private static ResourceBundle rb;
	
	static {
		rb = ResourceBundle.getBundle("");
	}
	 
	public Traza_Log() {
		log = Logger.getLogger(Traza_Log.class);
//		registro("Creamos una herramienta de Trazas__log");
	}

	
	/**
	 * Proceso que sobrecarga el metodo añadiendo la posibilidad de uso de
	 * externalizacion de cadenas y uso de variables en tiempo de ejecucion.
	 * 
	 * @param clave   Clave del properties.
	 * @param nivel   Nivel con el que se va a mostrar el mensaje.
	 * @param valores Valores para las variables en los mensajes.
	 */
	@Override
	public void registro(String clave, int nivel, String valores[]) {
		if (rb == null) {
			rb = ResourceBundle.getBundle("com.log4j.textos_trazas"); //LE DECIMOS DONDE ESTA EL FICHERO 
		}
		String mensa = rb.getString(clave);			// AQUI SE RESUELVE EL FICHERO text_trazas.properties 
		if (valores != null && valores.length > 0) {
			// SE SUSTITUYE LAS VARIABLES DEL TEXTO, SI LAS HAY, POR SU VALOR
			mensa = MessageFormat.format(mensa, (Object[]) valores);
		}
		registro(mensa, nivel);
	}	
	
	/**
	 * Sobrecarga del metodo {@link #registro(String, int, String[])} para no tener
	 * que indicar el nivel siempre.<BR/>
	 * Por defecto se usa el nivel trace.
	 * 
	 * @param clave   Clave del properties.
	 * @param valores Valores para las variables en los mensajes.
	 */
	@Override
	public void registro(String clave, String valores[]) {
		if (rb == null) {
			rb = ResourceBundle.getBundle("com.log4j.textos_trazas");
		}
		String mensa = rb.getString(clave);
		if (valores != null && valores.length > 0) {
			// SE SUSTITUYE LAS VARIABLES DEL TEXTO, SI LAS HAY, POR SU VALOR
			mensa = MessageFormat.format(mensa, (Object[]) valores);
		}
		registro(mensa, LOG_TRACE);
	}
	
	
	@Override
	public void registro(String mensaje) {
		registro(mensaje, LOG_TRACE);
	}
	
	@Override
	public void registro(String mensaje, int nivel) {
		if (nivel == LOG_TRACE) {
//			mensaje = gestion_texto.capitalizar_texto(mensaje);
			if (log.isTraceEnabled()) {
				log.trace(mensaje);
			}
		}
		if (nivel == LOG_DEBUG) {
			if (log.isDebugEnabled()) {
				mensaje = mensaje.toLowerCase().trim();
				log.debug(mensaje);
			}
		}
		if (nivel == LOG_INFO) {
			if (log.isInfoEnabled()) {
				mensaje = mensaje.toUpperCase().trim();
				log.info(mensaje);
			}
		}
		if (nivel == LOG_WARNIG) {  
			if (log.isEnabledFor(Level.WARN)) {
//				mensaje = gestion_texto.fraseado_Texto(mensaje);
				log.warn(mensaje);
			}
		}
		if (nivel == LOG_ERROR) {
			if (log.isEnabledFor(Level.ERROR)) {
//				mensaje = gestion_texto.fraseado_Texto(mensaje);
				log.error(mensaje);
			}
		}
		if (nivel == LOG_FATAL) {
			if (log.isEnabledFor(Level.FATAL)) {
//				mensaje = gestion_texto.fraseado_Texto(mensaje);
				log.fatal(mensaje);
			}
		}

	}
	
}
