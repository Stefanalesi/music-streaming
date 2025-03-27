package com.musicstreaming.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String email;
    public String role;

    @OneToMany(mappedBy = "user")
    private List<Playlist> playlists;
}
