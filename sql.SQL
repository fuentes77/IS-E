CREATE TABLE userTable(
  userID int,
  vorname VARCHAR(250) NOT NULL,
  nachname VARCHAR (250) NOT NULL,
  email_Adresse VARCHAR2(250) NOT NULL unique,
  password VARCHAR2(255) not null , 
  PRIMARY KEY (userID)
  );
  
  
create sequence Iseq
start with 1
increment by 1;

create or replace trigger userInsert
before insert on userTable for each row
begin
   :new.userID:=Iseq.nextval;
end;

  
CREATE TABLE reiseagentur(
agenturID int ,
email_Adresse VARCHAR2(250) NOT NULL,
passwordB VARCHAR2(250) Null,
PRIMARY KEY (agenturID)
);

 
create sequence reisenIseq
start with 100
increment by 1;

create or replace trigger reisenAgenturInsert
before insert on reiseagentur for each row
begin
   :new.agenturID:=reisenIseq.nextval;
end;



CREATE TABLE flug(
flugID int,
abflug VARCHAR(250) NOT NULL,
ankunft VARCHAR2(250) NOT NULL,
preis NUMBER(250) NOT NULL,
sitzAnzahl INTEGER NOT NULL,
PRIMARY KEY (flugID)

);

create sequence FlugIseq
start with 1
increment by 1;

create or replace trigger flugInsert
before insert on flug for each row
begin
   :new.flugID:=FlugIseq.nextval;
end;



CREATE TABLE nachricht(
  nachrichtID int,
  von VARCHAR(250)  NULL,
  zu VARCHAR2(250)  NULL,
  nachricht NVARCHAR2(3900)  NULL,
  PRIMARY KEY (nachrichtID)
  
  );
  
create sequence nachrichtIseq
start with 1
increment by 1;

create or replace trigger nachrichtInsert
before insert on nachricht for each row
begin
   :new.nachrichtID:=nachrichtIseq.nextval;
end;


  CREATE TABLE buchung(
  flugID VARCHAR2(250) NOT NULL,
  userID VARCHAR2(250) NOT NULL,
  buchungsID int ,
  PRIMARY KEY (buchungsID),
  CONSTRAINT buchung_fk_flug Foreign KEY (flugID) REFERENCES flug(flugID),
  CONSTRAINT buchung_fk_User Foreign KEY (userID) REFERENCES userTable(userID)
  );
  
  CREATE TABLE sitz(
  sitzNummer INTEGER ,
  flugID varchar(250),
  PRIMARY KEY (sitzNummer,flugID),
  CONSTRAINT sitz_fk_flug Foreign key flugID REFERENCES flug(flugID)
  );
  
  
  
  CREATE TABLE admin(
  anschrift VARCHAR(250) NOT NULL,
  pasword VARCHAR(250) NOT NULL,
  email_Adresse VARCHAR2(250),
  PRIMARY KEY (email_Adresse)
  );
  
  CREATE TABLE flugmanager(
  managerID int ,
  vorname VARCHAR(250) NOT NULL,
  nachname VARCHAR (250) NOT NULL,
  email_Adresse VARCHAR2(250) NOT NULL UNIQUE,
  PRIMARY KEY (managerID)
  );
  