 ---------------------------------------------------------------
 --        Script Oracle.  
 ---------------------------------------------------------------


DROP TABLE Circuits cascade constraints;
DROP TABLE Accompagnateurs cascade constraints;
DROP TABLE Reservations cascade constraints;
DROP TABLE Hotels cascade constraints;
DROP TABLE Villes cascade constraints;
DROP TABLE visite cascade constraints;
DROP TABLE Clients cascade constraints;
DROP TABLE Passwds cascade constraints;

drop sequence Seq_Cli_idCli;
drop sequence Seq_Cir_idCir;
drop sequence Seq_Acc_idAcc;
drop sequence Seq_Res_idRes;
drop sequence Seq_Hot_idHot;
drop sequence Seq_Vil_idVil;
drop sequence Seq_Pass_idPass;

------------------------------------------------------------
-- Table: Clients
------------------------------------------------------------
CREATE TABLE Clients(
	idClient       NUMBER NOT NULL ,
	nom            VARCHAR2 (100)  ,
	userName       VARCHAR2 (25)  ,
	mdp            VARCHAR2 (25)  ,
	prenom         VARCHAR2 (100)  ,
	telephone      VARCHAR2 (25)  ,
	ville          VARCHAR2 (100)  ,
	rue            VARCHAR2 (150)  ,
	numRue         NUMBER(10,0)   ,
	codePostal     VARCHAR2 (25)  ,
	dateNaissance  DATE   ,
	CONSTRAINT Clients_Pk PRIMARY KEY (idClient)
);

------------------------------------------------------------
-- Table: Circuits
------------------------------------------------------------
CREATE TABLE Circuits(
	idCircuit         NUMBER NOT NULL ,
	nom               VARCHAR2 (50)  ,
	places            NUMBER (10,0)  ,
	prix              NUMBER(10,0)   ,
	dateDepart        DATE   ,
	dateFin           DATE   ,
	open              NUMBER (1) ,
	idAccompagnateur  NUMBER(10,0)   ,
	CONSTRAINT Circuits_Pk PRIMARY KEY (idCircuit) ,
	CONSTRAINT CHK_BOOLEAN_open CHECK (open IN (0,1))
);

------------------------------------------------------------
-- Table: Accompagnateurs
------------------------------------------------------------
CREATE TABLE Accompagnateurs(
	idAccompagnateur  NUMBER NOT NULL ,
	nom               VARCHAR2 (100)  ,
	prenom            VARCHAR2 (100)  ,
	telephone         VARCHAR2 (25)  ,
	numRue            NUMBER(10,0)   ,
	rue               VARCHAR2 (150)  ,
	ville             VARCHAR2 (100)  ,
	codePostal        VARCHAR2 (25)  ,
	CONSTRAINT Accompagnateurs_Pk PRIMARY KEY (idAccompagnateur)
);

------------------------------------------------------------
-- Table: Reservations
------------------------------------------------------------
CREATE TABLE Reservations(
	idReservation          NUMBER NOT NULL ,
	acompteVerse          NUMBER (1) ,
	secondPaiement         NUMBER (1) ,
	dateLimitePaiement     DATE   ,
	dateReservation        DATE   ,
	annulation             NUMBER (1) ,
	acompteMontant         NUMBER(10,0)   ,
	secondPaiementMontant  NUMBER(10,0)   ,
	idClient               NUMBER(10,0)   ,
	idCircuit              NUMBER(10,0)   ,
	CONSTRAINT Reservations_Pk PRIMARY KEY (idReservation) ,
	CONSTRAINT CHK_BOOLEAN_acompteVerse CHECK (acompteVerse IN (0,1)),
	CONSTRAINT CHK_BOOLEAN_secondPaiement CHECK (secondPaiement IN (0,1)),
	CONSTRAINT CHK_BOOLEAN_annulation CHECK (annulation IN (0,1))
);

------------------------------------------------------------
-- Table: Hotels
------------------------------------------------------------
CREATE TABLE Hotels(
	idHotel    NUMBER NOT NULL ,
	nom        VARCHAR2 (50)  ,
	telephone  VARCHAR2 (50)  ,
	rue        VARCHAR2 (50)  ,
	numRue     NUMBER(10,0)   ,
	CONSTRAINT Hotels_Pk PRIMARY KEY (idHotel)
);

------------------------------------------------------------
-- Table: Villes
------------------------------------------------------------
CREATE TABLE Villes(
	idVille  NUMBER NOT NULL ,
	nom      VARCHAR2 (50)  ,
	idHotel  NUMBER(10,0)   ,
	CONSTRAINT Villes_Pk PRIMARY KEY (idVille)
);

------------------------------------------------------------
-- Table: Passwds
------------------------------------------------------------
CREATE TABLE Passwds(
	idPasswd  NUMBER NOT NULL ,
	username  VARCHAR2 (25)  ,
	passwd    VARCHAR2 (25)  ,
	rank      NUMBER(10,0)   ,
	CONSTRAINT Passwds_Pk PRIMARY KEY (idPasswd)
);

------------------------------------------------------------
-- Table: visite
------------------------------------------------------------
CREATE TABLE visite(
	Nombrenuits  NUMBER (10,0)  ,
	Datearrivee  DATE   ,
	idCircuit    NUMBER(10,0)  NOT NULL  ,
	idVille      NUMBER(10,0)  NOT NULL  ,
	CONSTRAINT visite_Pk PRIMARY KEY (idCircuit,idVille)
);




ALTER TABLE Circuits ADD FOREIGN KEY (idAccompagnateur) REFERENCES Accompagnateurs(idAccompagnateur);
ALTER TABLE Reservations ADD FOREIGN KEY (idClient) REFERENCES Clients(idClient);
ALTER TABLE Reservations ADD FOREIGN KEY (idCircuit) REFERENCES Circuits(idCircuit);
ALTER TABLE Hotels ADD FOREIGN KEY (idVille) REFERENCES Villes(idVille);
ALTER TABLE Villes ADD FOREIGN KEY (idHotel) REFERENCES Hotels(idHotel);
ALTER TABLE visite ADD FOREIGN KEY (idCircuit) REFERENCES Circuits(idCircuit);
ALTER TABLE visite ADD FOREIGN KEY (idVille) REFERENCES Villes(idVille);

CREATE SEQUENCE Seq_Cli_idCli START WITH 1 INCREMENT BY 1 NOCYCLE;
CREATE SEQUENCE Seq_Cir_idCir START WITH 1 INCREMENT BY 1 NOCYCLE;
CREATE SEQUENCE Seq_Acc_idAcc START WITH 1 INCREMENT BY 1 NOCYCLE;
CREATE SEQUENCE Seq_Res_idRes START WITH 1 INCREMENT BY 1 NOCYCLE;
CREATE SEQUENCE Seq_Hot_idHot START WITH 1 INCREMENT BY 1 NOCYCLE;
CREATE SEQUENCE Seq_Vil_idVil START WITH 1 INCREMENT BY 1 NOCYCLE;
CREATE SEQUENCE Seq_Pass_idPass START WITH 1 INCREMENT BY 1 NOCYCLE;


CREATE OR REPLACE TRIGGER Clients_idClient
	BEFORE INSERT ON Clients 
  FOR EACH ROW 
	WHEN (NEW.idClient IS NULL) 
	BEGIN
		 select Seq_Cli_idCli.NEXTVAL INTO :NEW.idClient from DUAL; 
	END;
    /
CREATE OR REPLACE TRIGGER Cir_idCir
	BEFORE INSERT ON Circuits 
  FOR EACH ROW 
	WHEN (NEW.idCircuit IS NULL) 
	BEGIN
		 select Seq_Cir_idCir.NEXTVAL INTO :NEW.idCircuit from DUAL; 
	END;
    /
CREATE OR REPLACE TRIGGER Acc_idAcc
	BEFORE INSERT ON Accompagnateurs 
  FOR EACH ROW 
	WHEN (NEW.idAccompagnateur IS NULL) 
	BEGIN
		 select Seq_Acc_idAcc.NEXTVAL INTO :NEW.idAccompagnateur from DUAL; 
	END;
    /
CREATE OR REPLACE TRIGGER Reservations_idReservation
	BEFORE INSERT ON Reservations 
  FOR EACH ROW 
	WHEN (NEW.idReservation IS NULL) 
	BEGIN
		 select Seq_Res_idRes.NEXTVAL INTO :NEW.idReservation from DUAL; 
	END;
    /
CREATE OR REPLACE TRIGGER Hotels_idHotel
	BEFORE INSERT ON Hotels 
  FOR EACH ROW 
	WHEN (NEW.idHotel IS NULL) 
	BEGIN
		 select Seq_Hot_idHot.NEXTVAL INTO :NEW.idHotel from DUAL; 
	END;
    /
CREATE OR REPLACE TRIGGER Villes_idVille
	BEFORE INSERT ON Villes 
  FOR EACH ROW 
	WHEN (NEW.idVille IS NULL) 
	BEGIN
		 select Seq_Vil_idVil.NEXTVAL INTO :NEW.idVille from DUAL; 
	END;
    /
CREATE OR REPLACE TRIGGER Passwds_idPasswd
	BEFORE INSERT ON Passwds 
  FOR EACH ROW 
	WHEN (NEW.idPasswd IS NULL) 
	BEGIN
		 select Seq_Pass_idPass.NEXTVAL INTO :NEW.idPasswd from DUAL; 
	END;
    /
