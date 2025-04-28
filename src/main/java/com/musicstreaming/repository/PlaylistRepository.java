package com.musicstreaming.repository;

import com.musicstreaming.entity.Playlist;
import com.musicstreaming.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PlaylistRepository {
    private final EntityManager em;

    public PlaylistRepository() {
        this.em = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    public List<Playlist> getAllPlaylists() {
        try {
            return em.createQuery("SELECT p FROM Playlist p", Playlist.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error getting all playlists", e);
        }
    }

    public void save(Playlist playlist) {
        try {
            em.getTransaction().begin();
            if (playlist.id == null) {
                em.persist(playlist);
            } else {
                em.merge(playlist);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error saving playlist", e);
        }
    }

    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
