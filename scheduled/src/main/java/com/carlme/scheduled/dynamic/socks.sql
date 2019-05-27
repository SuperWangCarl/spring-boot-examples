/*
  开启本地数据库mysql，随便打开查询窗口，然后执行脚本内容，如下：
 */
DROP DATABASE IF EXISTS `socks`;
CREATE DATABASE `socks`;
USE `SOCKS`;
DROP TABLE IF EXISTS `cron`;
CREATE TABLE `cron`  (
  `cron_id` varchar(30) NOT NULL PRIMARY KEY,
  `cron` varchar(30) NOT NULL
);
INSERT INTO `cron` VALUES ('1', '0/5 * * * * ?');