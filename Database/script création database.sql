create database pe2idatabase;


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
    TypeU varchar(10) NOT NULL check(TypeU="enseignant" or TypeU="etudiant" or TypeU="bde")
);
create table Enseigne(
	id_Enseigne int PRIMARY KEY auto_increment,
    Nom varchar(30) NOT NULL UNIQUE,
    Adresse varchar(100) NOT NULL,
    Code_Postal int NOT NULL,
    Ville varchar(50) NOT NULL
);

create table UtilisateurEnseigne(
	id_Utilisateur char(8) NOT NULL,
    id_Enseigne int NOT NULL,
    FOREIGN KEY(id_Utilisateur) REFERENCES Utilisateur(id_Utilisateur),
    FOREIGN KEY(id_Enseigne) REFERENCES Enseigne(id_Enseigne),
    PRIMARY KEY(id_Utilisateur,id_Enseigne)
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


/*****************************************************************************************************************************************************************/
/********************************************************************Jeu de données*******************************************************************************/
/*****************************************************************************************************************************************************************/

/****** Utilisateurs *******/
INSERT INTO Utilisateur VALUES ('brf2125a','Bremec','Florian','mdpflo','1997-06-21','17C Avenu du Gers',31270,'Frouzins','',0781734740,'fbremec@gmail.com','etudiant');
INSERT INTO Utilisateur VALUES ('rgv2021a','Argenty','Valentin','mdpval','1997-03-09','13 rue Jules Verne',31270,'Frouzins','',0666247082,'valentin.argenty@gmail.com','etudiant');
INSERT INTO Utilisateur VALUES ('tes1234e','DeTest','Test','mdptest','0001-01-01','1 rue Test',12345,'Testville','',012346789,'test.test@test.com','etudiant'); 

/****** Enseignes *******/
INSERT INTO Enseigne VALUES (1,'IUT Informatique','128 Route de Rangueil',31100,'Toulouse');

/****** Enseignes + Utilisateurs *******/
INSERT INTO Utilisateurenseigne VALUES ('brf2125a',1);
INSERT INTO Utilisateurenseigne VALUES ('rgv2021a',1);
INSERT INTO Utilisateurenseigne VALUES ('tes1234e',1);

/****** Promotions *******/
INSERT INTO Promotion(id_Enseigne, Annee) VALUES (1,2017);

/****** Semestres *******/
INSERT INTO Semestre VALUES (1,1,1,1),(2,1,1,2),(3,1,1,3),(4,1,1,4);

/****** Groupes *******/
INSERT INTO Groupe VALUES (1,1,'E');

/****** Ues *******/
INSERT INTO Ue VALUES (1,1,1,1,'Base de l\'informatique'),(2,1,1,2,'Gestion d\'un système');

/****** Modules *******/
INSERT INTO Module VALUES (1,1,'M1101','Base de l\'architecture système'),(2,1,'M1102','Base d\'un système');
INSERT INTO Module VALUES (3,2,'M1201','caca');

/****** Forums *******/
INSERT INTO Forum VALUES (1,1,'Travaux Pratiques','viescolaire'),(2,1,'Cours','viescolaire'),(3,1,'Travaux Dirigés','viescolaire'),(4,1,'Partiels','viescolaire');

/****** Modules + Forums *******/
INSERT INTO ForumModule VALUES (1,1);
INSERT INTO ForumModule VALUES (1,2);

/****** Sujets *******/
INSERT INTO Sujet VALUES (1,1,1,'Installation d\'une machine virtuelle Linux',1,'2016-12-08');
INSERT INTO Sujet VALUES (2,1,1,'Configuration de Linux',2, '2016-10-13');
INSERT INTO Sujet VALUES (3,1,1,'Suppression de linux',3, '2016-10-14');
INSERT INTO Sujet VALUES (4,1,2,'Suppression de linux 2',4, '2016-10-14');

<<<<<<< HEAD
/****** Commentaires *******/
INSERT INTO Commentaire VALUES (1,'brf2125a',1,'Comment on installe Linux ?','Bonjour j\'ai un problème.','en cours','2016-12-09');

/****** Réponses *******/
INSERT INTO Reponse VALUES (1,1,'brf2125a','On fait comme ça.','2016-12-10');
=======
select * FROM REPONSE WHERE id_Commentaire = 1;

select *
from forum;

alter table Sujet ADD datePubli date;

update Sujet set datePubli = 12/10/2016
where id_sujet = 1;
>>>>>>> 25092b7da95738ae503e0556194b6ae47b1a1217

/****** Documents *******/
INSERT INTO Document VALUES (1,1,1,'brf2125a','lien','2016-12-10','document installation linux');
INSERT INTO Document(id_Sujet, id_Utilisateur, Lien, DateD, Nom) VALUES (1,'rgv2021a','lien','2016-11-11','correction');