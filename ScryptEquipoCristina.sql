-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: equipo
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `entrenador`
--

DROP TABLE IF EXISTS `entrenador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrenador` (
  `codentrenador` int NOT NULL AUTO_INCREMENT,
  `dni` char(12) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `ape1` varchar(50) DEFAULT NULL,
  `ape2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codentrenador`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrenador`
--

LOCK TABLES `entrenador` WRITE;
/*!40000 ALTER TABLE `entrenador` DISABLE KEYS */;
INSERT INTO `entrenador` VALUES (1,'79297715V','Mohamed','Mota','Cifuentes'),(2,'67232956T','Maria','Barea','Guevara'),(3,'23977487X','Kevin','Mateos','Sanz'),(4,'11527656X','Carmen','Prada','Vallejo');
/*!40000 ALTER TABLE `entrenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo` (
  `codequipo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `direcsede` varchar(100) DEFAULT NULL,
  `fondos` decimal(10,0) DEFAULT NULL,
  `codentrenador` int DEFAULT NULL,
  PRIMARY KEY (`codequipo`),
  KEY `fk_codentrenador` (`codentrenador`),
  CONSTRAINT `fk_codentrenador` FOREIGN KEY (`codentrenador`) REFERENCES `entrenador` (`codentrenador`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=1235 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES (1231,'Pablo Picaso','Calle nose donde nº45',2145778,4),(1232,'Marbella','Avenida Sin originalidad nº1',321456,2),(1233,'Esteponense','Calle Inevntada nº2',2000254,3),(1234,'Estepona','Calle Inventada nº1',2000000,1);
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugador`
--

DROP TABLE IF EXISTS `jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugador` (
  `codjugador` int NOT NULL AUTO_INCREMENT,
  `dni` char(12) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `ape1` varchar(50) DEFAULT NULL,
  `ape2` varchar(50) DEFAULT NULL,
  `codequipo` int DEFAULT NULL,
  PRIMARY KEY (`codjugador`),
  KEY `fk_codequipo` (`codequipo`),
  CONSTRAINT `fk_codequipo` FOREIGN KEY (`codequipo`) REFERENCES `equipo` (`codequipo`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=1116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador`
--

LOCK TABLES `jugador` WRITE;
/*!40000 ALTER TABLE `jugador` DISABLE KEYS */;
INSERT INTO `jugador` VALUES (1112,'97771686C','Siham','Capdevila','Sampedro',1234),(1113,'68508954G','Jonatan','Ayala','Zheng',1233),(1114,'37675206X','Ramiro','Molinero','Lago',1231),(1115,'15905854C','Angel','del Castillo','Moran',1232);
/*!40000 ALTER TABLE `jugador` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-25 22:24:40
