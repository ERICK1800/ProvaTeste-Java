package com.fatec.provateste.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.provateste.entities.Anuncio;
import com.fatec.provateste.services.AnuncioService;

@RestController
@RequestMapping("anuncios")
@CrossOrigin
public class AnuncioController {

    @Autowired
    private AnuncioService anuncioService;

    @GetMapping("{id}")
    public ResponseEntity<Anuncio> getAnuncio(@PathVariable int id){
        Anuncio anuncio = anuncioService.getAnuncioById(id);
        return ResponseEntity.ok().body(anuncio);
    }

    @GetMapping
    public ResponseEntity<List<Anuncio>> getAnuncios(){
        List<Anuncio> anuncios = anuncioService.getAnuncios();
        return ResponseEntity.ok().body(anuncios);
    }
    
    @PostMapping
    public ResponseEntity<Anuncio> saveAnuncio(@RequestBody Anuncio anuncio){
        Anuncio newAnuncio = anuncioService.save(anuncio);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(anuncio.getId())
                .toUri();

        return ResponseEntity.created(location).body(newAnuncio);
    }
}
