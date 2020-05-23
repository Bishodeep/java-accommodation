CREATE TABLE `Roles` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);
insert into `Roles`(Id,Name) values(1,"admin");
insert into `Roles`(Id,Name) values(2,"student");
CREATE TABLE `AccommodationDetails` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `TypeId` varchar(30) DEFAULT NULL,
  `Location` varchar(40) DEFAULT NULL,
  `MonthlyCharge` int DEFAULT NULL,
  `TypeName` varchar(50) DEFAULT NULL,
  `Available` tinyint(1) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `accommodationtypes` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Available` int DEFAULT NULL,
  PRIMARY KEY (`Id`)
);
CREATE TABLE `StudentDetails` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `Address` varchar(40) DEFAULT NULL,
  `Contact` varchar(20) DEFAULT NULL,
  `UserId` int DEFAULT NULL,
  PRIMARY KEY (`Id`)
);
CREATE TABLE `UserRooms` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `StudentId` int DEFAULT NULL,
  `RoomId` int DEFAULT NULL,
  `Payment` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Id`)
);
insert into `Users`(Id,Name,Password,RoleId) values(5,"admin","admin123",1);
CREATE TABLE `Users` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Password` varchar(225) DEFAULT NULL,
  `RoleId` int DEFAULT NULL,
  PRIMARY KEY (`Id`)
);
