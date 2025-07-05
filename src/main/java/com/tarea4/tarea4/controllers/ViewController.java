package com.tarea4.tarea4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String home() {
        return "redirect:/completadas";
    }

    @GetMapping("/completadas")
    public String completadas() {
        return "completadas";       
    }
}
