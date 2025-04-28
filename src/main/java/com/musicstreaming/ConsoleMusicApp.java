package com.musicstreaming;

import com.musicstreaming.entity.Artist;
import com.musicstreaming.entity.Song;
import com.musicstreaming.entity.User;
import com.musicstreaming.entity.Playlist;
import com.musicstreaming.service.ArtistService;
import com.musicstreaming.service.SongService;
import com.musicstreaming.service.UserService;
import com.musicstreaming.service.PlaylistService;
import com.musicstreaming.util.JPAUtil;
import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.io.InputStream;

public class ConsoleMusicApp {
    private static final SongService songService = new SongService();
    private static final ArtistService artistService = new ArtistService();
    private static final UserService userService = new UserService();
    private static final PlaylistService playlistService = new PlaylistService();

    static {
        try {
            // Set the LogManager system property before any logging occurs
            System.setProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager");
            
            // Initialize LogManager
            LogManager.getLogManager().reset();
            
            // Configure logging
            InputStream is = ConsoleMusicApp.class.getClassLoader().getResourceAsStream("logging.properties");
            if (is != null) {
                LogManager.getLogManager().readConfiguration(is);
                System.out.println("Logging configuration loaded successfully");
            } else {
                System.err.println("Could not find logging.properties");
            }
        } catch (Exception e) {
            System.err.println("Error configuring logging: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Starting application...");
            
            // Initialize services
            System.out.println("Initializing services...");
            try {
                songService.toString(); // Force initialization
                artistService.toString();
                userService.toString();
                playlistService.toString();
                System.out.println("Services initialized successfully.");
            } catch (Exception e) {
                System.err.println("Error initializing services: " + e.getMessage());
                e.printStackTrace();
                throw e;
            }

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nMusic Streaming Console App");
                System.out.println("1. Display all songs");
                System.out.println("2. Display songs by artist");
                System.out.println("3. Display all artists");
                System.out.println("4. Display all users");
                System.out.println("5. Display all playlists");
                System.out.println("6. Add new song");
                System.out.println("7. Add new artist");
                System.out.println("8. Exit");
                System.out.print("Choose an option: ");

                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            displayAllSongs();
                            break;
                        case 2:
                            displaySongsByArtist(scanner);
                            break;
                        case 3:
                            displayAllArtists();
                            break;
                        case 4:
                            displayAllUsers();
                            break;
                        case 5:
                            displayAllPlaylists();
                            break;
                        case 6:
                            addNewSong(scanner);
                            break;
                        case 7:
                            addNewArtist(scanner);
                            break;
                        case 8:
                            System.out.println("Exiting...");
                            scanner.close();
                            return;
                        default:
                            System.out.println("Invalid option. Try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    e.printStackTrace();
                    scanner.nextLine(); // Clear the input buffer
                }
            }
        } catch (Exception e) {
            System.err.println("Fatal error during initialization: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        } finally {
            try {
                JPAUtil.close();
            } catch (Exception e) {
                System.err.println("Error closing JPA resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void displayAllSongs() {
        List<Song> songs = songService.getAllSongs();
        System.out.println("\nAll Songs:");
        for (Song song : songs) {
            System.out.println("- " + song.title + " (Duration: " + song.duration + "s, Release: " + song.releaseDate + ")");
        }
    }

    private static void displaySongsByArtist(Scanner scanner) {
        System.out.print("Enter Artist ID: ");
        try {
            long artistId = scanner.nextLong();
            scanner.nextLine(); // Consume newline
            List<Song> songs = songService.getSongsByArtist(artistId);
            System.out.println("\nSongs by Artist ID " + artistId + ":");
            for (Song song : songs) {
                System.out.println("- " + song.title + " (Duration: " + song.duration + "s, Release: " + song.releaseDate + ")");
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid artist ID or no songs found.");
        }
    }

    private static void displayAllArtists() {
        List<Artist> artists = artistService.getAllArtists();
        System.out.println("\nAll Artists:");
        for (Artist artist : artists) {
            System.out.println("- " + artist.name + " (Genre: " + artist.genre + ", Country: " + artist.country + ")");
        }
    }

    private static void displayAllUsers() {
        List<User> users = userService.getAllUsers();
        System.out.println("\nAll Users:");
        for (User user : users) {
            System.out.println("- " + user.name + " (Email: " + user.email + ", Role: " + user.role + ")");
        }
    }

    private static void displayAllPlaylists() {
        List<Playlist> playlists = playlistService.getAllPlaylists();
        System.out.println("\nAll Playlists:");
        for (Playlist playlist : playlists) {
            System.out.println("- " + playlist.name + " (User: " + playlist.user.name + ")");
        }
    }

    private static void addNewSong(Scanner scanner) {
        try {
            System.out.println("\nAdd New Song");
            System.out.print("Enter song title: ");
            String title = scanner.nextLine();
            
            System.out.print("Enter duration (in seconds): ");
            int duration = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            System.out.print("Enter release date (YYYY-MM-DD): ");
            String releaseDate = scanner.nextLine();
            
            // Display available artists
            List<Artist> artists = artistService.getAllArtists();
            System.out.println("\nAvailable Artists:");
            for (Artist artist : artists) {
                System.out.println(artist.id + ". " + artist.name);
            }
            
            System.out.print("Enter Artist ID (or 0 to skip): ");
            long artistId = scanner.nextLong();
            scanner.nextLine(); // Consume newline
            
            Song song = new Song();
            song.title = title;
            song.duration = duration;
            song.releaseDate = releaseDate;
            
            // Link with artist if one was selected
            if (artistId > 0) {
                Artist artist = artistService.getArtistById(artistId);
                if (artist != null) {
                    song.artists = List.of(artist);
                } else {
                    System.out.println("Warning: Artist not found. Song will be saved without artist.");
                }
            }
            
            songService.save(song);
            System.out.println("Song added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding song: " + e.getMessage());
        }
    }

    private static void addNewArtist(Scanner scanner) {
        try {
            System.out.println("\nAdd New Artist");
            System.out.print("Enter artist name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter genre: ");
            String genre = scanner.nextLine();
            
            System.out.print("Enter country: ");
            String country = scanner.nextLine();
            
            Artist artist = new Artist();
            artist.name = name;
            artist.genre = genre;
            artist.country = country;
            
            artistService.save(artist);
            System.out.println("Artist added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding artist: " + e.getMessage());
        }
    }
}
