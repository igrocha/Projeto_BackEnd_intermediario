package com.example.exercice06.Controllers;

import com.example.exercice06.Models.Musica;
import com.example.exercice06.Models.Playlist;
import com.example.exercice06.Services.MusicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MusicAppController{
    @Autowired
    private MusicAppService musicAppService;

    @GetMapping("/musicas")
    public ResponseEntity<Object> listarMusicas() {
        return ResponseEntity.status(200).body(musicAppService.listaDeMusicas());
    }

    @GetMapping("/playlists")
    public ResponseEntity<Object> listarPlaylists() {
        return ResponseEntity.status(200).body(musicAppService.listaDePlaylists());
    }

    @PostMapping("/musicas")
    public ResponseEntity<Object> adicionarMusica(@RequestBody Musica novaMusica) {
        Musica musicaSalva = musicAppService.salvarMusica(novaMusica);
        musicAppService.listaDeMusicas().add(musicaSalva);
        return ResponseEntity.status(200).body(musicaSalva);
    }

    @PostMapping("/playlists")
    public ResponseEntity<Object> adicionarPlaylist(@RequestBody Playlist novaPlaylist) {
        Playlist playlistSalva = musicAppService.salvarPlaylist(novaPlaylist);
        musicAppService.listaDePlaylists().add(playlistSalva);
        return ResponseEntity.status(200).body(playlistSalva);
    }

    @PutMapping("/musicas/{id}")
    public ResponseEntity<Object> editarMusica(@PathVariable int id, @RequestBody Musica musicaEditada) {
        Musica musicaExistente = musicAppService.listaDeMusicas().get(id);
        if (musicaExistente != null) {
            Musica target = musicAppService.atualizaMusica(musicaEditada);
            if(target != null){
                return ResponseEntity.status(200).body(musicaEditada);
            }else{
                return ResponseEntity.status(404).body("Música não encontrada");
            }
        } else {
            return ResponseEntity.status(404).body("Música não encontrada");
        }
    }

    @PutMapping("/playlists/{id}")
    public ResponseEntity<Object> editarPlaylist(@PathVariable int id, @RequestBody Playlist playlistEditada) {
        Playlist playlistExistente = musicAppService.listaDePlaylists().get(id);
        if (playlistExistente != null) {
            Playlist target = musicAppService.atualizaPlaylist(playlistEditada);
            if(target != null){
                return ResponseEntity.status(200).body(playlistEditada);
            }else{
                return ResponseEntity.status(404).body("Playlist não encontrada");
            }
        } else {
            return ResponseEntity.status(404).body("Playlist não encontrada");
        }
    }

    @DeleteMapping("/musicas/{id}")
    public ResponseEntity<Object> deletarMusica(@PathVariable int id, @RequestBody Musica musicaEditada) {
        Musica musicaExistente = musicAppService.listaDeMusicas().get(id);
        if (musicaExistente != null) {
            Musica target = musicAppService.deletarMusica(musicaExistente);
            if(target != null){
                return ResponseEntity.status(200).body("Música deletada");
            }else{
                return ResponseEntity.status(404).body("Música não encontrada");
            }
        } else {
            return ResponseEntity.status(404).body("Música não encontrada");
        }
    }

    @DeleteMapping("/playlists/{id}")
    public ResponseEntity<Object> deletarPlaylist(@PathVariable int id, @RequestBody Playlist playlistEditada) {
        Playlist playlistExistente = musicAppService.listaDePlaylists().get(id);
        if (playlistExistente != null) {
            Playlist target = musicAppService.deletarPlaylist(playlistExistente);
            if(target != null){
                return ResponseEntity.status(200).body("Playlist Deletada");
            }else{
                return ResponseEntity.status(404).body("Música não encontrada");
            }

        } else {
            return ResponseEntity.status(404).body("Música não encontrada");
        }
    }

    @DeleteMapping("/playlists/{id}/{music}")
    public ResponseEntity<Object> deletarMusicaNaPlaylist(@PathVariable int playlistId, @PathVariable int musicId, @RequestBody Playlist playlistEditada) {
        Playlist playlistExistente = musicAppService.listaDePlaylists().get(playlistId);
        if (playlistExistente != null) {
            Musica target = musicAppService.deletarMusicaNaPlaylist(playlistExistente, musicId);
            if(target != null){
                return ResponseEntity.status(200).body("Música " + target.getName() + " deletada com sucesso!" );
            }else{
                return ResponseEntity.status(404).body("Música não encontrada");
            }
        } else {
            return ResponseEntity.status(404).body("Música não encontrada");
        }
    }
}