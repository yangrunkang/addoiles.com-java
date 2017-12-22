-- 由于采取了加密算法 根据密码长度加密结果长度也有变化 !!!!
alter table `user` modify column `password` varchar(100) NOT NULL COMMENT '用户密码';


-- experience表变更(drop)和数据迁移(迁移至article)
-- article 表添加type类型 0-经历分享
alter table `article` modify column `article_type` int(1) NOT NULL COMMENT '文章类型 0-经历分享 1-软件评测 2-技术沉淀';
-- article 表添加 评分 和 评分次数 字段
alter table `article` add `rates` int(2) NOT NULL DEFAULT '0' COMMENT '评分' AFTER `content`;
alter table `article` add `rate_count` int(4) DEFAULT '0' COMMENT '评分次数' AFTER `rates`;
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
