
CREATE TABLE Equipment (
EID INT PRIMARY KEY,
EquipmentName VARCHAR(10) NOT NULL,
EquipmentModel VARCHAR(10) NOT NULL,
MaintenanceHistory DATE NOT NULL,
);

CREATE TABLE Doctor (
DID INT PRIMARY KEY,
FName VARCHAR(20) NOT NULL,
LName VARCHAR(20) NOT NULL,
Specialty VARCHAR(10) NOT NULL,
Address VARCHAR(30) NOT NULL,
PhoneNum INT NOT NULL ,
);

CREATE TABLE Patient (
PID INT PRIMARY KEY,
FName VARCHAR(20) NOT NULL,
LName VARCHAR(20) NOT NULL,
Gender VARCHAR(10) NOT NULL,
Nationality VARCHAR(20) DEFAULT 'Jordanian',
DateOfBirth DATE NOT NULL,
Address VARCHAR(30) NOT NULL,
Email VARCHAR(20) UNIQUE,
EID INT,
FOREIGN KEY (EID) REFERENCES Equipment(EID)
);

CREATE TABLE Appointment (
DID INT,
PID INT,
FOREIGN KEY (DID) REFERENCES Doctor(DID),
FOREIGN KEY (PID) REFERENCES Patient(PID),
PRIMARY KEY (DID, PID)
);

CREATE TABLE Facility  (
FID INT PRIMARY KEY,
FacilityName VARCHAR(50) NOT NULL,
FacilityAdress VARCHAR(100) NOT NULL,
PID INT,
FOREIGN KEY (PID) REFERENCES Patient(PID)
);