-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: test
-- ------------------------------------------------------
-- Server version	8.0.27

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES ('HR','Human Resource'),('SALE','Sales'),
('FIN','Finance'), ('OP','Operations'),('DEV','Research and Development');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'1977-06-14','Geert','Vanderkelen','M','2022-07-19','SALE');
INSERT INTO `employees` VALUES (2,'1985-05-20','LiMin ','Wilharm','F','1999-12-16','OP');
INSERT INTO `employees` VALUES (3,'1987-02-04','Lalit ','Wielonsky','F','1999-12-16','FIN');
INSERT INTO `employees` VALUES (4,'1989-12-23','Dannz ','Kamble','M','1999-12-18','DEV');
INSERT INTO `employees` VALUES (5,'1985-03-07','Zhongwei ','DuBourdieux','M','1999-12-19','SALE');
INSERT INTO `employees` VALUES (6,'1982-07-19','Rosita','Fujisawa','F','1999-12-20','HR');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `salaries` WRITE;
/*!40000 ALTER TABLE `salaries` DISABLE KEYS */;
INSERT INTO `salaries` VALUES (1,50000,'2022-07-19','9999-01-01');
INSERT INTO `salaries` VALUES (2,110000,'1999-12-16','9999-01-01');
INSERT INTO `salaries` VALUES (3,90000,'1999-12-16','9999-01-01');
INSERT INTO `salaries` VALUES (4,85000,'1999-12-18','9999-01-01');
INSERT INTO `salaries` VALUES (5,70000,'1999-12-19','9999-01-01');
INSERT INTO `salaries` VALUES (6,90000,'1999-12-20','9999-01-01');
/*!40000 ALTER TABLE `salaries` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
