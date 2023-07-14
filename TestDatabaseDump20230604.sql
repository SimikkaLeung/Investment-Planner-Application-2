DROP DATABASE IF EXISTS banktest;
CREATE DATABASE banktest;
USE banktest;

-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: bank
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `webaccount`
--

DROP TABLE IF EXISTS `webaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `webaccount` (
  `account_id` varchar(30) NOT NULL,
  `acc_password` varchar(20) NOT NULL,
  `user_type` varchar(20) NOT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `webaccount`
--

LOCK TABLES `webaccount` WRITE;
/*!40000 ALTER TABLE `webaccount` DISABLE KEYS */;
INSERT INTO `webaccount` VALUES ('daniel77','abc123','employee\r'),('helena','abc123','client\r'),('iris2023','abc123','client\r'),('kelly','abc123','client\r'),('kelvin66','abc123','employee\r'),('kikikiki','abc123','client\r'),('peter012','abc123','client\r'),('simleung','abc123','client\r'),('steven88','abc123','employee\r');
/*!40000 ALTER TABLE `webaccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL,
  `account_id` varchar(30) NOT NULL,
  `employee_fname` varchar(255) NOT NULL,
  `employee_lname` varchar(255) NOT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `webaccount` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bankclient`
--

DROP TABLE IF EXISTS `bankclient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bankclient` (
  `client_id` int NOT NULL,
  `account_id` varchar(30) NOT NULL,
  `client_fname` varchar(255) NOT NULL,
  `client_lname` varchar(255) NOT NULL,
  `employee_assigned` int DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  KEY `account_id` (`account_id`),
  KEY `employee_assigned` (`employee_assigned`),
  CONSTRAINT `bankclient_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `webaccount` (`account_id`),
  CONSTRAINT `bankclient_ibfk_2` FOREIGN KEY (`employee_assigned`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankclient`
--

LOCK TABLES `bankclient` WRITE;
/*!40000 ALTER TABLE `bankclient` DISABLE KEYS */;
INSERT INTO `bankclient` VALUES (1,'simleung','Sim','Leung',1),(2,'peter012','Peter','Pang',2),(3,'kelly','Kelly','Chan',1),(4,'iris2023','Iris','Lee',3),(5,'kikikiki','Kiki','Lam',NULL),(6,'helena','Helena','Wong',NULL);
/*!40000 ALTER TABLE `bankclient` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'kelvin66','Kelvin','Cheung\r'),(2,'daniel77','Daniel','Leung\r'),(3,'steven88','Steven','Chan\r');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `product_type` varchar(255) NOT NULL,
  `num_of_days` int NOT NULL,
  `interest_rate` decimal(10,7) NOT NULL,
  `min_principal` decimal(20,2) NOT NULL,
  `max_principal` decimal(20,2) NOT NULL,
  `days_per_compounding` int NOT NULL,
  `effective_rate` decimal(10,7) GENERATED ALWAYS AS (((pow((1 + (`interest_rate` / 100)),(`num_of_days` / `days_per_compounding`)) - 1) * 100)) VIRTUAL,
  `product_desc` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  CONSTRAINT `highest_prinicpal` CHECK ((`max_principal` > `min_principal`)),
  CONSTRAINT `lowest_prinicpal` CHECK ((`min_principal` > 0)),
  CONSTRAINT `min_days2` CHECK ((`num_of_days` > 0)),
  CONSTRAINT `positive_rate2` CHECK ((`interest_rate` > 0)),
  CONSTRAINT `valid_compounding1` CHECK ((`days_per_compounding` > 0)),
  CONSTRAINT `valid_compounding2` CHECK ((`days_per_compounding` <= `num_of_days`))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`product_id`, `product_name`, `product_type`, `num_of_days`, `interest_rate`, `min_principal`, `max_principal`, `days_per_compounding`, `product_desc`) VALUES (1,'6-month Fixed Rate Saving','Term Savings',183,1.0000000,1000.00,1000000.00,183,'Guaranteed fixed-rate investments (term savings). The interest is not compounded.\r'),(2,'1-year Fixed Rate Saving','Term Savings',365,2.0000000,2000.00,2000000.00,365,'Guaranteed fixed-rate investments (term savings). The interest is compounded annually.\r'),(3,'2-year Fixed Rate Saving','Term Savings',730,3.0000000,3000.00,2000000.00,365,'Guaranteed fixed-rate investments (term savings). The interest is compounded annually.\r'),(4,'US Gov Treasury Notes','Treasury Notes',1095,5.0000000,2000.00,500000.00,1095,'The interests are issued in forms of coupons and are not compounded.\r'),(5,'Hong Kong 2 Year Government Bond','Bond',730,5.0000000,4000.00,500000.00,730,'The interests are issued in forms of coupons and are not compounded.\r'),(6,'Canada Gov Treasury Bills','Treasury Bills',183,1.5000000,1500.00,200000.00,183,'The interest earned or return on the investment is the difference between the purchase price and the face value amount of the bill.\r'),(7,'Conservative Portfolio','Portfolio',730,5.0000000,2000.00,10000000.00,365,'The interest rate listed is an expected rate and not a guranteed rate. The interest is compounded annually.\r'),(8,'Balanced Portfolio','Portfolio',1095,7.0000000,2000.00,10000000.00,365,'The interest rate listed is an expected rate and not a guranteed rate. The interest is compounded annually.\r'),(9,'Growth Portfolio','Portfolio',1095,10.0000000,5000.00,10000000.00,365,'The interest rate listed is an expected rate and not a guranteed rate. The interest is compounded annually.\r'),(10,'Aggressive Growth Portfolio','Portfolio',1095,15.0000000,5000.00,10000000.00,365,'The interest rate listed is an expected rate and not a guranteed rate. The interest is compounded annually.\r');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionnaire`
--

DROP TABLE IF EXISTS `questionnaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questionnaire` (
  `quest_id` int NOT NULL,
  `client_id` int NOT NULL,
  `principal` decimal(20,2) NOT NULL,
  `target_rate` decimal(10,7) NOT NULL,
  `num_of_days` int NOT NULL,
  `submission_time` datetime NOT NULL,
  PRIMARY KEY (`quest_id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `questionnaire_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `bankclient` (`client_id`),
  CONSTRAINT `min_days1` CHECK ((`num_of_days` > 0)),
  CONSTRAINT `min_principal` CHECK ((`principal` > 0)),
  CONSTRAINT `positive_rate1` CHECK ((`target_rate` > 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionnaire`
--

LOCK TABLES `questionnaire` WRITE;
/*!40000 ALTER TABLE `questionnaire` DISABLE KEYS */;
INSERT INTO `questionnaire` VALUES (1,3,50000.00,13.0000000,750,'2023-06-04 05:30:42'),(2,3,5000000.00,80.0000000,1300,'2023-06-04 05:31:12'),(3,1,888888.00,30.0000000,750,'2023-06-04 05:32:09'),(4,1,500.00,5.0000000,750,'2023-06-04 05:32:29'),(5,1,2000.00,5.0000000,750,'2023-06-04 05:32:35');
/*!40000 ALTER TABLE `questionnaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suggestion`
--

DROP TABLE IF EXISTS `suggestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suggestion` (
  `suggestion_id` int NOT NULL,
  `quest_id` int NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`suggestion_id`),
  KEY `quest_id` (`quest_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `suggestion_ibfk_1` FOREIGN KEY (`quest_id`) REFERENCES `questionnaire` (`quest_id`),
  CONSTRAINT `suggestion_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suggestion`
--

LOCK TABLES `suggestion` WRITE;
/*!40000 ALTER TABLE `suggestion` DISABLE KEYS */;
INSERT INTO `suggestion` VALUES (1,1,7),(2,1,3),(3,1,5),(4,1,2),(5,1,6),(6,1,1),(7,2,10),(8,2,9),(9,2,8),(10,2,7),(11,3,7),(12,3,3),(13,3,2),(14,3,1),(15,5,2),(16,5,6),(17,5,1);
/*!40000 ALTER TABLE `suggestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bank'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-04 10:18:54
SELECT * FROM webaccount;
SELECT * FROM employee;
SELECT * FROM bankclient;
SELECT * FROM product;
SELECT * FROM suggestion;
SELECT * FROM questionnaire;
