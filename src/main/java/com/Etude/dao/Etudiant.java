package com.Etude.dao;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Etudiant implements Serializable{
	@Id
	@GeneratedValue
	
	private Long code;
	private String name;
	private String adresse;
	private Float Moyenne;

	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Float getMoyenne() {
		return Moyenne;
	}
	public void setMoyenne(Float moyenne) {
		Moyenne = moyenne;
	}
	public Etudiant(Long code, String name, String adresse, Float Moyenne) {
		super();
		this.code = code;
		this.name = name;
		this.adresse = adresse;
		this.Moyenne = Moyenne;
	}
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

