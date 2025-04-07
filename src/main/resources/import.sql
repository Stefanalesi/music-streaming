INSERT INTO user (id, username, email) VALUES (1, 'john_doe', 'john@example.com');
INSERT INTO user (id, username, email) VALUES (2, 'jane_doe', 'jane@example.com');
INSERT INTO user (id, username, email) VALUES (3, 'alice_smith', 'alice@example.com');
INSERT INTO user (id, username, email) VALUES (4, 'bob_jones', 'bob@example.com');

INSERT INTO artist (id, name, genre) VALUES (1, 'Drake', 'Hip-Hop');
INSERT INTO artist (id, name, genre) VALUES (2, 'Adele', 'Pop');
INSERT INTO artist (id, name, genre) VALUES (3, 'The Weeknd', 'R&B');
INSERT INTO artist (id, name, genre) VALUES (4, 'Eminem', 'Rap');
INSERT INTO artist (id, name, genre) VALUES (5, 'Beyoncé', 'Pop');

INSERT INTO song (id, title, duration, artist_id) VALUES (1, 'God\'s Plan', 198, 1);
INSERT INTO song (id, title, duration, artist_id) VALUES (2, 'Rolling in the Deep', 228, 2);
INSERT INTO song (id, title, duration, artist_id) VALUES (3, 'Blinding Lights', 200, 3);
INSERT INTO song (id, title, duration, artist_id) VALUES (4, 'Hotline Bling', 267, 1);
INSERT INTO song (id, title, duration, artist_id) VALUES (5, 'Lose Yourself', 312, 4);
INSERT INTO song (id, title, duration, artist_id) VALUES (6, 'Halo', 261, 5);
INSERT INTO song (id, title, duration, artist_id) VALUES (7, 'Stan', 267, 4);
INSERT INTO song (id, title, duration, artist_id) VALUES (8, 'Single Ladies', 195, 5);
INSERT INTO song (id, title, duration, artist_id) VALUES (9, 'Starboy', 230, 3);
INSERT INTO song (id, title, duration, artist_id) VALUES (10, 'Hello', 295, 2);

INSERT INTO playlist (id, name, user_id) VALUES (1, 'My Favorites', 1);
INSERT INTO playlist (id, name, user_id) VALUES (2, 'Chill Vibes', 2);
INSERT INTO playlist (id, name, user_id) VALUES (3, 'Workout Mix', 3);
INSERT INTO playlist (id, name, user_id) VALUES (4, 'Relaxing Tunes', 4);

INSERT INTO playlist_songs (playlist_id, song_id) VALUES (1, 1);
INSERT INTO playlist_songs (playlist_id, song_id) VALUES (1, 3);
INSERT INTO playlist_songs (playlist_id, song_id) VALUES (2, 2);
INSERT INTO playlist_songs (playlist_id, song_id) VALUES (2, 4);
INSERT INTO playlist_songs (playlist_id, song_id) VALUES (3, 5);
INSERT INTO playlist_songs (playlist_id, song_id) VALUES (3, 6);
INSERT INTO playlist_songs (playlist_id, song_id) VALUES (4, 7);
INSERT INTO playlist_songs (playlist_id, song_id) VALUES (4, 8);
INSERT INTO playlist_songs (playlist_id, song_id) VALUES (4, 9);
INSERT INTO playlist_songs (playlist_id, song_id) VALUES (4, 10);
