package com.ms.api_filmes.controller;

import com.ms.api_filmes.model.Filme;
import com.ms.api_filmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeController {
    @Autowired
    private Environment environment;
    @Autowired
    private FilmeRepository repository;

    @GetMapping(value = "/{id}/{currency}")
    public Filme findFilm(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
        var filme = repository.getReferenceById(id);
        if (filme == null) throw new RuntimeException("Film not found");

        var port = environment.getProperty("local.server.port");
        filme.setEnvironment(port);
        return filme;
    }
}
