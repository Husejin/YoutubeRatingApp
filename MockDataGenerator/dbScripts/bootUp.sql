DROP
DATABASE IF EXISTS Youtube_Rankings;

CREATE
DATABASE Youtube_Rankings;
USE
Youtube_Rankings;

DROP TABLE IF EXISTS allVideos;
CREATE TABLE `allVideos`
(
    `id`            INT(20) AUTO_INCREMENT,
    `name`          TEXT(100),
    `description`   TEXT(500),
    `allVotes`      INT unsigned DEFAULT '0',
    `positiveVotes` INT unsigned DEFAULT '0',
    `url`           TEXT(200),
    `thumbnailUrl`  TEXT(200),
    `alternateImage` LONGBLOB,
    PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS users;
CREATE TABLE `users`
(
    `id`       INT(20) AUTO_INCREMENT,
    `username` TEXT(100),
    `password` TEXT(100),
    `role`   TEXT(100),
    PRIMARY KEY (`id`)
);

