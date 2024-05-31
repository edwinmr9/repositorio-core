package com.modelo;

public interface IUsuario_Fachada {

	/**
	 * Proceso de llamada al metodo de consulta de un usuario por el nombre.
	 * 
	 * @param nombre_usuario Nombre del usuario a buscar.
	 * @return Informacion encontrada en la base de datos de un usuario concreto.
	 */
	Usuarios consultar_PorNombre(String nombre_usuario);

}