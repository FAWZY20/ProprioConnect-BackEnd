package com.ProprioConnect.ProprioConnect.appartement.model;

import com.ProprioConnect.ProprioConnect.locataire.model.Locataire;
import com.ProprioConnect.ProprioConnect.proprietaire.model.Proprietaire;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "appartement")
public class Appartement implements  Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appartSeq")
    @SequenceGenerator(name = "appartSeq", sequenceName = "appartSeq", allocationSize = 1)
    private Long id;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "codePostal")
    private String codePostal;

    @Column(name = "ville")
    private String ville;

    @Column(name = "surface")
    private Double surface;

    @Column(name = "nombrePieces")
    private Integer nombrePieces;

    @Column(name = "type")
    private String type;

    @Column(name = "etage")
    private Integer etage;

    @Column(name = "balcon")
    private Boolean balcon;

    @Column(name = "ascenseur")
    private Boolean ascenseur;
    @Column(name = "dateConstruction")
    private LocalDate dateConstruction;

    @Column(name = "loyer")
    private Double loyer;

    @Column(name = "description")
    private String description;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "proprietaire_id", nullable = false)
    private Proprietaire proprietaire;
    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locataire_id", referencedColumnName = "id")
    private Locataire locataire;

    public Appartement(String adresse,
                       String codePostal,
                       String ville,
                       Double surface,
                       Integer nombrePieces,
                       String type,
                       Integer etage,
                       Boolean balcon,
                       Boolean ascenseur,
                       LocalDate dateConstruction,
                       Double loyer,
                       String description,
                       Proprietaire proprietaire,
                       Locataire locataire) {
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.surface = surface;
        this.nombrePieces = nombrePieces;
        this.type = type;
        this.etage = etage;
        this.balcon = balcon;
        this.ascenseur = ascenseur;
        this.dateConstruction = dateConstruction;
        this.loyer = loyer;
        this.description = description;
        this.proprietaire = proprietaire;
        this.locataire = locataire;
    }

    public Appartement(){}

    public Long getId() {
        return id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Double getSurface() {
        return surface;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public Integer getNombrePieces() {
        return nombrePieces;
    }

    public void setNombrePieces(Integer nombrePieces) {
        this.nombrePieces = nombrePieces;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEtage() {
        return etage;
    }

    public void setEtage(Integer etage) {
        this.etage = etage;
    }

    public Boolean getBalcon() {
        return balcon;
    }

    public void setBalcon(Boolean balcon) {
        this.balcon = balcon;
    }

    public Boolean getAscenseur() {
        return ascenseur;
    }

    public void setAscenseur(Boolean ascenseur) {
        this.ascenseur = ascenseur;
    }

    public LocalDate getDateConstruction() {
        return dateConstruction;
    }

    public void setDateConstruction(LocalDate dateConstruction) {
        this.dateConstruction = dateConstruction;
    }

    public Double getLoyer() {
        return loyer;
    }

    public void setLoyer(Double loyer) {
        this.loyer = loyer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }
}
