package com.musicstreaming.controller;

import com.musicstreaming.entity.Song;
import com.musicstreaming.service.SongService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/songs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SongController {
    @Inject
    SongService songService;

    @GET
    public List<Song> getSongs() {
        return songService.getAllSongs();
    }
}
