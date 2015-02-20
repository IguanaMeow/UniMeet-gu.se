CREATE DATABASE  IF NOT EXISTS `guproject` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `guproject`;
-- MySQL dump 10.13  Distrib 5.5.35, for debian-linux-gnu (x86_64)
--
-- Host: 188.121.44.3    Database: guproject
-- ------------------------------------------------------
-- Server version	5.0.96-log

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
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `Student_Language2`
--

DROP TABLE IF EXISTS `Student_Language2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student_Language2` (
  `idStudent` int(11) NOT NULL,
  `idLanguage` varchar(9) NOT NULL,
  PRIMARY KEY  (`idStudent`,`idLanguage`),
  KEY `fk_idStudent_idx` (`idStudent`),
  KEY `fk_idLanguage_idx` (`idLanguage`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student_Language2`
--

LOCK TABLES `Student_Language2` WRITE;
/*!40000 ALTER TABLE `Student_Language2` DISABLE KEYS */;
INSERT INTO `Student_Language2` VALUES (1,'ALB'),(1,'DEN'),(1,'ENG'),(2,'ARB'),(2,'BGL'),(2,'BOS'),(3,'BGL'),(3,'DEN'),(3,'ENG'),(4,'AZE'),(4,'ENG'),(4,'SAM'),(4,'SPN'),(5,'AWA'),(5,'DUT'),(5,'HUN'),(6,'AZE'),(6,'ENG'),(6,'JAV'),(7,'AZE'),(7,'BGL'),(7,'ENG'),(9,'ENG'),(11,'ALB'),(11,'AWA'),(11,'CHH'),(11,'ENG'),(12,'CHM'),(12,'GER'),(12,'HAU'),(12,'LIT'),(12,'PAN'),(13,'BOS'),(13,'DUT'),(13,'JPN'),(16,'CHH'),(16,'ENG'),(16,'SWE'),(17,'ENG'),(21,'AWA'),(21,'AZE'),(22,'CHH'),(22,'ENG'),(22,'SPN'),(26,'AZE'),(26,'BOS'),(30,'ENG'),(31,'ALB'),(31,'AZE'),(31,'BHO'),(31,'BOS');
/*!40000 ALTER TABLE `Student_Language2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-23 17:16:34
