CREATE DATABASE  IF NOT EXISTS `pokemon_tcg_pocket` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pokemon_tcg_pocket`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pokemon_tcg_pocket
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `cartas`
--

DROP TABLE IF EXISTS `cartas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartas` (
  `id_carta` int NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `sub_tipo` varchar(50) DEFAULT NULL,
  `rareza` varchar(30) DEFAULT NULL,
  `expansion_poke` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_carta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartas`
--

LOCK TABLES `cartas` WRITE;
/*!40000 ALTER TABLE `cartas` DISABLE KEYS */;
INSERT INTO `cartas` VALUES (1,'Pikachu','Eléctrico','Básico','Común','Espada y Escudo'),(2,'Charizard','Fuego','Etapa 2','Ultra Rara','Destino Brillante'),(3,'Bulbasaur','Planta','Básico','Común','Orígenes'),(4,'Squirtle','Agua','Básico','Común','Orígenes'),(5,'Snorlax','Normal','Básico','Rara','Rebel Clash'),(6,'Gengar','Fantasma','Etapa 2','Rara Holo','Oscuridad Incandescente'),(7,'Lucario','Lucha','Etapa 1','Rara','Evoluciones'),(8,'Eevee','Normal','Básico','Común','Truenos Perdidos');
/*!40000 ALTER TABLE `cartas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartas_en_mazo`
--

DROP TABLE IF EXISTS `cartas_en_mazo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartas_en_mazo` (
  `id_mazo` int NOT NULL,
  `id_carta` int NOT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`id_mazo`,`id_carta`),
  KEY `FK_carta_mazo` (`id_carta`),
  CONSTRAINT `FK_carta_mazo` FOREIGN KEY (`id_carta`) REFERENCES `cartas` (`id_carta`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_mazo_cartas` FOREIGN KEY (`id_mazo`) REFERENCES `mazos` (`num_mazo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartas_en_mazo`
--

LOCK TABLES `cartas_en_mazo` WRITE;
/*!40000 ALTER TABLE `cartas_en_mazo` DISABLE KEYS */;
INSERT INTO `cartas_en_mazo` VALUES (101,1,3),(101,5,2),(101,8,2),(102,2,3),(102,5,1),(102,7,2),(103,3,4),(103,8,2),(104,1,1),(104,4,4),(104,6,2);
/*!40000 ALTER TABLE `cartas_en_mazo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadisticas_cartas`
--

DROP TABLE IF EXISTS `estadisticas_cartas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadisticas_cartas` (
  `id_carta` int NOT NULL,
  `hp` int DEFAULT NULL,
  `ataque_1` varchar(100) DEFAULT NULL,
  `daño_ataque_1` varchar(10) DEFAULT NULL,
  `ataque_2` varchar(100) DEFAULT NULL,
  `daño_ataque_2` varchar(10) DEFAULT NULL,
  `debilidad` varchar(50) DEFAULT NULL,
  `resistencia` varchar(50) DEFAULT NULL,
  `coste_retiro` int DEFAULT NULL,
  PRIMARY KEY (`id_carta`),
  CONSTRAINT `FK_carta_estadisticas` FOREIGN KEY (`id_carta`) REFERENCES `cartas` (`id_carta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadisticas_cartas`
--

LOCK TABLES `estadisticas_cartas` WRITE;
/*!40000 ALTER TABLE `estadisticas_cartas` DISABLE KEYS */;
INSERT INTO `estadisticas_cartas` VALUES (1,60,'Impactrueno','20','Chispa','30','Tierra','Acero',1),(2,150,'Lanzallamas','90','Explosión Fuego','130','Agua','Planta',3),(3,50,'Latigazo Cepa','10','Drenadoras','20','Fuego','Agua',1),(4,50,'Pistola Agua','20','Burbuja','10','Eléctrico','Fuego',1),(5,130,'Placaje','50','Rodar','80','Lucha','Fantasma',4),(6,120,'Lengua Maldita','60','Sombras Tenebrosas','90','Psíquico','Lucha',2),(7,110,'Puño Meteoro','70','Aguante','40','Psíquico','Oscuro',2),(8,60,'Golpe Rápido','30','Mordisco','20','Lucha','Ninguna',1);
/*!40000 ALTER TABLE `estadisticas_cartas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugadores` (
  `id_jugador` varchar(100) NOT NULL,
  `nombre_usuario` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  PRIMARY KEY (`id_jugador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES ('JUG001','AshKetchum','ash@pallet.com','2023-03-01 10:00:00'),('JUG002','MistyWater','misty@cerulean.com','2023-03-05 15:30:00'),('JUG003','BrockSolid','brock@pewter.com','2023-03-10 08:45:00'),('JUG004','GaryOak','gary@viridian.com','2023-03-12 13:20:00');
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mazos`
--

DROP TABLE IF EXISTS `mazos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mazos` (
  `num_mazo` int NOT NULL,
  `nombre_mazo` varchar(100) DEFAULT NULL,
  `num_jugador` varchar(100) DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  PRIMARY KEY (`num_mazo`),
  KEY `FK_jugador_mazo` (`num_jugador`),
  CONSTRAINT `FK_jugador_mazo` FOREIGN KEY (`num_jugador`) REFERENCES `jugadores` (`id_jugador`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mazos`
--

LOCK TABLES `mazos` WRITE;
/*!40000 ALTER TABLE `mazos` DISABLE KEYS */;
INSERT INTO `mazos` VALUES (101,'Rayo Explosivo','JUG001','2023-03-06 12:00:00'),(102,'Fuego Ardiente','JUG004','2023-03-12 14:00:00'),(103,'Verde Natural','JUG002','2023-03-08 09:00:00'),(104,'Agua Letal','JUG002','2023-03-09 10:15:00');
/*!40000 ALTER TABLE `mazos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partidas`
--

DROP TABLE IF EXISTS `partidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partidas` (
  `id_partida` int NOT NULL,
  `id_jugador_1` varchar(100) DEFAULT NULL,
  `id_jugador_2` varchar(100) DEFAULT NULL,
  `fecha_partida` datetime DEFAULT NULL,
  `ganador` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_partida`),
  KEY `FK_partida_jugador1` (`id_jugador_1`),
  KEY `FK_partida_jugador2` (`id_jugador_2`),
  KEY `FK_partida_ganador` (`ganador`),
  CONSTRAINT `FK_partida_ganador` FOREIGN KEY (`ganador`) REFERENCES `jugadores` (`id_jugador`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_partida_jugador1` FOREIGN KEY (`id_jugador_1`) REFERENCES `jugadores` (`id_jugador`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_partida_jugador2` FOREIGN KEY (`id_jugador_2`) REFERENCES `jugadores` (`id_jugador`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partidas`
--

LOCK TABLES `partidas` WRITE;
/*!40000 ALTER TABLE `partidas` DISABLE KEYS */;
INSERT INTO `partidas` VALUES (1,'jug001','jug002','2025-05-16 12:06:33','jug001'),(7,'jug001','jug002','2025-05-16 12:09:38','jug001'),(201,'JUG001','JUG004','2023-03-15 17:00:00','JUG004'),(202,'JUG002','JUG003','2023-03-16 18:30:00','JUG003'),(203,'JUG001','JUG002','2023-03-17 16:00:00','JUG002'),(204,'JUG003','JUG004','2023-03-18 19:00:00','JUG003');
/*!40000 ALTER TABLE `partidas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-02 10:13:18
