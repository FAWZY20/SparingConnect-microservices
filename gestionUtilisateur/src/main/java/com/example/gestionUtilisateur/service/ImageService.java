package com.example.gestionUtilisateur.service;

import com.example.gestionUtilisateur.controler.ImageControler;
import com.example.gestionUtilisateur.model.Images;
import com.example.gestionUtilisateur.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService implements ImageControler {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public void uploadImage(@RequestParam("name") String name,
                            @RequestParam("userid") Long userid,
                            @RequestParam("profil") boolean profilImg,
                            @RequestParam("type") String type,
                            @RequestParam("image") MultipartFile file) throws IOException {
        byte[] imageBytes = file.getBytes();

        Images image = new Images();
        image.setName(name);
        image.setUserId(userid);
        image.setProfilImg(profilImg);
        image.setType(type);
        image.setImages(imageBytes);

        imageRepository.save(image);
    }

    @Override
    public List<Images> getImageByUserId(@PathVariable("userId") Long userId){
        return imageRepository.findImagesByUserId(userId);
    }

    @Override
    public Images getImageProfil(Long userId) {
        return (Images) imageRepository.findImagesByUserId(userId)
                .stream().filter(img -> img.getProfilImg() == true);
    }

    @Override
    public void deleteImageById(@PathVariable("id") Long id){
        imageRepository.deleteById(id);
    }

}
