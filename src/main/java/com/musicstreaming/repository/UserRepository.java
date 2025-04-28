package com.musicstreaming.repository;

import com.musicstreaming.entity.User;
import com.musicstreaming.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class UserRepository {
    private final EntityManager em;

    public UserRepository() {
        this.em = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    public List<User> getAllUsers() {
        try {
            return em.createQuery("SELECT u FROM User u", User.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error getting all users", e);
        }
    }

    public void save(User user) {
        try {
            em.getTransaction().begin();
            if (user.id == null) {
                em.persist(user);
            } else {
                em.merge(user);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error saving user", e);
        }
    }

    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
