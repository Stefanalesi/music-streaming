package com.musicstreaming.test;

import com.musicstreaming.entity.Playlist;
import com.musicstreaming.service.PlaylistService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class PlaylistServiceTest {
    @Inject
    PlaylistService playlistService;

    @Test
    public void testGetPlaylists() {
        List<Playlist> playlists = playlistService.getAllPlaylists();
        assertFalse(playlists.isEmpty());
    }
}
