-- 由于采取了加密算法 根据密码长度加密结果长度也有变化 !!!!
alter table `user` modify column `password` varchar(100) NOT NULL COMMENT '用户密码';

-- -----------------------------------------数据迁移Start-------------------------------------------------------------
-- experience表变更(drop)和数据迁移(迁移至article)
-- article 表添加type类型 0-经历分享
alter table `article` modify column `article_type` int(1) NOT NULL COMMENT '文章类型 0-经历分享 1-软件评测 2-技术沉淀';
-- article 表添加 评分 和 评分次数 字段
alter table `article` add `rates` int(2) NOT NULL DEFAULT '0' COMMENT '评分' AFTER `content`;
alter table `article` add `rate_count` int(4) DEFAULT '0' COMMENT '评分次数' AFTER `rates`;

-- 具体的导出路径需要看show global variables like '%secure%';结果secure_file_priv的值
-- experience 表数据 迁移到 article 表
SELECT experience_id,0,user_id,title,content,rates,rate_count,delete_status,create_time,update_time from experience
into outfile '/data/experience_data.csv' fields terminated by ',' optionally enclosed by '"' lines terminated by '\n';
-- 迁移到 article 表
load data infile '/data/experience_data.csv' replace into table  article
fields terminated by ',' optionally enclosed by '"' lines terminated by '\n'
(article_id,article_type,user_id,title,content,rates,rate_count,delete_status,create_time,update_time);
-- 删除experience表
drop table experience;


--
-- 创建微内容新表 (合并hots和dreams表等等 它们都属于微内容)
CREATE TABLE `micro_content` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `micro_id` varchar(32) NOT NULL COMMENT '微内容id',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `micro_type` int(1) NOT NULL COMMENT '微内容类型 0-热门动弹 1-梦想',
  `title` varchar(32) NOT NULL COMMENT '标题',
  `content` varchar(500) NOT NULL COMMENT '内容',
  `likes` int(6) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态 0-正常 1-删除',
  `create_time` int(11) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT '微内容';
-- 迁移hots表
select hot_id,user_id,0,title,content,0,delete_status,create_time from hots
into outfile '/data/hots_data.csv' fields terminated by ',' optionally enclosed by '"' lines terminated by '\n';
-- 迁移
load data infile '/data/hots_data.csv' replace into table  micro_content
fields terminated by ',' optionally enclosed by '"' lines terminated by '\n'
(micro_id,user_id,micro_type,title,content,likes,delete_status,create_time);
-- 删除hots表
drop table hots;

-- 迁移dreams表
select dream_id,user_id,1,title,content,0,delete_status,create_time from dreams
into outfile '/data/dreams_data.csv' fields terminated by ',' optionally enclosed by '"' lines terminated by '\n';
-- 迁移
load data infile '/data/dreams_data.csv' replace into table  micro_content
fields terminated by ',' optionally enclosed by '"' lines terminated by '\n'
(micro_id,user_id,micro_type,title,content,likes,delete_status,create_time);
-- 删除dreams表
drop table dreams;
-- -----------------------------------------数据迁移End-------------------------------------------------------------

-- 删除 article表 sub_title字段
alter table article drop column sub_title;
