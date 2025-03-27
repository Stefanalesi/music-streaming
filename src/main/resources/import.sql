INSERT INTO user (id, username, email) VALUES (1, 'john_doe', 'john@example.com');
INSERT INTO artist (id, name, genre) VALUES (1, 'Drake', 'Hip-Hop');
INSERT INTO song (id, title, duration, artist_id) VALUES (1, 'God\'s Plan', 198, 1);
INSERT INTO playlist (id, name, user_id) VALUES (1, 'My Favorites', 1);
INSERT INTO playlist_songs (playlist_id, song_id) VALUES (1, 1);
