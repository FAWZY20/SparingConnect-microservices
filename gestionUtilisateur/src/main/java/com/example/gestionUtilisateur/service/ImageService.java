package com.example.gestionUtilisateur.service;

import com.example.gestionUtilisateur.controler.ImageControler;
import com.example.gestionUtilisateur.model.Images;
import com.example.gestionUtilisateur.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

@Service
public class ImageService implements ImageControler {


    public static final int BITE_SIZE = 4 * 1024;
    @Autowired
    ImageRepository imageRepository;

    @Override
    public void uploadImage(@RequestParam("userid") Long userid,
                            @RequestParam("profil") boolean profilImg,
                            @RequestParam("image") MultipartFile file) throws IOException {

        Images image = new Images();
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setImages(file.getBytes());

        image.setUserId(userid);
        image.setProfilImg(profilImg);

        imageRepository.save(image);
    }

    @Override
    public List<Images> getImageByUserId(@PathVariable("userId") Long userId){
        return imageRepository.findImagesByUserId(userId);
    }

    @Override
    public ResponseEntity<byte[]> getImageProfil(Long userId) {
        Images image = imageRepository.findImagesByUserId(userId)
                .stream()
                .filter(img -> img.getProfilImg() == true)
                .findFirst()
                .orElse(null);

        if (image != null){
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(image.getType()))
                    .body(image.getImages());
        }else {
             return (ResponseEntity<byte[]>) ResponseEntity.badRequest();
        }
    }

    @Override
    public void updateImgProfil(@PathVariable("userId") Long userId,
                                @RequestParam("image") MultipartFile file) throws IOException {

        Images image = imageRepository.findImagesByUserIdAndProfilImg(userId, true);

        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setImages(file.getBytes());

        imageRepository.save(image);
    }

    @Override
    public void deleteImageById(@PathVariable("id") Long id){
        imageRepository.deleteById(id);
    }

}
