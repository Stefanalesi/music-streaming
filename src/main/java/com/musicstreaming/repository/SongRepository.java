package com.musicstreaming.repository;

import com.musicstreaming.entity.Song;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.util.List;

public class SongRepository {
    private final EntityManager em;

    public SongRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        this.em = emf.createEntityManager();
    }

    public List<Song> findAll() {
        return em.createQuery("SELECT s FROM Song s", Song.class).getResultList();
    }

    public List<Song> findSongsByArtist(Long artistId) {
        return em.createQuery(
            "SELECT s FROM Song s JOIN s.artists a WHERE a.id = :artistId", 
            Song.class)
            .setParameter("artistId", artistId)
            .getResultList();
    }

    public Long countSongsByArtist(Long artistId) {
        return em.createQuery(
            "SELECT COUNT(s) FROM Song s JOIN s.artists a WHERE a.id = :artistId", 
            Long.class)
            .setParameter("artistId", artistId)
            .getSingleResult();
    }

    @Transactional
    public void save(Song song) {
        em.getTransaction().begin();
        if (song.id == null) {
            em.persist(song);
        } else {
            em.merge(song);
        }
        em.getTransaction().commit();
    }
}
