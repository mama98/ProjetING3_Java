
CREATE TABLE `Ecole` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `AnneeScolaire` (
	`id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Trimestre` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`numero` INT NOT NULL,
	`debut` date NOT NULL,
	`fin` date NOT NULL,
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
	`nom` varchar(255) NOT NULL,
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

INSERT INTO `AnneeScolaire` (`id`) VALUES ('2015'), ('2016'),('2017'), ('2018'), ('2019');
INSERT INTO `Ecole` (`id`, `nom`) VALUES ('1', 'ECE'), ('2', 'EPITA'), ('3', 'ESTACA'), ('4', 'ESILV'), ('5', 'EPF');
INSERT INTO `Discipline` (`id`, `nom`) VALUES ('1', 'Informatique'), ('2', 'Mathématiques'), ('3', 'Physique'), ('4', 'Electronique'), ('5', 'Anglais'), ('6', 'Espagnol'), ('7', 'Japonais'), ('8', 'Droit');
INSERT INTO `Niveau` (`id`, `nom`) VALUES ('1', 'ING1'), ('2', 'ING2'), ('3', 'ING3'), ('4', 'ING4'), ('5', 'ING5');
INSERT INTO `Classe` (`id`, `nom`, `id_AnneeScolaire`, `id_Ecole`, `id_Niveau`) VALUES ('1', 'TD01', '2019', '1', '3'), ('2', 'TD02', '2019', '1', '3'), ('3', 'TD03', '2019', '1', '3'), ('4', 'TD04', '2018', '1', '3'), ('5', 'TD05', '2019', '1', '3'), ('6', 'TD02', '2019', '2', '2');
INSERT INTO `Personne` (`id`, `nom`, `prenom`, `login`, `password`, `type_Enseignant`) VALUES ('1', 'Beurotte', 'Marine', 'mama', 'beubeu', '0'), ('2', 'Ricout', 'Valentine', 'vava', 'riri', '1'), ('3', 'Hubert', 'Philippe', 'phiphi', 'huhu', '0'), ('4', 'Cohen', 'Arthur', 'arar', 'coco', '1'), ('5', 'Afkir', 'Sophia', 'soso', 'afaf', '0'), ('6', 'Poissonnier', 'Terence', 'tete', 'poipoi', '1'), ('7', 'Chamouard', 'Laure', 'lolo', 'chacha', '0'),
 ('8', 'Rossignol', 'Paul-Louis', 'popo', 'roro', '1'), ('9', 'Le Du', 'Laure', 'laulau', 'lele', '0'), ('10', 'Planchard', 'Malo', 'malo', 'coco', '1'), ('11', 'Rabillard', 'Paul', 'paul', 'rara', '0'), ('12', 'Lemercier', 'Thomas', 'toto', 'lele', '1'), ('13', 'Montoute', 'Kerwan', 'keke', 'monmon', '0'), ('14', 'Lenclud', 'Gregoire', 'greg', 'lele', '1'), ('15', 'Jogarajah', 'Kishor', 'kiki', 'jojo', '0'), ('16', 'Devincre', 'Leonard', 'leo', 'dede', '1'),
 ('17', 'Corbet', 'Alexandre', 'alex', 'coco', '0'), ('18', 'Chhem', 'Serina', 'sese', 'cheche', '1'), ('19', 'Carlier', 'Helene', 'hehe', 'caca', '0'), ('20', 'Jouvet', 'Tom', 'tomtom', 'joujou', '1');
INSERT INTO `Inscription` (`id`, `id_Classe`, `id_Personne`) VALUES ('1', '5', '1'), ('2', '3', '3');
INSERT INTO `Enseignement` (`id`, `id_Classe`, `id_Discipline`, `id_Personne`) VALUES ('1', '5', '1', '4'), ('2', '3', '2', '2');
INSERT INTO `Trimestre` (`id`, `numero`, `debut`, `fin`, `id_AnneeScolaire`) VALUES ('1', '1', '2018-09-01', '2018-12-15', '2018'), ('2', '2', '2018-12-15', '2019-03-15', '2019'), ('3', '3', '2019-03-15', '2019-06-15', '2019');
INSERT INTO `Bulletin` (`id`, `nom`, `appreciation`, `id_Trimestre`, `id_Inscription`) VALUES ('1', 'Bulletin 2018', 'Très bon trimestre, continuez comme ça!', '1', '1'), ('2', 'Bulletin 2019', 'Quelques lacunes en mathématiques veuillez poursuivre vos efforts.', '2', '1'), ('3', 'Bulletin 2019', 'Bon trimestre dans l\'ensemble.', '3', '1'), ('4', 'Bulletin 2019', 'Quelques lacunes en électronique, poursuivez vos efforts!', '2', '2');
INSERT INTO `DetailBulletin` (`id`, `appreciation`, `id_Bulletin`, `id_Enseignement`) VALUES ('1', 'Bon niveau en informatique, élève très motivée ', '1', '1'), ('2', 'Niveau satisfaisant en mathématique, continuez vos efforts', '1', '2');
INSERT INTO `Evaluation` (`id`, `note`, `appreciation`, `id_DetailBulletin`) VALUES ('1', '15', 'TP 1 Qestion 6: non respect de la consigne', '1'), ('2', '17', 'Projet Web Dynamique complet, manque les ventes flash', '1'), ('3', '12', 'Satisfaisant', '2'), ('4', '13', 'Bien', '2');