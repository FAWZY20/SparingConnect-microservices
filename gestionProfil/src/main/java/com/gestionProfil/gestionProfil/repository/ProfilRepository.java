package com.gestionProfil.gestionProfil.repository;

import com.gestionProfil.gestionProfil.model.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {

}
