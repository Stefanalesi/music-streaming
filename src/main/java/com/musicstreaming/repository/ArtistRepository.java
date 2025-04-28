package com.musicstreaming.repository;

import com.musicstreaming.entity.Artist;
import com.musicstreaming.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ArtistRepository {
    private final EntityManager em;

    public ArtistRepository() {
        this.em = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    public List<Artist> getAllArtists() {
        try {
            return em.createQuery("SELECT a FROM Artist a", Artist.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error getting all artists", e);
        }
    }

    public Artist getArtistById(Long id) {
        try {
            return em.find(Artist.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error getting artist by id", e);
        }
    }

    public void save(Artist artist) {
        try {
            em.getTransaction().begin();
            if (artist.id == null) {
                em.persist(artist);
            } else {
                em.merge(artist);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error saving artist", e);
        }
    }

    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
