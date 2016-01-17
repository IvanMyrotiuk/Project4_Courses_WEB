-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: project4_courses
-- ------------------------------------------------------
-- Server version	5.6.24-log

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_teacher` int(10) unsigned NOT NULL,
  `name_course` varchar(90) NOT NULL,
  `places` smallint(6) NOT NULL,
  `active` tinyint(4) DEFAULT '1' COMMENT '0 - you can not enroll to the course, 1 - open regestration',
  PRIMARY KEY (`id`),
  KEY `id_teacher` (`id_teacher`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`id_teacher`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (2,9,'Java Professional',33,1),(13,11,'Java as passion',7,1),(14,11,'Films',17,1),(15,12,'My Biography',7,1),(16,12,'Life of actress',17,1),(17,13,'Communication',7,1),(18,13,'Log4j',17,1),(19,12,'Passion',17,1),(20,12,'Cooking',17,1),(21,14,'Literature',17,1),(22,14,'Java core',2,1),(23,14,'Technology',17,1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `register` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_student` int(10) unsigned NOT NULL,
  `id_course` int(10) unsigned NOT NULL,
  `registered` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mark` tinyint(4) DEFAULT '0',
  `testimonial` text,
  `graduated` timestamp NULL DEFAULT NULL,
  `active` tinyint(4) DEFAULT '1' COMMENT '0 - already graduated, 1 - studing',
  PRIMARY KEY (`id`),
  KEY `id_student` (`id_student`),
  KEY `id_course` (`id_course`),
  CONSTRAINT `register_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `student` (`id`),
  CONSTRAINT `register_ibfk_2` FOREIGN KEY (`id_course`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES (1,14,2,'2016-01-03 19:40:46',100,'Greate Job Ivan Myrotiuk you are the best of the best','2016-01-03 19:40:47',0),(48,16,14,'2016-01-10 18:05:36',0,NULL,NULL,1),(49,16,15,'2016-01-10 18:05:36',0,NULL,NULL,1),(50,16,16,'2016-01-10 18:05:36',78,'Greate','2016-01-10 18:18:29',0),(51,16,17,'2016-01-10 18:05:36',0,NULL,NULL,1),(52,16,2,'2016-01-10 18:05:47',0,NULL,NULL,1),(53,17,13,'2016-01-10 18:11:52',0,NULL,NULL,1),(54,17,14,'2016-01-10 18:11:52',0,NULL,NULL,1),(55,17,15,'2016-01-10 18:11:52',0,NULL,NULL,1),(56,17,16,'2016-01-10 18:11:52',89,'Greate','2016-01-10 18:18:29',0),(57,17,17,'2016-01-10 18:11:52',0,NULL,NULL,1),(61,18,16,'2016-01-10 18:12:18',90,'Greate','2016-01-10 18:18:29',0),(63,14,2,'2016-01-10 18:13:40',0,NULL,NULL,1),(64,14,13,'2016-01-10 18:13:40',0,NULL,NULL,1),(65,14,14,'2016-01-10 18:13:40',0,NULL,NULL,1),(66,14,15,'2016-01-10 18:13:40',0,NULL,NULL,1),(67,14,16,'2016-01-10 18:13:40',100,'Greate work you are awesome','2016-01-10 18:17:43',0),(69,14,16,'2016-01-10 18:27:53',99,'as usual awesome','2016-01-10 18:28:51',0),(70,16,16,'2016-01-10 18:27:59',85,'Better','2016-01-10 18:28:51',0),(71,14,19,'2016-01-11 20:21:59',89,'Greate','2016-01-11 20:23:58',0),(72,16,19,'2016-01-11 20:22:20',60,'Good','2016-01-11 20:24:17',0),(78,18,13,'2016-01-11 20:34:10',0,NULL,NULL,1),(79,18,14,'2016-01-11 20:34:10',0,NULL,NULL,1),(80,18,15,'2016-01-11 20:34:10',0,NULL,NULL,1),(81,18,16,'2016-01-11 20:34:10',0,NULL,NULL,1),(82,18,19,'2016-01-11 20:34:10',0,NULL,NULL,1),(83,18,17,'2016-01-11 20:34:10',0,NULL,NULL,1),(84,14,17,'2016-01-11 22:05:31',0,NULL,NULL,1),(86,16,20,'2016-01-15 01:45:05',90,'Great work','2016-01-15 01:47:30',0),(87,14,20,'2016-01-15 01:45:23',89,'You have learned material','2016-01-15 01:46:33',0),(89,20,13,'2016-01-15 15:19:48',0,NULL,NULL,1),(90,20,14,'2016-01-15 15:20:17',0,NULL,NULL,1),(91,20,15,'2016-01-15 15:20:17',0,NULL,NULL,1),(92,20,2,'2016-01-15 15:20:36',0,NULL,NULL,1),(93,20,16,'2016-01-15 15:20:36',0,NULL,NULL,1),(95,14,21,'2016-01-15 16:27:40',90,'great','2016-01-15 16:28:46',0),(96,16,21,'2016-01-15 16:27:51',91,'good','2016-01-15 16:29:04',0),(132,17,23,'2016-01-16 19:03:27',70,'You can learn material better','2016-01-16 19:04:59',0),(133,21,23,'2016-01-16 19:03:39',90,'greate work','2016-01-16 19:05:15',0);
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `address` varchar(90) NOT NULL,
  `phone_number` char(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password_hash` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (14,'Ivan','Myrotiuk','Beverly Hills 7','7777777777','ivan@gmail.com',-1032466921),(16,'Julia','Julianna','Beverly Hills 9','1234567895','julia@gmail.com',-1032466921),(17,'Lilu','LiMyrotiuk','Beverly Hills 8','8888888888','lilu@gmail.com',-1032464968),(18,'Izabella','Myrotiuk','Beverly Hills 10','2222222222','izabella.myr@gmail.com',-1032464968),(19,'Ivan Student','Myrotuik Student','Beverly Hills','2','2',49),(20,'Andrey','Andrey','123j1lkej','123','12@mail.ru',-2065160779),(21,'Suzi','Suzzanna','Hollywood 89','1234567897','suzi@gmail.com',-1032466921);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `experience_years` float NOT NULL,
  `email` varchar(45) NOT NULL,
  `password_hash` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (9,'John','Myrotiuk',2.5,'john@gmail.com',-1867378635),(10,'Ivan','Myrotuik',2,'1',49),(11,'Scarlett','Johansson',2.5,'scr@gmail.com',-1867378635),(12,'Charlize','Theron',3.5,'cher@gmail.com',-1867378635),(13,'Cameron','Diaz',1.5,'diaz@gmail.com',-1867378635),(14,'Hilary','Duff',1.5,'duff@gmail.com',-1867378635);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-16 23:32:40
