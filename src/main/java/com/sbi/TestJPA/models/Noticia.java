package com.sbi.TestJPA.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

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
