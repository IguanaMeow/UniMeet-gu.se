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
-- Table structure for table `Student_Outdoor`
--

DROP TABLE IF EXISTS `Student_Outdoor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student_Outdoor` (
  `idStudent` int(6) NOT NULL,
  `idOutdoor` int(11) NOT NULL,
  UNIQUE KEY `Student_ID` (`idStudent`,`idOutdoor`),
  KEY `Outdoor_ID` (`idOutdoor`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student_Outdoor`
--

LOCK TABLES `Student_Outdoor` WRITE;
/*!40000 ALTER TABLE `Student_Outdoor` DISABLE KEYS */;
INSERT INTO `Student_Outdoor` VALUES (1,1),(1,3),(1,5),(3,5),(4,5),(4,6),(5,4),(5,5),(6,1),(8,2),(8,3),(8,6),(9,4),(9,5),(9,6),(10,3),(10,4),(10,7),(11,4),(11,6),(11,8),(12,5),(13,1),(13,5),(16,1),(18,5),(21,4),(22,4),(30,2);
/*!40000 ALTER TABLE `Student_Outdoor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-23 17:16:31
