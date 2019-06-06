/* 创建 测试数据库 01 */
CREATE DATABASE IF NOT EXISTS test01  DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;
use test01;
/*创建表*/
DROP TABLE IF EXISTS `t_common_notice`;
CREATE TABLE `t_common_notice` (
  `id` varchar(36) NOT NULL COMMENT 'ID',
  `notice_name` varchar(60) NOT NULL COMMENT '通告名',
  `create_id` varchar(36) NOT NULL DEFAULT '' COMMENT '创建者的用户ID',
  `modified_id` varchar(36) NOT NULL DEFAULT '' COMMENT '修改者的用户ID',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `comment` varchar(255)  NOT NULL DEFAULT '' COMMENT '备注',
  `del_flag` tinyint(4) NOT NULL DEFAULT 1 COMMENT '是否可以删除标记：0不能删除,1可以删除,默认1',
  `use_flag` tinyint(4) NOT NULL DEFAULT 1 COMMENT '是否在使用（删除）标记：0不使用(已逻辑删除),1使用,默认1',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='通知公告';

create index notice_name on t_common_notice(notice_name);
INSERT INTO `t_common_notice` VALUES ('18fdaa43a3f94845be12229ccfcbe12f', 'test01', 'carlme', 'carlme', '2019-06-06 10:05:01', '2019-06-06 10:05:01', '', '1', '1');