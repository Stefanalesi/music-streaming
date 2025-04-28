INSERT INTO USER (name, email, role, user_type) VALUES ('john_doe', 'john@example.com', 'NORMAL', 'NORMAL');
INSERT INTO USER (name, email, role, user_type) VALUES ('jane_doe', 'jane@example.com', 'NORMAL', 'NORMAL');
INSERT INTO USER (name, email, role, user_type, hasAdFreeExperience) VALUES ('alice_smith', 'alice@example.com', 'PREMIUM', 'PREMIUM', true);
INSERT INTO USER (name, email, role, user_type, hasAdFreeExperience) VALUES ('bob_jones', 'bob@example.com', 'PREMIUM', 'PREMIUM', true);

INSERT INTO USER (name, email, role, user_type, genre, country) VALUES ('Drake', 'drake@example.com', 'ARTIST', 'ARTIST', 'Hip-Hop', 'Canada');
INSERT INTO USER (name, email, role, user_type, genre, country) VALUES ('Adele', 'adele@example.com', 'ARTIST', 'ARTIST', 'Pop', 'UK');
INSERT INTO USER (name, email, role, user_type, genre, country) VALUES ('The Weeknd', 'weeknd@example.com', 'ARTIST', 'ARTIST', 'R&B', 'Canada');
INSERT INTO USER (name, email, role, user_type, genre, country) VALUES ('Eminem', 'eminem@example.com', 'ARTIST', 'ARTIST', 'Rap', 'USA');
INSERT INTO USER (name, email, role, user_type, genre, country) VALUES ('Beyoncé', 'beyonce@example.com', 'ARTIST', 'ARTIST', 'Pop', 'USA');

INSERT INTO SONG (title, duration, releaseDate) VALUES ('God''s Plan', 198, '2018-01-19');
INSERT INTO SONG (title, duration, releaseDate) VALUES ('Rolling in the Deep', 228, '2010-11-29');
INSERT INTO SONG (title, duration, releaseDate) VALUES ('Blinding Lights', 200, '2019-11-29');
INSERT INTO SONG (title, duration, releaseDate) VALUES ('Hotline Bling', 267, '2015-07-31');
INSERT INTO SONG (title, duration, releaseDate) VALUES ('Lose Yourself', 312, '2002-10-28');
INSERT INTO SONG (title, duration, releaseDate) VALUES ('Halo', 261, '2008-12-12');
INSERT INTO SONG (title, duration, releaseDate) VALUES ('Stan', 267, '2000-11-21');
INSERT INTO SONG (title, duration, releaseDate) VALUES ('Single Ladies', 195, '2008-10-13');
INSERT INTO SONG (title, duration, releaseDate) VALUES ('Starboy', 230, '2016-09-21');
INSERT INTO SONG (title, duration, releaseDate) VALUES ('Hello', 295, '2015-10-23');

INSERT INTO PLAYLIST (name, user_id) VALUES ('My Favorites', 1);
INSERT INTO PLAYLIST (name, user_id) VALUES ('Chill Vibes', 2);
INSERT INTO PLAYLIST (name, user_id) VALUES ('Workout Mix', 3);
INSERT INTO PLAYLIST (name, user_id) VALUES ('Relaxing Tunes', 4);

INSERT INTO song_artist (song_id, artist_id) VALUES (1, 5);
INSERT INTO song_artist (song_id, artist_id) VALUES (2, 6);
INSERT INTO song_artist (song_id, artist_id) VALUES (3, 7);
INSERT INTO song_artist (song_id, artist_id) VALUES (4, 5);
INSERT INTO song_artist (song_id, artist_id) VALUES (5, 8);
INSERT INTO song_artist (song_id, artist_id) VALUES (6, 9);
INSERT INTO song_artist (song_id, artist_id) VALUES (7, 8);
INSERT INTO song_artist (song_id, artist_id) VALUES (8, 9);
INSERT INTO song_artist (song_id, artist_id) VALUES (9, 7);
INSERT INTO song_artist (song_id, artist_id) VALUES (10, 6);

INSERT INTO playlist_song (playlist_id, song_id) VALUES (1, 1);
INSERT INTO playlist_song (playlist_id, song_id) VALUES (1, 3);
INSERT INTO playlist_song (playlist_id, song_id) VALUES (2, 2);
INSERT INTO playlist_song (playlist_id, song_id) VALUES (2, 4);
INSERT INTO playlist_song (playlist_id, song_id) VALUES (3, 5);
INSERT INTO playlist_song (playlist_id, song_id) VALUES (3, 6);
INSERT INTO playlist_song (playlist_id, song_id) VALUES (4, 7);
INSERT INTO playlist_song (playlist_id, song_id) VALUES (4, 8);
INSERT INTO playlist_song (playlist_id, song_id) VALUES (4, 9);
INSERT INTO playlist_song (playlist_id, song_id) VALUES (4, 10);
