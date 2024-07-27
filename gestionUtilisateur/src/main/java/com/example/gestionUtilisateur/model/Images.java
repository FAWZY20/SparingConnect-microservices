package com.example.gestionUtilisateur.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Images")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "vehicle_seq", allocationSize = 1)
    public Long id;

    @Column(name = "userid")
    public Long userId;

    @Column(name = "name")
    public String name;

    @Column(name = "type")
    public String type;

    @Column(name = "profil")
    public boolean profilImg;

    @Column(name = "image", columnDefinition="bytea")
    public byte[] images;

    public Images(Long userId, String name, String type, boolean profilImg, byte[] images) {
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.profilImg = profilImg;
        this.images = images;
    }


    public Images(){

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getProfilImg() {
        return profilImg;
    }

    public void setProfilImg(boolean profilImg) {
        this.profilImg = profilImg;
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }

}
