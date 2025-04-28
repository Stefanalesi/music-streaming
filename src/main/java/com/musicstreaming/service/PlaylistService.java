package com.musicstreaming.service;

import com.musicstreaming.entity.Playlist;
import com.musicstreaming.repository.PlaylistRepository;
import java.util.List;

public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistService() {
        this.playlistRepository = new PlaylistRepository();
    }

    public List<Playlist> getAllPlaylists() {
        try {
            return playlistRepository.getAllPlaylists();
        } finally {
            playlistRepository.close();
        }
    }

    public void save(Playlist playlist) {
        try {
            playlistRepository.save(playlist);
        } finally {
            playlistRepository.close();
        }
    }
}
