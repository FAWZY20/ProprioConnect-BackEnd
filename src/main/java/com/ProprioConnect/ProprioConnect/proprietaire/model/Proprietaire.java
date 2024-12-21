package com.ProprioConnect.ProprioConnect.proprietaire.model;


import com.ProprioConnect.ProprioConnect.appartement.model.Appartement;
import com.ProprioConnect.ProprioConnect.locataire.model.Locataire;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "proprietaire")
public class Proprietaire {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proprietaireSeq")
    @SequenceGenerator(name = "proprietaireSeq", sequenceName = "proprietaireSeq", allocationSize = 1)
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
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "date_inscription")
    private Date date_inscription = new Date();
    @JsonManagedReference
    @OneToMany(mappedBy = "proprietaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Locataire> locataires;

    @JsonManagedReference
    @OneToMany(mappedBy = "proprietaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appartement> appartements;

    public Proprietaire(String nom,
                        String prenom,
                        String mdp,
                        String email,
                        String telephone,
                        String adresse,
                        Date date_inscription,
                        List<Locataire> locataires,
                        List<Appartement> appartements) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.date_inscription = date_inscription;
        this.locataires = locataires;
        this.appartements = appartements;
    }

    public Proprietaire(){}

    public Long getId() {
        return id;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(Date date_inscription) {
        this.date_inscription = date_inscription;
    }

    public List<Locataire> getLocataires() {
        return locataires;
    }

    public void setLocataires(List<Locataire> locataires) {
        this.locataires = locataires;
    }

}
