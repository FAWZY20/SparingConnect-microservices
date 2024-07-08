package com.example.gestionUtilisateur.repository;

import com.example.gestionUtilisateur.model.Utilisateur;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findUtilisateurById(long id);

    Utilisateur findUtilisateurByMail(String mail);

    Utilisateur findUtilisateurByMailAndPassword(String mail, String password);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM utilisateur USING profil WHERE utilisateur.id = profil.userid AND utilisateur.id = :userId", nativeQuery = true)
    void deleteUserAndProfilById(@Param("userId") long userId);

}
