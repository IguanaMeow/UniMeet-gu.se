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
-- Table structure for table `Message`
--

DROP TABLE IF EXISTS `Message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Message` (
  `Fuser` int(11) default NULL,
  `Tuser` int(11) default NULL,
  `Message` varchar(2000) default NULL,
  `Read` tinyint(4) default '0',
  `Time` timestamp NULL default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Message`
--

LOCK TABLES `Message` WRITE;
/*!40000 ALTER TABLE `Message` DISABLE KEYS */;
INSERT INTO `Message` VALUES (11,5,'hi',1,'2013-12-11 17:30:55'),(11,5,'how r u ?',1,'2013-12-11 17:31:55'),(5,11,'I am good and u ?',1,'2013-12-11 17:35:55'),(11,5,'I am good',1,'2013-12-11 17:36:55'),(11,5,'What are you studying?',1,'2013-12-11 17:37:00'),(5,11,'SEM',1,'2013-12-11 17:37:55'),(11,2,'Hi, How r u ?',1,'2014-01-10 16:12:04'),(11,5,'Thats good',1,'2013-12-12 02:49:52'),(11,2,'Hi',1,'2014-01-10 16:12:14'),(11,5,'What are you doing ?',1,'2013-12-12 03:37:30'),(11,5,'hiiiiiiiiiiii',1,'2013-12-12 03:37:40'),(11,5,'hiii',1,'2013-12-12 03:42:32'),(11,5,'helloooo',1,'2013-12-12 03:42:40'),(11,5,'Hello',1,'2014-01-10 16:27:00'),(11,5,'Hi, How r u ?',1,'2014-01-10 16:48:07'),(11,5,'Hey',1,'2014-01-13 03:56:51'),(11,5,'hello',1,'2014-01-13 04:10:26'),(11,5,'helooo henfnin fhogrm  irnrgbrejfnewiofnj ewnfioewnf',1,'2013-12-28 13:34:03'),(11,5,'hi',1,'2013-12-28 20:11:19'),(11,5,'How r u ?How r u ?How r u ?How r u ?How r u ?How r u ?How r u ?How r u ?How r u ?How r u ?How r u ?How r u ?How r u ?How r u ?How r u ?How r u ?How r u ?How r u ?How r u ?How r u ?',1,'2014-01-09 21:15:26'),(5,26,'Yeah I do',1,'2014-01-16 07:42:13'),(26,5,'Cool, come here you sexy beast',1,'2014-01-16 07:42:45'),(5,26,'Why so many for one person',1,'2014-01-16 07:44:26'),(11,5,'hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh',1,'2014-01-16 19:18:03'),(11,5,'hello',1,'2014-01-16 19:22:47'),(11,5,'hi',1,'2014-01-16 19:29:30'),(11,5,'hi',1,'2014-01-16 19:34:32'),(11,5,'hi',1,'2014-01-16 19:40:47'),(11,5,'hi',1,'2014-01-16 19:43:01'),(11,5,'hi',1,'2014-01-16 19:44:47'),(2,11,'Hello',1,'2014-01-17 02:03:20'),(11,7,'Hi!',0,'2014-01-17 18:31:54'),(11,7,'How are you?\n',0,'2014-01-17 18:32:05'),(11,5,'hi',1,'2014-01-17 22:52:59'),(21,3,'thanks',1,'2014-02-01 03:11:05');
/*!40000 ALTER TABLE `Message` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-23 17:16:38
