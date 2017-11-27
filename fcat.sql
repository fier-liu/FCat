/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : fcat

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-11-27 19:28:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority_id` int(11) DEFAULT NULL,
  `authority_type` varchar(255) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2903 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_authority
-- ----------------------------
INSERT INTO `t_authority` VALUES ('2824', '2', 'group', '13', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2825', '2', 'group', '5', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2826', '2', 'group', '1', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2827', '2', 'group', '6', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2828', '2', 'group', '7', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2829', '2', 'group', '8', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2830', '2', 'group', '21', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2831', '2', 'group', '14', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2832', '2', 'group', '33', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2833', '2', 'group', '4', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2834', '2', 'group', '5', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2835', '2', 'group', '3', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2836', '2', 'group', '23', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2837', '2', 'group', '10', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2838', '2', 'group', '11', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2839', '2', 'group', '12', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2840', '2', 'group', '13', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2841', '2', 'group', '14', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2842', '2', 'group', '15', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2843', '2', 'group', '24', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2844', '2', 'group', '27', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2845', '2', 'group', '20', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2846', '2', 'group', '28', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2847', '2', 'group', '16', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2848', '2', 'group', '17', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2849', '2', 'group', '18', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2850', '2', 'group', '19', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2851', '2', 'group', '21', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2852', '2', 'group', '22', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2853', '2', 'group', '32', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2854', '2', 'group', '33', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2855', '2', 'group', '34', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2856', '2', 'group', '35', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2868', '1', 'group', '13', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2869', '1', 'group', '5', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2870', '1', 'group', '1', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2871', '1', 'group', '6', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2872', '1', 'group', '7', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2873', '1', 'group', '8', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2874', '1', 'group', '21', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2875', '1', 'group', '14', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2876', '1', 'group', '33', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2877', '1', 'group', '34', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2878', '1', 'group', '35', 'menu', null, null);
INSERT INTO `t_authority` VALUES ('2879', '1', 'group', '3', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2880', '1', 'group', '4', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2881', '1', 'group', '5', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2882', '1', 'group', '23', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2883', '1', 'group', '10', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2884', '1', 'group', '11', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2885', '1', 'group', '12', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2886', '1', 'group', '13', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2887', '1', 'group', '14', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2888', '1', 'group', '15', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2889', '1', 'group', '24', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2890', '1', 'group', '27', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2891', '1', 'group', '16', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2892', '1', 'group', '17', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2893', '1', 'group', '18', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2894', '1', 'group', '19', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2895', '1', 'group', '20', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2896', '1', 'group', '21', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2897', '1', 'group', '22', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2898', '1', 'group', '28', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2899', '1', 'group', '32', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2900', '1', 'group', '33', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2901', '1', 'group', '34', 'element', null, null);
INSERT INTO `t_authority` VALUES ('2902', '1', 'group', '35', 'element', null, null);

-- ----------------------------
-- Table structure for t_element
-- ----------------------------
DROP TABLE IF EXISTS `t_element`;
CREATE TABLE `t_element` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `uri` varchar(255) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `path` varchar(2000) DEFAULT NULL,
  `method` varchar(10) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_element
-- ----------------------------
INSERT INTO `t_element` VALUES ('3', 'userManager:btn_add', 'button', '新增', '/fcat-user/v1/tUser/**', '1', null, null, 'POST', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('4', 'userManager:btn_edit', 'button', '编辑', '/fcat-user/v1/tUser/**', '1', null, null, 'PUT', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('5', 'userManager:btn_del', 'button', '删除', '/fcat-user/v1/tUser/**', '1', null, null, 'DELETE', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('10', 'menuManager:btn_add', 'button', '新增', '/fcat-user/v1/tMenu/**', '6', null, null, 'POST', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('11', 'menuManager:btn_edit', 'button', '编辑', '/fcat-user/v1/tMenu/**', '6', '0', '', 'PUT', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('12', 'menuManager:btn_del', 'button', '删除', '/fcat-user/v1/tMenu/**', '6', '0', '', 'DELETE', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('13', 'menuManager:btn_element_add', 'button', '新增元素', '/fcat-user/v1/tElement/**', '6', null, null, 'POST', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('14', 'menuManager:btn_element_edit', 'button', '编辑元素', '/fcat-user/v1/tElement/**', '6', null, null, 'PUT', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('15', 'menuManager:btn_element_del', 'button', '删除元素', '/fcat-user/v1/tElement/**', '6', null, null, 'DELETE', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('16', 'groupManager:btn_add', 'button', '新增', '/fcat-user/v1/tGroup/**', '7', null, null, 'POST', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('17', 'groupManager:btn_edit', 'button', '编辑', '/fcat-user/v1/tGroup/**', '7', null, null, 'PUT', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('18', 'groupManager:btn_del', 'button', '删除', '/fcat-user/v1/tGroup/**', '7', null, null, 'DELETE', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('19', 'groupManager:btn_userManager', 'button', '分配用户', '/fcat-user/v1/tUserGroup/**', '7', null, null, 'POST', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('20', 'groupManager:btn_resourceManager', 'button', '分配权限', '/fcat-user/v1/tAuthority/**', '7', null, null, 'GET', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('21', 'groupManager:menu', 'uri', '分配菜单', '/fcat-user/v1/tAuthority/**', '7', null, null, 'POST', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('22', 'groupManager:element', 'uri', '分配元素', '/fcat-user/v1/tAuthority/**', '7', null, null, 'POST', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('23', 'userManager:view', 'uri', '查看', '/fcat-user/v1/tUser/**', '1', '0', '', 'GET', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('24', 'menuManager:view', 'uri', '查看', '/fcat-user/v1/tMenu/**', '6', '0', '', 'GET', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('27', 'menuManager:element_view', 'uri', '查看元素', '/fcat-user/v1/tElement/**', '6', null, null, 'GET', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('28', 'groupManager:view', 'uri', '查看', '/fcat-user/v1/tGroup/**', '7', null, null, 'GET', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('32', 'groupTypeManager:view', 'uri', '查看', '/fcat-user/v1/tGroupType/**', '8', null, null, 'GET', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('33', 'groupTypeManager:btn_add', 'button', '新增', '/fcat-user/v1/tGroupType/**', '8', null, null, 'POST', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('34', 'groupTypeManager:btn_edit', 'button', '编辑', '/fcat-user/v1/tGroupType/**', '8', null, null, 'PUT', '2017-10-06 15:24:15', '2017-10-06 15:24:15');
INSERT INTO `t_element` VALUES ('35', 'groupTypeManager:btn_del', 'button', '删除', '/fcat-user/v1/tGroupType/**', '8', null, null, 'DELETE', '2017-10-06 15:24:15', '2017-10-06 15:24:15');

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `path` varchar(2000) DEFAULT NULL,
  `group_type_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_group
-- ----------------------------
INSERT INTO `t_group` VALUES ('1', 'role', '角色', '-1', '/role', '1', '2017-10-12 13:14:13', '2017-10-12 13:14:13');
INSERT INTO `t_group` VALUES ('2', 'superAdmin', '超级管理员', '1', '/role/superAdmin', '1', '2017-10-06 21:29:40', '2017-10-06 21:29:40');
INSERT INTO `t_group` VALUES ('4', 'tourist', '游客', '1', '/role/tourist', '1', '2017-10-06 21:29:40', '2017-10-06 21:29:40');
INSERT INTO `t_group` VALUES ('6', 'company', '深圳华为技术有限公司', '-1', '/company', '2', '2017-10-06 21:29:40', '2017-10-06 21:29:40');
INSERT INTO `t_group` VALUES ('7', 'financeDepart', '财务部', '6', '/company/financeDepart', '2', '2017-10-06 21:29:40', '2017-10-06 21:29:40');
INSERT INTO `t_group` VALUES ('8', 'hrDepart', '人力资源部', '6', '/company/hrDepart', '2', '2017-10-06 21:29:40', '2017-10-06 21:29:40');

-- ----------------------------
-- Table structure for t_group_type
-- ----------------------------
DROP TABLE IF EXISTS `t_group_type`;
CREATE TABLE `t_group_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_group_type
-- ----------------------------
INSERT INTO `t_group_type` VALUES ('1', 'role', '角色类型', '2017-10-06 14:49:11', '2017-10-06 14:49:11');
INSERT INTO `t_group_type` VALUES ('2', 'depart', '部门类型', '2017-10-06 14:49:11', '2017-10-06 14:49:11');
INSERT INTO `t_group_type` VALUES ('3', 'custom', '自定义类型', '2017-10-06 14:49:11', '2017-10-06 14:49:11');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `parent_id` int(11) NOT NULL,
  `href` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `order_num` int(11) NOT NULL DEFAULT '0',
  `path` varchar(500) DEFAULT NULL,
  `enabled` char(1) DEFAULT 'Y',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', 'userManager', '用户管理', '5', '/index/tUserList', 'fa fa-user', '0', '/adminSys/baseManager/userManager', 'Y', '2017-10-06 15:36:15', '2017-10-06 15:36:15');
INSERT INTO `t_menu` VALUES ('5', 'baseManager', '基础配置', '13', '/', 'fa fa-cog', '0', '/adminSys/baseManager', 'Y', '2017-10-06 15:36:15', '2017-10-06 15:36:15');
INSERT INTO `t_menu` VALUES ('6', 'menuManager', '菜单管理', '5', '/index/tMenuList', 'fa fa-list', '0', '/adminSys/baseManager/menuManager', 'Y', '2017-10-06 15:36:15', '2017-10-06 15:36:15');
INSERT INTO `t_menu` VALUES ('7', 'groupManager', '组织架构管理', '5', '/index/tGroupList', 'fa fa-users', '0', '/adminSys/baseManager/groupManager', 'Y', '2017-10-06 15:36:15', '2017-10-06 15:36:15');
INSERT INTO `t_menu` VALUES ('8', 'groupTypeManager', '组织类型管理', '5', '/index/tGroupTypeList', 'fa fa-object-group', '0', '/adminSys/baseManager/groupTypeManager', 'Y', '2017-10-06 15:36:15', '2017-10-06 15:36:15');
INSERT INTO `t_menu` VALUES ('13', 'adminSys', '权限管理系统', '-1', '/', 'fa fa-terminal', '0', '/adminSys', 'Y', '2017-10-06 15:36:15', '2017-10-06 15:36:15');
INSERT INTO `t_menu` VALUES ('14', 'contentSys', '区域管理系统', '-1', '/', 'fa-newspaper-o', '0', '/contentSys', 'Y', '2017-10-06 15:36:15', '2017-10-06 15:36:15');
INSERT INTO `t_menu` VALUES ('21', 'dictManager', '数据字典', '5', '/index/dictList', 'fa fa-book', '0', '/adminSys/baseManager/dictManager', 'Y', '2017-10-06 15:36:15', '2017-10-06 15:36:15');
INSERT INTO `t_menu` VALUES ('33', 'areaManager', '区域管理', '14', '/', 'fa fa-map-o', '0', null, 'Y', '2017-10-17 21:44:03', '2017-10-17 21:44:03');
INSERT INTO `t_menu` VALUES ('34', 'country', '国家', '33', '/index/dictList', 'fa fa-clone', '0', null, 'Y', '2017-10-17 21:46:21', '2017-10-17 21:46:21');
INSERT INTO `t_menu` VALUES ('35', 'province', '省会', '33', '/index/dictList', 'fa  fa-film', '0', null, 'Y', '2017-10-17 21:49:49', '2017-10-17 21:49:49');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `mobile_phone` varchar(255) NOT NULL,
  `tel_phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sex` char(1) DEFAULT 'S' COMMENT '''F''-女，''M''-男，''S''-保密',
  `status` char(1) DEFAULT 'Y' COMMENT '''Y''-激活，''N''-未激活，''D''-已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'xiaoliu', '123456', '小刘', '1991-02-11', '广东省深圳市福田', '13025442101', '07997287924', 'xiaoliu@163.com', 'M', 'Y', '2017-10-06 14:40:36', '2017-10-06 14:40:36');
INSERT INTO `t_user` VALUES ('2', 'aki', '123456', '阿沂', '1989-02-11', '广东省省长市水斗村', '13430932112', '07997287923', 'aki@163.com', 'F', 'Y', '2017-10-06 14:40:36', '2017-10-06 14:40:36');
INSERT INTO `t_user` VALUES ('3', 'xiaoxiong', '123456', '小熊', '1995-02-11', '广东省深圳市宝安', '13225442101', '07997287922', 'xiaoxiong@163.com', 'M', 'Y', '2017-10-06 14:40:36', '2017-10-06 14:40:36');
INSERT INTO `t_user` VALUES ('4', 'xiaofei', '123456', '小飞', '1992-02-11', '广东省深圳市盐田', '13225442101', '07997287922', 'xiaofei@163.com', 'M', 'Y', '2017-10-08 16:15:59', '2017-10-08 16:15:59');
INSERT INTO `t_user` VALUES ('5', 'xiaoxiang', '123456', '小翔', '1992-02-11', '广东省深圳市盐田', '13225442103', '07997287923', 'xiaoxiang@163.com', 'S', 'Y', '2017-10-17 17:55:24', '2017-10-17 17:55:24');
INSERT INTO `t_user` VALUES ('7', '18925231121', '1', '2334', '1', '1', '1', '1', '1', 'S', 'Y', '2017-10-17 18:18:59', '2017-10-17 18:18:59');
INSERT INTO `t_user` VALUES ('8', 'hbk619', '123456', '小王', null, null, '13923772870', null, '463061820@qq.com', 'M', 'Y', '2017-11-03 15:08:09', '2017-11-03 15:08:09');

-- ----------------------------
-- Table structure for t_user_group
-- ----------------------------
DROP TABLE IF EXISTS `t_user_group`;
CREATE TABLE `t_user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(255) DEFAULT NULL,
  `user_id` int(255) DEFAULT NULL,
  `type` varchar(20) DEFAULT 'member' COMMENT '''member''-成员，''leader''-领导',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_group
-- ----------------------------
INSERT INTO `t_user_group` VALUES ('38', '1', '5', 'leader', null, null);
INSERT INTO `t_user_group` VALUES ('39', '1', '3', 'leader', null, null);
INSERT INTO `t_user_group` VALUES ('40', '1', '5', 'member', null, null);
INSERT INTO `t_user_group` VALUES ('41', '1', '7', 'member', null, null);
INSERT INTO `t_user_group` VALUES ('43', '1', '1', 'leader', null, null);
INSERT INTO `t_user_group` VALUES ('44', '2', '1', 'leader', null, null);
INSERT INTO `t_user_group` VALUES ('45', '2', '2', 'leader', null, null);
INSERT INTO `t_user_group` VALUES ('46', '2', '3', 'leader', null, null);
INSERT INTO `t_user_group` VALUES ('47', '2', '4', 'leader', null, null);
INSERT INTO `t_user_group` VALUES ('48', '2', '5', 'leader', null, null);
INSERT INTO `t_user_group` VALUES ('49', '2', '7', 'leader', null, null);
INSERT INTO `t_user_group` VALUES ('50', '1', '2', 'leader', null, null);
