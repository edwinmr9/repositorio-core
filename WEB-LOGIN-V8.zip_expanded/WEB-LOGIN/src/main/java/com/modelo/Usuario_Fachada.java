package com.modelo;

/**
 * Fachada de acceso a los procesos de la tabla Usuarios.
 * 
 * @author jsolv
 *
 */
public class Usuario_Fachada implements IUsuario_Fachada {
	/**
	 * Propiedad para definir el DAO de acceso a los datos
	 */
	private IUsuario_DAO usuario_dao;

	/**
	 * Contructor de la fachada para USUARIOS en la capa modelo
	 */
	public Usuario_Fachada() {
		// CREACION DEL DAO PARA SU USO EN LOS METODOS DE LA FACHADA
		usuario_dao = new Usuario_DAO();
	}

	/**
	 * Proceso de llamada al metodo de consulta de un usuario por el nombre.
	 * 
	 * @param nombre_usuario Nombre del usuario a buscar.
	 * @return Informacion encontrada en la base de datos de un usuario concreto.
	 */
	@Override
	public Usuarios consultar_PorNombre(String nombre_usuario) {
		// LLAMADA A LA OPERACION DEL DAO
		Usuarios usuario_consultado = usuario_dao.consultar_PorNombre(nombre_usuario);
		// RETORNO DEL RESULTADO DE LA CONSULTA DEL DAO
		return usuario_consultado;
	}
}
