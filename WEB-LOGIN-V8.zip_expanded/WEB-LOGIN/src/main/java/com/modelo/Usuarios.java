package com.modelo;

import java.util.Date;

/**
 * DTO Para la tabla de usuarios. Usado en el proceso de autenticacion (login).
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.0
 * @since 26-4-2024
 *
 */
public class Usuarios {
	// PROPIEDADES DE CLASE.
	private String nombreUsuario;
	private String carpetaDocumentacion;
	private Date fechaAlta;
	private Date fechaBaja;
	private String idioma;
	private String password;
	private String rol;

	// METODOS ACCESORES DE LA PROPIEDADES DE CLASE
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCarpetaDocumentacion() {
		return carpetaDocumentacion;
	}

	public void setCarpetaDocumentacion(String carpetaDocumentacion) {
		this.carpetaDocumentacion = carpetaDocumentacion;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
