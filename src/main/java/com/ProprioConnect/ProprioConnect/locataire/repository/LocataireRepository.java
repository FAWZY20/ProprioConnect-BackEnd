package com.ProprioConnect.ProprioConnect.locataire.repository;


import com.ProprioConnect.ProprioConnect.locataire.model.Locataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocataireRepository extends JpaRepository<Locataire, Long> {
    Locataire findLocataireByEmail(String email);

    Locataire findLocataireById(Long locataireId);
}
