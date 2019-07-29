package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Qzwy
 */
@RestController
@RequestMapping("/")
public class LoginController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
