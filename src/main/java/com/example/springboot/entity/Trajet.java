package com.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trajects")
public class Trajet {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	 
	 @Column(name = "nom")
     private String nom;
	 
	 @Column(name = "email")
     private String email;
	 
	 @Column(name = "phone")
     private String phone;
	 
	 @Column(name = "depart")
     private String depart;
	 
	 @Column(name = "destination")
     private String destination;
	 
	 @Column(name = "prix")
     private int prix;
     
    //Constructor without fields
	public Trajet() {
		 
	}

//Constructor with fields
	public Trajet(String nom, String email, String phone, String depart, String destination, int prix) {
		super();
		this.nom = nom;
		this.email = email;
		this.phone = phone;
		this.depart = depart;
		this.destination = destination;
		this.prix = prix;
	}
	
	
//Getters & setters
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
     
      

}
