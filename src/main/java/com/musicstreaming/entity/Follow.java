package com.musicstreaming.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FOLLOW")
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
}