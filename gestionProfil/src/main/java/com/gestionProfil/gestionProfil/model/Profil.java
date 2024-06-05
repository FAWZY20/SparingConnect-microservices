package com.gestionProfil.gestionProfil.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

@Entity
@Table(name = "profil")
public class Profil {

    @Column(name = "id", nullable = false)
    @GeneratedValue()
    public long id;

    @Column(name = "userId")
    public long userId;

    @Column(name = "sport")
    public long sport;

    @Column(name = "poid")
    public long poid;

    @Column(name = "niveau")
    public long niveau;

    public Profil(long id, long userId, long sport, long poid, long niveau) {
        this.id = id;
        this.userId = userId;
        this.sport = sport;
        this.poid = poid;
        this.niveau = niveau;
    }

    public Profil(){

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getSport() {
        return sport;
    }

    public void setSport(long sport) {
        this.sport = sport;
    }

    public long getPoid() {
        return poid;
    }

    public void setPoid(long poid) {
        this.poid = poid;
    }

    public long getNiveau() {
        return niveau;
    }

    public void setNiveau(long niveau) {
        this.niveau = niveau;
    }

}
