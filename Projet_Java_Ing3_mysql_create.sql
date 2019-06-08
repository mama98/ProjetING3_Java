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
	`note` DOUBLE,
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

INSERT INTO `AnneeScolaire` (`id`) VALUES
('2015'), ('2016'),('2017'), ('2018'), ('2019');

INSERT INTO `Ecole` (`id`, `nom`) VALUES
('1', 'ECE'), ('2', 'EPITA'), ('3', 'ESTACA'), ('4', 'ESILV'), ('5', 'EPF');

INSERT INTO `Discipline` (`id`, `nom`) VALUES
('1', 'Informatique'), ('2', 'Mathématiques'), ('3', 'Physique'), ('4', 'Electronique'), ('5', 'Anglais'),
('6', 'Espagnol'), ('7', 'Japonais'), ('8', 'Droit');

INSERT INTO `Niveau` (`id`, `nom`) VALUES
('1', 'ING1'), ('2', 'ING2'), ('3', 'ING3'), ('4', 'ING4'), ('5', 'ING5');

INSERT INTO `Classe` (`id`, `nom`, `id_AnneeScolaire`, `id_Ecole`, `id_Niveau`) VALUES
('1', 'TD01', '2019', '1', '3'), ('2', 'TD02', '2019', '1', '3'), ('3', 'TD03', '2019', '1', '3'),
('4', 'TD04', '2018', '1', '3'), ('5', 'TD05', '2019', '1', '3'), ('6', 'TD02', '2019', '2', '2');

INSERT INTO `Personne` (`id`, `nom`, `prenom`, `login`, `password`, `type_Enseignant`) VALUES
('1', 'Beurotte', 'Marine', 'mama', 'beubeu', '0'), ('2', 'Ricout', 'Valentine', 'vava', 'riri', '1'),
('3', 'Hubert', 'Philippe', 'phiphi', 'huhu', '0'), ('4', 'Cohen', 'Arthur', 'arar', 'coco', '1'),
('5', 'Afkir', 'Sophia', 'soso', 'afaf', '0'), ('6', 'Poissonnier', 'Terence', 'tete', 'poipoi', '1'),
('7', 'Chamouard', 'Laure', 'lolo', 'chacha', '0'), ('8', 'Rossignol', 'Paul-Louis', 'popo', 'roro', '1'),
('9', 'Le Du', 'Laure', 'laulau', 'lele', '0'), ('10', 'Planchard', 'Malo', 'malo', 'coco', '1'),
('11', 'Rabillard', 'Paul', 'paul', 'rara', '0'), ('12', 'Lemercier', 'Thomas', 'toto', 'lele', '1'),
('13', 'Montoute', 'Kerwan', 'keke', 'monmon', '0'), ('14', 'Lenclud', 'Gregoire', 'greg', 'lele', '1'),
('15', 'Jogarajah', 'Kishor', 'kiki', 'jojo', '0'), ('16', 'Devincre', 'Leonard', 'leo', 'dede', '1'),
 ('17', 'Corbet', 'Alexandre', 'alex', 'coco', '0'), ('18', 'Chhem', 'Serina', 'sese', 'cheche', '1'),
 ('19', 'Carlier', 'Helene', 'hehe', 'caca', '0'), ('20', 'Jouvet', 'Tom', 'tomtom', 'joujou', '1');
 
INSERT INTO `Inscription` (`id`, `id_Classe`, `id_Personne`) VALUES
('1', '5', '1'), ('2', '3', '3'), ('3', '1', '5'), ('4', '1', '7'), ('5', '2', '9'), ('6', '4', '11'),
('7', '4', '13'), ('8', '6', '15'), ('9', '5', '17'), ('10', '3', '19');

INSERT INTO `Enseignement` (`id`, `id_Classe`, `id_Discipline`, `id_Personne`) VALUES
('1', '5', '1', '4'), ('2', '3', '2', '2'),
('3', '2', '1', '4'), ('4', '6', '2', '2'),
('5', '1', '1', '4'), ('6', '4', '2', '2');

INSERT INTO `Trimestre` (`id`, `numero`, `debut`, `fin`, `id_AnneeScolaire`) VALUES
('1', '1', '2018-09-01', '2018-12-15', '2018'), ('2', '2', '2018-12-15', '2019-03-15', '2019'),
('3', '3', '2019-03-15', '2019-06-15', '2019');

INSERT INTO `Bulletin` (`id`, `nom`, `appreciation`, `id_Trimestre`, `id_Inscription`) VALUES 
('1', 'Bulletin 2018', 'Très bon trimestre, continuez comme ça!', '1', '1'), 
('2', 'Bulletin 2019', 'Quelques lacunes en mathématiques veuillez poursuivre vos efforts.', '2', '1'), 
('3', 'Bulletin 2019', 'Bon trimestre dans l\'ensemble.', '3', '1'), 
('4', 'Bulletin 2019', 'Quelques lacunes en électronique, poursuivez vos efforts!', '2', '2'),
('5', 'Bulletin 2017', 'Mauvais trimestre ! Les soirées ne sont pas plus importantes que le travail.', '3', '2'),
('6', 'Bulletin 2017', 'Des difficultés en physique. Il faut persévérer.', '1', '3'),
('7', 'Bulletin 2018', 'Trimestre correct.', '2', '3'),
('8', 'Bulletin 2018', 'Excellent travail !', '1', '4'),
('9', 'Bulletin 2018', 'Très bon trimestre. Petit relachement en mathématiques.', '2', '4'),
('10', 'Bulletin 2015', 'Bon travail dans l\'ensemble.', '1', '5'),
('11', 'Bulletin 2016', 'Trop d\'absences ce semestre.', '2', '5'),
('12', 'Bulletin 2017', 'Très bon travail, continuez !', '3', '6'),
('13', 'Bulletin 2019', 'Des lacunes en informatique. Bon travail en physique.', '1', '6'),
('14', 'Bulletin 2018', 'Bon travail dans l\'ensemble.', '1', '7'),
('15', 'Bulletin 2018', 'Ensemble fragile. Poursuivez vos efforts !', '3', '7'),
('16', 'Bulletin 2015', 'Attention aux bavardages !', '2', '8'),
('17', 'Bulletin 2016', 'Ne pas se laisser embarquer par l\'ambiance peu sérieuse de la classe.', '2', '8'),
('18', 'Bulletin 2015', 'Soyez plus attentif en cours.', '1', '9'),
('19', 'Bulletin 2016', 'Manque de travail.', '2', '9'), 
('20', 'Bulletin 2018', 'Bon trimestre sauf en électronique.', '1', '10'), 
('21', 'Bulletin 2018', 'Des progrès en informatique ! Continuez comme ça.', '2', '10'), 
('22', 'Bulletin 2019', 'Bon trimestre !', '3', '10');

INSERT INTO `DetailBulletin` (`id`, `appreciation`, `id_Bulletin`, `id_Enseignement`) VALUES
('1', 'Bon niveau en informatique, élève très motivée ', '1', '1'),
('2', 'Niveau satisfaisant en mathématique, continuez vos efforts', '1', '2'),
('3', 'Bon travail', '2', '3'), ('4', 'Satisfaisant', '2', '4'),
('5', 'Moyen', '3', '5'), ('6', 'Médiocre', '3', '6'),
('7', 'Très bien', '4', '2'), ('8', 'Parfait', '4', '5'),
('9', 'Bien', '5', '3'), ('10', 'Très moyen', '6', '5');

INSERT INTO `Evaluation` (`id`, `note`, `appreciation`, `id_DetailBulletin`) VALUES
('1', '15', 'TP 1 Qestion 6: non respect de la consigne', '1'),
('2', '17', 'Projet Web Dynamique complet, manque les ventes flash', '1'),
('3', '12', 'Satisfaisant', '2'), ('4', '13', 'Bien', '2'),
('5', '10', 'Moyen', '3'), ('6', '8', 'Insuffisant', '3'),
('7', '6', 'Médiocre', '4'), ('8', '13', 'Excellent', '4'),
('9', '19', 'Très bon travail', '5'), ('10', '7', 'Très moyen', '5'),
('11', '20', 'Parfait', '6'), ('12', '13', 'Bon travail', '6'),
('13', '9.5', 'Moyen', '7'), ('14', '6', 'Peu d\'investissement', '7'),
('15', '4', 'Médiocre', '8'), ('16', '14', 'Bien', '8'),
('17', '12', 'Satisfaisant', '9'), ('18', '20', 'Parfait', '9'),
('19', '15', 'Bon travail', '9'), ('20', '20', 'Excellent', '10'),
('21', '18', 'Très bon travail', '10'), ('22', '9', 'Assez bien', '10');