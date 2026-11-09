package com.devsenior.llavemaestra.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.llavemaestra.dto.HerramientaResponse;
import com.devsenior.llavemaestra.service.HerramientaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController 
@RequestMapping ("/api/herramientas")
public class HerramientasController {


    private final HerramientaService herramientaService;

    public HerramientasController(HerramientaService herramientaService) {
        this.herramientaService = herramientaService;
    }

    @PreAuthorize ("hasAuthority('HERRAMIENTAS_VER')")
    @GetMapping
    public ResponseEntity <List<HerramientaResponse>> listar(Authentication authentication) {
        return ResponseEntity.ok(herramientaService.listar(authentication));
    }

    @PreAuthorize ("hasAuthority('HERRAMIENTAS_VER')")
    @GetMapping("/{id}")
    public ResponseEntity<HerramientaResponse> buscarPorId (@PathVariable Long id,Authentication authentication) {
        return ResponseEntity.ok(herramientaService.buscarPorId(id, authentication));
    }
    
    

}
