package com.musicstreaming.repository;

import com.musicstreaming.entity.Artist;
import com.musicstreaming.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ArtistRepository {
    private final EntityManager em;

    public ArtistRepository() {
        this.em = JPAUtil.getEntityManagerFactory().createEntityManager();
        // Test database connection
        try {
            em.createNativeQuery("SELECT 1 FROM DUAL").getSingleResult();
            System.out.println("Database connection successful");
        } catch (Exception e) {
            System.err.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public List<Artist> getAllArtists() {
        try {
            return em.createQuery("SELECT a FROM Artist a", Artist.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Artist getArtistById(Long id) {
        try {
            return em.find(Artist.class, id);
        } finally {
            em.close();
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
            throw e;
        } finally {
            em.close();
        }
    }
}
