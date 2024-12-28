package com.ProprioConnect.ProprioConnect.Authentification.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public interface AuthentificationControler {

    @PostMapping("/login/proprietaire")
    public ResponseEntity authentificateProprietaire(@RequestParam("email") String email,
                                           @RequestParam("mdp") String mdp);

    @PostMapping("/login/locataire")
    public ResponseEntity authentificateLocataire(@RequestParam("email") String email,
                                                     @RequestParam("mdp") String mdp);

}
