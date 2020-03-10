-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: emr
-- ------------------------------------------------------
-- Server version	5.5.62-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `reg_patient`
--

DROP TABLE IF EXISTS `reg_patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reg_patient` (
  `rfid` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `phoneno` int(11) DEFAULT NULL,
  `date_of_birth` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `postal Code` int(11) DEFAULT NULL,
  `alterntate_phoneno` int(11) DEFAULT NULL,
  `gname` varchar(100) DEFAULT NULL,
  `gphoneno` int(11) DEFAULT NULL,
  `gaddress` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`rfid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reg_patient`
--

LOCK TABLES `reg_patient` WRITE;
/*!40000 ALTER TABLE `reg_patient` DISABLE KEYS */;
INSERT INTO `reg_patient` VALUES (1,'Sushant Kawelekar',18,'MALE',4561379,'17/05/2001','MH','GaganBawda','fhsj',416206,789465132,'Saad Jamadar',1321564,'sfjshdfjks'),(2,'David',54,'MALE',789465453,'29/08/2005','KA','Banglore','jdfk',5465,123456,'djf',123564,'dhsfh'),(3,'Henry',65,'MALE',456132,'08/07/1997','DL','KD','alkfj',564,5465,'kjsdfj',545321,'skjfk'),(4,'Prathmesh Bhamange',20,'MALE',855209636,'21/03/2000','MH','KOP','MAhit Nahi',416101,1234567890,'Prakash ',1234567890,'sjkfk'),(5,'Selena',25,'FEMAlE',1234567890,'12/04/1995','KA','BG','ksjf',456123,123456789,'ksdfj',123,'ksjd'),(5164928,'Sushant Kawlekar',18,'MALE',771980993,'17/05/2001','MH','GaganBawda','KAJf',416206,1234567890,'Saad Jamdar',123456798,'dfjh'),(5186490,'Arihant Kote',22,'MALE',1324589,'01/07/1998','MH','KP','dhf',416455,123456789,'jf',132,'kjwf'),(5466879,'John',11,'MALE',5465465,'05/0/2005','khfkj','fj','akjf',354,54,'dfj',5545,'sjf');
/*!40000 ALTER TABLE `reg_patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-26 14:12:45
