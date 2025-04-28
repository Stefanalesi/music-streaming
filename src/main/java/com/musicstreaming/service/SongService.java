package com.musicstreaming.service;

import com.musicstreaming.entity.Song;
import com.musicstreaming.repository.SongRepository;
import java.util.List;

public class SongService {
    private final SongRepository songRepository;

    public SongService() {
        this.songRepository = new SongRepository();
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public List<Song> getSongsByArtist(Long artistId) {
        return songRepository.findSongsByArtist(artistId);
    }

    public Long getSongCountByArtist(Long artistId) {
        return songRepository.countSongsByArtist(artistId);
    }

    public void save(Song song) {
        songRepository.save(song);
    }
}
