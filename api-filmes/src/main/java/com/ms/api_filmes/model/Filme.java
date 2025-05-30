package com.ms.api_filmes.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Filme implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "diretor", nullable = false, length = 180)
    private String diretor;
    @Column(name = "launch_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date launchDate;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false, length = 250)
    private String name;
    @Transient
    private String currency;
    @Transient
    private String environment;

    public Filme() {
    }

    public Filme(Long id, String diretor, String name, Date launchDate, Double price, String currency, String environment) {
        this.id = id;
        this.diretor = diretor;
        this.launchDate = launchDate;
        this.price = price;
        this.name = name;
        this.currency = currency;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return Objects.equals(id, filme.id) && Objects.equals(diretor, filme.diretor) && Objects.equals(launchDate, filme.launchDate) && Objects.equals(price, filme.price) && Objects.equals(name, filme.name) && Objects.equals(currency, filme.currency) && Objects.equals(environment, filme.environment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, diretor, launchDate, price, name, currency, environment);
    }
}
