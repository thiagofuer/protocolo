-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: protocolo
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Dumping data for table `classeprocessual`
--

LOCK TABLES `classeprocessual` WRITE;
/*!40000 ALTER TABLE `classeprocessual` DISABLE KEYS */;
INSERT INTO `classeprocessual` VALUES (1,'Procedimento Sumário'),(2,'Procedimento Ordinário'),(3,'Procedimento do Juizado Especial Cível'),(4,'Guarda'),(5,'Nunciação de Obra Nova'),(6,'Execução de Título Extrajudicial'),(7,'Cumprimento de Sentença'),(8,'Execução de Alimentos'),(9,'Relatório Falimentar'),(10,'Homologação de transação extrajudicial'),(11,'Insolvência Requerida pelo Credor'),(12,'Reintegração / Manutenção de Posse'),(13,'Outros Procedimentos de Jurisdição Voluntária'),(14,'Inquérito Policial'),(15,'Ação Penal - Proc. Ordinário'),(16,'Ação Penal - Júri'),(17,'Regulamentação de Visitas'),(18,'Crimes contra a Propriedade Imaterial'),(19,'Pedido de Prisão Temporária'),(20,'Notificação para Explicações'),(21,'Procedimento Investigatório do MP'),(22,'Medidas Protetivas de Urgência'),(23,'Auto Apreensão Flagrante'),(24,'Apuração de Ato Infracional'),(25,'Protocolo de Petição'),(26,'Mandado de Segurança Coletivo'),(27,'Divórcio Consensual'),(28,'Divórcio Litigioso'),(29,'Dúvida'),(30,'Expropriação da Lei 8.257/91'),(31,'Falência de Empresários, Sociedades Empresáriais, Microempresas e Empresas de Pequeno Porte'),(32,'Decretação de Prisão Criminal'),(33,'Habeas Data'),(34,'Habilitação de Crédito'),(35,'Homologação de Transação Extrajudicial'),(36,'Ofício'),(37,'Imissão na Posse'),(38,'Decretação de Prisão Civil'),(39,'Impugnação de Crédito'),(40,'Inquérito Extrajudicial'),(41,'Recebimento'),(42,'Decretação de Internação'),(43,'Mandado de Injunção'),(44,'Mandado de Segurança Coletivo'),(45,'Mandado de Segurança'),(46,'Opção de Nacionalidade'),(47,'Desacolhimento de Prisão'),(48,'Averiguação de Paternidade'),(49,'Remessa'),(50,'Pedido de Resposta ou Retificação da Lei de Imprensa'),(51,'Protesto Formado a Bordo'),(52,'Recuperação Extrajudicial'),(53,'Prisão'),(54,'Recuperação Judicial'),(55,'Recebimento'),(56,'Acolhimento de exceção'),(57,'Registro Torrens'),(58,'Relatório Falimentar'),(59,'Apensamento'),(60,'Remição do Imóvel Hipotecado'),(61,'Renovatória de Locação'),(62,'Desapensamento'),(63,'Restituição de Coisa ou Dinheiro na Falência do Devedor Empresário'),(64,'Rejeição'),(65,'Revisional de Aluguel'),(66,'Separação Litigiosa'),(67,'Sonegados'),(68,'Suprimento de Idade e/ou Consentimento'),(69,'Suspensão de Liminar ou Antecipação de Tutela'),(70,'Suspensão de Execução de Sentença'),(71,'Não-Homologação de prisão em flagrante'),(72,'Procedimento de Liquidação'),(73,'Liquidação por Arbitramento'),(74,'Concessão de efeito suspensivo'),(75,'Liquidação por Artigos'),(76,'Liquidação Provisória por Arbitramento'),(77,'Liquidação Provisória por Artigos'),(78,'Procedimento de Cumprimento de Sentença/Decisão'),(79,'Cumprimento de sentença'),(80,'Cumprimento Provisório de Sentença'),(81,'Revogação'),(82,'Processo de Execução'),(83,'Execução de Título Extrajudicial'),(84,'Mandado'),(85,'Devolução'),(86,'Oficial de Justiça');
/*!40000 ALTER TABLE `classeprocessual` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `competencia`
--

LOCK TABLES `competencia` WRITE;
/*!40000 ALTER TABLE `competencia` DISABLE KEYS */;
INSERT INTO `competencia` VALUES (1,0),(2,1),(3,2),(4,0),(5,0),(6,0),(7,0),(8,0),(9,0),(10,0),(11,0),(12,0),(13,0),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(20,1),(21,1),(22,1),(23,1),(24,1),(25,1),(26,1),(27,1),(28,1),(29,1),(30,1),(31,1),(32,1),(33,1),(34,2),(35,2),(36,0),(37,3),(38,0),(39,0),(40,0),(41,0),(42,0),(43,0),(44,0),(45,0),(46,0),(47,0),(48,0),(49,0),(50,0),(51,0),(52,0),(53,3),(54,3),(55,3),(56,3),(57,3),(58,3),(59,3),(60,3),(61,3),(62,3),(63,3),(64,3),(65,3),(66,3),(67,3),(68,3),(69,1),(70,1),(71,1),(72,1),(73,1),(74,1),(75,1),(76,1),(77,1),(78,1),(79,1),(80,1),(81,1),(82,1),(83,1),(84,1),(85,1),(86,1),(87,1),(88,1),(89,1),(90,1),(91,1),(92,1);
/*!40000 ALTER TABLE `competencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `classe_competencia`
--

LOCK TABLES `classe_competencia` WRITE;
/*!40000 ALTER TABLE `classe_competencia` DISABLE KEYS */;
INSERT INTO `classe_competencia` VALUES (1,4),(2,5),(3,6),(4,7),(5,8),(6,9),(7,10),(8,11),(9,12),(10,13),(11,14),(12,15),(13,16),(14,17),(15,18),(16,19),(17,20),(18,21),(19,22),(20,23),(21,24),(22,25),(23,26),(24,27),(25,28),(26,29),(27,30),(28,31),(29,32),(30,33),(31,34),(32,35),(33,38),(34,39),(35,40),(36,41),(37,42),(38,43),(39,44),(40,45),(41,46),(42,47),(43,48),(44,49),(45,50),(46,51),(47,52),(48,53),(49,54),(50,55),(51,56),(52,57),(53,58),(54,59),(55,60),(56,61),(57,62),(58,63),(59,64),(60,65),(61,66),(62,67),(63,68),(64,70),(65,71),(66,72),(67,73),(68,74),(69,75),(70,76),(71,77),(72,78),(73,79),(74,80),(75,81),(76,82),(77,83),(78,84),(79,85),(80,86),(81,87),(82,88),(83,89),(84,90),(85,91),(86,92);
/*!40000 ALTER TABLE `classe_competencia` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `comarca`
--

LOCK TABLES `comarca` WRITE;
/*!40000 ALTER TABLE `comarca` DISABLE KEYS */;
INSERT INTO `comarca` VALUES (1,'Cuiabá');
/*!40000 ALTER TABLE `comarca` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `vara`
--

LOCK TABLES `vara` WRITE;
/*!40000 ALTER TABLE `vara` DISABLE KEYS */;
INSERT INTO `vara` VALUES (1,'Quarta vara cível',1),(2,'Sétima vara cível',1),(3,'Terceira vara cível',1),(4,'Primeira vara cível da capital',1),(5,'Primeira vara especializada da família e sucessões',1), (6,'Primeira vara especializada da fazenda pública',1), (7,'Primeira vara especializada direito bancário',1);
/*!40000 ALTER TABLE `vara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `vara_competencia`
--

LOCK TABLES `vara_competencia` WRITE;
/*!40000 ALTER TABLE `vara_competencia` DISABLE KEYS */;
INSERT INTO `vara_competencia` VALUES (1,1),(1,2),(1,3),(2,36),(2,37),(3,69);
/*!40000 ALTER TABLE `vara_competencia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

--
-- Dumping data for table `processo`
--

LOCK TABLES `processo` WRITE;
/*!40000 ALTER TABLE `processo` DISABLE KEYS */;
INSERT INTO `processo` VALUES (1,'2',1,1),(2,'49',2,1),(3,'23',3,1),(4,'49',4,1),(5,'31',5,1),(6,'87',6,1),(7,'33',7,1),(8,'65',8,1),(9,'7',9,1),(10,'61',10,1),(11,'17',11,1),(12,'37',12,1),(13,'55',13,1),(14,'89',14,1),(15,'11',15,1),(16,'75',16,1),(17,'22',17,1),(18,'54',18,1),(19,'64',19,1),(20,'17',20,1),(21,'66',21,1),(22,'95',22,1),(23,'16',23,1),(24,'98',24,1),(25,'44',25,1),(26,'74',26,1),(27,'44',27,1),(28,'62',28,1),(29,'40',29,1),(30,'77',30,1),(31,'61',31,1),(32,'65',32,1),(33,'29',33,2),(34,'96',34,2),(35,'23',35,2),(36,'59',36,2),(37,'73',37,2),(38,'88',38,2),(39,'6',39,2),(40,'60',40,2),(41,'60',41,2),(42,'25',42,2),(43,'6',43,2),(44,'92',44,2),(45,'64',45,2),(46,'7',46,2),(47,'19',47,2),(48,'16',48,2),(49,'53',49,2),(50,'20',50,2),(51,'73',51,2),(52,'11',52,2),(53,'11',53,2),(54,'74',54,2),(55,'59',55,2),(56,'52',56,2),(57,'45',57,2),(58,'22',58,2),(59,'85',59,2),(60,'50',60,2),(61,'43',61,2),(62,'64',62,2),(63,'85',63,2),(64,'21',64,3),(65,'2',65,3),(66,'34',66,3),(67,'82',67,3),(68,'80',68,3),(69,'90',69,3),(70,'2',70,3),(71,'28',71,3),(72,'62',72,3),(73,'58',73,3),(74,'69',74,3),(75,'12',75,3),(76,'92',76,3),(77,'58',77,3),(78,'26',78,3),(79,'68',79,3),(80,'74',80,3),(81,'74',81,3),(82,'82',82,3),(83,'57',83,3),(84,'48',84,3),(85,'58',85,3),(86,'32',86,3);
/*!40000 ALTER TABLE `processo` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-09 17:16:52
