package com.example.gestionUtilisateur.repository;

import com.example.gestionUtilisateur.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findUtilisateurById(long id);
}
