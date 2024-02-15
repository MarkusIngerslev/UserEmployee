package com.example.useremployee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnicodeJPARestController {

    @GetMapping("/unicode/{i}")
    public String unicodeToChar(@PathVariable int i) {
        char c = (char)i;
        return "unicode = " + i + " char = " + c;
    }
}
