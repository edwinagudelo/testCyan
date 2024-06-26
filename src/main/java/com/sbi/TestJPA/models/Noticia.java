package com.sbi.TestJPA.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Noticia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Lob
	@Column
	private String noticia;
	
	@ManyToOne
	@JoinColumn(name="idpeticion", referencedColumnName="id")
	private Peticion idpeticion;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNoticia() {
		return noticia;
	}
	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}
	public Peticion getIdpeticion() {
		return idpeticion;
	}
	public void setIdpeticion(Peticion idpeticion) {
		this.idpeticion = idpeticion;
	}
	
	public Noticia(Peticion peti, String strNoti) {
		idpeticion = peti;
		noticia = strNoti;
	}
}
