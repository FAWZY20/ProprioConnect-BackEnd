package com.ProprioConnect.ProprioConnect.proprietaire.service;

import com.ProprioConnect.ProprioConnect.proprietaire.controler.ProprietaireControler;
import com.ProprioConnect.ProprioConnect.proprietaire.model.Proprietaire;
import com.ProprioConnect.ProprioConnect.proprietaire.repository.ProprietaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProprietaireService implements ProprietaireControler {

    private final ProprietaireRepository proprietaireRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ProprietaireService(ProprietaireRepository proprietaireRepository, PasswordEncoder passwordEncoder) {
        this.proprietaireRepository = proprietaireRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity addProprietaire(Proprietaire proprietaire) throws Exception {
        try {
            if (proprietaireRepository.findByEmail(proprietaire.getEmail()) == null){
                proprietaire.setMdp(passwordEncoder.encode(proprietaire.getMdp()));
                proprietaireRepository.save(proprietaire);
                return ResponseEntity.ok("l'utilisateur a bien etait ajouter");
            } else {
                return ResponseEntity.ok("l'utilisateur existe deja");
            }
        }catch (Exception e){
            throw new Exception("l'utilisateur n'a pas pu etre ajouter");
        }
    }

    @Override
    public ResponseEntity getProprietaire(Long propId) throws Exception {
        try {
            Proprietaire proprietaire = proprietaireRepository.findProprietaireById(propId);
            return ResponseEntity.ok(proprietaire);
        }catch (Exception e){
            throw new Exception("Aucun utilisateur trouver");
        }
    }

    @Override
    public ResponseEntity deleteProprietaire(Long propId) throws Exception {
        try {
            proprietaireRepository.deleteById(propId);
            return ResponseEntity.ok("l'utilisateur et bien supprimer");
        }catch (Exception e){
            throw new Exception("l'utilisateur n'a pas pu etre supprimer");
        }
    }
}
