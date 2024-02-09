package com.sbi.TestJPA.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Analisis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idpeticion", referencedColumnName="id")
	private Peticion idpeticion;
	
	private String palabra;
	private Integer contador;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Peticion getIdpeticion() {
		return idpeticion;
	}
	public void setIdpeticion(Peticion idpeticion) {
		this.idpeticion = idpeticion;
	}
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	public Integer getContador() {
		return contador;
	}
	public void setContador(Integer contador) {
		this.contador = contador;
	}
	
	public Analisis(Peticion peti, String strPalabra) {
		idpeticion = peti;
		palabra = strPalabra;
		contador = 0;
	}
	
	public Analisis() {}
	
	public void incrementar() {
		contador++;
	}

}
