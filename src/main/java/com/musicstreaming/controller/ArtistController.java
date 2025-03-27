package com.musicstreaming.controller;

import com.musicstreaming.entity.Artist;
import com.musicstreaming.service.ArtistService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/artists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArtistController {
    @Inject
    ArtistService artistService;

    @GET
    public List<Artist> getArtists() {
        return artistService.getAllArtists();
    }
}
