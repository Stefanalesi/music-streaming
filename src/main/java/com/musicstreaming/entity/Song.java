package com.musicstreaming.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "SONG")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    public int duration;
    public String releaseDate;

    @ManyToMany
    @JoinTable(
            name = "song_artist",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    public List<Artist> artists;
}