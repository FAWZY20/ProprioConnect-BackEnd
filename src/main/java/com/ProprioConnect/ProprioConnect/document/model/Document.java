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

    @Column(nullable = false)
    private String auteur;

    @Column(nullable = false)
    private String sujet;

    @Column(name = "datecreation")
    private LocalDate datecreation =  LocalDate.now();

    @Column(name = "contenu", nullable = false)
    private byte[] contenu;

    @Column(name = "nom_fichier", nullable = false)
    private String nomFichier;


    public Document(String auteur, String sujet, byte[] contenu, String nomFichier) {
        this.auteur = auteur;
        this.sujet = sujet;
        this.contenu = contenu;
        this.nomFichier = nomFichier;
    }
    public Document(){}

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
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
