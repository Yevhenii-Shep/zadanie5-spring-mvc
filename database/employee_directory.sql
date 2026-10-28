
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `employee_directory` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `employee_directory`;
DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `birth_date` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `job_title` varchar(255) NOT NULL,
  `salary` decimal(10,0) DEFAULT NULL,
  `full_time` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idemployee_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Jozef','Novák','1992-04-15','jozef.novak@ukf.sk','+421901234567','Software Engineer',2000,1),(2,'Mária','Kováčová','1988-11-20','maria.kovacova@ukf.sk','+421902345678','Data Analyst',1800,1),(3,'Peter','Horváth','1995-07-05','peter.horvath@ukf.sk','+421903456789','System Administrator',1600,0),(4,'Anna','Miklová','1990-09-25','anna.miklova@ukf.sk','+421904567890','UX Designer',NULL,1),(5,'Milan','Rybár','1985-03-14','milan.rybar@ukf.sk','+421905678901','DevOps Engineer',2200,1),(6,'Eva','Králiková','1998-02-28','eva.kralikova@ukf.sk','+421906789012','Front-End Developer',1900,1),(7,'Martin','Slovák','1983-12-09','martin.slovak@ukf.sk','+421907890123','Back-End Developer',2100,0),(8,'Jana','Poláková','1991-06-17','jana.polakova@ukf.sk','+421908901234','Project Manager',NULL,1),(9,'Tomáš','Bielik','1987-08-30','tomas.bielik@ukf.sk','+421909012345','QA Tester',1700,1),(10,'Zuzana','Petríková','1996-05-22','zuzana.petrikova@ukf.sk','+421910123456','Product Owner',2300,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

