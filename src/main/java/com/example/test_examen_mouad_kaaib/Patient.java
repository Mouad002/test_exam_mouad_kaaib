package com.example.test_examen_mouad_kaaib;

import java.util.Date;

public class Patient {
    private int idPatient;
    private String nom;
    private String prenom;
    private String cin;
    private String email;
    private String telephone;
    private Date dateNaissance;

    // Constructor
    public Patient(int idPatient, String nom, String prenom, String cin, String email, String telephone, Date dateNaissance) {
        this.idPatient = idPatient;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email = email;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
    }

    // Default constructor
    public Patient() {}

    // Getters and Setters
    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    // toString method for displaying patient details
    @Override
    public String toString() {
        return "Patient{" +
                "idPatient=" + idPatient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", dateNaissance=" + dateNaissance +
                '}';
    }
}
