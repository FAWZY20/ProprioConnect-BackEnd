package com.ProprioConnect.ProprioConnect.appartement.service;

import com.ProprioConnect.ProprioConnect.appartement.controler.AppartementControler;
import com.ProprioConnect.ProprioConnect.appartement.model.Appartement;
import com.ProprioConnect.ProprioConnect.appartement.repository.AppartementRepository;
import com.ProprioConnect.ProprioConnect.proprietaire.model.Proprietaire;
import com.ProprioConnect.ProprioConnect.proprietaire.repository.ProprietaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppartementService implements AppartementControler {

    private final AppartementRepository appartementRepository;
    private final ProprietaireRepository proprietaireRepository;

    @Autowired
    public AppartementService(AppartementRepository appartementRepository, ProprietaireRepository proprietaireRepository) {
        this.appartementRepository = appartementRepository;
        this.proprietaireRepository = proprietaireRepository;
    }

    @Override
    public ResponseEntity addAppart(Appartement appartement) throws Exception {
        try {
            if (appartementRepository.findAppartById(appartement.getId()) == null){
                appartementRepository.save(appartement);
                return ResponseEntity.ok("l'appartement a bien etait ajouter");
            }else {
                return ResponseEntity.ok("l'appartement existe deja");
            }
        }catch (Exception e){
            throw new Exception("l'appartement n'a pas pu etre ajouter");
        }
    }

    @Override
    public ResponseEntity getAppart(Long appartementId) throws Exception {
        try {
            Appartement appartement = appartementRepository.findAppartById(appartementId);
            return ResponseEntity.ok(appartement);
        }catch (Exception e){
            throw new Exception("l'appartement n'a pas etait trouver ");
        }
    }

    @Override
    public ResponseEntity getApparts(Long proprioId) throws Exception {
        try{
            Proprietaire proprietaire = proprietaireRepository.findProprietaireById(proprioId);
            if (proprietaire !=null){
                List<Appartement> appartements = appartementRepository.findAppartByProprietaire(proprietaire);
                if (appartements != null){
                    return ResponseEntity.ok(appartements);
                }else {
                    return ResponseEntity.ok("le proprietaire n'a aucun appartement");
                }
            }else {
                return ResponseEntity.ok("le proprietaire n'existe pas");
            }
        }catch (Exception e){
            throw new Exception("une erreur ces produit lors de la recherchees appartement" + e);
        }
    }

    @Override
    public ResponseEntity deleteAppart(Long appartementId) throws Exception {
        try {
            appartementRepository.deleteById(appartementId);
            return ResponseEntity.ok("l'appartement a bien etait supprimer");
        }catch (Exception e){
            throw new Exception("l'appartement n'a pas etait trouver ");
        }
    }

}
