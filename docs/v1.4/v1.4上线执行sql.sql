-- 文章类型 添加 1-小记客栈
alter table `article` modify column `article_type` int(1) NOT NULL COMMENT '文章类型 0-经历分享 1-小记客栈 2-技术沉淀';