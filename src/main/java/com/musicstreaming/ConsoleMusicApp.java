package com.musicstreaming;

import com.musicstreaming.entity.Song;
import com.musicstreaming.service.SongService;
import java.util.List;
import java.util.Scanner;

public class ConsoleMusicApp {
    private static final SongService songService = new SongService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMusic Streaming Console App");
            System.out.println("1. Display all songs");
            System.out.println("2. Display songs by artist");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllSongs();
                    break;
                case 2:
                    System.out.print("Enter Artist ID: ");
                    Long artistId = scanner.nextLong();
                    displaySongsByArtist(artistId);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void displayAllSongs() {
        List<Song> songs = songService.getAllSongs();
        System.out.println("\nAll Songs:");
        for (Song song : songs) {
            System.out.println("- " + song.title);
        }
    }

    private static void displaySongsByArtist(Long artistId) {
        List<Song> songs = songService.getSongsByArtist(artistId);
        System.out.println("\nSongs by Artist ID " + artistId + ":");
        for (Song song : songs) {
            System.out.println("- " + song.title);
        }
    }
}
