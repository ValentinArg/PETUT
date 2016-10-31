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
    Libellé varchar(100) NOT NULL
    
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
    Date_Commentaire char(20) NOT NULL check(date_Commentaire like "%/%/%"),
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
    id_Reponse int,
    id_Utilisateur varchar(30) NOT NULL,
    Lien varchar(500) NOT NULL,
    date_Document char(20) NOT NULL check(date_Document like "%/%/%"),
    Nom varchar(50),
    FOREIGN KEY(id_Reponse) REFERENCES Reponse(id_Reponse),
    FOREIGN KEY(id_Utilisateur) REFERENCES Utilisateur(id_Utilisateur)
);

create table DocumentSujet(
	id_Document int NOT NULL,
    id_Sujet int NOT NULL,
    Type_Document varchar(30) NOT NULL check(type_Document like "sujet" || type_Document like "correction" || type_Document like "docimporte"),
    FOREIGN KEY(id_Document) REFERENCES Document(id_Document),
    FOREIGN KEY(id_Sujet) REFERENCES Sujet(id_Sujet),
	PRIMARY KEY(id_Document, id_Sujet)
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

INSERT INTO Utilisateur VALUES (1,'Bremec Florian','17C Avenu du Gers',31270,'Frouzins',0781734740,'fbremec@gmail.com','etudiant');
INSERT INTO Enseigne VALUES (1,'IUT Informatique','128 Route de Rangueil',31100,'Toulouse');
INSERT INTO Utilisateurenseigne VALUES (1,1);
INSERT INTO Promotion VALUES (1,1,2017);
INSERT INTO Semestre VALUES (1,1,1,1),(2,1,1,2),(3,1,1,3),(4,1,1,4);
INSERT INTO Groupe VALUES (1,1,'E');
INSERT INTO Ue VALUES (1,1,1,1,'Base de l\'informatique'),(2,1,1,2,'Gestion d\'un système');
INSERT INTO Module VALUES (1,1,'M1101','Base de l\'architecture système'),(2,1,'M1102','Base d\'un système');
INSERT INTO Forum VALUES (1,1,'Travaux Pratiques','viescolaire'),(2,1,'Cours','viescolaire'),(3,1,'Travaux Dirigés','viescolaire'),(4,1,'Partiels','viescolaire');
INSERT INTO Sujet VALUES (1,1,1,'Installation d\'une machine virtuelle Linux',1);
INSERT INTO Commentaire VALUES (1,1,1,'Comment on fais ?','Bonjour j\'ai un problème.','29/10/2016');
INSERT INTO Reponse VALUES (1,1,1,'on fais comme ca','29/10/2016');
INSERT INTO Document VALUES (1,1,1,'29/10/2016','document installation linux');
INSERT INTO Document (id_Document,id_Utilisateur,Lien,date_Document,Nom) VALUES (2,1,'29/10/2016','correction');
INSERT INTO Documentsujet VALUES (2,1,'correction');
    