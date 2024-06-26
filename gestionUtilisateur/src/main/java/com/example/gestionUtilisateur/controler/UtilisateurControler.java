package com.example.gestionUtilisateur.controler;

import com.example.gestionUtilisateur.model.Utilisateur;
import com.example.gestionUtilisateur.repository.UtilisateurRepository;
import com.example.gestionUtilisateur.service.AuthentificationService;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtilisateurControler {

    @Autowired
    UtilisateurRepository utilisateurRepository;


    @Autowired
    AuthentificationService authentificationService;

    @PostMapping("/login")
    public String login(@RequestBody Utilisateur utilisateur){
        return authentificationService.checkConnexion(utilisateur);
    }

    @GetMapping("/getAllUser")
    public List<Utilisateur> getAllUser(){
        return utilisateurRepository.findAll();
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
    }

    @PutMapping("/updateUser/{id}")
    public void updateUser(@RequestBody Utilisateur utilisateur, @PathVariable("id") long id ){
        Utilisateur userUpdate = utilisateurRepository.findUtilisateurById(id);

        userUpdate.setNom(utilisateur.getNom());
        userUpdate.setPrenom(utilisateur.getPrenom());
        userUpdate.setAge(utilisateur.getAge());
        userUpdate.setVille(utilisateur.getVille());
        userUpdate.setMail(utilisateur.getMail());
        userUpdate.setPassword(utilisateur.getPassword());
        userUpdate.setDescription(utilisateur.getDescription());

        utilisateurRepository.save(userUpdate);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") long id){
        utilisateurRepository.deleteById(id);
    }
}
