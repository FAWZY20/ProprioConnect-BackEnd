package com.ProprioConnect.ProprioConnect.locataire.model;

import com.ProprioConnect.ProprioConnect.appartement.model.Appartement;
import com.ProprioConnect.ProprioConnect.proprietaire.model.Proprietaire;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "locataire")
public class Locataire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locataireSeq")
    @SequenceGenerator(name = "locataireSeq", sequenceName = "locataireSeq", allocationSize = 1)
    private Long id;

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "mdp")
    private String mdp;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "date_naissance")
    private LocalDate date_naissance;
    @Column(name = "date_inscription")
    private LocalDate date_inscription =  LocalDate.now();

    @JsonBackReference("proprietaire-locataires")
    @ManyToOne
    @JoinColumn(name = "proprietaire_id")
    private Proprietaire proprietaire;

    @JsonManagedReference("locataire-appartements")
    @OneToOne(mappedBy = "locataire", cascade = CascadeType.ALL, orphanRemoval = true)
    private Appartement appartement;

    @Column(name = "contrat")
    private File contrat;

    public Locataire(String nom,
                     String prenom,
                     String mdp,
                     String email,
                     String telephone,
                     LocalDate date_naissance,
                     LocalDate date_inscription,
                     Proprietaire proprietaire,
                     Appartement appartement,
                     File contrat) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.email = email;
        this.telephone = telephone;
        this.date_naissance = date_naissance;
        this.date_inscription = date_inscription;
        this.proprietaire = proprietaire;
        this.appartement = appartement;
        this.contrat = contrat;
    }

    public Locataire(){}

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

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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

    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }

    public LocalDate getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(LocalDate date_inscription) {
        this.date_inscription = date_inscription;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Appartement getAppartement() {
        return appartement;
    }

    public void setAppartement(Appartement appartement) {
        this.appartement = appartement;
    }

    public File getContrat() {
        return contrat;
    }

    public void setContrat(File contrat) {
        this.contrat = contrat;
    }
}
