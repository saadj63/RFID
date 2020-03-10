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
-- Table structure for table `medical_problems`
--

DROP TABLE IF EXISTS `medical_problems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medical_problems` (
  `rfid` int(11) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `symptoms` varchar(500) DEFAULT NULL,
  `allergies` varchar(500) DEFAULT NULL,
  `addiction` varchar(500) DEFAULT NULL,
  `comments` varchar(500) DEFAULT NULL,
  `doctor_name` varchar(100) DEFAULT NULL,
  KEY `rfid_idx` (`rfid`),
  CONSTRAINT `rfid` FOREIGN KEY (`rfid`) REFERENCES `reg_patient` (`rfid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_problems`
--

LOCK TABLES `medical_problems` WRITE;
/*!40000 ALTER TABLE `medical_problems` DISABLE KEYS */;
INSERT INTO `medical_problems` VALUES (5164928,'22/01/2020','High Fever	\nHead AChe','NO','Tobacco\nDrugs\nSmoking\nGamja','kdjf','Dr.ABC'),(5186490,'22/01/2020','jhgdsjksdjf','sdkfjs','sdkjf','skdjf','Dr.ABC');
/*!40000 ALTER TABLE `medical_problems` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-26 14:12:54
