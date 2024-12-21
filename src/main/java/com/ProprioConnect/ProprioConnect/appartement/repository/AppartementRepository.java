package com.ProprioConnect.ProprioConnect.appartement.repository;

import com.ProprioConnect.ProprioConnect.appartement.model.Appartement;
import com.ProprioConnect.ProprioConnect.proprietaire.model.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppartementRepository extends JpaRepository<Appartement, Long> {
    Appartement findAppartById(Long appartID);

    List<Appartement> findAppartByProprietaire(Proprietaire proprietaire);
}
