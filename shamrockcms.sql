/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : shamrockcms

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2016-11-28 17:11:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `name` varchar(50) DEFAULT NULL COMMENT '管理员名称',
  `password` varchar(32) DEFAULT NULL COMMENT '密码 MD5加密',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`adminId`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='管理员';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '2012-08-08 00:00:00');
INSERT INTO `admin` VALUES ('2', '观音', 'e10adc3949ba59abbe56e057f20f883e', '2016-08-29 15:03:11');
INSERT INTO `admin` VALUES ('8', '王飞', '123456', '2016-08-29 15:46:09');

-- ----------------------------
-- Table structure for admin_folder
-- ----------------------------
DROP TABLE IF EXISTS `admin_folder`;
CREATE TABLE `admin_folder` (
  `adminId` bigint(20) DEFAULT NULL,
  `folderId` bigint(20) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of admin_folder
-- ----------------------------
INSERT INTO `admin_folder` VALUES ('1', '1', '2014-10-29 20:48:42');
INSERT INTO `admin_folder` VALUES ('1', '3', '2014-10-29 20:48:43');
INSERT INTO `admin_folder` VALUES ('1', '4', '2014-10-29 20:48:44');
INSERT INTO `admin_folder` VALUES ('1', '5', '2014-10-29 20:48:45');
INSERT INTO `admin_folder` VALUES ('1', '2', '2014-10-29 20:48:46');
INSERT INTO `admin_folder` VALUES ('1', '7', '2016-10-12 11:45:29');
INSERT INTO `admin_folder` VALUES ('1', '8', '2016-10-13 16:49:57');
INSERT INTO `admin_folder` VALUES ('2', '1', '2016-10-13 21:39:33');
INSERT INTO `admin_folder` VALUES ('2', '3', '2016-10-13 21:39:59');
INSERT INTO `admin_folder` VALUES ('1', '8', '2016-10-17 14:46:41');
INSERT INTO `admin_folder` VALUES ('1', '9', '2016-10-17 14:59:34');
INSERT INTO `admin_folder` VALUES ('1', '10', '2016-10-17 15:01:56');
INSERT INTO `admin_folder` VALUES ('1', '11', '2016-10-17 15:05:31');
INSERT INTO `admin_folder` VALUES ('1', '12', '2016-10-17 15:07:31');
INSERT INTO `admin_folder` VALUES ('1', '13', '2016-10-17 15:10:46');
INSERT INTO `admin_folder` VALUES ('1', '14', '2016-11-25 17:50:52');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `articleId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `folderId` bigint(20) DEFAULT NULL,
  `path` varchar(200) DEFAULT NULL,
  `adminId` bigint(20) DEFAULT '0' COMMENT '管理员ID',
  `picture` varchar(60) DEFAULT NULL,
  `title` varchar(200) DEFAULT '' COMMENT '文件名称',
  `summary` varchar(2000) DEFAULT NULL,
  `content` mediumtext COMMENT '文件内容',
  `viewCount` int(11) DEFAULT '0' COMMENT '浏览数',
  `commentCount` int(11) DEFAULT '0' COMMENT '评论数',
  `status` enum('hidden','display') DEFAULT 'display' COMMENT '状态：0 隐藏 1 显示',
  `check` enum('yes','no','init') DEFAULT NULL,
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`articleId`),
  KEY `idx_folder` (`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='文件';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '3', '1#3#', '1', 'upload/template/articlebg/12.jpg', 'Never in my life did I imagine a month would feel like a week, and reality like a dream. Oh beautiful Ibiza thank you for this experience.', 'Hello World!!', '<p>In the beginning of June, I decided I&#39;m going to visit the promised \r\nisland everyone wants to see and I must say, I wasn&#39;t disappointed. \r\nFinding a job wasn&#39;t that hard, you find it quickly because of all the \r\nparties, companies are looking for&nbsp;promotors&nbsp;and that&#39;s how I ran into&nbsp;<a href=\"http://www.ibizaclubhub.com/\">IbizaClubHub</a>.\r\n A completely new company which gave me a lot, much more than I \r\nexpected. Is it hard to work as a&nbsp;promotor? Yes. Is it hard to work on \r\nthe burning sun? Yes. But is it hard to live on Ibiza and work with the \r\nmost amazing people you&#39;ll ever meet? Not at all.</p><p>I arrived on the&nbsp;<strong>9th&nbsp;of July</strong> and was welcomed by Paul and Janine, two&nbsp;really nice&nbsp;Germans&nbsp;which drove me to my flat in&nbsp;<strong>Figueretas</strong>,\r\n which is between Ibiza town and Playa d&#39; en&nbsp;Bossa. A calm neighbourhood\r\n on a party island, can you imagine? Straight away I realized that Ibiza\r\n has a lot more to offer than just parties. Thanks to a friend of mine, \r\nthe very first night he took me to the old Ibiza town, which I found \r\nvery fascinating. The port with beautiful yachts, night life and all the\r\n cute stores melted my heart, I was already in love. After exploring the\r\n town, it was time for my very first party there, so we went \r\nto&nbsp;Sankeys&nbsp;which after a few visits became one of my favourite clubs. \r\nSince it was my first day on Ibiza, I&nbsp;didn&#39;t&nbsp;want to stay out too long \r\nbecause the next day I already had my first meeting with the team and \r\nthe most amazing boss on this planet,&nbsp;Okan. I was welcomed with open \r\narms and nicest words ever and because it was my first day I just had to\r\n get to know the beach, which later became my office, and just enjoy the\r\n beautiful Playa d&#39; en&nbsp;Bossa. After a few days I learned a few tricks on\r\n how to do my job, but I wouldn&#39;t be able to learn it if it&nbsp;wasn&#39;t&nbsp;for \r\nthe workshops and people who I worked with.&nbsp;</p><p>Days passed by extremely quickly, working from&nbsp;12pm&nbsp;till&nbsp;7pm&nbsp;on a \r\nbeautiful sandy beach with your feet in water and nice fresh breeze \r\ndidn&#39;t even feel like proper working place. But as the nights were \r\narriving each time after sunny days, whole Playa d&#39; en&nbsp;Bossa&nbsp;changed \r\ninto a party place. Even ‘tho during the day you could find parties here\r\n and there (Bora Bora, Jet, Ushuaia), during the night every single bar \r\nhad its own party and clubs slowly started to open their doors. While \r\nwalking on the streets of Playa d’ en Bossa you get stopped by tons of \r\npromotors for tickets and inviting you for drinks, and I know how \r\nannoying it can be being ‘harassed’ by promotors on every step you take,\r\n but please be kind if you are about to reject them since this is their \r\njob and most of them get payed by commission and need to approach \r\neverybody, plus you’re in their office so accept it or leave Playa d’ en\r\n Bossa.<br/>I didn’t attend that much parties, but the ones I did I enjoyed them \r\nall. For example, just a few days after I arrived the whole team was \r\ninvited to HYTE in Amnesia, which is not that far from Ibiza town and \r\nbecause the buses to go back after the party are supposed to arrive only\r\n every full hour is better to take a taxi, since to be honest is not \r\nthat expensive, for example to Figueretas it costed only around 11€.<br/>If you don’t know which clubs you should visit and when, check out the \r\ninternet site IBIZA SPOTLIGHT where you can find all the parties that \r\nare about to have place in all the clubs. Since the prices of the \r\ntickets are expensive, usually on the day of a big event there are \r\npromotors walking on the beach handing out wristbands for 10€ cheaper \r\nthan normal tickets and help you save a little bit of money. \r\nUnfortunately, I didn’t attend a few of the best parties on the island \r\nand I do regret that, but Ibiza is always going to be there, so I \r\nalready know this was not my last visit. &nbsp;&nbsp;</p><p>But because this island is not only about partying I planned my \r\nsecond day off in the upcoming week as a trip around the island, so \r\nafter a wild night in Sankeys and a two hours of sleep I kicked the \r\nthree musketeers (Steven, Thanos and Bartek) out of the bed and we \r\nrented a scooter and a quad. The rental place next to&nbsp;Tantra&nbsp;bar has \r\ndifferent types of vehicles to offer, our scooter costed&nbsp;30€ for&nbsp;a bit \r\nless than 24h&nbsp;and 150€ of deposit. The quad is of course more expensive,\r\n but if you know how to drive it you shouldn&#39;t be worried about getting \r\nyour money from the deposit back. First stop was <strong>Sa&nbsp;Caleta</strong>,\r\n a beautiful sandy beach surrounded by red stones placed right \r\nafter&nbsp;Sas&nbsp;Salines. This beach is perfect for people who want to relax \r\nand enjoy the sound of the ocean, because there are no bars or loud \r\nmusic, only one restaurant and a small clothing store. After that we \r\nwent to&nbsp;<strong>Cala&nbsp;des&nbsp;Jondal</strong>, a nice beach with small stones\r\n but no worries about falling when walking into the water since there is\r\n a small bridge that takes you straight to the sand in the sea. \r\nAfterwards we headed towards <strong>Cubells</strong> and didn’t know we\r\n are about to visit a beach for a bit “higher class” and to be honest, \r\nthe beach itself wasn’t that special that’s why we headed to some weird \r\nstones we saw a few meters ahead of us and had a view which took our \r\nbreath. Our plan was to visit Cala Llentrisca but we didn’t know there \r\nwill be a fence and a security guard welcoming us and explaining that \r\nthere is a bit of a walk to come to the beach and because we didn’t have\r\n much more time we skipped it and went straight to<strong> Es Vedra</strong>.\r\n This place is a must see, especially for the sunset. To get there you \r\nbetter rent a scooter or even better a quad, since the road is really \r\nbad and you have trouble getting there also with a car. Es Vedra is \r\nnothing more but a small rocky island, but the view you get with the \r\nsunset and all the nature around you is breath taking.</p><ul class=\" list-paddingleft-2\"><li><p>fun fact: Es Vedra is the third most magnetic spot on the \r\nplanet, so forget about having any signal on your phone, which is to be \r\nhonest a good thing so you can enjoy the view without anyone disturbing \r\nyou.</p></li></ul><p>My last day off was reserved for a chill beach day with one of \r\nthe best people I ever met in my life, Nina. We decided to visit the \r\nfirst beach next to Playa d’ en Bossa, <strong>Sas Salines</strong>. To \r\nget there you can either take a bus, which is supposed to come every \r\nhalf an hour or just grab a taxi if you are in four (it costs around 12€\r\n one way). Why better take a taxi? Because waiting for a bus is \r\nrealizing how much luck you are having this day. They do have a schedule\r\n but not exactly on what time is the next bus, just saying it arrives \r\n“every” 15/30/60 min. So if you’re in a hurry, just take a taxi because \r\non Ibiza every worker takes it easy and every time you’re in a hurry \r\nthere is siesta.</p><p>As much as I would love to describe every single day to its finest \r\ndetails, I just summarized my favorite and helpful things that happened \r\non this beautiful island. But leaving it was hard. I&#39;m going to be \r\ncompletely honest, I cried like a baby since the minute I woke up till \r\nflying back home. It&#39;s hard to leave so many good and lovely people \r\nbehind and not knowing when you&#39;ll see them again. My lovely team or \r\nbetter said, family... I&#39;m going to miss all of you, but <em>this is not a goodbye, it&#39;s a see you soon.</em></p><p><br/></p>', '0', '1', 'display', 'yes', '2014-10-29 00:00:00', '2014-10-29 00:00:00');
INSERT INTO `article` VALUES ('3', '9', '13#9#', '1', 'upload/template/articlebg/9.jpg', '诗和远方', '诗和远方', '<pre id=\"best-content-725488014\" style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px;\">你是人间四月天<br style=\"text-align: left;\"/>我说你是人间的四月天，<br style=\"text-align: left;\"/>笑响点亮了四面风；轻灵<br style=\"text-align: left;\"/>在春的光艳中交舞着变。<br style=\"text-align: left;\"/><br style=\"text-align: left;\"/>你是四月早天里的云烟，<br style=\"text-align: left;\"/>黄昏吹着风的软，星子在<br style=\"text-align: left;\"/>无意中闪，细雨点洒在花前。<br style=\"text-align: left;\"/><br style=\"text-align: left;\"/>那轻，那娉婷，你是，鲜妍<br style=\"text-align: left;\"/>百花的冠冕你戴着，你是<br style=\"text-align: left;\"/>天真，庄严，你是夜夜的月圆。<br style=\"text-align: left;\"/><br style=\"text-align: left;\"/>雪化后那片鹅黄，你像；新鲜<br style=\"text-align: left;\"/>初放芽的绿，你是；柔嫩喜悦<br style=\"text-align: left;\"/>水光浮动着你梦期待中白莲。<br style=\"text-align: left;\"/><br style=\"text-align: left;\"/>你是一树一树的花开，是燕<br style=\"text-align: left;\"/>在梁间呢喃，－你是爱，是暖，<br style=\"text-align: left;\"/>是希望，你是人间的四月天！</span></pre><p><br style=\"text-align: left;\"/></p><p style=\"display:none;\" data-background=\"background-repeat:repeat; background-position:center center; background-image:url(/upload/template/articlebg/3.jpg);\"><br/></p>', '3', '3', 'display', 'yes', '2014-09-05 09:41:56', '2016-09-05 00:00:00');
INSERT INTO `article` VALUES ('4', '5', '1#5#', '1', 'upload/template/articlebg/12.jpg', '碎玉', '', '<p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://master:8888/cms//static/template/manage/assets/ueditor/dialogs/attachment/fileTypeImages/icon_txt.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"http://master:8888/cms/upload/file/20160906/1473155721396099286.txt\" title=\"1473155721396099286.txt\">1473155721396099286.txt</a></p><p style=\"text-align:center\"><img src=\"http://master:8888/cms/upload/image/20160906/1473155557326062598.png\" style=\"width: 716px; height: 514px;\" height=\"514\" width=\"716\"/><br/></p><p><img src=\"http://master:8888/cms/upload/image/20160906/1473159278340096234.png\" style=\"width: 641px; height: 585px;\" height=\"585\" width=\"641\"/></p><p><img src=\"http://master:8888/cms/upload/image/20160906/1473155557330090667.png\" style=\"width: 726px; height: 518px;\" height=\"518\" width=\"726\"/></p><p><img src=\"/upload/image/20160906/1473159278341097809.png\" style=\"width: 576px; height: 514px;\" height=\"514\" width=\"576\"/></p><p><br/></p>', '0', '0', 'display', 'yes', '2016-09-07 00:00:00', '2016-09-07 00:00:00');
INSERT INTO `article` VALUES ('6', '7', '1#5#7#', '1', 'upload/template/articlebg/1.jpg', '断桥残雪', '', '<p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">每当瑞雪初霁，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">站在宝石山上向南眺望，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">西湖银装素裹，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">白堤横亘雪柳霜桃。</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\"><br/></span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">断桥的石桥拱面无遮无拦，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">在阳光下冰雪消融，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">露出了斑驳的桥栏，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">而桥的两端还在皑皑白雪的覆盖下。</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\"><br/></span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">依稀可辨的石桥身似隐似现，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">而涵洞中的白雪奕奕生光，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">桥面灰褐形成反差，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">远望去似断非断，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">故称断桥。</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\"><br/></span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">伫立桥头，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">放眼四望，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">远山近水，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">尽收眼底，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">给人以生机勃勃的强烈属深刻的印象，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">是欣赏西湖雪景之佳地，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">中国著名的民间传说《白蛇传》，</span></p><p style=\"text-align: center;\"><span style=\"font-family: 楷体,楷体_GB2312,SimKai; font-size: 18px; color: rgb(255, 0, 0);\">为断桥景物增添了浪漫的色彩。</span></p><p><br/></p><p style=\"display:none;\" data-background=\"background-repeat:repeat; background-position:center center; background-image:url(/upload/template/articlebg/17.jpg);\"><br/></p>', '0', '0', 'display', 'yes', '2016-10-13 00:00:00', '2016-10-13 00:00:00');
INSERT INTO `article` VALUES ('7', '7', '1#5#7#', '1', 'upload/template/articlebg/10.jpg', '苏堤', '', '<p>苏堤<br/></p>', '0', '0', 'display', 'yes', '2016-10-13 00:00:00', '2016-10-13 13:27:32');
INSERT INTO `article` VALUES ('8', '9', '13#9#', '2', 'upload/template/articlebg/17.jpg', '如果有来生', '', '<p style=\"text-align: center; text-indent: 0em;\">如果有来生，要做一棵树，<br style=\"text-align: left;\"/>站成永恒。没有悲欢的姿势，<br style=\"text-align: left;\"/>一半在尘土里安详，<br style=\"text-align: left;\"/>一半在风里飞扬；<br style=\"text-align: left;\"/>一半洒落荫凉，<br style=\"text-align: left;\"/>一半沐浴阳光。<br style=\"text-align: left;\"/>非常沉默、非常骄傲。<br style=\"text-align: left;\"/>从不依靠、从不寻找。<br style=\"text-align: left;\"/><br style=\"text-align: left;\"/>如果有来生，要化成一阵风，<br style=\"text-align: left;\"/>一瞬间也能成为永恒。<br style=\"text-align: left;\"/>没有善感的情怀，<br style=\"text-align: left;\"/>没有多情的眼睛。<br style=\"text-align: left;\"/>一半在雨里洒脱，<br style=\"text-align: left;\"/>一半在春光里旅行；<br style=\"text-align: left;\"/>寂寞了，孤自去远行，<br style=\"text-align: left;\"/>把淡淡的思念统带走，<br style=\"text-align: left;\"/>从不思念、从不爱恋；<br style=\"text-align: left;\"/><br style=\"text-align: left;\"/>如果有来生，要做一只鸟，<br style=\"text-align: left;\"/>飞越永恒，没有迷途的苦恼。<br style=\"text-align: left;\"/>东方有火红的希望，南方有温暖的巢床，<br style=\"text-align: left;\"/>向西逐退残阳，向北唤醒芬芳。<br style=\"text-align: left;\"/><br style=\"text-align: left;\"/>如果有来生，<br style=\"text-align: left;\"/>希望每次相遇，<br style=\"text-align: left;\"/>都能化为永恒。</p>', '0', '0', 'display', 'yes', '2016-10-13 00:00:00', '2016-10-13 00:00:00');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `fatherId` bigint(20) DEFAULT NULL COMMENT '父评论ID',
  `kindId` bigint(20) DEFAULT NULL,
  `kind` varchar(45) DEFAULT NULL COMMENT '文件ID',
  `name` varchar(45) DEFAULT NULL COMMENT '评论者',
  `email` varchar(45) DEFAULT NULL COMMENT '评论者邮件地址',
  `url` varchar(200) DEFAULT NULL COMMENT '评论者网址',
  `phone` bigint(20) DEFAULT NULL,
  `content` text COMMENT '内容',
  `ip` varchar(45) DEFAULT NULL COMMENT 'Ip',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`commentId`),
  KEY `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='评论';

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `key` varchar(45) NOT NULL COMMENT 'Key',
  `value` varchar(45) DEFAULT NULL COMMENT '值',
  `description` text COMMENT '描述',
  `createTime` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='网站配置';

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES ('shamrock_headline_image_height', '420', '首页头图的高（px）', '2012-08-08 00:00:00');
INSERT INTO `config` VALUES ('shamrock_headline_image_width', '858', '首页头图的宽（px）', '2012-08-08 00:00:00');
INSERT INTO `config` VALUES ('shamrock_seo_description', '这是我的博客', '网站描述', '2016-09-01 20:47:40');
INSERT INTO `config` VALUES ('shamrock_seo_headline', '师说CMS是用Java开发的内容管理系统', '网站口号', '2012-08-08 00:00:00');
INSERT INTO `config` VALUES ('shamrock_seo_title', '文学网', '网站名称', '2012-08-08 00:00:00');
INSERT INTO `config` VALUES ('shamrock_static', 'false', '是否启用全站静态化', '2012-08-08 00:00:00');
INSERT INTO `config` VALUES ('shamrock_template', 'blog', '模板', '2012-08-08 00:00:00');
INSERT INTO `config` VALUES ('shamrock_webId', '13', '网站名称和目录里面folderId一致', '2016-10-10 11:28:09');

-- ----------------------------
-- Table structure for folder
-- ----------------------------
DROP TABLE IF EXISTS `folder`;
CREATE TABLE `folder` (
  `folderId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '目录ID',
  `fatherId` bigint(20) NOT NULL DEFAULT '0' COMMENT '父亲Id，用于构建目录树',
  `ename` varchar(45) NOT NULL COMMENT '英文名',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '中文名',
  `path` varchar(200) NOT NULL DEFAULT '' COMMENT '路径',
  `content` text,
  `level` tinyint(4) DEFAULT '1' COMMENT '层级',
  `sort` tinyint(4) DEFAULT '0' COMMENT '排序',
  `width` int(11) DEFAULT '0',
  `height` int(11) DEFAULT '0',
  `count` int(11) DEFAULT '0' COMMENT '文件数',
  `status` varchar(20) DEFAULT 'hidden' COMMENT '状态：0 隐藏 1 现实',
  `check` enum('yes','no') DEFAULT 'no',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`folderId`),
  UNIQUE KEY `idx_ename` (`ename`) USING BTREE,
  KEY `idx_status` (`fatherId`,`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='目录';

-- ----------------------------
-- Records of folder
-- ----------------------------
INSERT INTO `folder` VALUES ('1', '0', 'blog', '博客', '1#', '这是我的博客', '1', '1', '0', '0', '0', 'display', 'no', '2014-10-29 18:37:39', null, '个人博客', 'upload/2016/10/17/aaffc250a76c432cb64c1bf886ece648.jpg');
INSERT INTO `folder` VALUES ('3', '1', 'life', '生活', '1#3#', '', '2', '3', '0', '0', '0', 'display', 'no', '2014-10-29 20:16:53', null, null, null);
INSERT INTO `folder` VALUES ('4', '1', 'work', '工作', '1#4#', '', '2', '2', '0', '0', '0', 'display', 'no', '2014-10-29 20:17:06', null, null, null);
INSERT INTO `folder` VALUES ('5', '1', 'travel', '旅游', '1#5#7#', '', '3', '1', '0', '0', '0', 'display', 'no', '2014-10-29 20:17:39', null, null, null);
INSERT INTO `folder` VALUES ('7', '5', 'xihu', '西湖', '1#5#7#', '<p>西湖美景,三月天<br/></p>', '3', '1', '0', '0', '0', 'display', 'yes', '2016-10-12 11:45:29', null, null, null);
INSERT INTO `folder` VALUES ('9', '13', 'shige', '诗歌', '13#9#', '<p>hhh</p>', '2', '1', '0', '0', '0', 'display', 'no', '2016-10-17 14:59:34', null, null, null);
INSERT INTO `folder` VALUES ('13', '0', 'wenxue', '文学网', '13#', '', '1', '1', '0', '0', '0', 'display', 'no', '2016-10-17 15:10:46', null, '文学网', '');
INSERT INTO `folder` VALUES ('14', '13', 'xiaoshuo', '小说', '13#14#', '', '2', '1', '0', '0', '0', 'display', 'no', '2016-11-25 17:50:52', null, '小说', null);

-- ----------------------------
-- Table structure for guestbook
-- ----------------------------
DROP TABLE IF EXISTS `guestbook`;
CREATE TABLE `guestbook` (
  `guestbookId` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `website` varchar(100) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `reply` varchar(2000) DEFAULT NULL,
  `status` enum('display','hidden','init') DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `replyTime` datetime DEFAULT NULL,
  PRIMARY KEY (`guestbookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of guestbook
-- ----------------------------

-- ----------------------------
-- Table structure for headline
-- ----------------------------
DROP TABLE IF EXISTS `headline`;
CREATE TABLE `headline` (
  `headlineId` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `picture` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `sort` tinyint(4) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`headlineId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of headline
-- ----------------------------

-- ----------------------------
-- Table structure for media
-- ----------------------------
DROP TABLE IF EXISTS `media`;
CREATE TABLE `media` (
  `mediaId` bigint(20) NOT NULL AUTO_INCREMENT,
  `kindId` bigint(20) DEFAULT '0',
  `name` varchar(200) DEFAULT NULL,
  `path` varchar(200) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `kind` varchar(20) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`mediaId`),
  KEY `idx_kind` (`kind`,`kindId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=ucs2 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of media
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `openId` bigint(20) DEFAULT NULL COMMENT '公共用户ID，只有是师说，QQ，微博等其它网站登录时才有。',
  `type` varchar(20) DEFAULT NULL COMMENT '帐号类型：0 本站 1 师说 2 QQ 3 微博',
  `name` varchar(45) DEFAULT NULL COMMENT '用户名',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
