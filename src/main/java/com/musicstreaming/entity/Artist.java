package com.musicstreaming.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "USER")
@DiscriminatorValue("ARTIST")
public class Artist extends User {
    public String genre;
    public String country;
}
