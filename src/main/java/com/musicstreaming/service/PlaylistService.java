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
        return playlistRepository.getAllPlaylists();
    }
}
