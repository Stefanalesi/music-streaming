package com.musicstreaming.service;

import com.musicstreaming.entity.Artist;
import com.musicstreaming.repository.ArtistRepository;
import java.util.List;

public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService() {
        this.artistRepository = new ArtistRepository();
    }

    public List<Artist> getAllArtists() {
        return artistRepository.getAllArtists();
    }

    public Artist getArtistById(Long id) {
        return artistRepository.getArtistById(id);
    }

    public void save(Artist artist) {
        artistRepository.save(artist);
    }
}
