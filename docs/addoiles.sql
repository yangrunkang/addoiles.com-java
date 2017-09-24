/*
Navicat MySQL Data Transfer

Source Server         : 本机连接
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : addoiles

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-24 15:14:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `article_id` varchar(32) NOT NULL COMMENT '文章id',
  `article_type` int(1) NOT NULL COMMENT '文章类型',
  `title` varchar(50) DEFAULT NULL COMMENT '文章标题',
  `content` longtext COMMENT '文章内容',
  `delete_status` int(1) DEFAULT NULL COMMENT '删除状态 0-正常 1-删除',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `commit_id` varchar(32) NOT NULL COMMENT '评论id',
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `target_id` varchar(32) NOT NULL COMMENT '被评论内容的id',
  `content` varchar(100) DEFAULT NULL COMMENT '评论内容',
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态 0-正常 1-删除',
  `create_time` int(11) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dreams
-- ----------------------------
DROP TABLE IF EXISTS `dreams`;
CREATE TABLE `dreams` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `dream_id` varchar(32) NOT NULL COMMENT '梦想id',
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `title` varchar(32) NOT NULL COMMENT '梦想标题',
  `content` varchar(500) NOT NULL COMMENT '梦想内容',
  `likes` int(6) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `delete_status` int(1) DEFAULT '0' COMMENT '删除状态 0-正常 1-删除',
  `create_time` int(11) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for experience
-- ----------------------------
DROP TABLE IF EXISTS `experience`;
CREATE TABLE `experience` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `experience_id` varchar(32) NOT NULL COMMENT '经历id',
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `title` varchar(50) NOT NULL COMMENT '经历标题',
  `content` varchar(2000) NOT NULL COMMENT '经历内容',
  `rates` int(2) NOT NULL DEFAULT '0' COMMENT '评分',
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态 0-正常 1-删除',
  `create_time` int(11) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hots
-- ----------------------------
DROP TABLE IF EXISTS `hots`;
CREATE TABLE `hots` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hot_id` varchar(32) NOT NULL COMMENT '热门id',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户id(可以为空)',
  `title` varchar(32) NOT NULL COMMENT '热门动弹标题',
  `content` varchar(50) NOT NULL COMMENT '热门动弹内容',
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态 0-正常 1-删除',
  `create_time` int(11) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `name` varchar(16) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '用户名密码',
  `email` varchar(32) DEFAULT NULL COMMENT '用户邮箱',
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态 0-正常 1-删除',
  `create_time` int(11) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
