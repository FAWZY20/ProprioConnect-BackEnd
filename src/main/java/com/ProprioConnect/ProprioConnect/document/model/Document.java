package com.ProprioConnect.ProprioConnect.document.model;


import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.io.File;
import java.time.LocalDate;

@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "auteur", nullable = false)
    private Long auteur;

    @Column(name = "destinataire", nullable = false)
    private Long destinataire;

    @Column(name = "sujet", nullable = false)
    private String sujet;

    @Column(name = "datecreation", nullable = false)
    private LocalDate datecreation =  LocalDate.now();

    @Column(name = "contenu", nullable = false)
    private byte[] contenu;

    @Column(name = "nom_fichier", nullable = false)
    private String nomFichier;


    public Document(Long auteur, Long destinataire, String sujet, LocalDate datecreation, byte[] contenu, String nomFichier) {
        this.auteur = auteur;
        this.destinataire = destinataire;
        this.sujet = sujet;
        this.datecreation = datecreation;
        this.contenu = contenu;
        this.nomFichier = nomFichier;
    }

    public Document(){}

    public Long getAuteur() {
        return auteur;
    }

    public void setAuteur(Long auteur) {
        this.auteur = auteur;
    }

    public Long getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Long destinataire) {
        this.destinataire = destinataire;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public LocalDate getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(LocalDate datecreation) {
        this.datecreation = datecreation;
    }

    public byte[] getContenu() {
        return contenu;
    }

    public void setContenu(byte[] contenu) {
        this.contenu = contenu;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }
}
