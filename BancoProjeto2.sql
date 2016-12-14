CREATE DATABASE  IF NOT EXISTS `projeto_d` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `projeto_d`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: projeto_d
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `cartis`
--
SET FOREIGN_KEY_CHECKS=0
DROP TABLE IF EXISTS `cartis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cartis` (
  `Id` int(11) NOT NULL,
  `NumCartao` varchar(15) NOT NULL,
  `Cod_Seg` int(3) NOT NULL,
  `Bandeira` varchar(20) NOT NULL,
  `Internacional` tinyint(4) NOT NULL,
  `Limite` int(11) NOT NULL,
  `DataVenc` date NOT NULL,
  `Bloqueado` tinyint(4) NOT NULL,
  PRIMARY KEY (`NumCartao`),
  UNIQUE KEY `NumCartao_UNIQUE` (`NumCartao`),
  CONSTRAINT `fk_CodFatura` FOREIGN KEY (`NumCartao`) REFERENCES `faturas` (`CodFatura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_NumConta` FOREIGN KEY (`NumCartao`) REFERENCES `conta` (`NumConta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartis`
--

LOCK TABLES `cartis` WRITE;
/*!40000 ALTER TABLE `cartis` DISABLE KEYS */;
INSERT INTO `cartis` VALUES (1,'4567891234',987,'VISA',0,799,'2019-09-09',0);
/*!40000 ALTER TABLE `cartis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `Id` varchar(11) NOT NULL,
  `CPF` varchar(12) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Senha` int(6) NOT NULL,
  `CEP` varchar(10) DEFAULT NULL,
  `Endereço` varchar(100) NOT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `TelefoneRes.` varchar(15) NOT NULL,
  `Celular` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`CPF`),
  KEY `fk_NumCartao_cl_idx` (`Id`),
  CONSTRAINT `fk_NumCartao_cl` FOREIGN KEY (`CPF`) REFERENCES `cartis` (`NumCartao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_NumConta_cl` FOREIGN KEY (`CPF`) REFERENCES `conta` (`NumConta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('01','47027178800','Calebe Carvalho',789567,'13277411','Rua Luiz','calebe@teste.com','1932792429','19983984501');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conta` (
  `Id` int(11) NOT NULL,
  `NumConta` varchar(20) NOT NULL,
  `SaldoConta` int(11) NOT NULL,
  `StatusConta` varchar(20) NOT NULL,
  `SenhaConta` int(6) NOT NULL,
  PRIMARY KEY (`NumConta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` VALUES (1,'03245',1000,'Ativa',789567);
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estabelecimentos`
--

DROP TABLE IF EXISTS `estabelecimentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estabelecimentos` (
  `Id` int(11) NOT NULL,
  `CodEstabelecimento` varchar(20) NOT NULL,
  `Index` int(11) DEFAULT NULL,
  `CNPJ` int(14) NOT NULL,
  `NomeEstab.` varchar(100) DEFAULT NULL,
  `Logradouro` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`CodEstabelecimento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estabelecimentos`
--

LOCK TABLES `estabelecimentos` WRITE;
/*!40000 ALTER TABLE `estabelecimentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `estabelecimentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faturas`
--

DROP TABLE IF EXISTS `faturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faturas` (
  `Id` int(11) NOT NULL,
  `CodFatura` varchar(20) NOT NULL,
  `DataFechamento` date DEFAULT NULL,
  PRIMARY KEY (`CodFatura`),
  CONSTRAINT `fk_NumLancamento` FOREIGN KEY (`CodFatura`) REFERENCES `lancamento` (`NumLancamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faturas`
--

LOCK TABLES `faturas` WRITE;
/*!40000 ALTER TABLE `faturas` DISABLE KEYS */;
INSERT INTO `faturas` VALUES (1,'6788','2016-09-10'),(1,'6789','2016-10-10');
/*!40000 ALTER TABLE `faturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lancamento`
--

DROP TABLE IF EXISTS `lancamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lancamento` (
  `Id` int(11) NOT NULL,
  `NumLancamento` varchar(20) NOT NULL,
  `Data` datetime NOT NULL,
  `Valor` int(11) NOT NULL,
  `NumParcelas` int(11) DEFAULT NULL,
  PRIMARY KEY (`NumLancamento`),
  KEY `Index` (`Id`),
  CONSTRAINT `fk_CodEstabelecimento_lan` FOREIGN KEY (`NumLancamento`) REFERENCES `estabelecimentos` (`CodEstabelecimento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lancamento`
--

LOCK TABLES `lancamento` WRITE;
/*!40000 ALTER TABLE `lancamento` DISABLE KEYS */;
INSERT INTO `lancamento` VALUES (1,'3030','2016-10-09 00:00:00',30,1),(1,'3032','2016-10-04 00:00:00',200,1);
/*!40000 ALTER TABLE `lancamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'projeto_d'
--

--
-- Dumping routines for database 'projeto_d'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-14 18:16:42
