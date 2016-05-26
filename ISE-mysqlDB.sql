CREATE TABLE userTable(
  userID VARCHAR(250) ,
  vorname VARCHAR(250) NOT NULL,
  nachname VARCHAR (250) NOT NULL,
  email_Adresse VARCHAR(250) NOT NULL unique,
  PRIMARY KEY (userID)
  );
  
  CREATE TABLE reiseagentur(
  email_Adresse VARCHAR(250) NOT NULL,
  agenturID VARCHAR(250) ,
  passwordB VARCHAR(250) Null,
  PRIMARY KEY (agenturID)
  );
  
CREATE TABLE Flug(
  FlugId VARCHAR(225)  NOT NULL,
  destination VARCHAR(225) NOT NULL,
  origin VARCHAR(225) NOT NULL,
  departureDateYear int NOT NULL,
  departureDateMonth int NOT NULL, 
  departureDateDay int NOT NULL, 
  departureDateHour int NOT NULL, 
  departureDateMinute int NOT NULL,
  arrivalDateYear int NOT NULL, 
  arrivalDateMonth int NOT NULL, 
  arrivalDateDay int NOT NULL,
  arrivalDateHour int NOT NULL, 
  arrivalDateMinute int NOT NULL, 
  seats int NOT NULL, 
  price double NOT NULL, 
  PRIMARY KEY (FlugId)
  );

  CREATE TABLE buchung(
  flugID VARCHAR(250) NOT NULL,
  userID VARCHAR(250) NOT NULL,
  buchungsID VARCHAR(250) ,
  PRIMARY KEY (buchungsID),
  CONSTRAINT buchung_fk_flug Foreign KEY (flugID) REFERENCES flug(flugID),
  CONSTRAINT buchung_fk_User Foreign KEY (userID) REFERENCES userTable(userID)
  );
  
  CREATE TABLE sitz(
  sitzNummer INTEGER ,
  flugID varchar(250),
  PRIMARY KEY (sitzNummer,flugID),
  CONSTRAINT sitz_fk_flug Foreign key (flugID) REFERENCES flug(flugID)
  );

  CREATE TABLE admin(
  anschrift VARCHAR(250) NOT NULL,
  pasword VARCHAR(250) NOT NULL,
  email_Adresse VARCHAR(250),
  PRIMARY KEY (email_Adresse)
  );
  
  CREATE TABLE flugmanager(
  managerID VARCHAR(250) NOT NULL,
  vorname VARCHAR(250) NOT NULL,
  nachname VARCHAR (250) NOT NULL,
  email_Adresse VARCHAR(250) NOT NULL UNIQUE,
  PRIMARY KEY (managerID)
  );

  CREATE TABLE nachricht(
    nachrichtID int,
    von VARCHAR (250),
    zu VARCHAR (250),
    nachricht VARCHAR (400),
    PRIMARY KEY (nachrichtID)
    );
  