package com.example.exercice06.Services;

import com.example.exercice06.Models.Musica;
import com.example.exercice06.Models.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MusicAppService{
    @Autowired
    private ArrayList<Musica> musicas;
    @Autowired
    private ArrayList<Playlist> playlists;

    public ArrayList<Musica> listaDeMusicas(){
        return this.musicas;
    }

    public ArrayList<Playlist> listaDePlaylists(){
        return this.playlists;
    }

    public Musica salvarMusica(Musica musica){
        Musica newMusica = new Musica(musica);
        musicas.add(newMusica);
        return newMusica;
    }

    public Playlist salvarPlaylist(Playlist playlist){
        Playlist newPlaylist = new Playlist(playlist);
        playlists.add(newPlaylist);
        return newPlaylist;
    }

    public Musica atualizaMusica(Musica indexMusica){
        int musicId = indexMusica.getId();
        for (int i = 0; i < musicas.toArray().length; i++) {
            if (musicas.get(i).getId() == musicId) {
                musicas.set(i, indexMusica);
                return musicas.get(i);
            }
        }
        return null;
    }

    public Playlist atualizaPlaylist(Playlist indexPlaylist){
        int playlistId = indexPlaylist.getId();
        for (int i = 0; i < playlists.toArray().length; i++) {
            if (playlists.get(i).getId() == playlistId) {
                playlists.set(i, indexPlaylist);
                return playlists.get(i);
            }
        }
        return null;
    }

    public Musica deletarMusica(Musica indexMusica){
        Musica target = null;
        for (Musica musica : musicas) {
            if (musica == indexMusica) {
                target = musica;
            }
        }

        if(target != null){
            musicas.remove(target);
        }

        return target;
    }

    public Playlist deletarPlaylist(Playlist indexPlaylist){
        Playlist target = null;
        for (Playlist playlist : playlists) {
            if (playlist == indexPlaylist) {
                target = playlist;
            }
        }

        if(target != null){
            playlists.remove(target);
        }

        return target;
    }

    public Musica deletarMusicaNaPlaylist(Playlist indexPlaylist, int musicId){
        Musica targetMusic = null;
        Playlist targetPlaylist = null;

        for (Playlist playlist : playlists) {
            if (playlist == indexPlaylist) {
                int[] musicIds = playlist.getMusicId();
                for (int i = 0; i < musicIds.length; i++) {
                    if (musicIds[i] == musicId) {
                        targetMusic = getMusicById(musicId);
                        if(targetMusic == null){
                            return targetMusic;
                        }

                        targetPlaylist = playlist;

                        int[] updatedMusicIds = new int[musicIds.length - 1];
                        System.arraycopy(musicIds, 0, updatedMusicIds, 0, i);
                        System.arraycopy(musicIds, i + 1, updatedMusicIds, i, musicIds.length - i - 1);
                        targetPlaylist.setMusicId(updatedMusicIds);
                        break;
                    }
                }
                break;
            }
        }

        return targetMusic;
    }


    public Musica getMusicById(int id){
        Musica target = null;
        for (Musica musica : musicas) {
            if (musica.getId() == id) {
                target = musica;
            }
        }

        return target;
    }
}