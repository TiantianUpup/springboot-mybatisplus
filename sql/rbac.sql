use rbac;
-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: rbac
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `system_id` bigint(20) NOT NULL COMMENT 'System ID',
  `resource_key` varchar(255) DEFAULT NULL COMMENT '资源标识符，英文',
  `resource_name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `resource_description` varchar(255) DEFAULT NULL COMMENT '资源描述',
  `deleted` tinyint(255) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '生成时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES (1,1,'test_resource','测试资源',NULL,0,'2019-05-23 07:19:51','2019-05-23 07:19:51'),(2,1,'test_resource_2','测试资源2',NULL,0,'2019-05-23 07:20:41','2019-05-23 07:20:41');
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `system_id` bigint(20) NOT NULL COMMENT 'System ID',
  `role_key` varchar(255) NOT NULL COMMENT '角色唯一标识符',
  `role_name` varchar(255) NOT NULL COMMENT '角色名称',
  `role_description` varchar(255) DEFAULT '' COMMENT '角色描述',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,1,'test_role','测试角色','','2019-05-23 07:18:56','2019-05-23 07:18:56');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_resource`
--

DROP TABLE IF EXISTS `role_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `system_id` bigint(20) NOT NULL,
  `resource_id` bigint(255) NOT NULL COMMENT '资源名称',
  `role_id` bigint(255) NOT NULL COMMENT '资源描述',
  `deleted` tinyint(255) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '生成时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_resource`
--

LOCK TABLES `role_resource` WRITE;
/*!40000 ALTER TABLE `role_resource` DISABLE KEYS */;
INSERT INTO `role_resource` VALUES (1,1,1,1,0,'2019-05-23 07:19:35','2019-05-23 07:19:35'),(2,1,2,1,0,'2019-05-23 07:21:07','2019-05-23 07:21:07');
/*!40000 ALTER TABLE `role_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system`
--

DROP TABLE IF EXISTS `system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `system_name` varchar(255) NOT NULL COMMENT '系统名称',
  `system_key` varchar(255) NOT NULL COMMENT '系统key为英文，系统唯一标识',
  `deleted` tinyint(255) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`,`system_key`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system`
--

LOCK TABLES `system` WRITE;
/*!40000 ALTER TABLE `system` DISABLE KEYS */;
INSERT INTO `system` VALUES (1,'测试系统','test',0,'2019-05-23 07:16:49','2019-05-23 07:16:49'),(2,'tt','tt',0,'2019-05-18 15:28:52','2019-05-18 15:28:52'),(3,'tttest','tttest',0,'2019-05-18 15:28:55','2019-05-18 15:28:55'),(4,'ds','fesdf',0,'2019-05-18 15:28:47','2019-05-18 15:28:47');
/*!40000 ALTER TABLE `system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `system_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL COMMENT 'User ID',
  `role_id` bigint(255) NOT NULL COMMENT 'Role ID',
  `deleted` tinyint(255) NOT NULL DEFAULT '0',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1,1,0,'2019-05-23 07:20:07','2019-05-23 07:20:07');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `deleted` tinyint(255) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '生成时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','123456',0,'2019-05-23 04:51:30','2019-05-23 04:51:30'),(2,'hetiantian','xx',0,'2019-08-03 07:13:11','2019-08-03 07:13:11'),(3,'tom','123456',0,'2019-08-03 08:09:47','2019-08-03 08:09:47'),(15,'jjj','jjj',0,'2019-08-04 03:46:10','2019-08-04 03:46:10'),(16,'jjj','123',0,'2019-08-04 03:46:10','2019-08-04 03:46:10'),(17,'jjj','1234',0,'2019-08-04 03:46:10','2019-08-04 03:46:10'),(18,'jjj','aaa',0,'2019-08-04 03:45:59','2019-08-04 03:45:59'),(19,'jjj','bbb',1,'2019-08-04 06:42:06','2019-08-04 06:42:06'),(20,'jjj','ccc',0,'2019-08-04 03:45:59','2019-08-04 03:45:59'),(21,'jjj','ddd',0,'2019-08-04 03:45:59','2019-08-04 03:45:59'),(22,'jjj','eee',0,'2019-08-04 03:45:59','2019-08-04 03:45:59');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-17 16:38:34
