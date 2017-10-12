-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: sys
-- ------------------------------------------------------
-- Server version	5.6.33

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
-- Table structure for table `trainer_details`
--

DROP TABLE IF EXISTS `trainer_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trainer_details` (
  `Name` varchar(30) DEFAULT NULL,
  `ID` varchar(45) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `DOJ` date DEFAULT NULL,
  `Phone` int(11) DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Soldier_no` int(11) DEFAULT NULL,
  `Benefits` varchar(100) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer_details`
--

LOCK TABLES `trainer_details` WRITE;
/*!40000 ALTER TABLE `trainer_details` DISABLE KEYS */;
INSERT INTO `trainer_details` VALUES ('ram','78','1992-08-09','2015-08-09',123456789,'Male','St MAry\'s road',2,'Education  Gift Cards ','ram','ram'),('brown','HGJUO34','1998-09-09','2019-09-09',1234567890,'Male','Peterborough street',8,'Education,Food Coupons,,','brown','brown'),('white','HGJUO90','1998-09-09','2019-09-09',1234567890,'Male','Peterborough street',8,'Education,Food Coupons,Gift Cards,Housing','white','white'),('pujitha','HGJUO88','1998-09-09','2019-09-09',1234567890,'Female','Peterborough street',8,'Education,,Gift Cards,','pujitha','pujitha');
/*!40000 ALTER TABLE `trainer_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-11 23:30:51
