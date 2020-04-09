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

 Date: 06/04/2020 13:14:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salary` decimal(10, 2) NULL DEFAULT NULL,
  `deptID` int(11) NULL DEFAULT NULL,
  `hiredate` date NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `工作外键`(`deptID`) USING BTREE,
  CONSTRAINT `工作外键` FOREIGN KEY (`deptID`) REFERENCES `dept` (`deptno`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '赵一', 35, '001', 800.00, 10, '2020-01-08', NULL);
INSERT INTO `employee` VALUES (2, '倩儿', 21, '002', 900.00, 10, '2020-01-22', NULL);
INSERT INTO `employee` VALUES (3, '孙三', 19, '003', 800.00, 20, '2019-12-12', NULL);
INSERT INTO `employee` VALUES (4, '李四', 30, '004', 1000.00, 30, '2019-11-16', NULL);
INSERT INTO `employee` VALUES (5, '王五', 28, '005', 900.00, 30, '2019-08-15', NULL);
INSERT INTO `employee` VALUES (6, '周大妈', 26, '006', 1200.00, 40, '2019-09-11', NULL);
INSERT INTO `employee` VALUES (7, '郑七', 40, '007', 1000.00, 10, '2019-12-24', NULL);
INSERT INTO `employee` VALUES (8, '东方不败', 27, '008', 2600.00, 20, '2020-01-03', NULL);
INSERT INTO `employee` VALUES (9, 'will', 23, NULL, NULL, 30, '2019-02-03', '123456');
INSERT INTO `employee` VALUES (14, 'luck', 29, '300', 300.00, 10, '2012-04-08', '1234');
INSERT INTO `employee` VALUES (15, 'wang', 51, NULL, NULL, 40, '2012-09-18', '123456');
INSERT INTO `employee` VALUES (17, '令狐冲', NULL, NULL, NULL, 50, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
