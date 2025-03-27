package com.musicstreaming.repository;

import com.musicstreaming.entity.Song;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class SongRepository {
    @PersistenceContext
    EntityManager em;

    public List<Song> getAllSongs() {
        return em.createQuery("SELECT s FROM Song s", Song.class).getResultList();
    }
}
