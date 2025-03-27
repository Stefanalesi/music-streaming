package com.musicstreaming.repository;

import com.musicstreaming.entity.Playlist;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class PlaylistRepository {
    @PersistenceContext
    EntityManager em;

    public List<Playlist> getAllPlaylists() {
        return em.createQuery("SELECT p FROM Playlist p", Playlist.class).getResultList();
    }
}
