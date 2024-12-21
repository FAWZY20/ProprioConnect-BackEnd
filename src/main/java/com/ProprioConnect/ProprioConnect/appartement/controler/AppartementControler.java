package com.ProprioConnect.ProprioConnect.appartement.controler;

import com.ProprioConnect.ProprioConnect.appartement.model.Appartement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public interface AppartementControler {

    @PostMapping("/appartement")
    public ResponseEntity addAppart(@RequestBody Appartement appartement) throws Exception;

    @GetMapping("/appartement/{appartementId}")
    public ResponseEntity getAppart(@PathVariable("appartementId") Long appartementId) throws Exception;

    @GetMapping("/appartements/{proprioId}")
    public ResponseEntity getApparts(@PathVariable("proprioId") Long proprioId) throws Exception;

    @DeleteMapping("/appartement/{appartementId}")
    public ResponseEntity deleteAppart(@PathVariable("appartementId") Long appartementId) throws Exception;

}
