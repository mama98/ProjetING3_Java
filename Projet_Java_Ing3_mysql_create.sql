CREATE TABLE `Ecole` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `AnneeScolaire` (
	`id` INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Trimestre` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`numero` INT NOT NULL,
	`debut` INT NOT NULL,
	`fin` INT NOT NULL,
	`id_AnneeScolaire` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Niveau` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Classe` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` varchar(255) NOT NULL,
	`id_AnneeScolaire` INT NOT NULL,
	`id_Ecole` INT NOT NULL,
	`id_Niveau` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Inscription` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_Classe` INT NOT NULL,
	`id_Personne` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Bulletin` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`appreciation` varchar(255) NOT NULL,
	`id_Trimestre` INT NOT NULL,
	`id_Inscription` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Discipline` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Personne` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` varchar(255) NOT NULL,
	`prenom` varchar(255) NOT NULL,
	`login` varchar(255) NOT NULL,
	`password` varchar(255) NOT NULL,
	`type_Enseignant` BOOLEAN,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Enseignement` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_Classe` INT NOT NULL,
	`id_Discipline` INT NOT NULL,
	`id_Personne` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `DetailBulletin` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`appreciation` varchar(255) NOT NULL,
	`id_Bulletin` INT NOT NULL,
	`id_Enseignement` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Evaluation` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`note` INT NOT NULL,
	`appreciation` varchar(255) NOT NULL,
	`id_DetailBulletin` INT NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Ecole` ENGINE = INNODB; 
ALTER TABLE `AnneeScolaire` ENGINE = INNODB; 
ALTER TABLE `Trimestre` ENGINE = INNODB; 
ALTER TABLE `Niveau` ENGINE = INNODB; 
ALTER TABLE `Classe` ENGINE = INNODB; 
ALTER TABLE `Inscription` ENGINE = INNODB; 
ALTER TABLE `Bulletin` ENGINE = INNODB; 
ALTER TABLE `Discipline` ENGINE = INNODB; 
ALTER TABLE `Personne` ENGINE = INNODB;
ALTER TABLE `Enseignement` ENGINE = INNODB; 
ALTER TABLE `DetailBulletin` ENGINE = INNODB; 
ALTER TABLE `Evaluation` ENGINE = INNODB; 

ALTER TABLE `Trimestre` ADD CONSTRAINT `Trimestre_fk0` FOREIGN KEY (`id_AnneeScolaire`) REFERENCES `AnneeScolaire`(`id`);

ALTER TABLE `Classe` ADD CONSTRAINT `Classe_fk0` FOREIGN KEY (`id_AnneeScolaire`) REFERENCES `AnneeScolaire`(`id`);

ALTER TABLE `Classe` ADD CONSTRAINT `Classe_fk1` FOREIGN KEY (`id_Ecole`) REFERENCES `Ecole`(`id`);

ALTER TABLE `Classe` ADD CONSTRAINT `Classe_fk2` FOREIGN KEY (`id_Niveau`) REFERENCES `Niveau`(`id`);

ALTER TABLE `Inscription` ADD CONSTRAINT `Inscription_fk0` FOREIGN KEY (`id_Classe`) REFERENCES `Classe`(`id`);

ALTER TABLE `Inscription` ADD CONSTRAINT `Inscription_fk1` FOREIGN KEY (`id_Personne`) REFERENCES `Personne`(`id`);

ALTER TABLE `Bulletin` ADD CONSTRAINT `Bulletin_fk0` FOREIGN KEY (`id_Trimestre`) REFERENCES `Trimestre`(`id`);

ALTER TABLE `Bulletin` ADD CONSTRAINT `Bulletin_fk1` FOREIGN KEY (`id_Inscription`) REFERENCES `Inscription`(`id`);

ALTER TABLE `Enseignement` ADD CONSTRAINT `Enseignement_fk0` FOREIGN KEY (`id_Classe`) REFERENCES `Classe`(`id`);

ALTER TABLE `Enseignement` ADD CONSTRAINT `Enseignement_fk1` FOREIGN KEY (`id_Discipline`) REFERENCES `Discipline`(`id`);

ALTER TABLE `Enseignement` ADD CONSTRAINT `Enseignement_fk2` FOREIGN KEY (`id_Personne`) REFERENCES `Personne`(`id`);

ALTER TABLE `DetailBulletin` ADD CONSTRAINT `DetailBulletin_fk0` FOREIGN KEY (`id_Bulletin`) REFERENCES `Bulletin`(`id`);

ALTER TABLE `DetailBulletin` ADD CONSTRAINT `DetailBulletin_fk1` FOREIGN KEY (`id_Enseignement`) REFERENCES `Enseignement`(`id`);

ALTER TABLE `Evaluation` ADD CONSTRAINT `Evaluation_fk0` FOREIGN KEY (`id_DetailBulletin`) REFERENCES `DetailBulletin`(`id`);

