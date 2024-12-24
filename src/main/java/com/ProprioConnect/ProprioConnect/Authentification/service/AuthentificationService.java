package com.ProprioConnect.ProprioConnect.Authentification.service;


import com.ProprioConnect.ProprioConnect.configuration.JwtUtils;
import com.ProprioConnect.ProprioConnect.Authentification.controler.AuthentificationControler;
import com.ProprioConnect.ProprioConnect.locataire.model.Locataire;
import com.ProprioConnect.ProprioConnect.locataire.repository.LocataireRepository;
import com.ProprioConnect.ProprioConnect.proprietaire.model.Proprietaire;
import com.ProprioConnect.ProprioConnect.proprietaire.repository.ProprietaireRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService implements AuthentificationControler {

    private final PasswordEncoder passwordEncoder;

    private final LocataireRepository locataireRepository;

    private final ProprietaireRepository proprietaireRepository;

    private final JwtUtils jwtUtils;

    public AuthentificationService(PasswordEncoder passwordEncoder, LocataireRepository utilisateurRepository, LocataireRepository locataireRepository, ProprietaireRepository proprietaireRepository, JwtUtils jwtUtils) {
        this.passwordEncoder = passwordEncoder;
        this.locataireRepository = locataireRepository;
        this.proprietaireRepository = proprietaireRepository;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public ResponseEntity authentificate(String email, String mdp) {
        Locataire locataire = locataireRepository.findLocataireByEmail(email);
        Proprietaire proprietaire = proprietaireRepository.findByEmail(email);

        if (locataire != null){
            if (!passwordEncoder.matches(mdp, locataire.getMdp())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mot de passe incorrect");
            }
            String token = jwtUtils.generateToken(locataire.getEmail());
            return ResponseEntity.ok(token);
        }
        if(proprietaire != null){
            if (!passwordEncoder.matches(mdp, proprietaire.getMdp())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mot de passe incorrect");
            }
            String token = jwtUtils.generateToken(proprietaire.getEmail());
            return ResponseEntity.ok(token);
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mot de passe incorrect");
        }
    }
}
