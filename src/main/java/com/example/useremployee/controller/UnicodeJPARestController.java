package com.example.useremployee.controller;

import com.example.useremployee.model.Unicode;
import com.example.useremployee.repositories.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UnicodeJPARestController {

    @Autowired
    UnicodeRepository unicodeRepository;

    // Add a new method that takes an int as a parameter
    // and returns a string with the int and its char value
    @GetMapping("/unicode/{i}")
    public String unicodeToChar(@PathVariable int i) {
        char c = (char)i;
        return "unicode = " + i + " char = " + c;
    }

    // Add a new method that takes a char as a parameter
    // and returns a string with the char and its unicode value
    @GetMapping("/char/{c}")
    public String charToUnicode(@PathVariable char c) {
        int i = (int)c;
        return "char = " + c + " unicode = " + i;
    }
    @GetMapping("/unicode")
    public List<Unicode> getUnicodes() {
        return unicodeRepository.findAll();
    }
}
