package com.example.gestionUtilisateur.service;

import com.example.gestionUtilisateur.model.Utilisateur;
import com.example.gestionUtilisateur.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    public void  updateUser(Utilisateur utilisateur, Long id){
        Utilisateur userUpdate = utilisateurRepository.findUtilisateurById(id);

        userUpdate.setNom(utilisateur.getNom());
        userUpdate.setPrenom(utilisateur.getPrenom());
        userUpdate.setAge(utilisateur.getAge());
        userUpdate.setVille(utilisateur.getVille());
        userUpdate.setMail(utilisateur.getMail());
        userUpdate.setDescription(utilisateur.getDescription());

        utilisateurRepository.save(userUpdate);
    }


    public void  updatePwd(Utilisateur utilisateur, Long id){
        Utilisateur pwdUpdate = utilisateurRepository.findUtilisateurById(id);
        pwdUpdate.setPassword(utilisateur.getPassword());
        utilisateurRepository.save(pwdUpdate);
    }
}
