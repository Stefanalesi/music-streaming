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
        try {
            return artistRepository.getAllArtists();
        } finally {
            artistRepository.close();
        }
    }

    public Artist getArtistById(Long id) {
        try {
            return artistRepository.getArtistById(id);
        } finally {
            artistRepository.close();
        }
    }

    public void save(Artist artist) {
        try {
            artistRepository.save(artist);
        } finally {
            artistRepository.close();
        }
    }
}
