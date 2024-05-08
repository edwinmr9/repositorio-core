package com.modelo;

public interface IUsuario_DAO {

	/**
	 * Proceso de consulta de la base de datos por la clave primaria de la tabla.
	 * 
	 * @param nombre_usuario
	 * @return
	 */
	Usuarios consultar_PorNombre(String nombre_usuario);

}