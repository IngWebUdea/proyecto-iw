-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: eduficticia
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `agenda_pruebas`
--

DROP TABLE IF EXISTS `agenda_pruebas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda_pruebas` (
  `pruebas_codigo` varchar(16) NOT NULL,
  `grupos_idgrupos` varchar(16) NOT NULL,
  `fecha_aplica` datetime NOT NULL,
  `usuario_encargado` varchar(32) DEFAULT NULL,
  `usuario_crea` varchar(32) NOT NULL,
  `fecha_crea` datetime NOT NULL,
  `usuario_modifica` varchar(32) DEFAULT NULL,
  `fecha_modifica` datetime DEFAULT NULL,
  `usuario_cancela` varchar(32) DEFAULT NULL,
  `fecha_cancela` datetime DEFAULT NULL,
  `cancelado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`pruebas_codigo`,`grupos_idgrupos`,`fecha_aplica`),
  KEY `fk_agenda_pruebas_pruebas1_idx` (`pruebas_codigo`),
  KEY `fk_agenda_pruebas_grupos1_idx` (`grupos_idgrupos`),
  CONSTRAINT `fk_agenda_pruebas_grupos1` FOREIGN KEY (`grupos_idgrupos`) REFERENCES `grupos` (`idgrupos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agenda_pruebas_pruebas1` FOREIGN KEY (`pruebas_codigo`) REFERENCES `pruebas` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='se agendan las pruebas para los grupos, en fechas establecidas';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda_pruebas`
--

LOCK TABLES `agenda_pruebas` WRITE;
/*!40000 ALTER TABLE `agenda_pruebas` DISABLE KEYS */;
INSERT INTO `agenda_pruebas` VALUES ('I0117-01','1102','2017-05-06 00:00:00',NULL,'user01','2017-04-20 00:00:00',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `agenda_pruebas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `areas` (
  `idarea` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(128) NOT NULL,
  PRIMARY KEY (`idarea`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` VALUES (1,'Matemáticas'),(2,'Español'),(3,'Química'),(4,'Biología'),(5,'Sociales'),(6,'Humanidades');
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `id_categoria` varchar(16) NOT NULL,
  `descripcion` varchar(64) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='para categorizar las pruebas en bimensual, simulacro universidad, etc';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES ('BIM','Prueba Bimensual'),('PSU','Prueba Simulación Universidad');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudades`
--

DROP TABLE IF EXISTS `ciudades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudades` (
  `idciudades` int(11) NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(64) NOT NULL,
  `codigo` varchar(16) NOT NULL,
  `provincia` int(11) NOT NULL,
  PRIMARY KEY (`idciudades`),
  KEY `FK_provincia_idx` (`provincia`),
  CONSTRAINT `FK_provincia` FOREIGN KEY (`provincia`) REFERENCES `provincias` (`idprovincias`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudades`
--

LOCK TABLES `ciudades` WRITE;
/*!40000 ALTER TABLE `ciudades` DISABLE KEYS */;
INSERT INTO `ciudades` VALUES (1,'Medellin','001',1),(2,'Abejorral','002',1),(3,'Envigado','266',1),(4,'Itagui','360',1),(5,'Marinilla','440',1),(6,'Rionegro','615',1),(7,'Sonson','756',1),(8,'San Rafael','667',1),(31,'Santa Fe De Bogotá D.C.','001',2),(32,'Chapinero','002',2),(33,'Candelaria','017',2),(34,'Manizales','001',3),(35,'Aguadas','013',3),(36,'Quibdó','001',4),(37,'Acandí','006',4),(38,'Armenia','001',5),(39,'Calarcá','130',5),(40,'Cali','001',6),(41,'Bunaventura','109',6);
/*!40000 ALTER TABLE `ciudades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grados`
--

DROP TABLE IF EXISTS `grados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grados` (
  `idgrados` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(16) NOT NULL,
  PRIMARY KEY (`idgrados`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grados`
--

LOCK TABLES `grados` WRITE;
/*!40000 ALTER TABLE `grados` DISABLE KEYS */;
INSERT INTO `grados` VALUES (8,'Octavo'),(9,'Noveno'),(10,'Décimo'),(11,'Once');
/*!40000 ALTER TABLE `grados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupos`
--

DROP TABLE IF EXISTS `grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupos` (
  `idgrupos` varchar(16) NOT NULL,
  `aula` varchar(16) NOT NULL,
  `grado` int(11) NOT NULL,
  PRIMARY KEY (`idgrupos`),
  KEY `FK_grado_idx` (`grado`),
  CONSTRAINT `FK_grado` FOREIGN KEY (`grado`) REFERENCES `grados` (`idgrados`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos`
--

LOCK TABLES `grupos` WRITE;
/*!40000 ALTER TABLE `grupos` DISABLE KEYS */;
INSERT INTO `grupos` VALUES ('1001','03',10),('1101','01',11),('1102','02',11);
/*!40000 ALTER TABLE `grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paises` (
  `idpaises` int(11) NOT NULL AUTO_INCREMENT,
  `pais` varchar(64) NOT NULL,
  `codigo` varchar(16) NOT NULL,
  PRIMARY KEY (`idpaises`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
INSERT INTO `paises` VALUES (1,'Colombia','57'),(2,'Argentina','54'),(3,'Chile','56'),(4,'Brazil','55'),(5,'Perú','51');
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfiles`
--

DROP TABLE IF EXISTS `perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfiles` (
  `idperfil` int(11) NOT NULL AUTO_INCREMENT,
  `perfil` varchar(32) NOT NULL,
  `codigo` varchar(8) NOT NULL COMMENT '\nEST\nACAD\nDOC\nADM',
  PRIMARY KEY (`idperfil`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfiles`
--

LOCK TABLES `perfiles` WRITE;
/*!40000 ALTER TABLE `perfiles` DISABLE KEYS */;
INSERT INTO `perfiles` VALUES (1,'Administrador','ADM'),(2,'Acudiente','ACD'),(3,'Estudiante','EST'),(4,'Sistemas','SIS'),(5,'Academico','ACD'),(6,'Docente','DCN'),(7,'Secretaria','SCR'),(8,'Auditor','ADT'),(9,'Director','DRC');
/*!40000 ALTER TABLE `perfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personas` (
  `idpersona` varchar(32) NOT NULL,
  `nombre` varchar(128) NOT NULL,
  `apellido` varchar(128) NOT NULL,
  `telefono` varchar(32) NOT NULL,
  `fechanacimiento` datetime NOT NULL,
  `email` varchar(128) NOT NULL,
  `institucion` varchar(128) NOT NULL,
  `tipodocumento` int(11) NOT NULL,
  `ciudad` int(11) NOT NULL,
  PRIMARY KEY (`idpersona`),
  KEY `FKtipoDoc_idx` (`tipodocumento`),
  KEY `FK_ciudad_idx` (`ciudad`),
  CONSTRAINT `FK_ciudad` FOREIGN KEY (`ciudad`) REFERENCES `ciudades` (`idciudades`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FKtipoDoc` FOREIGN KEY (`tipodocumento`) REFERENCES `tipos_doc` (`idtipodoc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES ('001','Andrés','Castro','300','1978-05-06 00:00:00','mail01@mail.com','institut01',1,1),('002','Acudiente01','ApeAcud01','301','1980-01-01 00:00:00','mail02@mail.com','institut01',1,1),('003','Estudiante01','ApeEsty01','302','1980-01-01 00:00:00','mail03@mail.com','institut01',2,6);
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preguntas`
--

DROP TABLE IF EXISTS `preguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preguntas` (
  `idpregunta` int(11) NOT NULL AUTO_INCREMENT,
  `texto` text NOT NULL,
  `numopt` int(11) NOT NULL COMMENT 'numero de opciones de respuesta',
  `opciones` json NOT NULL,
  `opt_correcta` char(1) NOT NULL,
  `nivel_dif` char(1) NOT NULL,
  `imgpath` varchar(256) DEFAULT NULL,
  `tiempo_rta` time DEFAULT NULL COMMENT 'Tiempo estimado en el que se responde la pregunta',
  `solucion` text,
  `sug_especifica` varchar(512) DEFAULT NULL COMMENT 'sugerencias para el aprendizaje de la o las temáticas abordadas por la pregunta',
  `usuariocrea` varchar(32) NOT NULL,
  `fechacrea` datetime NOT NULL,
  PRIMARY KEY (`idpregunta`),
  KEY `FK_usuario_idx` (`usuariocrea`),
  CONSTRAINT `FK_usuario` FOREIGN KEY (`usuariocrea`) REFERENCES `usuarios` (`login`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntas`
--

LOCK TABLES `preguntas` WRITE;
/*!40000 ALTER TABLE `preguntas` DISABLE KEYS */;
INSERT INTO `preguntas` VALUES (1,'Texto pregunta matematicas 01',4,'{\"a\": \"p1 option a\", \"b\": \"p1 option b\", \"c\": \"p1 option c\", \"d\": \"p1 option d\"}','b','0',NULL,NULL,NULL,NULL,'user01','2017-04-29 00:00:00'),(2,'Texto pregunta matematicas 02',4,'{\"a\": \"p2 option a\", \"b\": \"p2 option b\", \"c\": \"p2 option c\", \"d\": \"p2 option d\"}','a','0',NULL,NULL,NULL,NULL,'user01','2017-04-29 00:00:00'),(3,'Texto pregunta biología 03',4,'{\"a\": \"p3 option a\", \"b\": \"p3 option b\", \"c\": \"p3 option c\", \"d\": \"p3 option d\"}','c','0',NULL,NULL,NULL,NULL,'user01','2017-04-29 00:00:00'),(4,'Texto pregunta química 04',4,'{\"a\": \"p4 option a\", \"b\": \"p4 option b\", \"c\": \"p4 option c\", \"d\": \"p4 option d\"}','c','1',NULL,NULL,NULL,NULL,'user01','2017-04-29 00:00:00'),(5,'Texto pregunta español 05',4,'{\"a\": \"p5 option a\", \"b\": \"p5 option b\", \"c\": \"p5 option c\", \"d\": \"p5 option d\"}','d','2',NULL,NULL,NULL,NULL,'user01','2017-04-29 00:00:00');
/*!40000 ALTER TABLE `preguntas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincias`
--

DROP TABLE IF EXISTS `provincias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincias` (
  `idprovincias` int(11) NOT NULL AUTO_INCREMENT,
  `provincia` varchar(64) NOT NULL,
  `codigo` varchar(16) NOT NULL,
  `pais` int(11) NOT NULL,
  PRIMARY KEY (`idprovincias`),
  KEY `FK_pais_idx` (`pais`),
  CONSTRAINT `FK_pais` FOREIGN KEY (`pais`) REFERENCES `paises` (`idpaises`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
INSERT INTO `provincias` VALUES (1,'Antioquia','05',1),(2,'Santa Fe De Bogotá','11',1),(3,'Caldas','17',1),(4,'Chocó','27',1),(5,'Quindio','63',1),(6,'Valle','76',1);
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pruebas`
--

DROP TABLE IF EXISTS `pruebas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pruebas` (
  `codigo` varchar(16) NOT NULL,
  `categoria` varchar(16) NOT NULL,
  `num_preguntas` int(11) NOT NULL,
  `duracion` time NOT NULL,
  `fecha_crea` datetime NOT NULL,
  `usuario_crea` varchar(32) NOT NULL,
  `aleatoria` tinyint(1) NOT NULL,
  `descripcion` varchar(512) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_categoria_idx` (`categoria`),
  CONSTRAINT `FK_categoria` FOREIGN KEY (`categoria`) REFERENCES `categorias` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pruebas`
--

LOCK TABLES `pruebas` WRITE;
/*!40000 ALTER TABLE `pruebas` DISABLE KEYS */;
INSERT INTO `pruebas` VALUES ('I0117-01','PSU',4,'00:00:02','2017-04-29 00:00:00','user01',0,'dato de prueba');
/*!40000 ALTER TABLE `pruebas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_respuestas`
--

DROP TABLE IF EXISTS `registro_respuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_respuestas` (
  `usuario` varchar(32) NOT NULL,
  `prueba` varchar(16) NOT NULL,
  `pregunta` int(11) NOT NULL,
  `respuesta` char(1) DEFAULT NULL,
  `demora` time DEFAULT NULL,
  `respondida` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`usuario`,`prueba`,`pregunta`),
  KEY `FK_usuarios_idx` (`usuario`),
  KEY `FK_pregunta_prueba_pru_idx` (`pregunta`),
  KEY `FK_pregunta_prueba_prue` (`prueba`),
  CONSTRAINT `FK_pregunta_prueba_preg` FOREIGN KEY (`pregunta`) REFERENCES `rel_preguntas_prueba` (`pregunta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_pregunta_prueba_prue` FOREIGN KEY (`prueba`) REFERENCES `rel_preguntas_prueba` (`prueba`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_usuarios` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`login`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Almacena los datos de las respuestas que un estudiante (usuario) da a las preguntas de una prueba';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_respuestas`
--

LOCK TABLES `registro_respuestas` WRITE;
/*!40000 ALTER TABLE `registro_respuestas` DISABLE KEYS */;
INSERT INTO `registro_respuestas` VALUES ('user02','I0117-01',1,'a',NULL,NULL),('user02','I0117-01',2,'a',NULL,NULL),('user02','I0117-01',3,'a',NULL,NULL),('user02','I0117-01',4,'a',NULL,NULL);
/*!40000 ALTER TABLE `registro_respuestas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_estudiante_acudiente`
--

DROP TABLE IF EXISTS `rel_estudiante_acudiente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rel_estudiante_acudiente` (
  `idestudiante` varchar(32) NOT NULL,
  `idacudiente` varchar(32) NOT NULL,
  `activo` tinyint(1) NOT NULL COMMENT 'para un posible cambio de acudiente',
  `grupo` varchar(16) DEFAULT NULL,
  `usuario_crea` varchar(32) NOT NULL,
  `usuario_modifica` varchar(32) DEFAULT NULL,
  `fecha_modifica` datetime DEFAULT NULL,
  `fecha_crea` datetime NOT NULL,
  PRIMARY KEY (`idestudiante`,`idacudiente`),
  KEY `FK_grupo_idx` (`grupo`),
  CONSTRAINT `FK_grupo` FOREIGN KEY (`grupo`) REFERENCES `grupos` (`idgrupos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_estudiante_acudiente`
--

LOCK TABLES `rel_estudiante_acudiente` WRITE;
/*!40000 ALTER TABLE `rel_estudiante_acudiente` DISABLE KEYS */;
INSERT INTO `rel_estudiante_acudiente` VALUES ('003','002',1,'1101','user01',NULL,NULL,'2017-04-28 00:00:00');
/*!40000 ALTER TABLE `rel_estudiante_acudiente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_perfiles_usuarios`
--

DROP TABLE IF EXISTS `rel_perfiles_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rel_perfiles_usuarios` (
  `perfil` int(11) NOT NULL,
  `usuario` varchar(32) NOT NULL,
  PRIMARY KEY (`perfil`,`usuario`),
  KEY `fk_perfiles_has_usuarios_usuarios1_idx` (`usuario`),
  KEY `fk_perfiles_has_usuarios_perfiles1_idx` (`perfil`),
  CONSTRAINT `fk_perfiles_has_usuarios_perfiles1` FOREIGN KEY (`perfil`) REFERENCES `perfiles` (`idperfil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_perfiles_has_usuarios_usuarios1` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`login`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_perfiles_usuarios`
--

LOCK TABLES `rel_perfiles_usuarios` WRITE;
/*!40000 ALTER TABLE `rel_perfiles_usuarios` DISABLE KEYS */;
INSERT INTO `rel_perfiles_usuarios` VALUES (1,'user01'),(2,'user01'),(2,'user03'),(3,'user01'),(3,'user02'),(4,'user01'),(8,'user01'),(9,'user01');
/*!40000 ALTER TABLE `rel_perfiles_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_preguntas_prueba`
--

DROP TABLE IF EXISTS `rel_preguntas_prueba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rel_preguntas_prueba` (
  `prueba` varchar(16) NOT NULL,
  `pregunta` int(11) NOT NULL,
  PRIMARY KEY (`prueba`,`pregunta`),
  KEY `FK_pregunta_idx` (`pregunta`),
  CONSTRAINT `FK_pregunta` FOREIGN KEY (`pregunta`) REFERENCES `preguntas` (`idpregunta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_prueba` FOREIGN KEY (`prueba`) REFERENCES `pruebas` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_preguntas_prueba`
--

LOCK TABLES `rel_preguntas_prueba` WRITE;
/*!40000 ALTER TABLE `rel_preguntas_prueba` DISABLE KEYS */;
INSERT INTO `rel_preguntas_prueba` VALUES ('I0117-01',1),('I0117-01',2),('I0117-01',3),('I0117-01',4);
/*!40000 ALTER TABLE `rel_preguntas_prueba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_preguntas_tematica`
--

DROP TABLE IF EXISTS `rel_preguntas_tematica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rel_preguntas_tematica` (
  `pregunta` int(11) NOT NULL,
  `tematica` int(11) NOT NULL,
  PRIMARY KEY (`pregunta`,`tematica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_preguntas_tematica`
--

LOCK TABLES `rel_preguntas_tematica` WRITE;
/*!40000 ALTER TABLE `rel_preguntas_tematica` DISABLE KEYS */;
INSERT INTO `rel_preguntas_tematica` VALUES (1,1),(1,2),(2,3),(3,6),(4,5),(5,4);
/*!40000 ALTER TABLE `rel_preguntas_tematica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tematicas`
--

DROP TABLE IF EXISTS `tematicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tematicas` (
  `idtematica` int(11) NOT NULL AUTO_INCREMENT,
  `tematica` varchar(256) NOT NULL,
  `area` int(11) NOT NULL,
  `sug_aprend` varchar(512) DEFAULT NULL COMMENT 'sugerencias al estudiante para un mejor aprendizaje de la tematica',
  PRIMARY KEY (`idtematica`),
  KEY `FK_area_idx` (`area`),
  CONSTRAINT `FK_area` FOREIGN KEY (`area`) REFERENCES `areas` (`idarea`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tematicas`
--

LOCK TABLES `tematicas` WRITE;
/*!40000 ALTER TABLE `tematicas` DISABLE KEYS */;
INSERT INTO `tematicas` VALUES (1,'Fracciones',1,NULL),(2,'Ecuaciones',1,NULL),(3,'Derivadas',1,NULL),(4,'Sinónmos',2,NULL),(5,'Balanceo',3,NULL),(6,'La célula',4,NULL),(7,'2da guerra mundial',5,NULL),(8,'Convivencia',6,NULL);
/*!40000 ALTER TABLE `tematicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_doc`
--

DROP TABLE IF EXISTS `tipos_doc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_doc` (
  `idtipodoc` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(64) NOT NULL,
  PRIMARY KEY (`idtipodoc`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_doc`
--

LOCK TABLES `tipos_doc` WRITE;
/*!40000 ALTER TABLE `tipos_doc` DISABLE KEYS */;
INSERT INTO `tipos_doc` VALUES (1,'Cédula de ciudadanía'),(2,'Tarjeta de identidad'),(3,'Pasaporte'),(4,'Cédula extranjería'),(5,'Registro Civil');
/*!40000 ALTER TABLE `tipos_doc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `login` varchar(32) NOT NULL,
  `password` varchar(128) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `usuariocrea` varchar(32) NOT NULL,
  `fechacrea` datetime NOT NULL,
  `usuariomodifica` varchar(32) DEFAULT NULL,
  `fechamodifica` datetime DEFAULT NULL,
  `persona` varchar(32) NOT NULL,
  PRIMARY KEY (`login`),
  KEY `FK_persona_idx` (`persona`),
  CONSTRAINT `FK_persona` FOREIGN KEY (`persona`) REFERENCES `personas` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='				';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('user01','tzhSOtzhSO+oFTDEpH1ovCbcETg==',1,'user01','2017-04-29 00:00:00',NULL,NULL,'001'),('user02','dSrVE0Bt56pNrFloaHM6dA==',1,'user01','2017-04-29 00:00:00',NULL,NULL,'003'),('user03','WGItKpxb3APSu78U2uNu9A==',1,'user01','2017-04-29 00:00:00',NULL,NULL,'002');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-10 21:15:15
