package com.musicstreaming.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PLAYLIST")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToMany
    @JoinTable(
            name = "playlist_song",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Song> songs;
}
