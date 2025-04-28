package com.musicstreaming.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "USER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("NORMAL")
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
