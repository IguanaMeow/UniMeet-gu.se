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
-- Table structure for table `Student_Music`
--

DROP TABLE IF EXISTS `Student_Music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student_Music` (
  `idStudent` int(6) NOT NULL,
  `idMusic` int(11) NOT NULL,
  PRIMARY KEY  (`idStudent`,`idMusic`),
  UNIQUE KEY `Student_ID` (`idStudent`,`idMusic`),
  KEY `idMusic_idx` (`idMusic`),
  CONSTRAINT `fk_music` FOREIGN KEY (`idMusic`) REFERENCES `Music` (`idMusic`),
  CONSTRAINT `fk_student` FOREIGN KEY (`idStudent`) REFERENCES `Student` (`Student_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student_Music`
--

LOCK TABLES `Student_Music` WRITE;
/*!40000 ALTER TABLE `Student_Music` DISABLE KEYS */;
INSERT INTO `Student_Music` VALUES (2,1),(7,1),(9,1),(11,1),(12,1),(14,1),(2,2),(4,2),(14,2),(30,2),(2,3),(3,3),(4,3),(5,3),(7,3),(12,3),(14,3),(16,3),(18,3),(22,3),(3,4),(5,4),(8,4),(9,4),(11,4),(6,5),(8,5),(9,5),(13,5),(16,5),(13,6),(11,9),(13,9),(30,9);
/*!40000 ALTER TABLE `Student_Music` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-23 17:16:17
