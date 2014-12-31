/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50619
 Source Host           : localhost
 Source Database       : wpay-admin

 Target Server Type    : MySQL
 Target Server Version : 50619
 File Encoding         : utf-8

 Date: 12/29/2014 23:50:18 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '用户真实姓名',
  `nickname` varchar(50) NOT NULL COMMENT '登录昵称',
  `password` varchar(64) DEFAULT NULL COMMENT '登录密码',
  `salt` varchar(6) DEFAULT NULL COMMENT '盐值',
  `status` tinyint(1) DEFAULT NULL COMMENT '用户状态: 1 可用、2 禁用',
  `roleId` bigint(20) DEFAULT NULL COMMENT '角色Id',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`nickname`) USING BTREE,
  KEY `IDX_CREATION_DATE` (`createTime`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `admin`
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES ('1', '管理员', 'admin', 'd7ed12f170ee37f16a7fe760b6ed940d', 'uqgsbd', '1', '1', '2014-01-08 18:43:35'), ('2', '开发者', 'develop', 'd461632e192bc0f4032c8df99db6ee9b', 'lZKuDi', '1', '1', '2014-01-10 17:25:10');
COMMIT;

-- ----------------------------
--  Table structure for `admin_permission`
-- ----------------------------
DROP TABLE IF EXISTS `admin_permission`;
CREATE TABLE `admin_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) DEFAULT NULL COMMENT '管理人员ID',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=312 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `admin_permission`
-- ----------------------------
BEGIN;
INSERT INTO `admin_permission` VALUES ('44', '2', '70'), ('43', '2', '69'), ('42', '2', '68'), ('41', '2', '67'), ('40', '2', '66'), ('39', '2', '65'), ('38', '2', '64'), ('37', '2', '63'), ('36', '2', '62'), ('35', '2', '61'), ('34', '2', '60'), ('33', '2', '59'), ('45', '2', '71'), ('46', '2', '72'), ('47', '12', '72'), ('48', '12', '71'), ('62', '16', '71'), ('60', '15', '71'), ('59', '14', '72'), ('55', '11', '72'), ('58', '14', '71'), ('66', '18', '71'), ('190', '23', '68'), ('238', '19', '110'), ('189', '23', '67'), ('188', '23', '93'), ('187', '23', '92'), ('186', '23', '91'), ('185', '23', '66'), ('184', '23', '65'), ('183', '23', '64'), ('182', '23', '63'), ('181', '23', '105'), ('180', '23', '96'), ('179', '23', '95'), ('178', '23', '94'), ('177', '23', '62'), ('176', '23', '61'), ('175', '23', '60'), ('174', '23', '59'), ('237', '19', '72'), ('236', '19', '71'), ('235', '19', '108'), ('234', '19', '107'), ('302', '20', '98'), ('301', '20', '99'), ('300', '20', '66'), ('299', '20', '65'), ('298', '20', '64'), ('297', '20', '63'), ('100', '21', '104'), ('99', '1', '104'), ('120', '22', '98'), ('119', '22', '97'), ('118', '22', '99'), ('117', '22', '71'), ('116', '22', '72'), ('115', '22', '104'), ('191', '23', '69'), ('192', '23', '70'), ('193', '23', '100'), ('194', '23', '101'), ('195', '23', '102'), ('196', '23', '103'), ('197', '23', '99'), ('198', '23', '98'), ('199', '23', '106'), ('200', '23', '107'), ('201', '23', '108'), ('202', '23', '71'), ('203', '23', '72'), ('204', '23', '104'), ('205', '23', '73'), ('206', '23', '74'), ('207', '23', '75'), ('208', '23', '76'), ('209', '23', '77'), ('210', '23', '78'), ('211', '23', '79'), ('212', '23', '80'), ('213', '23', '85'), ('214', '23', '86'), ('215', '23', '87'), ('216', '23', '88'), ('217', '23', '89'), ('218', '23', '90'), ('219', '23', '81'), ('220', '23', '82'), ('221', '23', '83'), ('222', '23', '84'), ('233', '19', '106'), ('232', '19', '98'), ('231', '19', '99'), ('311', '20', '72'), ('310', '20', '71'), ('309', '20', '109'), ('308', '20', '112'), ('307', '20', '110'), ('306', '20', '111'), ('305', '20', '108'), ('304', '20', '107'), ('303', '20', '106'), ('290', '25', '111'), ('289', '25', '110'), ('288', '25', '72'), ('287', '25', '71'), ('286', '25', '98'), ('285', '25', '99'), ('279', '24', '110'), ('278', '24', '72'), ('277', '24', '71'), ('276', '24', '109'), ('275', '24', '106'), ('274', '24', '98'), ('273', '24', '99'), ('272', '24', '103'), ('271', '24', '100'), ('270', '24', '67'), ('269', '24', '91'), ('268', '24', '63'), ('267', '24', '96');
COMMIT;

-- ----------------------------
--  Table structure for `annunciate`
-- ----------------------------
DROP TABLE IF EXISTS `annunciate`;
CREATE TABLE `annunciate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL COMMENT '通告标题',
  `context` text COMMENT '通告内容',
  `outhre` varchar(20) DEFAULT NULL COMMENT '发布者',
  `state` int(1) DEFAULT NULL COMMENT '通告状态：1 有效、2 无效',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `annunciate`
-- ----------------------------
BEGIN;
INSERT INTO `annunciate` VALUES ('60', '关于合作渠道完善规范', '', 'admin', '1', '2014-04-19 14:28:31'), ('61', '哈哈', '哈哈', 'admin', '1', '2014-12-13 21:12:44');
COMMIT;

-- ----------------------------
--  Table structure for `menu_1`
-- ----------------------------
DROP TABLE IF EXISTS `menu_1`;
CREATE TABLE `menu_1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '菜单名称',
  `sort` tinyint(2) DEFAULT '1' COMMENT '排序',
  `status` int(1) DEFAULT '1' COMMENT '状态：1 有效、2 无效',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `menu_1`
-- ----------------------------
BEGIN;
INSERT INTO `menu_1` VALUES ('5', '系统管理', '3', '1', '2014-01-09 16:00:49'), ('4', '数据管理', '1', '1', '2014-01-09 15:58:54');
COMMIT;

-- ----------------------------
--  Table structure for `menu_2`
-- ----------------------------
DROP TABLE IF EXISTS `menu_2`;
CREATE TABLE `menu_2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `parentId` int(11) NOT NULL COMMENT '一级菜单ID',
  `sort` tinyint(2) DEFAULT '1' COMMENT '排序',
  `rel` varchar(20) DEFAULT NULL COMMENT '引用',
  `defalutUrl` varchar(100) DEFAULT NULL COMMENT '默认连接地址',
  `status` int(1) DEFAULT '1' COMMENT '状态：1 有效、2 无效',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `menu_2`
-- ----------------------------
BEGIN;
INSERT INTO `menu_2` VALUES ('28', '角色列表', '5', '1', 'roleLiNav', '/oper/admin/role/list.page', '1'), ('29', '用户列表', '5', '1', 'userLiNav', '/oper/admin/user/list.page', '1'), ('30', '功能菜单列表', '5', '3', 'menuLiNav', '/oper/admin/menu/list', '1'), ('32', '通告管理', '4', '1', 'annunciateLiNav', '/oper/admin/manage/annunciate/list.page', '1');
COMMIT;

-- ----------------------------
--  Table structure for `menu_3`
-- ----------------------------
DROP TABLE IF EXISTS `menu_3`;
CREATE TABLE `menu_3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(100) DEFAULT NULL COMMENT '连接地址',
  `parentId` int(11) DEFAULT NULL COMMENT '父级ID',
  `status` int(1) DEFAULT '1' COMMENT '状态：1 有效、2 无效',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `menu_3`
-- ----------------------------
BEGIN;
INSERT INTO `menu_3` VALUES ('73', '用户管理列表', '/pay/admin/user/list.page', '29', '1'), ('74', '新增用户', '/pay/admin/user/new', '29', '1'), ('75', '编辑用户', '/pay/admin/user/edit', '29', '1'), ('76', '更新用户状态', '/pay/admin/user/updatestatus', '29', '1'), ('77', '用户权限列表', '/pay/admin/user/userpermission', '29', '1'), ('78', '更新用户权限', '/pay/admin/user/adduserpermission', '29', '1'), ('79', '用户合作渠道列表', '/pay/admin/user/userbigqn', '29', '1'), ('80', '更新用户合作渠道', '/pay/admin/user/adduserbigqn', '29', '1'), ('81', '功能菜单列表', '/pay/admin/menu/list.page', '30', '1'), ('82', '新增功能菜单', '/pay/admin/menu/new', '30', '1'), ('83', '编辑功能菜单', '/pay/admin/menu/edit', '30', '1'), ('84', '删除功能菜单', '/pay/admin/menu/delete', '30', '1'), ('85', '角色管理列表', '/pay/admin/role/list.page', '28', '1'), ('86', '新增角色', '/pay/admin/role/new', '28', '1'), ('87', '编辑角色', '/pay/admin/role/edit', '28', '1'), ('88', '删除角色', '/pay/admin/role/delete', '28', '1'), ('89', '角色权限列表', '/pay/admin/role/rolepermission', '28', '1'), ('90', '更新角色权限', '/pay/admin/role/addrolepermission', '28', '1'), ('94', '新增通告', '/pay/admin/manage/annunciate/new', '32', '1'), ('95', '编辑通告', '/pay/admin/manage/annunciate/edit', '32', '1'), ('96', '通告列表', '/pay/admin/manage/annunciate/list.page', '32', '1');
COMMIT;

-- ----------------------------
--  Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '角色名称',
  `type` int(1) DEFAULT '2' COMMENT '角色权限类型：1 所有权限、2 局部权限',
  `description` varchar(20) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `role`
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('1', '超级管理员', '1', '超级管理员角色'), ('2', '商务管理员', '2', '商务管理角色'), ('4', '普通用户', '2', '游戏开发商');
COMMIT;

-- ----------------------------
--  Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  KEY `FKBD40D538B5696F36` (`role_id`) USING BTREE,
  KEY `FKBD40D538FDFEE796` (`permission_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `role_permission`
-- ----------------------------
BEGIN;
INSERT INTO `role_permission` VALUES ('2', '104'), ('2', '72'), ('4', '104'), ('2', '71'), ('2', '59'), ('2', '60'), ('2', '61'), ('2', '62'), ('2', '94'), ('2', '95'), ('2', '96'), ('2', '63'), ('2', '64'), ('2', '65'), ('2', '66'), ('2', '91'), ('2', '92'), ('2', '93'), ('2', '67'), ('2', '68'), ('2', '69'), ('2', '70'), ('2', '100'), ('2', '101'), ('2', '102'), ('2', '103'), ('2', '97'), ('2', '98'), ('2', '99'), ('1', '59'), ('1', '60'), ('1', '61'), ('1', '62'), ('1', '94'), ('1', '95'), ('1', '96'), ('1', '63'), ('1', '64'), ('1', '65'), ('1', '66'), ('1', '91'), ('1', '92'), ('1', '93'), ('1', '67'), ('1', '68'), ('1', '69'), ('1', '70'), ('1', '100'), ('1', '101'), ('1', '102'), ('1', '103'), ('1', '97'), ('1', '98'), ('1', '99'), ('1', '71'), ('1', '72'), ('1', '104'), ('1', '73'), ('1', '74'), ('1', '75'), ('1', '76'), ('1', '77'), ('1', '78'), ('1', '79'), ('1', '80'), ('1', '85'), ('1', '86'), ('1', '87'), ('1', '88'), ('1', '89'), ('1', '90'), ('1', '81'), ('1', '82'), ('1', '83'), ('1', '84'), ('4', '72'), ('4', '71'), ('4', '98'), ('4', '99');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
