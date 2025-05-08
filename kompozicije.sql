<<<<<<< HEAD
/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.18-MariaDB : Database - database
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kompozicije` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `kompozicije`;



DROP TABLE IF EXISTS `MuzickiUrednik`;

CREATE TABLE `MuzickiUrednik` (
  `MuzickiUrednikID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Ime` VARCHAR(30) NOT NULL,
  `Prezime` VARCHAR(30) NOT NULL,
  `Username` VARCHAR(30) NOT NULL,
  `Password` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`MuzickiUrednikID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `MuzickiUrednik` VALUES 
(1,'Ljubica','Ilic','ljubica','ljubica123'),
(2,'Uros','Kovic','uros','uros123');



DROP TABLE IF EXISTS `Autor`;

CREATE TABLE `Autor` (
  `AutorID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ImeAutora` VARCHAR(30) NOT NULL,
  `PrezimeAutorа` VARCHAR(30) NOT NULL,
  `Email` VARCHAR(50) NOT NULL,
  `Telefon` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`AutorID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Autor` VALUES 
(1,'Dragan', 'Brajovic', 'dragan@gmail.com', '0631231234'),
(2,'Bane', 'Opacic', 'bane@gmail.com', '0654645434'),
(3,'Aleksandra', 'Milutinovic', 'aleksandra@gmail.com', '0641235153'),
(4,'Zeljko', 'Joksimovic', 'zeljko@gmail.com', '0653425362'),
(5,'Dusan', 'Alagic', 'dusan@gmail.com', '0621723625');



DROP TABLE IF EXISTS `Zanr`;

CREATE TABLE `Zanr` (
  `ZanrID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivZanra` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`ZanrID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Zanr` VALUES 
(1,'Pop'),
(2,'Rock'),
(3,'Narodna'),
(4,'Rep'),
(5,'Dzez');


DROP TABLE IF EXISTS `Uloga`;

CREATE TABLE `Uloga` (
  `UlogaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivUloge` VARCHAR(50) NOT NULL,
  `Opis` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`UlogaID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;




INSERT  INTO `Uloga` VALUES 
(1,'Tekstopisac', 'Covek koji pise tekst pesme.'),
(2,'Kompozitor', 'Covek koji komponuje muziku.'),
(3,'Aranzer', 'Covek koji pravi aranzman za muziku.');




DROP TABLE IF EXISTS `MuzickaKompozicija`;

CREATE TABLE `MuzickaKompozicija` (
  `MuzickaKompozicijaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivKompozicije` VARCHAR(50) NOT NULL,
  `GodinaNastanka` INT(4) NOT NULL,
  `DuzinaTrajanjaSekundi` INT(7) NOT NULL,
  `ZanrID` BIGINT(10) UNSIGNED NOT NULL,
  `MuzickiUrednikID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`MuzickaKompozicijaID`),
  CONSTRAINT `fk_zanr_id` FOREIGN KEY (`ZanrID`) REFERENCES `Zanr` (`ZanrID`),
  CONSTRAINT `fk_urednik_id` FOREIGN KEY (`MuzickiUrednikID`) REFERENCES `MuzickiUrednik` (`MuzickiUrednikID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT  INTO `MuzickaKompozicija` VALUES 
(1,'Nekad i sad', 2022, 206 , 1, 1);


DROP TABLE IF EXISTS `UlogaKompozicije`;

CREATE TABLE `UlogaKompozicije` (
  `MuzickaKompozicijaID` BIGINT(10) UNSIGNED NOT NULL,
  `RbUloge` INT(7) NOT NULL,
  `Komentar` VARCHAR(100) NOT NULL,
  `AutorID` BIGINT(10) UNSIGNED NOT NULL,
  `UlogaID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`MuzickaKompozicijaID`, `RbUloge`),
  CONSTRAINT `fk_autor_id` FOREIGN KEY (`AutorID`) REFERENCES `Autor` (`AutorID`),
  CONSTRAINT `fk_uloga_id` FOREIGN KEY (`UlogaID`) REFERENCES `Uloga` (`UlogaID`),
  CONSTRAINT `fk_mk_id` FOREIGN KEY (`MuzickaKompozicijaID`) REFERENCES `MuzickaKompozicija` (`MuzickaKompozicijaID`) ON DELETE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `UlogaKompozicije` VALUES 
(1,1,'Uzivao u pisanju teksta.', 1, 1),
(1,2,'Uzivao u komponovanju pesme.', 1, 2),
(1,3,'Uzivao u aranzmanu za pesmu.', 5, 3);




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
=======
/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.18-MariaDB : Database - database
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kompozicije` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `kompozicije`;



DROP TABLE IF EXISTS `MuzickiUrednik`;

CREATE TABLE `MuzickiUrednik` (
  `MuzickiUrednikID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Ime` VARCHAR(30) NOT NULL,
  `Prezime` VARCHAR(30) NOT NULL,
  `Username` VARCHAR(30) NOT NULL,
  `Password` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`MuzickiUrednikID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `MuzickiUrednik` VALUES 
(1,'Ljubica','Ilic','ljubica','ljubica123'),
(2,'Uros','Kovic','uros','uros123');



DROP TABLE IF EXISTS `Autor`;

CREATE TABLE `Autor` (
  `AutorID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ImeAutora` VARCHAR(30) NOT NULL,
  `PrezimeAutorа` VARCHAR(30) NOT NULL,
  `Email` VARCHAR(50) NOT NULL,
  `Telefon` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`AutorID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Autor` VALUES 
(1,'Dragan', 'Brajovic', 'dragan@gmail.com', '0631231234'),
(2,'Bane', 'Opacic', 'bane@gmail.com', '0654645434'),
(3,'Aleksandra', 'Milutinovic', 'aleksandra@gmail.com', '0641235153'),
(4,'Zeljko', 'Joksimovic', 'zeljko@gmail.com', '0653425362'),
(5,'Dusan', 'Alagic', 'dusan@gmail.com', '0621723625');



DROP TABLE IF EXISTS `Zanr`;

CREATE TABLE `Zanr` (
  `ZanrID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivZanra` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`ZanrID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Zanr` VALUES 
(1,'Pop'),
(2,'Rock'),
(3,'Narodna'),
(4,'Rep'),
(5,'Dzez');


DROP TABLE IF EXISTS `Uloga`;

CREATE TABLE `Uloga` (
  `UlogaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivUloge` VARCHAR(50) NOT NULL,
  `Opis` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`UlogaID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;




INSERT  INTO `Uloga` VALUES 
(1,'Tekstopisac', 'Covek koji pise tekst pesme.'),
(2,'Kompozitor', 'Covek koji komponuje muziku.'),
(3,'Aranzer', 'Covek koji pravi aranzman za muziku.');




DROP TABLE IF EXISTS `MuzickaKompozicija`;

CREATE TABLE `MuzickaKompozicija` (
  `MuzickaKompozicijaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivKompozicije` VARCHAR(50) NOT NULL,
  `GodinaNastanka` INT(4) NOT NULL,
  `DuzinaTrajanjaSekundi` INT(7) NOT NULL,
  `ZanrID` BIGINT(10) UNSIGNED NOT NULL,
  `MuzickiUrednikID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`MuzickaKompozicijaID`),
  CONSTRAINT `fk_zanr_id` FOREIGN KEY (`ZanrID`) REFERENCES `Zanr` (`ZanrID`),
  CONSTRAINT `fk_urednik_id` FOREIGN KEY (`MuzickiUrednikID`) REFERENCES `MuzickiUrednik` (`MuzickiUrednikID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT  INTO `MuzickaKompozicija` VALUES 
(1,'Nekad i sad', 2022, 206 , 1, 1);


DROP TABLE IF EXISTS `UlogaKompozicije`;

CREATE TABLE `UlogaKompozicije` (
  `MuzickaKompozicijaID` BIGINT(10) UNSIGNED NOT NULL,
  `RbUloge` INT(7) NOT NULL,
  `Komentar` VARCHAR(100) NOT NULL,
  `AutorID` BIGINT(10) UNSIGNED NOT NULL,
  `UlogaID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`MuzickaKompozicijaID`, `RbUloge`),
  CONSTRAINT `fk_autor_id` FOREIGN KEY (`AutorID`) REFERENCES `Autor` (`AutorID`),
  CONSTRAINT `fk_uloga_id` FOREIGN KEY (`UlogaID`) REFERENCES `Uloga` (`UlogaID`),
  CONSTRAINT `fk_mk_id` FOREIGN KEY (`MuzickaKompozicijaID`) REFERENCES `MuzickaKompozicija` (`MuzickaKompozicijaID`) ON DELETE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `UlogaKompozicije` VALUES 
(1,1,'Uzivao u pisanju teksta.', 1, 1),
(1,2,'Uzivao u komponovanju pesme.', 1, 2),
(1,3,'Uzivao u aranzmanu za pesmu.', 5, 3);




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
>>>>>>> c782e61ed4cb996509392665a173d79c7e452d46
