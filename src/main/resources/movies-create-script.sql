# 1. go get the json file from glitch
# 2. copypasta into a new json file under /resources

# --> You may need to establish a connection to your localhost db here

# 3. create the movies_db

# 4. use the movies_db

# 5. drop the table(s) to which no other tables are dependent (none at first)

# 6. map the json movie properties to movies table columns
# --> start with just a movies table with all the columns found in the movie json properties

# 6a. Run the script to make sure it works

# 7. refactor to extract the directors to a new table with just an id and name
# --> change the movies table to reference the directors table via Foreign Key
# --> now that movies is dependent on directors, you need to move directors above movies in the script

# 8. Go add DROP IF EXIST statements for movies and directors

# 9. RUN IT!

use movies_db;

DROP TABLE IF EXISTS movie_actors;
DROP TABLE IF EXISTS movie_genre;
DROP TABLE IF EXISTS actors;
DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS directors;



CREATE TABLE IF NOT EXISTS directors
(
    id   INT unsigned not null auto_increment,
    Name varchar(120),
    primary key (id)

);

CREATE TABLE IF NOT EXISTS movies
(
    id    INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    year  CHAR(4)      NOT NULL,
    plot  TEXT,
    director_id INT unsigned not null,
    PRIMARY KEY (id),
    FOREIGN KEY (director_id) REFERENCES directors (id)
);


# CREATE TABLE IF NOT EXISTS movies
# (
#     Title       varchar(155) not null,
#     Year        char(4)      not null,
#     Plot        TEXT         not null,
#     Poster      varchar(255),
#     id          INT unsigned not null auto_increment,
#     director_id INT unsigned not null,
#     primary key (id),
#     foreign key (director_id) REFERENCES directors (id)
# );

CREATE TABLE IF NOT EXISTS genres
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(32),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS movie_genre
(
    movie_id INT UNSIGNED NOT NULL,
    genre_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies (id),
    FOREIGN KEY (genre_id) REFERENCES genres (id)
);

CREATE TABLE IF NOT EXISTS actors
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS movie_actors
(
    movie_id INT UNSIGNED NOT NULL,
    actor_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies (id),
    FOREIGN KEY (actor_id) REFERENCES actors (id)
);






