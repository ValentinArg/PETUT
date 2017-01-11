
create database pe2idatabase;


create table Enseigne(
	id_Enseigne int PRIMARY KEY auto_increment,
    Nom varchar(30) NOT NULL UNIQUE,
    Adresse varchar(100) NOT NULL,
    Code_Postal int NOT NULL,
    Ville varchar(50) NOT NULL
);


create table Promotion(
	id_Promotion int PRIMARY KEY auto_increment,
    id_Enseigne int NOT NULL,
    Annee smallint NOT NULL,
    FOREIGN KEY(id_Enseigne) REFERENCES Enseigne(id_Enseigne)
);

create table Semestre(
	id_Semestre int PRIMARY KEY auto_increment,
    id_Promotion int NOT NULL,
    id_Enseigne int NOT NULL,
    Numero tinyint NOT NULL,
    FOREIGN KEY(id_Promotion) REFERENCES Promotion(id_Promotion),
    FOREIGN KEY(id_Enseigne) REFERENCES Enseigne(id_Enseigne)
);

create table Ue(
	id_Ue int PRIMARY KEY auto_increment,
    id_Semestre int NOT NULL,
    id_Enseigne int NOT NULL,
    Numero tinyint NOT NULL,
    Libelle varchar(50) NOT NULL,
    FOREIGN KEY(id_Semestre) REFERENCES Semestre(id_Semestre),
    FOREIGN KEY(id_Enseigne) REFERENCES Enseigne(id_Enseigne)
);

create table Forum(
	id_Forum int PRIMARY KEY auto_increment,
    id_Enseigne int NOT NULL,
    Nom varchar(30) NOT NULL,
    TypeF varchar(30) NOT NULL check(TypeF="viescolaire" || TypeF="vieetudiante"),
    FOREIGN KEY(id_Enseigne) REFERENCES Enseigne(id_Enseigne)
);

create table Module(
	id_Module int PRIMARY KEY auto_increment,
    id_Ue int NOT NULL,
    Numero varchar(10) NOT NULL,
    Libelle varchar(100) NOT NULL
);

create table Groupe(
	id_Groupe int PRIMARY KEY auto_increment,
    id_Semestre int NOT NULL,
    Libelle varchar(10) NOT NULL,
    FOREIGN KEY(id_Semestre) REFERENCES Semestre(id_Semestre)
);


create table Utilisateur(
	id_Utilisateur char(8) PRIMARY KEY,
    Nom varchar(30) NOT NULL,
    Prenom varchar(30) NOT NULL,
	MotDePasse varchar(50) NOT NULL check(length(MotDePasse)>=5),
    DateNaissance date,
    Adresse varchar(100),
    Code_Postal int,
    Ville varchar(50),
    Photo varchar(500),
    Telephone int UNIQUE,
    Adresse_Mail varchar(50) UNIQUE check(AdresseMail like "%@%"),
    TypeU varchar(10) NOT NULL check(TypeU="enseignant" or TypeU="etudiant" or TypeU="bde"),
    id_Groupe int,
    FOREIGN KEY(id_Groupe) REFERENCES Groupe(Id_Groupe)
);

create table UtilisateurEnseigne(
	id_Utilisateur char(8) NOT NULL,
    id_Enseigne int NOT NULL,
    FOREIGN KEY(id_Utilisateur) REFERENCES Utilisateur(id_Utilisateur),
    FOREIGN KEY(id_Enseigne) REFERENCES Enseigne(id_Enseigne),
    PRIMARY KEY(id_Utilisateur,id_Enseigne)
);

create table ForumModule(
	id_Module int NOT NULL,
	id_Forum int NOT NULL,
    FOREIGN KEY(id_Module) REFERENCES Module(id_Module),
    FOREIGN KEY(id_Forum) REFERENCES Forum(id_Forum),
    PRIMARY KEY(id_Module,id_Forum)
);

create table Sujet(
	id_Sujet int PRIMARY KEY auto_increment,
    id_Module int NOT NULL,
	id_Forum int NOT NULL,
    Nom varchar(50) NOT NULL,
    Numero tinyint NOT NULL,
    DateS date NOT NULL,
    FOREIGN KEY(id_Module) REFERENCES ForumModule(id_Module),
    FOREIGN KEY(id_Forum) REFERENCES ForumModule(id_Forum)
);

create table Commentaire(
	id_Commentaire int PRIMARY KEY auto_increment,
    id_Utilisateur varchar(30) NOT NULL,
    id_Sujet int NOT NULL,
    Question varchar(1000) NOT NULL,
    Texte varchar(10000) NOT NULL,
    Statut varchar(20) NOT NULL check(Statut="en cours" || Statut="résolu"),
	DateC date NOT NULL,
    FOREIGN KEY(id_Sujet) REFERENCES Sujet(id_Sujet),
    FOREIGN KEY(id_Utilisateur) REFERENCES Utilisateur(id_Utilisateur)
);

create table Reponse(
	id_Reponse int PRIMARY KEY auto_increment,
    id_Commentaire int NOT NULL,
    id_Utilisateur varchar(30) NOT NULL,
    Texte varchar(10000) NOT NULL,
    DateR date NOT NULL,
    FOREIGN KEY(id_Commentaire) REFERENCES Commentaire(id_Commentaire),
    FOREIGN KEY(id_Utilisateur) REFERENCES Utilisateur(id_Utilisateur)
);

create table Document(
	id_Document int PRIMARY KEY auto_increment,
    id_Sujet int NOT NULL,
    id_Reponse int,
    id_Utilisateur varchar(30) NOT NULL,
    Lien varchar(500) NOT NULL,
    DateD date NOT NULL,
    Nom varchar(50),
    FOREIGN KEY(id_Sujet) REFERENCES Sujet(id_Sujet),
    FOREIGN KEY(id_Reponse) REFERENCES Reponse(id_Reponse),
    FOREIGN KEY(id_Utilisateur) REFERENCES Utilisateur(id_Utilisateur)
);

create table Evenement(
	id_Evenement int PRIMARY KEY auto_increment,
	id_Enseigne int NOT NULL,
    id_Utilisateur char(8) NOT NULL,
    Libelle varchar(50) NOT NULL,
    Adresse varchar(50) NOT NULL,
    Code_Postal int NOT NULL,
    Ville varchar(50) NOT NULL,
    DateHeureE datetime NOT NULL,
    TypeE varchar(30) NOT NULL check(TypeE="scolaire" || TypeE="etudiant"),
    FOREIGN KEY(id_Enseigne) REFERENCES Enseigne(id_Enseigne),
	FOREIGN KEY(id_Utilisateur) REFERENCES Utilisateur(id_Utilisateur)
);

create table Modification(
	id_Modification int PRIMARY KEY auto_increment,
    Libelle varchar(100) not null,
    Auteur varchar(50),
    TypeM varchar(50) not null check(TypeM="nouveaute" || TypeM="maintenance"),
    DateM date not null);


/*****************************************************************************************************************************************************************/
/********************************************************************Jeu de données*******************************************************************************/
/*****************************************************************************************************************************************************************/


/****** Enseignes *******/
INSERT INTO Enseigne VALUES (1,'IUT Informatique','128 Route de Rangueil',31100,'Toulouse');

/****** Promotions *******/
INSERT INTO Promotion(id_Enseigne, Annee) VALUES (1,2017);

/****** Semestres *******/
INSERT INTO Semestre VALUES (1,1,1,1),(2,1,1,2),(3,1,1,3),(4,1,1,4);


/****** Ues *******/
INSERT INTO Ue VALUES (1,1,1,1,'Base de l\'informatique'),(2,1,1,2,'Gestion d\'un système');

/****** Forums *******/
INSERT INTO Forum VALUES (1,1,'Travaux Pratiques','viescolaire'),(2,1,'Cours','viescolaire'),(3,1,'Travaux Dirigés','viescolaire'),(4,1,'Partiels','viescolaire');

/****** Modules *******/
INSERT INTO Module VALUES (1,1,'M1101','Base de l\'architecture système'),(2,1,'M1102','Base d\'un système');
INSERT INTO Module VALUES (3,2,'M1201','caca');

/****** Groupes *******/
INSERT INTO Groupe VALUES (1,1,'E');
INSERT INTO Groupe VALUES (2,1,'enseignant');


/****** Utilisateurs *******/
INSERT INTO Utilisateur VALUES ('brf2125a','Bremec','Florian','mdpflo','1997-06-21','17C Avenu du Gers',31270,'Frouzins','',0781734740,'fbremec@gmail.com','etudiant',1);
INSERT INTO Utilisateur VALUES ('rgv2021a','Argenty','Valentin','mdpval','1997-03-09','13 rue Jules Verne',31270,'Frouzins','',0666247082,'valentin.argenty@gmail.com','etudiant',1);
INSERT INTO Utilisateur VALUES ('tes1234e','DeTest','Test','mdptest','0001-01-01','1 rue Test',12345,'Testville','',012346789,'test.test@test.com','etudiant',1); 
INSERT INTO Utilisateur VALUES ('map2056a','Magnaud','Patrick','mdppatrick','1987-05-12','12rue des alouettes',31270,'Toulouse','',0561909652,'magnaud.patrick@gmail.com','ensignant',2); 
INSERT INTO Utilisateur VALUES ('mit3467a','Millan','Thierry','mdpmillan','1985-10-24','25 rue des bretzel',31270,'Toulouse','',0561909623,'millan.thierry@gmail.com','ensignant',2); 
INSERT INTO Utilisateur VALUES ('sed','Senouci','Dinard','mdpdinard','1978-02-13','54 bis rue des maths',31270,'Toulouse','',0561907862,'senouci.dinard@gmail.com','ensignant',2); 
INSERT INTO Utilisateur VALUES ('vif2674a','Viallet','Fabienne','mdpviallet','1965-05-12','10 avenue CDG',31270,'Toulouse','',0561913591,'viallet.fabienne@gmail.com','ensignant',2); 
INSERT INTO Utilisateur VALUES ('fej2610a','Ferenback','Jérome','mdpferenback','1978-01-18','15 rue python',31270,'Toulouse','',0561901352,'ferenback.jerome@gmail.com','ensignant',2); 
INSERT INTO Utilisateur VALUES ('mao0125a','Marquie','Olivier','mdpmarquie','1971-06-10','19 rue danemark',31270,'Toulouse','',0561901283,'marquie.olivier@gmail.com','ensignant',2); 



/****** Enseignes + Utilisateurs *******/
INSERT INTO Utilisateurenseigne VALUES ('brf2125a',1);
INSERT INTO Utilisateurenseigne VALUES ('rgv2021a',1);
INSERT INTO Utilisateurenseigne VALUES ('tes1234e',1);

/****** Modules + Forums *******/
INSERT INTO ForumModule VALUES (1,1);
INSERT INTO ForumModule VALUES (1,2);

/****** Sujets *******/
INSERT INTO Sujet VALUES (1,1,1,'Installation d\'une machine virtuelle Linux',1,'2016-12-08');
INSERT INTO Sujet VALUES (2,1,1,'Configuration de Linux',2, '2016-10-13');
INSERT INTO Sujet VALUES (3,1,1,'Suppression de linux',3, '2016-10-14');
INSERT INTO Sujet VALUES (4,1,2,'Suppression de linux 2',4, '2016-10-14');
INSERT INTO Sujet VALUES (5,1,1,'Valider votre adresse mail',5, '2016-10-11');
INSERT INTO Sujet VALUES (6,1,1,'Activer session CRDOC',6, '2016-11-02');
INSERT INTO Sujet VALUES (7,1,1,'Initiation Ada',7, '2016-11-04');
INSERT INTO Sujet VALUES (8,1,1,'Initiation algorithme',8, '2016-11-07');
INSERT INTO Sujet VALUES (9,1,1,'Création site html',9, '2016-11-11');
INSERT INTO Sujet VALUES (10,1,1,'Création MOF',10, '2016-11-13');
INSERT INTO Sujet VALUES (11,1,1,'Utilisation de linux',11, '2016-11-15');
INSERT INTO Sujet VALUES (12,1,1,'Instalation Package Linux',12, '2016-11-18');
INSERT INTO Sujet VALUES (13,1,1,'Création MOT',13, '2016-11-20');
INSERT INTO Sujet VALUES (14,1,1,'Zorglub Eclipse',14, '2016-12-02');
INSERT INTO Sujet VALUES (15,1,3,'Les champs',15, '2016-12-10');
INSERT INTO Sujet VALUES (16,1,4,'Partiel Ada Carré',16, '2016-12-10');

/****** Commentaires *******/
INSERT INTO Commentaire VALUES (1,'brf2125a',1,'Comment on installe Linux ?','Bonjour j\'ai un problème.','en cours','2016-12-09');
INSERT INTO Commentaire VALUES (2,'rgv2021a',7,'Comment créer une boucle ','Bonjour j\'ai un problème, je n\'arrive pas à mettre en place la boucle pour lE TP','en cours','2016-11-10');


/****** Réponses *******/
INSERT INTO Reponse VALUES (1,1,'brf2125a','On fait comme ça.','2016-12-10');

/****** Documents *******/
INSERT INTO Document VALUES (1,1,1,'brf2125a','lien','2016-12-10','document installation linux');
INSERT INTO Document(id_Sujet, id_Utilisateur, Lien, DateD, Nom) VALUES (1,'rgv2021a','lien','2016-11-11','correction');

/****** Modifications *******/
INSERT INTO Modification Values (1,'Ajout des news de modification','ValentinArg','nouveaute','2017-01-08');
INSERT INTO Modification VALUES (2,'Amélioration du rendu des pages','ValentinArg','maintenance','2017-01-10');
