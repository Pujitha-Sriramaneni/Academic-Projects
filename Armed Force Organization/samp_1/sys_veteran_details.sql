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
-- Table structure for table `veteran_details`
--

DROP TABLE IF EXISTS `veteran_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veteran_details` (
  `Name` varchar(50) NOT NULL,
  `ID` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `doj` date DEFAULT NULL,
  `dol` date DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `years` int(11) DEFAULT NULL,
  `designation` varchar(45) DEFAULT NULL,
  `Benefits` varchar(50) DEFAULT NULL,
  `pension` int(11) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veteran_details`
--

LOCK TABLES `veteran_details` WRITE;
/*!40000 ALTER TABLE `veteran_details` DISABLE KEYS */;
INSERT INTO `veteran_details` VALUES ('abc','HJUIK12','1998-06-09','2007-07-07','2016-09-09','Male','alice street, apt 212',8,'Trainer','Food Coupons ',150,'abc','abc'),('gai','KJHUI00','1998-06-08','2007-07-07','2016-09-09','Female','alice street',8,'Soldier','Food Coupons ',1000,'gai','gai'),('raj','HRAJI98','1998-06-09','2007-07-07','2016-09-09','Male','new bury street',9,'soldier','Food Coupons Gift Cards',1500,'raj','raj'),('umesh','KJHUI98','1998-06-08','2007-07-07','2016-09-09','Male','alice street',8,'Head','Food Coupons ',100,'umesh','umesh');
/*!40000 ALTER TABLE `veteran_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-11 23:30:57
