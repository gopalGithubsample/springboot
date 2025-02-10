package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class AnimeCharacterController {

    private String[] characterNames = new String[3];

    public AnimeCharacterController() {
        characterNames[0] = "Goku";
        characterNames[1] = "Naruto";
        characterNames[2] = "Saitama";
    }

    @GetMapping("/names")
    public String[] getAllCharacterNames() {
        return characterNames;
    }
}