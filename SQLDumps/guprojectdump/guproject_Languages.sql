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
-- Table structure for table `Languages`
--

DROP TABLE IF EXISTS `Languages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Languages` (
  `idLanguage` varchar(9) NOT NULL,
  `Description` varchar(70) NOT NULL,
  PRIMARY KEY  (`idLanguage`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Languages`
--

LOCK TABLES `Languages` WRITE;
/*!40000 ALTER TABLE `Languages` DISABLE KEYS */;
INSERT INTO `Languages` VALUES ('ALB','Albanian'),('ARB','Arabic'),('AWA','Awadhi'),('AZE','Azerbaijani'),('BGL','Bengali'),('BHO','Bhojpuri'),('BOS','Bosnian'),('BUR','Burmese'),('CHH','Chinese, Hakka'),('CHM','Chinese, Mandarin'),('CMN','Chinese, Min Nan'),('CTN','Cantonese'),('DEN','Danish'),('DUT','Dutch'),('ENG','English'),('EST','Estonian'),('FAR','Faroese'),('FIN','Finnish'),('FRE','French'),('GER','German'),('GRE','Greek'),('GUJ','Gujarati'),('HAU','Hausa'),('HIN','Hindi'),('HUN','Hungarian'),('ICE','Icelandic'),('ITL','Italian'),('JAV','Javanese'),('JPN','Japanese'),('KAN','Kannada'),('KOR','Korean'),('LAT','Latvian'),('LIT','Lithuanian'),('MAI','Maithili'),('MAL','Malayalam'),('MRT','Marathi'),('NOR','Norwegian'),('ORI','Oriya'),('PAN','Panjabi'),('PER','Persian'),('POL','Polish'),('POR','Portuguese'),('ROM','Romanian'),('RUS','Russian'),('SAM','Sami'),('SEC','Serbo-Croatian'),('SER','Serbian'),('SIN','Sindhi'),('SLO','Slovak'),('SPN','Spanish'),('SUN','Sunda'),('SWE','Swedish'),('TAI','Thai'),('TAM','Tamil'),('TEL','Telugu'),('TUR','Turkish'),('UKR','Ukrainian'),('URD','Urdu'),('VTM','Vietnamese'),('YOR','Yoruba');
/*!40000 ALTER TABLE `Languages` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-23 17:16:21
