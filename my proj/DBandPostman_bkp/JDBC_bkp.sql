-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: jpql_db
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_category` varchar(255) DEFAULT NULL,
  `product_created_date` datetime(6) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_price` double NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'GROCERY','2023-08-26 16:22:53.456000','Fully Grained Basmati Rice','Rice 50 Kg',1200),(2,'GROCERY','2023-08-26 16:24:51.240000','Fresh Chakki Aata','Wheat 20 Kg',700),(3,'ELECTRONICS','2023-08-26 16:25:49.657000','Samsung top of the line Galaxy S series Model','Samsung S23 Ultra',110000),(4,'BOOKS','2023-08-26 16:26:48.438000','Harry Potter Series','Harry Potter : Prisoner of Azkaban',350),(5,'BOOKS','2023-08-26 16:27:58.296000','Creed of Assassins','Assassin Creed',320),(6,'MEN_FASHION','2023-08-26 16:29:09.127000','Hoodie with different size','Hoodie X XL M L',798),(7,'MEN_FASHION','2023-08-26 16:29:35.645000','Jeans with different size','Jeans X XL M L',899),(8,'MEN_FASHION','2023-08-26 16:29:58.725000','Shirts with different size','Shirt X XL M L',645),(9,'WOMEN_FASHION','2023-08-26 16:31:26.938000','Kurtas with different size','Kurta X XL M L',1045),(10,'WOMEN_FASHION','2023-08-26 16:31:54.108000','Piecses with different size','One Piece X XL M L',1021),(12,'WOMEN_FASHION','2023-08-26 20:21:41.357000','Leggings with different size','Leggings X XL M L',449);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-27 17:11:03
