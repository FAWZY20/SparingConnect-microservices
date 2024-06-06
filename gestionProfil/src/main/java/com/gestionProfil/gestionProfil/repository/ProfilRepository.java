package com.gestionProfil.gestionProfil.repository;

import com.gestionProfil.gestionProfil.model.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {

    @Query(value = "SELECT p.id, p.userid, p.sport, p.poid, p.niveau FROM profil AS p , utilisateur AS u WHERE p.userid = u.id AND u.id = :uid", nativeQuery = true)
    Profil getProfilByUserId(@Param("uid") Long id);
}
