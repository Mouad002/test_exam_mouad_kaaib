package com.example.test_examen_mouad_kaaib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ICabinetMetierImp implements ICabinetMetier{
    private final Connection con = SingletonConnexionDB.getConnection();
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public List<Patient> afficherPatients() {
        List<Patient> patients = new ArrayList<>();
        try {
            ps = con.prepareStatement("select * from patient");
            rs = ps.executeQuery();
            while(rs.next()) {
                patients.add(new Patient(rs.getInt("id_patient"), rs.getString("nom"), rs.getString("prenom"), rs.getString("cin"), rs.getString("email"), rs.getString("telephone"),  new Date(rs.getDate("date_naissance").getTime())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public Patient rechercherPatientsParMotCle(String motCle) {
        try {
            ps = con.prepareStatement("select * from patient where nom like ? or prenom like ?");
            ps.setString(1, motCle + "%");
            ps.setString(2, motCle + "%");
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Patient(rs.getInt("id_patient"), rs.getString("nom"), rs.getString("prenom"), rs.getString("cin"), rs.getString("email"), rs.getString("telephone"), rs.getDate("date_naissance"));
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void ajouterUnPatient(Patient patient) {
        try {
            ps = con.prepareStatement("INSERT INTO Patient (nom, prenom, cin, email, telephone, date_naissance) VALUES (?, ?, ?, ?, ?, ?);");

            ps.setString(1, patient.getNom());
            ps.setString(2, patient.getPrenom());
            ps.setString(3, patient.getCin());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getTelephone());
            ps.setDate(6, new java.sql.Date(patient.getDateNaissance().getTime()));

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerUnPatient(int id_patient) {
        try {
            ps = con.prepareStatement("DELETE FROM Patient WHERE id_patient = ?");
            ps.setInt(1, id_patient);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("can't deleted it because it has a foreign key reference");
        }
    }

    @Override
    public List<Consultation> afficherConsultationsDunPatient(int id_patient) {
        List<Consultation> consultations = new ArrayList<>();
        Medecin medecin;
        Patient patient;
        try {
            ps = con.prepareStatement("SELECT * from consultation where patient = ?");
            ps.setInt(1, id_patient);
            rs = ps.executeQuery();
            while(rs.next()) {
                medecin = new Medecin();
                patient = new Patient();
                medecin.setIdMedecin(rs.getInt("medecin"));
                patient.setIdPatient(rs.getInt("patient"));
                consultations.add(new Consultation(rs.getInt("id_consultation"), new Date(rs.getDate("date_consultation").getTime()),medecin, patient));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consultations;
    }

    @Override
    public void ajoutermedecin(Medecin medecin) {
        try {
            ps = con.prepareStatement("INSERT INTO medecin (nom, prenom, tel, email) VALUES (?, ?, ?, ?)");

            ps.setString(1, medecin.getNom());
            ps.setString(2, medecin.getPrenom());
            ps.setString(3, medecin.getTel());
            ps.setString(4, medecin.getEmail());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Medecin> afficherMedecins() {
        List<Medecin> medecines = new ArrayList<>();
        try {
            ps = con.prepareStatement("select * from medecin");
            rs = ps.executeQuery();
            while(rs.next()) {
                medecines.add(new Medecin(rs.getInt("id_medecin"), rs.getString("nom"), rs.getString("prenom") , rs.getString("email"), rs.getString("tel")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medecines;
    }

    @Override
    public void supprimerMedecin(int id_medecin) {
        try {
            ps = con.prepareStatement("DELETE FROM medecin WHERE id_medecin = ?");
            ps.setInt(1, id_medecin);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("can't deleted it because it has a foreign key reference");
        }
    }

    @Override
    public List<Consultation> afficherConsultationParMedecin(int id_medecin) {
        List<Consultation> consultations = new ArrayList<>();
        Medecin medecin;
        Patient patient;
        try {
            ps = con.prepareStatement("SELECT * from consultation where medecin = ?");
            ps.setInt(1, id_medecin);
            rs = ps.executeQuery();
            while(rs.next()) {
                medecin = new Medecin();
                patient = new Patient();
                medecin.setIdMedecin(rs.getInt("medecin"));
                patient.setIdPatient(rs.getInt("patient"));
                consultations.add(new Consultation(rs.getInt("id_consultation"), new Date(rs.getDate("date_consultation").getTime()),medecin, patient));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consultations;
    }

    @Override
    public void ajouterConsultation(Consultation consultation) {
        try {
            ps = con.prepareStatement("INSERT INTO consultation (date_consultation, medecin, patient) VALUES (?, ?, ?)");

            ps.setDate(1, new java.sql.Date(consultation.getDateConsultation().getTime())); // Convert Date to SQL Date
            ps.setInt(2, consultation.getMedecin().getIdMedecin()); // Assuming Medecin has an ID
            ps.setInt(3, consultation.getPatient().getIdPatient()); // Assuming Patient has an ID

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Consultation> afficherConsultation() {
        List<Consultation> consultations = new ArrayList<>();
        Medecin medecin;
        Patient patient;
        try {
            ps = con.prepareStatement("select * from consultation");
            rs = ps.executeQuery();
            while(rs.next()) {
                medecin = new Medecin();
                medecin.setIdMedecin(rs.getInt("medecin"));
                patient = new Patient();
                patient.setIdPatient(rs.getInt("patient"));
                consultations.add(new Consultation(rs.getInt("id_consultation"), new Date(rs.getDate("date_consultation").getTime()),medecin, patient));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consultations;
    }

    @Override
    public void supprimerConsultation(int id_consultation) {
        try {
            ps = con.prepareStatement("DELETE FROM consultation WHERE id_consultation = ?");
            ps.setInt(1, id_consultation);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("can't deleted it because it has a foreign key reference");
        }
    }

    public static void main(String[] args) {
        ICabinetMetierImp helper = new ICabinetMetierImp();

        System.out.println("list des patients");
        System.out.println(helper.afficherPatients());

        System.out.println("rechercher patient par mot cle : ");
        System.out.println(helper.rechercherPatientsParMotCle("j"));

        System.out.println("ajouter nouveau patient : ");
        Patient patient1 = new Patient(1, "Doe", "John", "CIN123456", "johndoe@example.com", "123456789", new Date(90, 0, 1));
        helper.ajouterUnPatient(patient1);

        System.out.println("supprimer un patient : ");
        helper.supprimerUnPatient(1);

        System.out.println("afficher les consultation d'un patient");
        System.out.println(helper.afficherConsultationsDunPatient(1));

        System.out.println("ajouter un medecin : ");
        Medecin medecin1 = new Medecin(1, "White", "Alice", "alicewhite@example.com", "111111111");
        helper.ajoutermedecin(medecin1);

        System.out.println("afficher la liste des medecines : ");
        System.out.println(helper.afficherMedecins());

        System.out.println("supprimer un medecin : ");
        helper.supprimerMedecin(1);

        System.out.println("la liste des consultation donnees par un medecin : ");
        System.out.println(helper.afficherConsultationParMedecin(1));

        System.out.println("ajouter une consultation");
        Medecin nMedecin = new Medecin();
        nMedecin.setIdMedecin(1);
        Patient nPatient = new Patient();
        nPatient.setIdPatient(1);
        Consultation consultation = new Consultation(0, new Date(System.currentTimeMillis()), nMedecin, nPatient);
        helper.ajouterConsultation(consultation);

        System.out.println("afficher la liste des consultations : ");
        System.out.println(helper.afficherConsultation());

        System.out.println("supprimer une consultation");
        helper.supprimerConsultation(1);
    }

}
