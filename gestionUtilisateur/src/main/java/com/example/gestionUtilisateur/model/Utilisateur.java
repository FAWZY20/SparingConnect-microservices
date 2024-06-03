package com.example.gestionUtilisateur.model;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "vehicle_seq", allocationSize = 1)
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private  String prenom;

    @Column(name = "age")
    private Integer age;

    @Column(name = "ville")
    private String ville;

    @Column(name = "description")
    private String description;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password", length = 10)
    private String password;

    public Utilisateur(long id, String nom, String prenom, Integer age, String ville, String description, String mail, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.ville = ville;
        this.description = description;
        this.mail = mail;
        this.password = password;
    }

    public Utilisateur(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
