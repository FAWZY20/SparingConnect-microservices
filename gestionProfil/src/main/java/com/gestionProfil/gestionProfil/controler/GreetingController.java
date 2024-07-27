package com.gestionProfil.gestionProfil.controler;

import org.springframework.web.bind.annotation.GetMapping;

public interface GreetingController {

    @GetMapping("/greeting")
    String greeting();

}
