package com.musicstreaming.service;

import com.musicstreaming.entity.Artist;
import com.musicstreaming.repository.ArtistRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ArtistService {
    @Inject
    ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.getAllArtists();
    }
}
