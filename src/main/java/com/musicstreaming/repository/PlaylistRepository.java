package com.musicstreaming.repository;

import com.musicstreaming.entity.Playlist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class PlaylistRepository {
    private final EntityManager em;

    public PlaylistRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        this.em = emf.createEntityManager();
    }

    public List<Playlist> getAllPlaylists() {
        return em.createQuery("SELECT p FROM Playlist p", Playlist.class).getResultList();
    }
}
