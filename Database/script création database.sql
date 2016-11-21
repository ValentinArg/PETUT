create database pe2idatabase;


create table Utilisateur(
	id_Utilisateur varchar(30) PRIMARY KEY,
    Nom varchar(30) NOT NULL,
    Prenom varchar(30) NOT NULL,
    Adresse varchar(100),
    Code_Postal int,
    Ville varchar(50),
    Photo varchar(500),
    Telephone int,
    Adresse_Mail varchar(50) NOT NULL check(AdresseMail like "%@%"),
    Type_Utilisateur varchar(10) NOT NULL check(Type_Utilisateur like "enseignant" || Type_Utilisateur like "etudiant" || Type_Utilisateur like "bde")
);
create table Enseigne(
	id_Enseigne int PRIMARY KEY,
    Nom varchar(30) NOT NULL,
    Adresse varchar(100) NOT NULL,
    Code_Postal int NOT NULL,
    Ville varchar(50) NOT NULL
);

create table UtilisateurEnseigne(
	id_Utilisateur varchar(30) NOT NULL,
    id_Enseigne int NOT NULL,
    FOREIGN KEY(id_Utilisateur) REFERENCES Utilisateur(id_Utilisateur),
    FOREIGN KEY(id_Enseigne) REFERENCES Enseigne(id_Enseigne),
    PRIMARY KEY(id_Utilisateur,id_Enseigne)
);

create table Promotion(
	id_Promotion int PRIMARY KEY,
    id_Enseigne int NOT NULL,
    Annee smallint NOT NULL,
    FOREIGN KEY(id_Enseigne) REFERENCES Enseigne(id_Enseigne)
);

create table Semestre(
	id_Semestre int PRIMARY KEY,
    id_Promotion int NOT NULL,
    id_Enseigne int not null,
    Numero tinyint,
    FOREIGN KEY(id_Promotion) REFERENCES Promotion(id_Promotion),
    FOREIGN KEY(id_Enseigne) REFERENCES Enseigne(id_Enseigne)
);

create table Ue(
	id_Ue int PRIMARY KEY,
    id_Semestre int NOT NULL,
    id_Enseigne int NOT NULL,
    numero char(1),
    libelle varchar(50),
    FOREIGN KEY(id_Semestre) REFERENCES Semestre(id_Semestre),
    FOREIGN KEY(id_Enseigne) REFERENCES Enseigne(id_Enseigne)
);

create table Forum(
	id_Forum int PRIMARY KEY,
    id_Enseigne int NOT NULL,
    Nom varchar(30) NOT NULL,
    Type_Forum varchar(30) check(Type_Forum like "viescolaire" || Type_Forum like "vieetudiante"),
    FOREIGN KEY(id_Enseigne) REFERENCES Enseigne(id_Enseigne)
);

create table Module(
	id_Module int PRIMARY KEY,
    id_Ue int NOT NULL,
    Numero varchar(10),
    Libelle varchar(100) NOT NULL
    
);

create table Groupe(
	id_Groupe int PRIMARY KEY,
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
	id_Sujet int PRIMARY KEY,
    id_Module int NOT NULL,
	id_Forum int NOT NULL,
    Nom varchar(50) NOT NULL,
    Numero tinyint NOT NULL,
    FOREIGN KEY(id_Module) REFERENCES ForumModule(id_Module),
    FOREIGN KEY(id_Forum) REFERENCES ForumModule(id_Forum)
);

create table Commentaire(
	id_Commentaire int PRIMARY KEY,
    id_Utilisateur varchar(30) NOT NULL,
    id_Sujet int NOT NULL,
    Question varchar(1000) NOT NULL,
    Texte varchar(10000) NOT NULL,
    Statut varchar (20) NOT NULL check(Statut like "en cours" || Statut like "résolu"),
    Date_Commentaire char(20) NOT NULL check(date_Commentaire like "%/%/%"),
    nbReponse int,
    FOREIGN KEY(id_Sujet) REFERENCES Sujet(id_Sujet),
    FOREIGN KEY(id_Utilisateur) REFERENCES Utilisateur(id_Utilisateur)
);

create table Reponse(
	id_Reponse int PRIMARY KEY,
    id_Commentaire int NOT NULL,
    id_Utilisateur varchar(30) NOT NULL,
    Texte varchar(10000) NOT NULL,
    Date_Reponse char(20) NOT NULL check(date_Reponse like "%/%/%"),
    FOREIGN KEY(id_Commentaire) REFERENCES Commentaire(id_Commentaire),
    FOREIGN KEY(id_Utilisateur) REFERENCES Utilisateur(id_Utilisateur)
);

create table Document(
	id_Document int PRIMARY KEY,
    id_Sujet int,
    id_Reponse int,
    id_Utilisateur varchar(30),
    Lien varchar(500) NOT NULL,
    date_Document char(20) NOT NULL check(date_Document like "%/%/%"),
    Nom varchar(50),
    FOREIGN KEY(id_Sujet) REFERENCES Sujet(id_Sujet),
    FOREIGN KEY(id_Reponse) REFERENCES Reponse(id_Reponse),
    FOREIGN KEY(id_Utilisateur) REFERENCES Utilisateur(id_Utilisateur)
);

create table Evenement(
	id_Evenement int NOT NULL PRIMARY KEY,
	id_Enseigne int NOT NULL,
    id_Utilisateur int NOT NULL,
    Nom varchar(50) NOT NULL,
    Adresse varchar(50) NOT NULL,
    Code_Postal int NOT NULL,
    Vile varchar(50) NOT NULL,
    Date_Evenement char(10) NOT NULL check(date_Reponse like "%/%/%"),
    Heure char(5) NOT NULL check(Heure like "%H%"),
    Type_Evenement varchar(30) check(Type_Forum = "viescolaire" || Type_Forum = "vieetudiante"),
    FOREIGN KEY(id_Enseigne) REFERENCES Enseigne(id_Enseigne),
	FOREIGN KEY(id_Utilisateur) REFERENCES Utilisateur(id_Utilisateur)
    
);


/*****************************************************************************************************************************************************************/
/********************************************************************Jeu de données*******************************************************************************/
/*****************************************************************************************************************************************************************/

INSERT INTO Utilisateur VALUES ('brf2125a','Bremec','Florian','17C Avenu du Gers',31270,'Frouzins','',0781734740,'fbremec@gmail.com','etudiant');
INSERT INTO Utilisateur VALUES ('rgv2021a','Argenty','Valentin','13 rue Jules Verne',31270,'Frouzins','',0666247082,'valentin.argenty@gmail.com','etudiant', 'toto');
INSERT INTO Utilisateur VALUES ('test','Test','Test','13 rue Test',12345,'Testville','',012346789,'test.test@test.com','etudiant', 'test');
INSERT INTO Enseigne VALUES (1,'IUT Informatique','128 Route de Rangueil',31100,'Toulouse');
INSERT INTO Utilisateurenseigne VALUES ('brf2125a',1);
INSERT INTO Promotion VALUES (1,1,2017);
INSERT INTO Semestre VALUES (1,1,1,1),(2,1,1,2),(3,1,1,3),(4,1,1,4);
INSERT INTO Groupe VALUES (1,1,'E');
INSERT INTO Ue VALUES (1,1,1,1,'Base de l\'informatique'),(2,1,1,2,'Gestion d\'un système');
INSERT INTO Module VALUES (1,1,'M1101','Base de l\'architecture système'),(2,1,'M1102','Base d\'un système');
INSERT INTO Module VALUES (3,2,'M1201','caca');
INSERT INTO Forum VALUES (1,1,'Travaux Pratiques','viescolaire'),(2,1,'Cours','viescolaire'),(3,1,'Travaux Dirigés','viescolaire'),(4,1,'Partiels','viescolaire');
INSERT INTO ForumModule VALUES (1,1);
INSERT INTO ForumModule VALUES (1,2);
INSERT INTO Sujet VALUES (1,1,1,'Installation d\'une machine virtuelle Linux',1);
INSERT INTO Commentaire VALUES (1,'brf2125a',1,'Comment on fais ?','Bonjour j\'ai un problème.','en cours','29/10/2016',1);
INSERT INTO Reponse VALUES (1,1,'brf2125a','on fais comme ca','29/10/2016');
INSERT INTO Document (id_Document,id_Utilisateur,Lien,date_Document,Nom) VALUES (1,'brf2125a','','29/10/2016','document installation linux');
INSERT INTO Document (id_Document,id_Sujet,Lien,date_Document,Nom) VALUES (2,1,'','29/10/2016','correction');

alter table Utilisateur add motdepasse varchar(20);

SELECT motdepasse FROM Utilisateur WHERE id_Utilisateur='rgv2021a';
delete from Utilisateur where id_utilisateur = 'rgv2021a';

Select f.nom, s.numero, s.nom 
from sujet as s, forummodule as fm, forum as f
where s.id_forum = fm.id_forum
and fm.id_forum = f.id_forum
and f.id_enseigne = 1;

select * FROM REPONSE WHERE id_Commentaire = 1;

select *
from forum;

alter table Sujet ADD datePubli date;

update Sujet set datePubli = 12/10/2016
where id_sujet = 1;

INSERT INTO Sujet VALUES (2,1,1,'Configuration de Linux',2, 13/10/2016);
INSERT INTO Sujet VALUES (3,1,1,'Suppression de linux',3, 14/10/2016);
INSERT INTO Sujet VALUES (4,1,2,'Suppression de linux',4, 14/10/2016);