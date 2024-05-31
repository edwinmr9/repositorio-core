package com.util;

public interface ITraza_Log extends INiveles_Log{

	void registro(String mensaje, int nivel);

	void registro(String mensaje);

	/**
	 * Sobrecarga del metodo {@link #registro(String, int, String[])} para no tener
	 * que indicar el nivel siempre.<BR/>
	 * Por defecto se usa el nivel trace.
	 * 
	 * @param clave   Clave del properties.
	 * @param valores Valores para las variables en los mensajes.
	 */
	void registro(String clave, String valores[]);

	/**
	 * Proceso que sobrecarga el metodo añadiendo la posibilidad de uso de
	 * externalizacion de cadenas y uso de variables en tiempo de ejecucion.
	 * 
	 * @param clave   Clave del properties.
	 * @param nivel   Nivel con el que se va a mostrar el mensaje.
	 * @param valores Valores para las variables en los mensajes.
	 */
	void registro(String clave, int nivel, String valores[]);



}