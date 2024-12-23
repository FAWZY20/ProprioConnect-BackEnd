package com.ProprioConnect.ProprioConnect.locataire.service;

import com.ProprioConnect.ProprioConnect.appartement.repository.AppartementRepository;
import com.ProprioConnect.ProprioConnect.locataire.controler.LocataireControler;
import com.ProprioConnect.ProprioConnect.locataire.model.Locataire;
import com.ProprioConnect.ProprioConnect.locataire.repository.LocataireRepository;
import com.ProprioConnect.ProprioConnect.proprietaire.model.Proprietaire;
import com.ProprioConnect.ProprioConnect.proprietaire.repository.ProprietaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LocataireService implements LocataireControler {

    private final LocataireRepository locataireRepository;

    private final ProprietaireRepository proprietaireRepository;

    private final AppartementRepository appartementRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LocataireService(LocataireRepository locataireRepository, ProprietaireRepository proprietaireRepository, AppartementRepository appartementRepository, PasswordEncoder passwordEncoder) {
        this.locataireRepository = locataireRepository;
        this.proprietaireRepository = proprietaireRepository;
        this.appartementRepository = appartementRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity addlocataire(Locataire locataire) throws Exception {
        try {
            if (locataireRepository.findLocataireByEmail(locataire.getEmail()) == null){
                Proprietaire proprietaire = proprietaireRepository.findProprietaireById(locataire.getProprietaire().getId());

                locataire.setMdp(passwordEncoder.encode(locataire.getMdp()));
                locataire.setProprietaire(proprietaire);
                locataireRepository.save(locataire);

                return ResponseEntity.ok("le locataire a bien etait ajouter");
            }else {
                return ResponseEntity.ok("le locataire existe deja");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("le Locataire n'a pas pu etre ajouter");

        }
    }

    @Override
    public ResponseEntity getlocataire(Long locataireId) throws Exception {
       try {
           Locataire locataire = locataireRepository.findLocataireById(locataireId);
           return ResponseEntity.ok(locataire);
       }catch (Exception e){
           throw new Exception("le locataire n'a pas etait trouver ");
       }
    }

    @Override
    public ResponseEntity deletelocataire(Long locataireId) throws Exception {
        try {
            locataireRepository.deleteById(locataireId);
            return ResponseEntity.ok("le locataire a bien etait supprimer");
        }catch (Exception e){
            throw new Exception("le locataire n'a pas etait trouver ");
        }
    }
}
