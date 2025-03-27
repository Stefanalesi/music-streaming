package com.musicstreaming.controller;

import com.musicstreaming.entity.Playlist;
import com.musicstreaming.service.PlaylistService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/playlists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlaylistController {
    @Inject
    PlaylistService playlistService;

    @GET
    public List<Playlist> getPlaylists() {
        return playlistService.getAllPlaylists();
    }
}
