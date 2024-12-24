package com.ProprioConnect.ProprioConnect.Authentification.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public interface AuthentificationControler {

    @PostMapping("/login")
    public ResponseEntity authentificate(@RequestParam("email") String email,
                                           @RequestParam("mdp") String mdp);


}
