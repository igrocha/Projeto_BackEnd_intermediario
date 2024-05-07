package com.example.exercice06.Models;

import org.springframework.stereotype.Component;

@Component
public class Musica{
    private int id; //"id": 9999,
    private String author; //"cantor": "Joao",
    private int yearLaunch; //"ano_lancamento": 2020,
    private String name; //"nome_musica": "XYZ",
    private String gender; //"genero":"rock"

    public Musica(int id, String author, int yearLaunch, String name, String gender) {
        this.id = id;
        this.author = author;
        this.yearLaunch = yearLaunch;
        this.name = name;
        this.gender = gender;
    }

    public Musica(Musica newMusica) {
        this.id = newMusica.id;
        this.author = newMusica.author;
        this.yearLaunch = newMusica.yearLaunch;
        this.name = newMusica.name;
        this.gender = newMusica.gender;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearLaunch() {
        return yearLaunch;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearLaunch(int yearLaunch) {
        this.yearLaunch = yearLaunch;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}