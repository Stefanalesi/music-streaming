package com.musicstreaming.repository;

import com.musicstreaming.entity.Song;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class SongRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Song> findAll() {
        return entityManager.createQuery("SELECT s FROM Song s", Song.class).getResultList();
    }

    public List<Song> findSongsByArtist(Long artistId) {
        return entityManager.createQuery("SELECT s FROM Song s WHERE s.artist.id = :artistId", Song.class)
                .setParameter("artistId", artistId)
                .getResultList();
    }

    public Long countSongsByArtist(Long artistId) {
        return entityManager.createQuery("SELECT COUNT(s) FROM Song s WHERE s.artist.id = :artistId", Long.class)
                .setParameter("artistId", artistId)
                .getSingleResult();
    }

    @Transactional
    public void save(Song song) {
        entityManager.persist(song);
    }
}
