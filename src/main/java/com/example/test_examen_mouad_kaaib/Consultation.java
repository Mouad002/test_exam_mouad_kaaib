package com.example.test_examen_mouad_kaaib;

import java.util.Date;

public class Consultation {
    private int idConsultation;
    private Date dateConsultation;
    private Medecin medecin;
    private Patient patient;

    // Constructor
    public Consultation(int idConsultation, Date dateConsultation, Medecin medecin, Patient patient) {
        this.idConsultation = idConsultation;
        this.dateConsultation = dateConsultation;
        this.medecin = medecin;
        this.patient = patient;
    }

    // Default constructor
    public Consultation() {}

    // Getters and Setters
    public int getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "idConsultation=" + idConsultation +
                ", dateConsultation=" + dateConsultation +
                ", medecin=" + medecin +
                ", patient=" + patient +
                '}';
    }
}
