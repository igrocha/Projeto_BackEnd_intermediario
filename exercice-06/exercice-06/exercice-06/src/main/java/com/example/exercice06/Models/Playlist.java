package com.example.exercice06.Models;

import org.springframework.stereotype.Component;

@Component
public class Playlist{
	private int id;//"id": 8888,
    private String author;//"autor": "Andre",
    private int yearLaunch; //"ano_criacao": 2021,
    private String name;//"nome_playlist": "XYZ",
    private int[] musicId;//“playlist_item”: {id_music1, id_music2, id_music3... }

    public Playlist(int id, String author, int yearLaunch, String name, int[] musicId) {
        this.id = id;
        this.author = author;
        this.yearLaunch = yearLaunch;
        this.name = name;
        this.musicId = musicId;
    }

    public Playlist(Playlist newPlaylist) {
        this.id = newPlaylist.id;
        this.author = newPlaylist.author;
        this.yearLaunch = newPlaylist.yearLaunch;
        this.name = newPlaylist.name;
        this.musicId = newPlaylist.musicId;
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

    public int[] getMusicId() {
        return musicId;
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

    public void setMusicId(int[] musicId) {
        this.musicId = musicId;
    }
}