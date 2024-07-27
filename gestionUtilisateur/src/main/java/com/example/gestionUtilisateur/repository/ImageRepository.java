package com.example.gestionUtilisateur.repository;

import com.example.gestionUtilisateur.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Images, Long> {

    List<Images> findImagesByUserId(long userId);

}
