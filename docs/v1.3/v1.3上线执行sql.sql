-- 导航栏表 增添问答区导航栏数据
INSERT INTO `addoiles`.`nav_settings` (`nav_name`, `nav_router`, `nav_icon`, `is_start`) VALUES ('问答区', '/QAArea', 'cube', '0');
-- 导航栏表 添加排序字段
alter table `addoiles`.`nav_settings` add `sort` int(2) DEFAULT 0 COMMENT '排序字段 1 最大,排在前面' AFTER `is_start`;
-- 更新导航栏排序数据
update `addoiles`.`nav_settings` set sort = case nav_name
when '主页' then 0
when '梦想墙' then 1
when '经历分享' then 2
when 'IT技术' then 3
when '问答区' then 4
when '聊天机器人' then 5
when '登录' then 6
when '注册' then 7
when '软件评测' then 90
when '程序员的生活记录' then 91
end;


