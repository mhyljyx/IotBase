/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50742
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50742
 File Encoding         : 65001

 Date: 15/11/2024 17:58:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for community
-- ----------------------------
DROP TABLE IF EXISTS `community`;
CREATE TABLE `community`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联网单位编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联网单位名称',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `credit_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联网单位地址编码',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联网单位地址',
  `region_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '行政区域编码',
  `phone_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管辖单位联系电话',
  `manager_company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管辖单位',
  `occaupy_area` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位占地面积',
  `build_area` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '总建筑面积',
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位类型（该巡查点位属于联网单位或住宅小区：1-联网单位，2-住宅小区）',
  `map_type` int(3) NULL DEFAULT NULL COMMENT '地图类型',
  `lng` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '经度',
  `lat` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '维度',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '互联网单位信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of community
-- ----------------------------

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门id',
  `open_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地方三方部门id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父级部门id',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------

-- ----------------------------
-- Table structure for device_state
-- ----------------------------
DROP TABLE IF EXISTS `device_state`;
CREATE TABLE `device_state`  (
  `id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件唯一编码',
  `device_category` int(3) NOT NULL COMMENT '事件源类型',
  `device_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件源编码',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营服务机构唯一编码',
  `online_status` int(3) NOT NULL COMMENT '在离线状态 0-离线，1-在线',
  `work_status` int(3) NOT NULL COMMENT '运行状态 0-离线，1-在线',
  `event_time` datetime NOT NULL COMMENT '事件发生时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '运行状态表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of device_state
-- ----------------------------

-- ----------------------------
-- Table structure for event_subscribe
-- ----------------------------
DROP TABLE IF EXISTS `event_subscribe`;
CREATE TABLE `event_subscribe`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件订阅名称',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件大类',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '接收方ip',
  `port` int(4) NOT NULL COMMENT '接收方port',
  `status` int(1) NOT NULL DEFAULT 0 COMMENT '0未取消 1已取消',
  `platform` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订阅平台',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `event_subscribe_name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '事件订阅表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of event_subscribe
-- ----------------------------

-- ----------------------------
-- Table structure for event_subscribe_grade
-- ----------------------------
DROP TABLE IF EXISTS `event_subscribe_grade`;
CREATE TABLE `event_subscribe_grade`  (
  `subscribe_id` int(11) NOT NULL COMMENT '事件订阅id一致',
  `subscribe_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件订阅名称',
  `grade` int(1) NOT NULL COMMENT '告警等级',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`subscribe_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '事件订阅报警关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of event_subscribe_grade
-- ----------------------------

-- ----------------------------
-- Table structure for event_subscribe_node_code
-- ----------------------------
DROP TABLE IF EXISTS `event_subscribe_node_code`;
CREATE TABLE `event_subscribe_node_code`  (
  `subscribe_id` int(11) NOT NULL COMMENT '事件订阅id一致',
  `subscribe_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件订阅名称',
  `node_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设备或者通道编号',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`subscribe_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '事件订阅（设备||通道）关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of event_subscribe_node_code
-- ----------------------------

-- ----------------------------
-- Table structure for event_subscribe_org
-- ----------------------------
DROP TABLE IF EXISTS `event_subscribe_org`;
CREATE TABLE `event_subscribe_org`  (
  `subscribe_id` int(11) NOT NULL COMMENT '事件订阅id一致',
  `subscribe_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件订阅名称',
  `org` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组织代码',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`subscribe_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '事件订阅组织关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of event_subscribe_org
-- ----------------------------

-- ----------------------------
-- Table structure for event_subscribe_type
-- ----------------------------
DROP TABLE IF EXISTS `event_subscribe_type`;
CREATE TABLE `event_subscribe_type`  (
  `subscribe_id` int(11) NOT NULL COMMENT '事件订阅id一致',
  `subscribe_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件订阅名称',
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件类型',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`subscribe_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '事件订阅类型关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of event_subscribe_type
-- ----------------------------

-- ----------------------------
-- Table structure for fault
-- ----------------------------
DROP TABLE IF EXISTS `fault`;
CREATE TABLE `fault`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '故障事件唯\r\n一编码',
  `device_category` int(3) NOT NULL COMMENT '事件源类型',
  `device_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件源编码',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `type` int(3) NOT NULL COMMENT '故障类型',
  `event_time` datetime NOT NULL COMMENT '事件发生时间',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '故障发生位置',
  `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '故障原因',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '故障信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fault
-- ----------------------------

-- ----------------------------
-- Table structure for fault_process
-- ----------------------------
DROP TABLE IF EXISTS `fault_process`;
CREATE TABLE `fault_process`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '与故障信息上报时编码一致',
  `device_category` int(3) NOT NULL COMMENT '事件源类型',
  `device_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件源编码',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `happen_time` datetime NOT NULL COMMENT '故障恢复时间',
  `process_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '故障处理方式',
  `fault_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '故障处理情况（人工处理时需填写）',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处理人员名称',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '故障处理信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fault_process
-- ----------------------------

-- ----------------------------
-- Table structure for fire_alarm
-- ----------------------------
DROP TABLE IF EXISTS `fire_alarm`;
CREATE TABLE `fire_alarm`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '火灾预警事件唯一编码',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营服务机构唯一编码',
  `device_category` int(3) NOT NULL COMMENT '事件源类型',
  `device_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件源编码',
  `alarm_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '火灾预警类型',
  `event_time` datetime NOT NULL COMMENT '事件发生时间',
  `alarm_level` int(3) NULL DEFAULT NULL COMMENT '火灾预警等级',
  `image_urls` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '火灾预警图片信息',
  `video_urls` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '火灾预警视频信息',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '火灾预警信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fire_alarm
-- ----------------------------

-- ----------------------------
-- Table structure for fire_alarm_process
-- ----------------------------
DROP TABLE IF EXISTS `fire_alarm_process`;
CREATE TABLE `fire_alarm_process`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '火灾预警事件唯一编码',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `device_category` int(3) NOT NULL COMMENT '事件源类型',
  `device_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件源编码',
  `alarm_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '火警类型',
  `check_time` datetime NOT NULL COMMENT '火灾预警复核时间',
  `handle_time` datetime NOT NULL COMMENT '处理完成时间',
  `process_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '火灾预警复核方式',
  `handle_user_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '现场处置人员姓名',
  `handle_user_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '值守处置人员编号',
  `handle_status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '复核结果',
  `handle_context` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '火灾预警处理记录',
  `handle_image_urls` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '现场处理图片信息',
  `handle_video_urls` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '现场处理视频信息',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '火灾预警处置信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fire_alarm_process
-- ----------------------------

-- ----------------------------
-- Table structure for flyway_schema_history
-- ----------------------------
DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE `flyway_schema_history`  (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `script` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `checksum` int(11) NULL DEFAULT NULL,
  `installed_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`) USING BTREE,
  INDEX `flyway_schema_history_s_idx`(`success`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of flyway_schema_history
-- ----------------------------
INSERT INTO `flyway_schema_history` VALUES (1, '1', '<< Flyway Baseline >>', 'BASELINE', '<< Flyway Baseline >>', NULL, 'root', '2024-11-14 17:44:26', 0, 1);
INSERT INTO `flyway_schema_history` VALUES (2, '1.0.20241114', 'base', 'SQL', 'V1.0.20241114__base.sql', -1405947239, 'root', '2024-11-14 17:44:33', 6654, 1);

-- ----------------------------
-- Table structure for hidden_danger_label
-- ----------------------------
DROP TABLE IF EXISTS `hidden_danger_label`;
CREATE TABLE `hidden_danger_label`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件id',
  `task_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '巡更任务id（当danger_source=1时，表示巡更任务id）',
  `route_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路线id',
  `point_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '巡检点位唯一编码',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '隐患说明',
  `position` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '隐患位置',
  `status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '隐患状态（0待核查，1处理中，2已办结，3超时完成）',
  `source` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '隐患来源 0隐患上报，1巡检异常，2消防投诉',
  `label_list` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '隐患标签：0其他隐患，1消防给水管道没水，2消防设施故障，3消防器材缺失，4安全通道堵塞或关闭，5电线老化，6物联设备故障',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '巡更隐患信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hidden_danger_label
-- ----------------------------

-- ----------------------------
-- Table structure for iot_device
-- ----------------------------
DROP TABLE IF EXISTS `iot_device`;
CREATE TABLE `iot_device`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设备编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设备名称',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `device_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设备识别码',
  `location` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '安装位置',
  `device_manufactory` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设备厂商',
  `device_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设备类型',
  `code_3c` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '3C证书编号',
  `qualified_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '型式检验报告编号',
  `relation_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关联编码',
  `building_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所属建筑物编号',
  `constructor` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '施工单位名称',
  `produce_date` datetime NULL DEFAULT NULL COMMENT '设备生产时间',
  `install_date` datetime NULL DEFAULT NULL COMMENT '设备安装时间',
  `expire_date` datetime NULL DEFAULT NULL COMMENT '设备到期时间',
  `parts_num` int(11) NULL DEFAULT NULL COMMENT '部件总数',
  `notify_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '设备报警通知号码',
  `hardware_version` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '硬件版本',
  `software_version` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '软件版本',
  `controlroom_position` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消控室位置',
  `map_type` int(3) NULL DEFAULT NULL COMMENT '地图类型',
  `lng` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '经度',
  `lat` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '维度',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '物联设备表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of iot_device
-- ----------------------------

-- ----------------------------
-- Table structure for iot_part
-- ----------------------------
DROP TABLE IF EXISTS `iot_part`;
CREATE TABLE `iot_part`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部件唯一编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部件名称',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `sensor_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部件识别码',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '安装位置',
  `type` int(3) NULL DEFAULT NULL COMMENT '部件类型',
  `relation_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关联编码',
  `building_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所属建筑物编号',
  `device_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '所属设备编码',
  `code_3c` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '3C证书编号',
  `qualified_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '型式检验报告编号',
  `manufactory` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部件生产厂商',
  `produce_date` datetime NULL DEFAULT NULL COMMENT '部件生产时间',
  `install_date` datetime NULL DEFAULT NULL COMMENT '部件安装时间',
  `expire_date` datetime NULL DEFAULT NULL COMMENT '部件到期时间',
  `map_type` int(3) NULL DEFAULT NULL COMMENT '地图类型',
  `lng` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '经度',
  `lat` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '维度',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部件表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of iot_part
-- ----------------------------

-- ----------------------------
-- Table structure for patrol_point
-- ----------------------------
DROP TABLE IF EXISTS `patrol_point`;
CREATE TABLE `patrol_point`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '巡更点位',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '巡更点位名称',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `point_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '巡检点位类型',
  `relation_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关联编码',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '巡更点位' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of patrol_point
-- ----------------------------

-- ----------------------------
-- Table structure for patrol_record
-- ----------------------------
DROP TABLE IF EXISTS `patrol_record`;
CREATE TABLE `patrol_record`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务唯一id',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营服务机构唯一编码',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '巡检点位名称',
  `result` int(11) NOT NULL COMMENT '巡更任务结果',
  `status` int(11) NOT NULL COMMENT '巡更任务状态',
  `type` int(11) NOT NULL COMMENT '巡更任务类型 0：安保巡更，1：消防巡更',
  `scheduled_start_time` datetime NOT NULL COMMENT '计划开始时间',
  `scheduled_end_time` datetime NOT NULL COMMENT '计划截止时间',
  `actual_start_time` datetime NOT NULL COMMENT '实际开始时间',
  `actual_end_time` datetime NOT NULL COMMENT '实际截止时间',
  `route_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '路线id',
  `point_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '巡检点位唯一编码',
  `order` int(11) NULL DEFAULT NULL COMMENT '点位顺序',
  `finish_time` datetime NOT NULL COMMENT '完成时间',
  `point_status` int(11) NULL DEFAULT NULL COMMENT '巡更点位状态(0：待核查，1：预约维修，2：消防整改，3：其它处理，4：已处理，5：无需处理)',
  `relation_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位编码',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '巡更记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of patrol_record
-- ----------------------------

-- ----------------------------
-- Table structure for platform_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `platform_dictionary`;
CREATE TABLE `platform_dictionary`  (
  `sign` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '平台标识',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '平台名称'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订阅平台' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of platform_dictionary
-- ----------------------------
INSERT INTO `platform_dictionary` VALUES ('dahua', '大华');
INSERT INTO `platform_dictionary` VALUES ('haikang', '海康');
INSERT INTO `platform_dictionary` VALUES ('other', '其他');

-- ----------------------------
-- Table structure for serviceagency
-- ----------------------------
DROP TABLE IF EXISTS `serviceagency`;
CREATE TABLE `serviceagency`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `serviceagency_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '消防物联网运营服务机构名称',
  `company_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '统一社会信用代码',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '单位地址',
  `legal_represen_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '法定代表人姓名',
  `legal_represen_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '法定代表人身份证号码',
  `legal_represen_tel` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '法定代表人联系电话',
  `company_num` int(5) NULL DEFAULT NULL COMMENT '接入联网单位总数',
  `serviceagency _area` int(5) NULL DEFAULT NULL COMMENT '机构运营场地面积',
  `onduty_person_num` int(3) NULL DEFAULT NULL COMMENT '值守人员总数',
  `contact_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '运营机构责任人姓名',
  `contact_tel` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '运营机构责任人联系电话',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '消防物联网运营服务机构表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of serviceagency
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别 0女 1男 9未知',
  `id_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证信息',
  `mobile_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '座机号',
  `address` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for warning
-- ----------------------------
DROP TABLE IF EXISTS `warning`;
CREATE TABLE `warning`  (
  `id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件预警事件唯一编码',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `device_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件源编码',
  `event_time` datetime NOT NULL COMMENT '事件发生时间',
  `alarm_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件预警类型',
  `image_urls` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '报警时刻的图片，多个url通过逗号分隔',
  `video_urls` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '实时视频，多个url通过逗号分隔，需要考虑链接的安全',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '事件预警信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of warning
-- ----------------------------

-- ----------------------------
-- Table structure for warning_process
-- ----------------------------
DROP TABLE IF EXISTS `warning_process`;
CREATE TABLE `warning_process`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件预警事件唯一编码',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '运营服务机\r\n构唯一编码',
  `device_category` int(3) NOT NULL COMMENT '事件源类型',
  `device_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件源编码',
  `alarm_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '火警类型',
  `check_time` datetime NOT NULL COMMENT '火灾预警复核时间',
  `handle_time` datetime NOT NULL COMMENT '处理完成时间',
  `process_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '火灾预警复核方式',
  `handle_user_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '现场处置人员姓名',
  `handle_user_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '值守处置人员编号',
  `handle_status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '复核结果',
  `handle_context` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '火灾预警处理记录',
  `handle_image_urls` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '现场处理图片信息',
  `handle_video_urls` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '现场处理视频信息',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '事件预警处置信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of warning_process
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
