package com.modelo;

import java.util.Date;

/**
 * DAO de acceso a la tabla de Usuarios.
 * 
 * @author jsolv
 * @since 26-4-2024.
 */
public class Usuario_DAO implements IUsuario_DAO {

	/**
	 * Proceso de consulta de la base de datos por la clave primaria de la tabla.
	 * 
	 * @param nombre_usuario
	 * @return
	 */
	@Override
	public Usuarios consultar_PorNombre(String nombre_usuario) {
		Usuarios usuario_consultado = null;
		// SIMULACION DEL RESULTADO DE LA CONSULTA
		if (nombre_usuario.equals("Juan")) {
			// INSTANCIAR EL OBJETO
			usuario_consultado = new Usuarios();
			// PASAMOS DATOS AL OBJETO
			usuario_consultado.setNombreUsuario("Juan");
			usuario_consultado.setPassword("admin");
			usuario_consultado.setFechaAlta(new Date());
			usuario_consultado.setRol("1");
			usuario_consultado.setIdioma("es");
		}
		// RETORNO DE LA INFORMACION OBTENIDA EN LA BASE DE DATOS
		return usuario_consultado;
	}
}
