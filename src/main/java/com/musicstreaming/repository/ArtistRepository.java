package com.musicstreaming.repository;

import com.musicstreaming.entity.Artist;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ArtistRepository {
    @PersistenceContext
    EntityManager em;

    public List<Artist> getAllArtists() {
        return em.createQuery("SELECT a FROM Artist a", Artist.class).getResultList();
    }
}
