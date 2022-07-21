CREATE TABLE `client` (
     `id` INT(11) NOT NULL AUTO_INCREMENT,
     `FIRST_NAME` VARCHAR(255) NULL,
     `LAST_NAME` VARCHAR(255) NULL,
     `address` VARCHAR(255) NULL,
     `birthdate` DATE NULL,
     PRIMARY KEY (`id`)
);

CREATE TABLE `account` (
     `id` INT(11) NOT NULL AUTO_INCREMENT,
     `client_id` INT(11) NOT NULL,
     `creation_date` TIMESTAMP NULL,
     `balance` FLOAT NULL,
     PRIMARY KEY (`id`)
);

CREATE TABLE `operation` (
     `id` INT(11) NOT NULL AUTO_INCREMENT,
     `account_id` INT(11) NOT NULL,
     `creation_date` TIMESTAMP NULL,
     `type` VARCHAR(255) NULL,
     `amount` FLOAT NULL,
     `balance` FLOAT NULL,
     PRIMARY KEY (`id`)
);
