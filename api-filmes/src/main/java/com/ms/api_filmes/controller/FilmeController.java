package com.ms.api_filmes.controller;

import com.ms.api_filmes.model.Filme;
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

    @GetMapping(value = "/{id}/{currency}")
    public Filme findFilm(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
        var port = environment.getProperty("local.server.port");
        return new Filme(1L, "Jorge Lucas", "Star wars", new Date(), Double.valueOf(15.3), currency, port);
    }
}
