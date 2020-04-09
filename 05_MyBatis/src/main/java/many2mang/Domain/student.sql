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

 Date: 08/04/2020 18:23:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (5, '小明');
INSERT INTO `student` VALUES (6, '小王');
INSERT INTO `student` VALUES (15, '小明');
INSERT INTO `student` VALUES (16, '小王');
INSERT INTO `student` VALUES (17, '小明');
INSERT INTO `student` VALUES (18, '小王');
INSERT INTO `student` VALUES (19, '小明');
INSERT INTO `student` VALUES (20, '小王');
INSERT INTO `student` VALUES (25, '小明');
INSERT INTO `student` VALUES (26, '小王');
INSERT INTO `student` VALUES (43, '小明');
INSERT INTO `student` VALUES (45, '小明');
INSERT INTO `student` VALUES (46, '小王');

SET FOREIGN_KEY_CHECKS = 1;
