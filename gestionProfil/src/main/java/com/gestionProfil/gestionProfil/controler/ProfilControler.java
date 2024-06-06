package com.gestionProfil.gestionProfil.controler;

import com.gestionProfil.gestionProfil.model.Profil;
import com.gestionProfil.gestionProfil.repository.ProfilRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfilControler {

    @Autowired
    ProfilRepository profilRepository;


    @GetMapping("/getAllProfil")
    public List<Profil> getAllProfil(){
        return profilRepository.findAll();
    }

    @GetMapping("/getProfil/{id}")
    public Profil getProfilByUserId(@PathVariable("id") Long id){
        return profilRepository.getProfilByUserId(id);
    }

    @PostMapping("/saveProfil/{id}")
    public void addProfilByUserID(@PathVariable("id") long id, @RequestBody Profil profil){
        profil.setUserId(id);
        profilRepository.save(profil);
    }

    @PutMapping("/editProfil/{id}")
    public void editProfilByUserId(@PathVariable("id") Long id, @RequestBody Profil profil){
        Profil profilUpdate = profilRepository.getProfilByUserId(id);

        profilUpdate.setSport(profil.getSport());
        profilUpdate.setNiveau(profil.getSport());
        profilUpdate.setPoid(profil.getPoid());

        profilRepository.save(profilUpdate);
    }

    @DeleteMapping("/deleteProfil/{id}")
    public void deleteProfil(@PathVariable("id") Long id){
        profilRepository.deleteById(id);
    }

}
