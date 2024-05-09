package com.modelo;

public class Prueba {

	public static void main(String[] args) {
		Usuarios usuario_nuevo = new Usuarios();
		usuario_nuevo.setNombreUsuario("Juan");
		String nombre = usuario_nuevo.getNombreUsuario();
		nombre = "Pepe";
	}

}
