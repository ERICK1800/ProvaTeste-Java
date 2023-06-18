package com.fatec.provateste.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.provateste.entities.Anuncio;
import com.fatec.provateste.repositories.AnuncioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    public Anuncio getAnuncioById(int id){
        return anuncioRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Anuncio não encontrado")
        );
    }
    
    public List<Anuncio> getAnuncios(){
        return anuncioRepository.findAll();
    }

    public Anuncio save(Anuncio anuncio) {
        return anuncioRepository.save(anuncio);
    }

}
