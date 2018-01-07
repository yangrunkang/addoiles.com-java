-- 导航栏表 增添问答区导航栏数据
INSERT INTO `addoiles`.`nav_settings` (`nav_name`, `nav_router`, `nav_icon`, `is_start`) VALUES ('论坛', '/OilForum',
                                                                                                 'cube', '0');
-- 导航栏表 添加排序字段
alter table `addoiles`.`nav_settings` add `sort` int(2) DEFAULT 0 COMMENT '排序字段 1 最大,排在前面' AFTER `is_start`;
-- 更新导航栏排序数据
update `addoiles`.`nav_settings` set sort = case nav_name
when '主页' then 0
when '梦想墙' then 1
when '经历分享' then 2
when 'IT技术' then 3
when '论坛' then 4
when '聊天机器人' then 5
when '登录' then 6
when '注册' then 7
when '软件评测' then 90
when '程序员的生活记录' then 91
end;
-- 问题表 添加问题类型字段
alter table `addoiles`.`question` add `type` int(2) DEFAULT 0 COMMENT '问题类型 0-编程语言 1-开发问题 2-缓存技术 3-操作系统 4-学习' AFTER `content`;

-- 新增 首页信息展示-运营
CREATE TABLE `first_page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `show_id` varchar(32) NOT NULL COMMENT '展示id',
  `title` varchar(50) NOT NULL COMMENT '标题',
  `content` varchar(5000) DEFAULT NULL COMMENT '内容描述',
  `image` longtext NOT NULL COMMENT '图片',
  `type` int(2) NOT NULL COMMENT '类型 0-电影推荐 1-新书推荐 2-图片分享',
  `delete_status` int(1) NOT NULL COMMENT '删除状态 0-正常 1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='首页信息展示-运营';

