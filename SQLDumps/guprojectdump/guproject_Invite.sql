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
-- Table structure for table `Invite`
--

DROP TABLE IF EXISTS `Invite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Invite` (
  `Fuser` int(6) default NULL,
  `Tuser` int(6) default NULL,
  `Location` varchar(40) default NULL,
  `Time` varchar(25) default NULL,
  `Why` varchar(25) default NULL,
  `Message` varchar(100) default NULL,
  `Accepted` tinyint(1) default NULL,
  `Declined` tinyint(1) default NULL,
  UNIQUE KEY `Tuser` (`Tuser`,`Fuser`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Invite`
--

LOCK TABLES `Invite` WRITE;
/*!40000 ALTER TABLE `Invite` DISABLE KEYS */;
INSERT INTO `Invite` VALUES (5,3,'hi','hi','hi','hi',0,0),(18,20,'Hi','Hi','Hi','Hi',0,0),(21,6,'123','123','Common Film Interests','123',0,0),(11,4,'Hi','Hey','Common Interests Shared','hey',0,0),(25,7,'Hagabadet','Tomorrow','Music','I would like to listen to music',1,0),(11,13,'hi','hi','Study Partner','hi',0,0),(21,2,'sgrrge','wrgrw','Common Film Interests','wrgwg',0,0),(28,10,'Center','Tomorrow','Common Outdoor Interests','Hi',1,0),(29,6,'Center','Tomorrow at 3 pm','Speak english','Hi',1,0),(30,17,'uni3','tomorro','meetingh','hello',1,0),(30,16,'uni4','today','I want to talk','hello5',1,0),(30,18,'my place ','now ','Common Interests Shared','because i\'m crazy about you ',0,0),(44,13,'Library','Tuesday 14-1','Chat','Hi!.....',0,0),(44,25,'Coffe place','Wednesday','Talk about politics','Yada yada',0,0),(44,38,'Cinemas','Saturday','Watching films','Hello',0,0),(21,5,'ndgmf','dng','Common Interests Shared','ngd',0,0),(22,12,'Center','Tomorrow','Matching Sport interests','Hi',0,0),(5,26,'What','What','In','the butt',1,0),(11,6,'hi','hi','Common Sports Interests','hi',0,0),(11,18,'hi','hi','Common Sports Interests','hi',0,0),(11,12,'hi','hi','Common Other Interests','hi',0,0),(11,22,'hi','hi','Common Other Interests','hi',0,0),(21,8,'rthw','rwtj','Common Indoor Interests','rtw',0,0),(21,11,'rus','bgr','Common Film Interests','lsd',0,0),(21,3,'NS','Tomorrow','Study Partner','Hello',1,0);
/*!40000 ALTER TABLE `Invite` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-23 17:16:30
