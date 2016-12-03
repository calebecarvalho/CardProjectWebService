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

DROP TABLE IF EXISTS `cartis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cartis` (
  `NumCartao` int(11) NOT NULL,
  `Cod_Seg` int(3) NOT NULL,
  `Bandeira` varchar(20) NOT NULL,
  `Internacional` tinyint(4) NOT NULL,
  `Limite` int(11) NOT NULL,
  `DataVenc` date NOT NULL,
  `Bloqueado` tinyint(4) NOT NULL,
  `Index` int(11) NOT NULL,
  PRIMARY KEY (`NumCartao`),
  KEY `Index` (`Index`),
  CONSTRAINT `fk_CPF_ct` FOREIGN KEY (`NumCartao`) REFERENCES `cliente` (`CPF`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_NumConta_ct` FOREIGN KEY (`NumCartao`) REFERENCES `conta` (`NumConta`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartis`
--

LOCK TABLES `cartis` WRITE;
/*!40000 ALTER TABLE `cartis` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `CPF` int(12) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Senha` int(6) NOT NULL,
  `CEP` int(8) DEFAULT NULL,
  `Endereço` varchar(100) NOT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `TelefoneRes.` int(10) NOT NULL,
  `Celular` int(11) DEFAULT NULL,
  `Index` int(11) DEFAULT NULL,
  PRIMARY KEY (`CPF`),
  KEY `Index` (`Index`),
  CONSTRAINT `fk_NumConta_cl` FOREIGN KEY (`CPF`) REFERENCES `conta` (`NumConta`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conta` (
  `NumConta` int(11) NOT NULL,
  `Index` int(11) DEFAULT NULL,
  `SaldoConta` int(11) NOT NULL,
  `StatusConta` varchar(20) NOT NULL,
  `SenhaConta` int(6) NOT NULL,
  PRIMARY KEY (`NumConta`),
  KEY `Index` (`Index`),
  CONSTRAINT `fk_CPF_cta` FOREIGN KEY (`NumConta`) REFERENCES `cliente` (`CPF`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_NumCartao_cta` FOREIGN KEY (`NumConta`) REFERENCES `cartis` (`NumCartao`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estabelecimentos`
--

DROP TABLE IF EXISTS `estabelecimentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estabelecimentos` (
  `CodEstabelecimento` int(11) NOT NULL,
  `Index` int(11) DEFAULT NULL,
  `CNPJ` int(14) NOT NULL,
  `NomeEstab.` varchar(100) DEFAULT NULL,
  `Logradouro` varchar(120) DEFAULT NULL,
  `Imagem` longblob,
  PRIMARY KEY (`CodEstabelecimento`),
  KEY `Index` (`Index`)
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
  `CodFatura` int(11) NOT NULL,
  `Index` int(11) DEFAULT NULL,
  `DataFechamento` date DEFAULT NULL,
  PRIMARY KEY (`CodFatura`),
  KEY `Index` (`Index`),
  CONSTRAINT `fk_NumCartao_fat` FOREIGN KEY (`CodFatura`) REFERENCES `cartis` (`NumCartao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_NumConta_fat` FOREIGN KEY (`CodFatura`) REFERENCES `conta` (`NumConta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_NumLancamento_fat` FOREIGN KEY (`CodFatura`) REFERENCES `lancamento` (`NumLancamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faturas`
--

LOCK TABLES `faturas` WRITE;
/*!40000 ALTER TABLE `faturas` DISABLE KEYS */;
/*!40000 ALTER TABLE `faturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionarios` (
  `CodFuncionario` int(11) NOT NULL,
  `Index` int(11) DEFAULT NULL,
  `NomeFuncionario` varchar(30) NOT NULL,
  `Cargo` varchar(10) DEFAULT NULL,
  `NivelAcesso` int(1) NOT NULL,
  `Senha` int(5) NOT NULL,
  PRIMARY KEY (`CodFuncionario`),
  KEY `Index` (`Index`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionarios`
--

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lancamento`
--

DROP TABLE IF EXISTS `lancamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lancamento` (
  `NumLancamento` int(11) NOT NULL,
  `Data` datetime NOT NULL,
  `Valor` int(11) NOT NULL,
  `NumParcelas` int(11) DEFAULT NULL,
  `Index` int(11) NOT NULL,
  PRIMARY KEY (`NumLancamento`),
  KEY `Index` (`Index`),
  CONSTRAINT `fk_CodEstabelecimento_lan` FOREIGN KEY (`NumLancamento`) REFERENCES `estabelecimentos` (`CodEstabelecimento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lancamento`
--

LOCK TABLES `lancamento` WRITE;
/*!40000 ALTER TABLE `lancamento` DISABLE KEYS */;
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

-- Dump completed on 2016-12-03 13:39:40
