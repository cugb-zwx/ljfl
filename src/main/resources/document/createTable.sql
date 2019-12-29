/*
Navicat MySQL Data Transfer

Source Server         : 121.36.50.36
Source Server Version : 50728
Source Host           : 121.36.50.36:3306
Source Database       : ljfl-dev

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2019-12-18 23:58:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '唯一标识',
  `code` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '城市编码',
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '城市名称',
  `py` varchar(500) COLLATE utf8_unicode_ci NOT NULL COMMENT '城市汉语拼音',
  `province_code` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '所属省区编码',
  `state` bit(1) NOT NULL COMMENT '城市状态（0 禁用 1 启用）',
  `reg` longtext COLLATE utf8_unicode_ci COMMENT '垃圾分类官方指导意见',
  `puh` longtext COLLATE utf8_unicode_ci COMMENT '垃圾分类官方处罚办法',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '数据记录状态',
  `note` tinytext COLLATE utf8_unicode_ci COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='城市表';

-- ----------------------------
-- Table structure for garbage_one
-- ----------------------------
DROP TABLE IF EXISTS `garbage_one`;
CREATE TABLE `garbage_one` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '唯一标识',
  `city_code` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '所属城市编码',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '垃圾名称',
  `remark` text COLLATE utf8_unicode_ci COMMENT '垃圾描述信息',
  `crate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '数据记录状态',
  `note` longtext COLLATE utf8_unicode_ci COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='垃圾一级分类表';

-- ----------------------------
-- Table structure for garbage_two
-- ----------------------------
DROP TABLE IF EXISTS `garbage_two`;
CREATE TABLE `garbage_two` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '唯一标识',
  `city_code` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '所属城市编码',
  `garbage-one-id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '垃圾所属一级分类ID',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '垃圾名称',
  `remark` text COLLATE utf8_unicode_ci COMMENT '垃圾描述信息',
  `crate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '数据记录状态',
  `note` longtext COLLATE utf8_unicode_ci COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='垃圾二级分类表';

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '唯一标识',
  `code` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '省区编码',
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '省区名称',
  `py` varchar(500) COLLATE utf8_unicode_ci NOT NULL COMMENT '省区名称汉语拼音',
  `type` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '省区类型( 1 直辖市 2 行政省 3 自治区 4 特别行政区  5 其他国家)',
  `state` bit(1) NOT NULL COMMENT '省区启用状态( 1 启用 0 禁止)',
  `reg` longtext COLLATE utf8_unicode_ci COMMENT '垃圾分类官方指导意见（备用）',
  `puh` longtext COLLATE utf8_unicode_ci COMMENT '垃圾分类官方处罚办法（备用）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `note` tinytext COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='省区表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户标识',
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `nick_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '昵称',
  `head_img` varchar(500) COLLATE utf8_unicode_ci NOT NULL COMMENT '头像',
  `passward` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '12345678' COMMENT '密码',
  `openid` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '微信openid',
  `sex` bit(1) NOT NULL DEFAULT b'1' COMMENT '性别',
  `age` tinyint(3) NOT NULL DEFAULT '20' COMMENT '年龄',
  `login_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
  `city_code` varchar(20) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '所属城市ID',
  `mobile` varchar(11) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '手机号',
  `count` int(20) NOT NULL DEFAULT '0' COMMENT '操作次数',
  `status` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '1' COMMENT '用户状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `note` text COLLATE utf8_unicode_ci COMMENT '备注信息',
  `points` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户表';

-- ----------------------------
-- Table structure for user_garbage
-- ----------------------------
DROP TABLE IF EXISTS `user_garbage`;
CREATE TABLE `user_garbage` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '唯一表示',
  `user_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户ID',
  `garbage_two_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '垃圾二级分类ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户垃圾关联表';

-- ----------------------------
-- Table structure for user_sign
-- ----------------------------
DROP TABLE IF EXISTS `user_sign`;
CREATE TABLE `user_garbage` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '唯一表示',
  `user_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户签到圾关联表';