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
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Course` (
  `idCourse` varchar(7) NOT NULL,
  `Description` varchar(100) NOT NULL,
  PRIMARY KEY  (`idCourse`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES ('MBAPO','Apotekarprogrammet'),('MBARB','Arbetsterapeutprogrammet'),('MBAUD','Audionomprogrammet'),('MBBIO','Biomedicinska analytikerprogrammet'),('MBDIE','Dietistprogrammet'),('MBLOG','Logopedprogrammet'),('MBREC','Receptarieprogrammet/Farmaci'),('MBSJG','Sjukgymnastprogrammet'),('MBSJH','Sjukhusfysikerprogrammet'),('MBSC','Sports Coaching'),('MBTAH','Tandhygienistprogrammet'),('MBTAT','Tandteknikerprogrammet'),('MMBAR','Barnmorskeprogrammet'),('MMEVI','Evidensbasering: praktik, teori, kontext'),('MMBCE','Buisness Creation and Entrepreneurship in Biomedicine'),('NBBIO','Biologi'),('NBFYS','Fysik'),('NBGEO','Geografi'),('NBGEV','Geovetenskap'),('NBKEM','Kemi'),('NBMAR','Marin vetenskap'),('NBMAT','Matematikprogrammet'),('SBSOF','Software Engineering and Management'),('NMATM','Atmospheric Science'),('NMBIS','Biodiversitet och systematik'),('NMCAS','Complex Adaptive Systems'),('NMECO','Ecotoxicology'),('NMFYO','Fysisk oceanografi'),('NMGEN','Genomik och Systembiologi'),('NMMVE','Marina vetenskaper'),('NMMAV','Matematiska vetenskaper'),('NMPHY','Physics'),('NMPMBS','Physics of Materials and Biological Systems'),('CBBEB','Bebyggelseantikvariskt program'),('CBKON','Konservatorsprogrammet'),('CBKUL','Kultur'),('CBKUS','Kultarvsstudier'),('CBLA','Liberal arts'),('CBREL','Religionsvetenskapligt program'),('CBTEO','Teologiskt program'),('CMARK','Arkeologisk praktik och teori'),('CMGEN','Genuspraktiker'),('CMKOM','Kulturarv och modernitet'),('CMRS','Religious Studies'),('FBBYG','Bygghantverksprogrammet'),('FBDSN','Design'),('FBFK','Fri konst'),('FBKER','Keramikkonst'),('FBSMY','Smyckekonst'),('FBTEX','Textilkonst'),('FMCCD','Child Culture Design'),('FMFKD','Fri konst med inriktning mot digitala medier'),('FMKON','Konsthantverk'),('FMBD','Business & Design ');
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-23 17:16:35
