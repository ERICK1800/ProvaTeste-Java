package com.fatec.provateste.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.provateste.entities.Anuncio;
import com.fatec.provateste.services.AnuncioService;

@RestController
@CrossOrigin
public class AnuncioController {

    @Autowired
    private AnuncioService anuncioService;

    @GetMapping("anuncio/{id}")
    public Anuncio getAnuncio(@PathVariable int id){
        return anuncioService.getAnuncioById(id);
    }

    @GetMapping("anuncios")
    public List<Anuncio> GetAnuncios(){
        return anuncioService.getAnuncios();
    }
    
}
