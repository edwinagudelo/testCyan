package com.sbi.TestJPA.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class Peticion {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Integer id;
	private String url;
	private Integer numNoticia;
	private String result;
	
	@OneToMany(mappedBy = "idpeticion")
	private Set<Noticia> noticias;
	
	@OneToMany(mappedBy = "idpeticion")
	private Set<Analisis> palabras;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getNumNoticia() {
		return numNoticia;
	}
	public void setNumNoticia(Integer numNoticia) {
		this.numNoticia = numNoticia;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Set<Noticia> getNoticias() {
		return noticias;
	}
	public void setNoticias(Set<Noticia> noticias) {
		this.noticias = noticias;
	}
	
	public Peticion(String strUrl) {
		url = strUrl;
		numNoticia = 0;
		result = "";
	}
	
	public Peticion() {}
}
