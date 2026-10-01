package br.com.fiap.taskmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloResource {


    @GetMapping
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("Olá mundo!");
    }
}
