package com.ms.api_filmes.controller;

import com.ms.api_filmes.model.Filme;
import com.ms.api_filmes.repository.FilmeRepository;
import com.ms.api_filmes.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;

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

        HashMap<String, String> params = new HashMap<>();
        params.put("amount", filme.getPrice().toString());
        params.put("from", "USD");
        params.put("to", currency);


        var response = new RestTemplate().getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}",
                Cambio.class, params);
        var cambio = response.getBody();

        var port = environment.getProperty("local.server.port");
        filme.setEnvironment(port);
        filme.setPrice(cambio.getConvertedValue());
        return filme;
    }
}
