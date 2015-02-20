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
-- Table structure for table `Student_Film`
--

DROP TABLE IF EXISTS `Student_Film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student_Film` (
  `idStudent` int(11) NOT NULL,
  `idFilm` int(11) NOT NULL,
  UNIQUE KEY `Student_ID` (`idStudent`,`idFilm`),
  KEY `Film_ID` (`idFilm`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student_Film`
--

LOCK TABLES `Student_Film` WRITE;
/*!40000 ALTER TABLE `Student_Film` DISABLE KEYS */;
INSERT INTO `Student_Film` VALUES (1,3),(1,5),(1,10),(2,2),(2,3),(2,4),(2,5),(2,10),(3,3),(3,4),(3,8),(3,9),(4,3),(4,5),(4,10),(5,4),(5,5),(6,1),(6,3),(6,4),(7,1),(7,8),(8,4),(8,6),(9,8),(10,10),(11,1),(11,4),(11,10),(12,2),(12,7),(13,1),(13,8),(16,3),(16,5),(18,4),(21,4),(22,1),(22,4),(30,5);
/*!40000 ALTER TABLE `Student_Film` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-23 17:16:27
