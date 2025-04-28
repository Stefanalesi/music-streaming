package com.musicstreaming.repository;

import com.musicstreaming.entity.Song;
import com.musicstreaming.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class SongRepository {
    private final EntityManager em;

    public SongRepository() {
        this.em = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    public List<Song> findAll() {
        try {
            return em.createQuery("SELECT s FROM Song s", Song.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error getting all songs", e);
        }
    }

    public List<Song> findSongsByArtist(Long artistId) {
        try {
            return em.createQuery(
                "SELECT s FROM Song s JOIN s.artists a WHERE a.id = :artistId", 
                Song.class)
                .setParameter("artistId", artistId)
                .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error getting songs by artist", e);
        }
    }

    public Long countSongsByArtist(Long artistId) {
        try {
            return em.createQuery(
                "SELECT COUNT(s) FROM Song s JOIN s.artists a WHERE a.id = :artistId", 
                Long.class)
                .setParameter("artistId", artistId)
                .getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("Error counting songs by artist", e);
        }
    }

    public void save(Song song) {
        try {
            em.getTransaction().begin();
            if (song.id == null) {
                em.persist(song);
            } else {
                em.merge(song);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error saving song", e);
        }
    }

    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
