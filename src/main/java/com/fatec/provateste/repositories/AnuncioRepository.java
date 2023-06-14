package com.fatec.provateste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.provateste.entities.Anuncio;

public interface AnuncioRepository extends JpaRepository <Anuncio,Integer>{
    
}
