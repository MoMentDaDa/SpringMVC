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

 Date: 08/04/2020 18:23:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student_teacher
-- ----------------------------
DROP TABLE IF EXISTS `student_teacher`;
CREATE TABLE `student_teacher`  (
  `student_id` int(11) NULL DEFAULT NULL,
  `teacher_id` int(11) NULL DEFAULT NULL,
  INDEX `student_teacher_ibfk_1`(`student_id`) USING BTREE,
  INDEX `student_teacher_ibfk_2`(`teacher_id`) USING BTREE,
  CONSTRAINT `student_teacher_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `student_teacher_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student_teacher
-- ----------------------------
INSERT INTO `student_teacher` VALUES (43, 37);
INSERT INTO `student_teacher` VALUES (43, 38);
INSERT INTO `student_teacher` VALUES (45, 39);
INSERT INTO `student_teacher` VALUES (45, 40);
INSERT INTO `student_teacher` VALUES (46, 39);
INSERT INTO `student_teacher` VALUES (46, 40);

SET FOREIGN_KEY_CHECKS = 1;
