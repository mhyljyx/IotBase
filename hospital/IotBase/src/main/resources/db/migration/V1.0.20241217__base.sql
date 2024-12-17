-- MySQL dump 10.13  Distrib 5.7.42, for Win64 (x86_64)
--
-- Host: localhost    Database: demo
-- ------------------------------------------------------
-- Server version	5.7.42

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
-- Table structure for table `black_ip`
--

DROP TABLE IF EXISTS `black_ip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `black_ip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  `ip` varchar(100) NOT NULL COMMENT '源地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='ip黑名单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `black_ip`
--

LOCK TABLES `black_ip` WRITE;
/*!40000 ALTER TABLE `black_ip` DISABLE KEYS */;
/*!40000 ALTER TABLE `black_ip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_state`
--

DROP TABLE IF EXISTS `device_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `device_state` (
  `id` varchar(16) NOT NULL COMMENT '事件唯一编码',
  `device_category` int(3) NOT NULL COMMENT '事件源类型',
  `device_id` varchar(16) NOT NULL COMMENT '事件源编码',
  `parent_id` varchar(32) NOT NULL COMMENT '运营服务机构唯一编码',
  `online_status` int(3) NOT NULL COMMENT '在离线状态 0-离线，1-在线',
  `work_status` int(3) NOT NULL COMMENT '运行状态 0-离线，1-在线',
  `event_time` datetime NOT NULL COMMENT '事件发生时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='运行状态表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_state`
--

LOCK TABLES `device_state` WRITE;
/*!40000 ALTER TABLE `device_state` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_subscribe`
--

DROP TABLE IF EXISTS `event_subscribe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_subscribe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '事件订阅名称',
  `category` varchar(255) NOT NULL COMMENT '事件大类',
  `ip` varchar(255) NOT NULL COMMENT '接收方ip',
  `port` int(4) NOT NULL COMMENT '接收方port',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0未取消 1已取消',
  `platform` varchar(255) DEFAULT NULL COMMENT '订阅平台',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `event_subscribe_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='事件订阅表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_subscribe`
--

LOCK TABLES `event_subscribe` WRITE;
/*!40000 ALTER TABLE `event_subscribe` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_subscribe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_subscribe_grade`
--

DROP TABLE IF EXISTS `event_subscribe_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_subscribe_grade` (
  `subscribe_id` int(11) NOT NULL COMMENT '事件订阅id一致',
  `subscribe_name` varchar(255) NOT NULL COMMENT '事件订阅名称',
  `grade` int(1) NOT NULL COMMENT '告警等级',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`subscribe_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='事件订阅报警关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_subscribe_grade`
--

LOCK TABLES `event_subscribe_grade` WRITE;
/*!40000 ALTER TABLE `event_subscribe_grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_subscribe_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_subscribe_node_code`
--

DROP TABLE IF EXISTS `event_subscribe_node_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_subscribe_node_code` (
  `subscribe_id` int(11) NOT NULL COMMENT '事件订阅id一致',
  `subscribe_name` varchar(255) NOT NULL COMMENT '事件订阅名称',
  `node_code` varchar(64) NOT NULL COMMENT '设备或者通道编号',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`subscribe_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='事件订阅（设备||通道）关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_subscribe_node_code`
--

LOCK TABLES `event_subscribe_node_code` WRITE;
/*!40000 ALTER TABLE `event_subscribe_node_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_subscribe_node_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_subscribe_org`
--

DROP TABLE IF EXISTS `event_subscribe_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_subscribe_org` (
  `subscribe_id` int(11) NOT NULL COMMENT '事件订阅id一致',
  `subscribe_name` varchar(255) NOT NULL COMMENT '事件订阅名称',
  `org` varchar(255) DEFAULT NULL COMMENT '组织代码',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`subscribe_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='事件订阅组织关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_subscribe_org`
--

LOCK TABLES `event_subscribe_org` WRITE;
/*!40000 ALTER TABLE `event_subscribe_org` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_subscribe_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_subscribe_type`
--

DROP TABLE IF EXISTS `event_subscribe_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_subscribe_type` (
  `subscribe_id` int(11) NOT NULL COMMENT '事件订阅id一致',
  `subscribe_name` varchar(255) NOT NULL COMMENT '事件订阅名称',
  `type` varchar(16) NOT NULL COMMENT '事件类型',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`subscribe_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='事件订阅类型关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_subscribe_type`
--

LOCK TABLES `event_subscribe_type` WRITE;
/*!40000 ALTER TABLE `event_subscribe_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_subscribe_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fault`
--

DROP TABLE IF EXISTS `fault`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fault` (
  `id` varchar(32) NOT NULL COMMENT '故障事件唯\r\n一编码',
  `device_category` int(3) NOT NULL COMMENT '事件源类型',
  `device_id` varchar(32) NOT NULL COMMENT '事件源编码',
  `parent_id` varchar(32) NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `type` int(3) NOT NULL COMMENT '故障类型',
  `event_time` datetime NOT NULL COMMENT '事件发生时间',
  `location` varchar(64) DEFAULT NULL COMMENT '故障发生位置',
  `reason` varchar(128) DEFAULT NULL COMMENT '故障原因',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='故障信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fault`
--

LOCK TABLES `fault` WRITE;
/*!40000 ALTER TABLE `fault` DISABLE KEYS */;
/*!40000 ALTER TABLE `fault` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fault_process`
--

DROP TABLE IF EXISTS `fault_process`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fault_process` (
  `id` varchar(32) NOT NULL COMMENT '与故障信息上报时编码一致',
  `device_category` int(3) NOT NULL COMMENT '事件源类型',
  `device_id` varchar(32) NOT NULL COMMENT '事件源编码',
  `parent_id` varchar(32) NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `happen_time` datetime NOT NULL COMMENT '故障恢复时间',
  `process_type` varchar(16) DEFAULT NULL COMMENT '故障处理方式',
  `fault_content` varchar(128) DEFAULT NULL COMMENT '故障处理情况（人工处理时需填写）',
  `handle_user_id` varchar(32) DEFAULT NULL COMMENT '处理人员名称',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='故障处理信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fault_process`
--

LOCK TABLES `fault_process` WRITE;
/*!40000 ALTER TABLE `fault_process` DISABLE KEYS */;
/*!40000 ALTER TABLE `fault_process` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fire_alarm`
--

DROP TABLE IF EXISTS `fire_alarm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fire_alarm` (
  `id` varchar(32) NOT NULL COMMENT '火灾预警事件唯一编码',
  `parent_id` varchar(32) NOT NULL COMMENT '运营服务机构唯一编码',
  `device_category` int(3) NOT NULL COMMENT '事件源类型',
  `device_id` varchar(32) NOT NULL COMMENT '事件源编码',
  `alarm_type` varchar(16) NOT NULL COMMENT '火灾预警类型',
  `event_time` datetime NOT NULL COMMENT '事件发生时间',
  `alarm_level` int(3) DEFAULT NULL COMMENT '火灾预警等级',
  `image_urls` varchar(255) DEFAULT NULL COMMENT '火灾预警图片信息',
  `video_urls` varchar(255) DEFAULT NULL COMMENT '火灾预警视频信息',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='火灾预警信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fire_alarm`
--

LOCK TABLES `fire_alarm` WRITE;
/*!40000 ALTER TABLE `fire_alarm` DISABLE KEYS */;
/*!40000 ALTER TABLE `fire_alarm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fire_alarm_process`
--

DROP TABLE IF EXISTS `fire_alarm_process`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fire_alarm_process` (
  `id` varchar(32) NOT NULL COMMENT '火灾预警事件唯一编码',
  `parent_id` varchar(32) NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `device_category` int(3) NOT NULL COMMENT '事件源类型',
  `device_id` varchar(32) NOT NULL COMMENT '事件源编码',
  `alarm_type` varchar(16) NOT NULL COMMENT '火警类型',
  `check_time` datetime NOT NULL COMMENT '火灾预警复核时间',
  `handle_time` datetime NOT NULL COMMENT '处理完成时间',
  `process_type` varchar(16) NOT NULL COMMENT '火灾预警复核方式',
  `handle_user_name` varchar(16) DEFAULT NULL COMMENT '现场处置人员姓名',
  `handle_user_id` varchar(16) DEFAULT NULL COMMENT '值守处置人员编号',
  `handle_status` varchar(16) NOT NULL COMMENT '复核结果',
  `handle_context` text COMMENT '火灾预警处理记录',
  `handle_image_urls` varchar(255) DEFAULT NULL COMMENT '现场处理图片信息',
  `handle_video_urls` varchar(255) DEFAULT NULL COMMENT '现场处理视频信息',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='火灾预警处置信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fire_alarm_process`
--

LOCK TABLES `fire_alarm_process` WRITE;
/*!40000 ALTER TABLE `fire_alarm_process` DISABLE KEYS */;
/*!40000 ALTER TABLE `fire_alarm_process` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`) USING BTREE,
  KEY `flyway_schema_history_s_idx` (`success`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','<< Flyway Baseline >>','BASELINE','<< Flyway Baseline >>',NULL,'root','2024-11-14 09:44:26',0,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hidden_danger`
--

DROP TABLE IF EXISTS `hidden_danger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hidden_danger` (
  `id` varchar(32) NOT NULL COMMENT '事件id',
  `parent_id` varchar(32) NOT NULL COMMENT '运营服务机构唯一编码',
  `task_id` varchar(32) DEFAULT NULL COMMENT '巡更任务id（当danger_source=1时，表示巡更任务id）',
  `route_id` varchar(32) DEFAULT NULL COMMENT '路线id',
  `point_id` varchar(32) DEFAULT NULL COMMENT '巡检点位唯一编码',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `description` varchar(64) DEFAULT NULL COMMENT '隐患说明',
  `position` varchar(64) DEFAULT NULL COMMENT '隐患位置',
  `status` varchar(1) DEFAULT NULL COMMENT '隐患状态（0待核查，1处理中，2已办结，3超时完成）',
  `source` varchar(1) DEFAULT NULL COMMENT '隐患来源 0隐患上报，1巡检异常，2消防投诉',
  `label_list` text COMMENT '隐患标签：0其他隐患，1消防给水管道没水，2消防设施故障，3消防器材缺失，4安全通道堵塞或关闭，5电线老化，6物联设备故障',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='隐患信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hidden_danger`
--

LOCK TABLES `hidden_danger` WRITE;
/*!40000 ALTER TABLE `hidden_danger` DISABLE KEYS */;
/*!40000 ALTER TABLE `hidden_danger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iot_device`
--

DROP TABLE IF EXISTS `iot_device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iot_device` (
  `id` varchar(16) NOT NULL COMMENT '设备编号',
  `name` varchar(255) NOT NULL COMMENT '设备名称',
  `parent_id` varchar(32) NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `device_code` varchar(64) NOT NULL COMMENT '设备识别码',
  `location` varchar(64) NOT NULL COMMENT '安装位置',
  `device_manufactory` varchar(255) NOT NULL COMMENT '设备厂商',
  `device_type` varchar(16) NOT NULL COMMENT '设备类型',
  `code_3c` varchar(32) DEFAULT NULL COMMENT '3C证书编号',
  `qualified_code` varchar(32) DEFAULT NULL COMMENT '型式检验报告编号',
  `relation_id` varchar(32) NOT NULL COMMENT '关联编码',
  `building_id` varchar(32) DEFAULT NULL COMMENT '所属建筑物编号',
  `constructor` varchar(32) DEFAULT NULL COMMENT '施工单位名称',
  `produce_date` datetime DEFAULT NULL COMMENT '设备生产时间',
  `install_date` datetime DEFAULT NULL COMMENT '设备安装时间',
  `expire_date` datetime DEFAULT NULL COMMENT '设备到期时间',
  `parts_num` int(11) DEFAULT NULL COMMENT '部件总数',
  `notify_phone` varchar(16) DEFAULT NULL COMMENT '设备报警通知号码',
  `hardware_version` varchar(16) DEFAULT NULL COMMENT '硬件版本',
  `software_version` varchar(16) DEFAULT NULL COMMENT '软件版本',
  `controlroom_position` varchar(64) DEFAULT NULL COMMENT '消控室位置',
  `map_type` int(3) DEFAULT NULL COMMENT '地图类型',
  `lng` varchar(16) DEFAULT NULL COMMENT '经度',
  `lat` varchar(16) DEFAULT NULL COMMENT '维度',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='物联设备表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iot_device`
--

LOCK TABLES `iot_device` WRITE;
/*!40000 ALTER TABLE `iot_device` DISABLE KEYS */;
/*!40000 ALTER TABLE `iot_device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iot_part`
--

DROP TABLE IF EXISTS `iot_part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iot_part` (
  `id` varchar(32) NOT NULL COMMENT '部件唯一编号',
  `name` varchar(32) NOT NULL COMMENT '部件名称',
  `parent_id` varchar(32) NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `sensor_code` varchar(32) NOT NULL COMMENT '部件识别码',
  `address` varchar(64) DEFAULT NULL COMMENT '安装位置',
  `type` int(3) DEFAULT NULL COMMENT '部件类型',
  `relation_id` varchar(32) NOT NULL COMMENT '关联编码',
  `building_id` varchar(32) DEFAULT NULL COMMENT '所属建筑物编号',
  `device_id` varchar(32) NOT NULL COMMENT '所属设备编码',
  `code_3c` varchar(32) DEFAULT NULL COMMENT '3C证书编号',
  `qualified_code` varchar(32) DEFAULT NULL COMMENT '型式检验报告编号',
  `manufactory` varchar(32) DEFAULT NULL COMMENT '部件生产厂商',
  `produce_date` datetime DEFAULT NULL COMMENT '部件生产时间',
  `install_date` datetime DEFAULT NULL COMMENT '部件安装时间',
  `expire_date` datetime DEFAULT NULL COMMENT '部件到期时间',
  `map_type` int(3) DEFAULT NULL COMMENT '地图类型',
  `lng` varchar(16) DEFAULT NULL COMMENT '经度',
  `lat` varchar(16) DEFAULT NULL COMMENT '维度',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='部件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iot_part`
--

LOCK TABLES `iot_part` WRITE;
/*!40000 ALTER TABLE `iot_part` DISABLE KEYS */;
/*!40000 ALTER TABLE `iot_part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patrol_point`
--

DROP TABLE IF EXISTS `patrol_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patrol_point` (
  `id` varchar(32) NOT NULL COMMENT '巡更点位',
  `name` varchar(64) NOT NULL COMMENT '巡更点位名称',
  `parent_id` varchar(32) NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `point_type` varchar(16) NOT NULL COMMENT '巡检点位类型',
  `relation_id` varchar(32) NOT NULL COMMENT '关联编码',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='巡更点位';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patrol_point`
--

LOCK TABLES `patrol_point` WRITE;
/*!40000 ALTER TABLE `patrol_point` DISABLE KEYS */;
/*!40000 ALTER TABLE `patrol_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patrol_record`
--

DROP TABLE IF EXISTS `patrol_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patrol_record` (
  `id` varchar(255) NOT NULL COMMENT '任务唯一id',
  `parent_id` varchar(32) NOT NULL COMMENT '运营服务机构唯一编码',
  `name` varchar(64) NOT NULL COMMENT '巡检点位名称',
  `result` int(11) NOT NULL COMMENT '巡更任务结果',
  `status` int(11) NOT NULL COMMENT '巡更任务状态',
  `type` int(11) NOT NULL COMMENT '巡更任务类型 0：安保巡更，1：消防巡更',
  `scheduled_start_time` datetime NOT NULL COMMENT '计划开始时间',
  `scheduled_end_time` datetime NOT NULL COMMENT '计划截止时间',
  `actual_start_time` datetime NOT NULL COMMENT '实际开始时间',
  `actual_end_time` datetime NOT NULL COMMENT '实际截止时间',
  `route_id` varchar(255) NOT NULL COMMENT '路线id',
  `point_id` varchar(32) NOT NULL COMMENT '巡检点位唯一编码',
  `order` int(11) DEFAULT NULL COMMENT '点位顺序',
  `finish_time` datetime NOT NULL COMMENT '完成时间',
  `point_status` int(11) DEFAULT NULL COMMENT '巡更点位状态(0：待核查，1：预约维修，2：消防整改，3：其它处理，4：已处理，5：无需处理)',
  `relation_id` varchar(255) DEFAULT NULL COMMENT '单位编码',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='巡更记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patrol_record`
--

LOCK TABLES `patrol_record` WRITE;
/*!40000 ALTER TABLE `patrol_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `patrol_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platform_dictionary`
--

DROP TABLE IF EXISTS `platform_dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `platform_dictionary` (
  `sign` varchar(255) DEFAULT NULL COMMENT '平台标识',
  `name` varchar(255) DEFAULT NULL COMMENT '平台名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='订阅平台';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platform_dictionary`
--

LOCK TABLES `platform_dictionary` WRITE;
/*!40000 ALTER TABLE `platform_dictionary` DISABLE KEYS */;
INSERT INTO `platform_dictionary` VALUES ('dahua','大华'),('haikang','海康'),('other','其他');
/*!40000 ALTER TABLE `platform_dictionary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_admin`
--

DROP TABLE IF EXISTS `sys_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_admin` (
  `id` varchar(32) NOT NULL COMMENT '管理员id',
  `account` varchar(64) NOT NULL COMMENT '账号',
  `mail` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `name` varchar(255) NOT NULL COMMENT '管理员名称',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `role_type` varchar(100) DEFAULT NULL COMMENT '角色类型',
  `status` varchar(1) DEFAULT '0' COMMENT '状态 0.正常 1.锁定',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `role_type` (`role_type`) USING BTREE,
  CONSTRAINT `admin_sys_role_dic_FK` FOREIGN KEY (`role_type`) REFERENCES `sys_role_dic` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_admin`
--

LOCK TABLES `sys_admin` WRITE;
/*!40000 ALTER TABLE `sys_admin` DISABLE KEYS */;
INSERT INTO `sys_admin` VALUES ('A_EeGapKdf4TT5ltZM','admin1','1849326022@qq.com','tztang','$2a$10$wfS.EWCYwxNn1YBpbmfIX.Cc9vIEKJzdoCGZlgxhDwArD98r3zorO','SYS_ADMIN','0','2024-12-17 09:59:32','2024-12-17 09:59:32','0'),('A_SRp6OauT5448FxHG','admin',NULL,'admin','$2a$10$tX19LYfNmJGB1ihglRM5SOmZcDqjU6Bt7LrpXOp1YdRqAPyl9j3Lm','SUPER_ADMIN','0','2024-12-10 17:28:46','2024-12-10 17:28:46','0');
/*!40000 ALTER TABLE `sys_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_admin_operate_log`
--

DROP TABLE IF EXISTS `sys_admin_operate_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_admin_operate_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(100) NOT NULL COMMENT '管理员账号',
  `url` varchar(255) NOT NULL COMMENT '请求url',
  `operate` varchar(100) NOT NULL COMMENT '操作描述',
  `parameter` text COMMENT '参数',
  `ip` varchar(100) NOT NULL COMMENT '源地址',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_admin_operate_log`
--

LOCK TABLES `sys_admin_operate_log` WRITE;
/*!40000 ALTER TABLE `sys_admin_operate_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_admin_operate_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_api`
--

DROP TABLE IF EXISTS `sys_api`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_api` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '接口名称',
  `url` varchar(255) NOT NULL COMMENT '接口路径',
  `method` varchar(10) NOT NULL COMMENT '请求方法(GET/POST/PUT/DELETE)',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `unique_url_method` (`url`,`method`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='系统接口表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_api`
--

LOCK TABLES `sys_api` WRITE;
/*!40000 ALTER TABLE `sys_api` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_api` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_community`
--

DROP TABLE IF EXISTS `sys_community`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_community` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL COMMENT '联网单位编码',
  `name` varchar(16) NOT NULL COMMENT '联网单位名称',
  `parent_id` varchar(32) NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `credit_code` varchar(32) NOT NULL COMMENT '联网单位地址编码',
  `address` varchar(64) NOT NULL COMMENT '联网单位地址',
  `region_code` varchar(16) NOT NULL COMMENT '行政区域编码',
  `phone_num` varchar(16) NOT NULL COMMENT '管辖单位联系电话',
  `manager_company` varchar(32) NOT NULL COMMENT '管辖单位',
  `occaupy_area` varchar(16) DEFAULT NULL COMMENT '单位占地面积',
  `build_area` varchar(16) DEFAULT NULL COMMENT '总建筑面积',
  `type` varchar(16) DEFAULT NULL COMMENT '单位类型（该巡查点位属于联网单位或住宅小区：1-联网单位，2-住宅小区）',
  `map_type` int(3) DEFAULT NULL COMMENT '地图类型',
  `lng` varchar(16) DEFAULT NULL COMMENT '经度',
  `lat` varchar(16) DEFAULT NULL COMMENT '维度',
  `is_open` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '0:关闭上传 1:开启上传',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='互联网单位信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_community`
--

LOCK TABLES `sys_community` WRITE;
/*!40000 ALTER TABLE `sys_community` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_community` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dept` (
  `id` varchar(35) NOT NULL COMMENT '部门id',
  `open_id` varchar(32) DEFAULT NULL COMMENT '地方三方部门id',
  `name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `parent_id` varchar(32) NOT NULL DEFAULT '0' COMMENT '父级部门id',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `id` bigint(11) NOT NULL COMMENT '菜单ID（主键）',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称\n',
  `url` varchar(255) DEFAULT NULL COMMENT '前端路由地址\n',
  `parent_id` int(11) DEFAULT NULL COMMENT '父菜单ID（支持菜单树）',
  `type` tinyint(1) DEFAULT NULL COMMENT '类型（0目录，1菜单）',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='系统菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_api`
--

DROP TABLE IF EXISTS `sys_role_api`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_api` (
  `role_type` varchar(100) NOT NULL COMMENT '角色类型（外键）',
  `api_id` bigint(11) NOT NULL COMMENT '接口ID（外键）',
  KEY `role_id` (`role_type`) USING BTREE,
  KEY `api_id` (`api_id`) USING BTREE,
  CONSTRAINT `sys_role_api_ibfk_2` FOREIGN KEY (`api_id`) REFERENCES `sys_api` (`id`),
  CONSTRAINT `sys_role_api_sys_role_dic_FK` FOREIGN KEY (`role_type`) REFERENCES `sys_role_dic` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='系统角色-接口关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_api`
--

LOCK TABLES `sys_role_api` WRITE;
/*!40000 ALTER TABLE `sys_role_api` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_api` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_dic`
--

DROP TABLE IF EXISTS `sys_role_dic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_dic` (
  `type` varchar(100) NOT NULL COMMENT '角色类型',
  `name` varchar(100) CHARACTER SET ucs2 NOT NULL COMMENT '类型名称',
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_dic`
--

LOCK TABLES `sys_role_dic` WRITE;
/*!40000 ALTER TABLE `sys_role_dic` DISABLE KEYS */;
INSERT INTO `sys_role_dic` VALUES ('AUDIT_ADMIN','审计管理员'),('NORMAL_USER','普通用户'),('SECURITY_ADMIN','安全管理员'),('SUPER_ADMIN','超级管理员'),('SYS_ADMIN','系统管理员');
/*!40000 ALTER TABLE `sys_role_dic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `role_type` varchar(100) NOT NULL COMMENT '角色类型（外键',
  `menu_id` bigint(11) NOT NULL COMMENT '菜单ID（外键）',
  KEY `role_id` (`role_type`) USING BTREE,
  KEY `menu_id` (`menu_id`) USING BTREE,
  CONSTRAINT `sys_role_menu_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`),
  CONSTRAINT `sys_role_menu_sys_role_dic_FK` FOREIGN KEY (`role_type`) REFERENCES `sys_role_dic` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='系统角色-菜单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_service_agency`
--

DROP TABLE IF EXISTS `sys_service_agency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_service_agency` (
  `id` varchar(35) NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `name` varchar(32) NOT NULL COMMENT '消防物联网运营服务机构名称',
  `company_code` varchar(16) NOT NULL COMMENT '统一社会信用代码',
  `address` varchar(255) NOT NULL COMMENT '单位地址',
  `legal_represen_name` varchar(16) DEFAULT NULL COMMENT '法定代表人姓名',
  `legal_represen_id` varchar(32) DEFAULT NULL COMMENT '法定代表人身份证号码',
  `legal_represen_tel` varchar(16) DEFAULT NULL COMMENT '法定代表人联系电话',
  `company_num` int(5) unsigned zerofill DEFAULT NULL COMMENT '接入联网单位总数',
  `serviceagency_area` int(5) DEFAULT NULL COMMENT '机构运营场地面积',
  `onduty_person_num` int(3) DEFAULT NULL COMMENT '值守人员总数',
  `contact_name` varchar(16) DEFAULT NULL COMMENT '运营机构责任人姓名',
  `contact_tel` varchar(16) DEFAULT NULL COMMENT '运营机构责任人联系电话',
  `ak` varchar(255) DEFAULT NULL COMMENT 'ak:用于生成token',
  `sk` varchar(255) DEFAULT NULL COMMENT 'sk:用于生成token',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='消防物联网运营服务机构表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_service_agency`
--

LOCK TABLES `sys_service_agency` WRITE;
/*!40000 ALTER TABLE `sys_service_agency` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_service_agency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` varchar(35) NOT NULL COMMENT '用户id',
  `name` varchar(255) NOT NULL COMMENT '用户姓名',
  `sex` varchar(1) NOT NULL COMMENT '性别 0女 1男 9未知',
  `id_number` varchar(64) DEFAULT NULL COMMENT '身份证信息',
  `dept_id` varchar(32) NOT NULL COMMENT '所属部门',
  `account` varchar(32) DEFAULT NULL COMMENT '账号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `mobile_phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `phone` varchar(32) DEFAULT NULL COMMENT '座机号',
  `address` varchar(1024) DEFAULT NULL COMMENT '地址',
  `role_type` varchar(100) DEFAULT NULL COMMENT '角色类型',
  `type` varchar(3) DEFAULT NULL COMMENT '人员类型',
  `status` varchar(1) DEFAULT '0' COMMENT '状态 0.正常 1.锁定',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `role_type` (`role_type`) USING BTREE,
  CONSTRAINT `user_sys_role_dic_FK` FOREIGN KEY (`role_type`) REFERENCES `sys_role_dic` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_operate_log`
--

DROP TABLE IF EXISTS `sys_user_operate_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_operate_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(100) NOT NULL COMMENT '用户账号',
  `url` varchar(255) NOT NULL COMMENT '请求url',
  `operate` varchar(100) NOT NULL COMMENT '操作描述',
  `parameter` text COMMENT '参数',
  `ip` varchar(100) NOT NULL COMMENT '源地址',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_operate_log`
--

LOCK TABLES `sys_user_operate_log` WRITE;
/*!40000 ALTER TABLE `sys_user_operate_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user_operate_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warning`
--

DROP TABLE IF EXISTS `warning`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warning` (
  `id` varchar(32) NOT NULL COMMENT '事件预警事件唯一编码',
  `parent_id` varchar(32) NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `device_id` varchar(16) NOT NULL COMMENT '事件源编码',
  `event_time` datetime NOT NULL COMMENT '事件发生时间',
  `alarm_type` varchar(16) NOT NULL COMMENT '事件预警类型',
  `image_urls` varchar(255) DEFAULT NULL COMMENT '报警时刻的图片，多个url通过逗号分隔',
  `video_urls` varchar(255) DEFAULT NULL COMMENT '实时视频，多个url通过逗号分隔，需要考虑链接的安全',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='事件预警信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warning`
--

LOCK TABLES `warning` WRITE;
/*!40000 ALTER TABLE `warning` DISABLE KEYS */;
/*!40000 ALTER TABLE `warning` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warning_process`
--

DROP TABLE IF EXISTS `warning_process`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warning_process` (
  `id` varchar(32) NOT NULL COMMENT '事件预警事件唯一编码',
  `parent_id` varchar(32) NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `device_category` int(3) NOT NULL COMMENT '事件源类型',
  `device_id` varchar(32) NOT NULL COMMENT '事件源编码',
  `alarm_type` varchar(16) NOT NULL COMMENT '火警类型',
  `check_time` datetime NOT NULL COMMENT '火灾预警复核时间',
  `handle_time` datetime NOT NULL COMMENT '处理完成时间',
  `process_type` varchar(16) NOT NULL COMMENT '火灾预警复核方式',
  `handle_user_name` varchar(16) DEFAULT NULL COMMENT '现场处置人员姓名',
  `handle_user_id` varchar(32) DEFAULT NULL COMMENT '值守处置人员编号',
  `handle_status` varchar(16) NOT NULL COMMENT '复核结果',
  `handle_context` text COMMENT '火灾预警处理记录',
  `handle_image_urls` varchar(255) DEFAULT NULL COMMENT '现场处理图片信息',
  `handle_video_urls` varchar(255) DEFAULT NULL COMMENT '现场处理视频信息',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='事件预警处置信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warning_process`
--

LOCK TABLES `warning_process` WRITE;
/*!40000 ALTER TABLE `warning_process` DISABLE KEYS */;
/*!40000 ALTER TABLE `warning_process` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'demo'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-17 14:40:15
