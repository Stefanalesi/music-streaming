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
        try {
            return songRepository.findAll();
        } finally {
            songRepository.close();
        }
    }

    public List<Song> getSongsByArtist(Long artistId) {
        try {
            return songRepository.findSongsByArtist(artistId);
        } finally {
            songRepository.close();
        }
    }

    public Long getSongCountByArtist(Long artistId) {
        try {
            return songRepository.countSongsByArtist(artistId);
        } finally {
            songRepository.close();
        }
    }

    public void save(Song song) {
        try {
            songRepository.save(song);
        } finally {
            songRepository.close();
        }
    }
}
