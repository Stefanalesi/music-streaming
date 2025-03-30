package com.musicstreaming.service;

import com.musicstreaming.entity.Song;
import com.musicstreaming.repository.SongRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class SongService {
    @Inject
    SongRepository songRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public List<Song> getSongsByArtist(Long artistId) {
        return songRepository.findSongsByArtist(artistId);
    }

    public Long getSongCountByArtist(Long artistId) {
        return songRepository.countSongsByArtist(artistId);
    }
}
