package com.musicstreaming;

import com.musicstreaming.entity.Song;
import com.musicstreaming.service.SongService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class SongServiceTest {
    @Inject
    SongService songService;

    @Test
    public void testGetSongs() {
        List<Song> songs = songService.getAllSongs();
        assertFalse(songs.isEmpty());
    }
}
