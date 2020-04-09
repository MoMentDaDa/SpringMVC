/*
 Navicat Premium Data Transfer

 Source Server         : will
 Source Server Type    : MySQL
 Source Server Version : 50556
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 08/04/2020 18:23:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (10, '老师2');
INSERT INTO `teacher` VALUES (11, '老师1');
INSERT INTO `teacher` VALUES (12, '老师2');
INSERT INTO `teacher` VALUES (13, '老师1');
INSERT INTO `teacher` VALUES (14, '老师2');
INSERT INTO `teacher` VALUES (19, '老师1');
INSERT INTO `teacher` VALUES (20, '老师2');
INSERT INTO `teacher` VALUES (37, '老师1');
INSERT INTO `teacher` VALUES (38, '老师2');
INSERT INTO `teacher` VALUES (39, '老师1');
INSERT INTO `teacher` VALUES (40, '老师2');

SET FOREIGN_KEY_CHECKS = 1;
