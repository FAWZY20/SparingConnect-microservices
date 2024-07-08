package com.gestionProfil.gestionProfil.model;

import jakarta.persistence.*;

@Entity
@Table(name = "profil")
public class Profil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "vehicle_seq", allocationSize = 1)
    private Long id;

    @Column(name = "userid", unique = true)
    private Long userId;

    @Column(name = "sport")
    private String sport;

    @Column(name = "poid")
    private Integer poid;

    @Column(name = "niveau")
    private String niveau;

    public Profil(Long id, Long userId, String sport, Integer poid, String niveau) {
        this.id = id;
        this.userId = userId;
        this.sport = sport;
        this.poid = poid;
        this.niveau = niveau;
    }


    public Profil(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Integer getPoid() {
        return poid;
    }

    public void setPoid(Integer poid) {
        this.poid = poid;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

}
