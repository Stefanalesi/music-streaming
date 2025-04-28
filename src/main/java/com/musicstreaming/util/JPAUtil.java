package com.musicstreaming.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JPAUtil {
    private static final Logger logger = Logger.getLogger(JPAUtil.class.getName());
    private static EntityManagerFactory emf;

    static {
        try {
            logger.info("Initializing EntityManagerFactory...");
            System.out.println("Creating EntityManagerFactory...");
            
            // Print system properties for debugging
            System.out.println("Java version: " + System.getProperty("java.version"));
            System.out.println("Classpath: " + System.getProperty("java.class.path"));
            
            emf = Persistence.createEntityManagerFactory("default");
            logger.info("EntityManagerFactory created successfully");
            System.out.println("EntityManagerFactory created successfully");
        } catch (PersistenceException e) {
            logger.log(Level.SEVERE, "Failed to create EntityManagerFactory", e);
            System.err.println("Failed to create EntityManagerFactory: " + e.getMessage());
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during initialization", e);
            System.err.println("Unexpected error during initialization: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            String error = "EntityManagerFactory is not initialized";
            logger.severe(error);
            throw new IllegalStateException(error);
        }
        return emf;
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            try {
                logger.info("Closing EntityManagerFactory...");
                System.out.println("Closing EntityManagerFactory...");
                emf.close();
                logger.info("EntityManagerFactory closed successfully");
                System.out.println("EntityManagerFactory closed successfully");
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error closing EntityManagerFactory", e);
                System.err.println("Error closing EntityManagerFactory: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
} 