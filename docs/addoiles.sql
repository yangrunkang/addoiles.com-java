/*
Navicat MySQL Data Transfer

Source Server         : 本机连接
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : addoiles

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-18 00:13:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oil_article
-- ----------------------------
DROP TABLE IF EXISTS `oil_article`;
CREATE TABLE `oil_article` (
  `id` varchar(32) NOT NULL,
  `article_id` varchar(32) DEFAULT NULL COMMENT '文章ID',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `title` varchar(10) DEFAULT NULL COMMENT '标题',
  `content` varchar(800) DEFAULT NULL COMMENT '内容',
  `type` int(2) DEFAULT NULL COMMENT '1-梦想 2-经历 3-最近难点 4-吐槽 5-新闻',
  `delete_status` int(1) DEFAULT '1' COMMENT '0-删除 1-正常',
  `favourite` int(10) DEFAULT NULL COMMENT '喜爱',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章';
-- 添加讨论次数
alter table oil_article add commit_times int(10) DEFAULT NULL COMMENT '讨论次数';

-- ----------------------------
-- Table structure for oil_comment
-- ----------------------------
DROP TABLE IF EXISTS `oil_comment`;
CREATE TABLE `oil_comment` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `comment_id` varchar(32) DEFAULT NULL COMMENT '评论ID',
  `delete_status` int(1) DEFAULT '1' COMMENT '0-删除 1-正常',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='所有评论相关';

-- ----------------------------
-- Table structure for oil_share
-- ----------------------------
DROP TABLE IF EXISTS `oil_share`;
CREATE TABLE `oil_share` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `title` varchar(16) DEFAULT NULL COMMENT '标题',
  `content` varchar(100) DEFAULT NULL COMMENT '内容',
  `favorite` int(5) DEFAULT NULL COMMENT '喜爱',
  `dislike` int(5) DEFAULT NULL COMMENT '厌恶',
  `delete_status` int(1) DEFAULT '1' COMMENT '0-删除 1-正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='无需注册所有人都可以';
-- 添加创建时间
alter table oil_share add create_time int(11) DEFAULT NULL COMMENT '创建时间';

-- ----------------------------
-- Table structure for oil_user
-- ----------------------------
DROP TABLE IF EXISTS `oil_user`;
CREATE TABLE `oil_user` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(10) DEFAULT NULL COMMENT '用户名',
  `password` varchar(16) DEFAULT NULL COMMENT '密码',
  `delete_status` int(1) DEFAULT '1' COMMENT '0-删除 1-正常',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `oil_text`;
CREATE TABLE `oil_text` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` varchar(32) DEFAULT NULL COMMENT '文章ID',
  `content` mediumtext COMMENT '存储超长文章',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;