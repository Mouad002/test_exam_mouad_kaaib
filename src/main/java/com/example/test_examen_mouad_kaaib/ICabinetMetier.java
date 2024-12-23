package com.example.test_examen_mouad_kaaib;

import java.util.List;

public interface ICabinetMetier {
    // 1. Gérer les patients du cabinet :
    public List<Patient> afficherPatients();
    public Patient rechercherPatientsParMotCle(String motCle);
    public void ajouterUnPatient(Patient p);
    public void supprimerUnPatient(int id_patient);
    public List<Consultation> afficherConsultationsDunPatient(int id_patient);
    // 2. Gérer les médecins :
    public void ajoutermedecin(Medecin medecin);
    public List<Medecin> afficherMedecins();
    public void supprimerMedecin(int id_medecin);
    public List<Consultation> afficherConsultationParMedecin(int id_medecin);
    // 3. Gérer les consultations :
    public void ajouterConsultation(Consultation c);
    public List<Consultation> afficherConsultation();
    public void supprimerConsultation(int id_consultation);
}
