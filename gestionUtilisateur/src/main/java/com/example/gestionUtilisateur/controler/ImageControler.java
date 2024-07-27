package com.example.gestionUtilisateur.controler;

import com.example.gestionUtilisateur.model.Images;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/images")
public interface ImageControler {

    @PostMapping("/addImage")
    public void uploadImage(@RequestParam("name") String name,
                            @RequestParam("userid") Long userid,
                            @RequestParam("profil") boolean profilImg,
                            @RequestParam("type") String type,
                            @RequestParam("image") MultipartFile file) throws IOException;

    @GetMapping("/getImage/{userId}")
    public List<Images> getImageByUserId(@PathVariable("userId") Long userId);

    @GetMapping("/getImageProfil/{userId}")
    public  Images getImageProfil(@PathVariable("userId") Long userId);


    @DeleteMapping("/deleteImage/{id}")
    public void deleteImageById(@PathVariable("id") Long id);

}
