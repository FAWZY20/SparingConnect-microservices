package com.example.gestionUtilisateur.controler;

import com.example.gestionUtilisateur.model.Images;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/images")
public interface ImageControler {

    @PostMapping("/addImage")
    public void uploadImage(@RequestParam("userid") Long userid,
                            @RequestParam("profil") boolean profilImg,
                            @RequestParam("image") MultipartFile file) throws IOException;

    @GetMapping("/getImage/{userId}")
    public List<Images> getImageByUserId(@PathVariable("userId") Long userId);

    @GetMapping("/getImageProfil/{userId}")
    public ResponseEntity<byte[]> getImageProfil(@PathVariable("userId") Long userId);

    @PutMapping("/updateImageProfil/{userId}")
    public void updateImgProfil(@PathVariable("userId") Long userId,
                                @RequestParam("image") MultipartFile file) throws IOException;

    @DeleteMapping("/deleteImage/{id}")
    public void deleteImageById(@PathVariable("id") Long id);

}
