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
	`AnneeScolaire.id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Niveau` (
	`id` INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Classe` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` varchar(255) NOT NULL,
	`AnneeScolaire.id` INT NOT NULL,
	`Ecole.id` INT NOT NULL,
	`Niveau.id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Inscription` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`Classe.id` INT NOT NULL,
	`Personne.id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Bulletin` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`appreciation` varchar(255) NOT NULL,
	`Trimestre.id` varchar(255) NOT NULL,
	`Inscription.id` varchar(255) NOT NULL,
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
	`type` enum ('Enseignant',
				 'Eleve') NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Enseignement` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`Classe.id` INT NOT NULL,
	`Discipline.id` INT NOT NULL,
	`Personne.id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `DetailBulletin` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`appreciation` varchar(255) NOT NULL,
	`Bulletin.id` INT NOT NULL,
	`Enseignement.id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Evaluation` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`note` INT NOT NULL,
	`appreciation` varchar(255) NOT NULL,
	`DetailBulletin.id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Trimestre` ADD CONSTRAINT `Trimestre_fk0` FOREIGN KEY (`AnneeScolaire.id`) REFERENCES `AnneeScolaire`(`id`);

ALTER TABLE `Classe` ADD CONSTRAINT `Classe_fk0` FOREIGN KEY (`AnneeScolaire.id`) REFERENCES `AnneeScolaire`(`id`);

ALTER TABLE `Classe` ADD CONSTRAINT `Classe_fk1` FOREIGN KEY (`Ecole.id`) REFERENCES `Ecole`(`id`);

ALTER TABLE `Classe` ADD CONSTRAINT `Classe_fk2` FOREIGN KEY (`Niveau.id`) REFERENCES `Niveau`(`id`);

ALTER TABLE `Inscription` ADD CONSTRAINT `Inscription_fk0` FOREIGN KEY (`Classe.id`) REFERENCES `Classe`(`id`);

ALTER TABLE `Inscription` ADD CONSTRAINT `Inscription_fk1` FOREIGN KEY (`Personne.id`) REFERENCES `Personne`(`id`);

ALTER TABLE `Bulletin` ADD CONSTRAINT `Bulletin_fk0` FOREIGN KEY (`Trimestre.id`) REFERENCES `Trimestre`(`id`);

ALTER TABLE `Bulletin` ADD CONSTRAINT `Bulletin_fk1` FOREIGN KEY (`Inscription.id`) REFERENCES `Inscription`(`id`);

ALTER TABLE `Enseignement` ADD CONSTRAINT `Enseignement_fk0` FOREIGN KEY (`Classe.id`) REFERENCES `Classe`(`id`);

ALTER TABLE `Enseignement` ADD CONSTRAINT `Enseignement_fk1` FOREIGN KEY (`Discipline.id`) REFERENCES `Discipline`(`id`);

ALTER TABLE `Enseignement` ADD CONSTRAINT `Enseignement_fk2` FOREIGN KEY (`Personne.id`) REFERENCES `Personne`(`id`);

ALTER TABLE `DetailBulletin` ADD CONSTRAINT `DetailBulletin_fk0` FOREIGN KEY (`Bulletin.id`) REFERENCES `Bulletin`(`id`);

ALTER TABLE `DetailBulletin` ADD CONSTRAINT `DetailBulletin_fk1` FOREIGN KEY (`Enseignement.id`) REFERENCES `Enseignement`(`id`);

ALTER TABLE `Evaluation` ADD CONSTRAINT `Evaluation_fk0` FOREIGN KEY (`DetailBulletin.id`) REFERENCES `DetailBulletin`(`id`);

