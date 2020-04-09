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

 Date: 08/04/2020 19:09:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '乔峰', 32, '123', '2020-01-07');
INSERT INTO `user` VALUES (2, '陆小凤', 32, '123', '2019-12-11');
INSERT INTO `user` VALUES (3, 'will', 17, '1234', '2019-09-25');
INSERT INTO `user` VALUES (4, 'luck', 48, 'wang1234', '2019-08-22');
INSERT INTO `user` VALUES (6, '', 5, '123', '2020-01-26');
INSERT INTO `user` VALUES (7, '明明', NULL, '123', '2019-06-11');
INSERT INTO `user` VALUES (8, '丽丽', 11, NULL, '2020-01-26');
INSERT INTO `user` VALUES (9, '习大大', 24, '44554', NULL);
INSERT INTO `user` VALUES (10, 'lulu', 21, 'dafdaf', '2012-03-04');

SET FOREIGN_KEY_CHECKS = 1;
