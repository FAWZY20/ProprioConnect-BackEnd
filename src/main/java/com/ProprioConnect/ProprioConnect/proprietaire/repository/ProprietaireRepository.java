package com.ProprioConnect.ProprioConnect.proprietaire.repository;

import com.ProprioConnect.ProprioConnect.proprietaire.model.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietaireRepository extends JpaRepository<Proprietaire, Long> {

    Proprietaire findProprietaireById(Long propId);

    Proprietaire findByEmail(String email);
}
