package com.musicstreaming.service;

import com.musicstreaming.entity.Playlist;
import com.musicstreaming.repository.PlaylistRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PlaylistService {
    @Inject
    PlaylistRepository playlistRepository;

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.getAllPlaylists();
    }
}
