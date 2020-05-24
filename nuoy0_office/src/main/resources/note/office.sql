mysql -uroot -p123456  -h127.0.0.1 -P3306

create database office default character set utf8;

grant all privileges on office.*  to office identified by 'office';

DROP TABLE IF EXISTS `user`;
create table `user` (
  `id` bigint(20) not null auto_increment comment '用户ID',
  `leader` bigint(20) not null comment '直属领导',
  `user_code` varchar(50) not null unique comment '用户编码',
  `user_name` varchar(50) not null comment '用户名称',
  `password`  varchar(50) not null comment '用户密码',
  `email`     varchar(50) not null comment '用户邮箱',
  `phone`     varchar(50) not null comment '用户电话',
  `salt`     varchar(50) not null comment  '盐',
  `create_time` datetime default null comment '创建时间',
  `last_update_time` datetime default null comment '最后更新时间',
  `opeation_ip`     varchar(50) not null comment '创建用户IP',
  primary key (`id`)
) engine=innodb auto_increment=1 default charset=utf8;

DROP TABLE IF EXISTS `task`;
create table `task` (
  `id` bigint(20) not null auto_increment comment '任务ID',
  `dispatcher` bigint(20) not null  comment '派发任务用户ID',
  `tasker`     bigint(20)  not null comment   '执行任务用户ID',
  `task_name`  varchar(50) not null comment '任务名称',
  `start_date` datetime not null comment '开始日期',
  `end_date`   datetime not null comment '结束日期',
  `task_type`  int(2) not null comment '任务类型 1:开发编码 2:会议讨论 3:设计相关 4:文档编写 5:bug处处理 6:环境部署 ',
  `notice_type` int(2) not null comment '通知类型 1 不提醒 2 邮件提醒 3 易信提醒',
  `topping` tinyint(1) not null comment '是否置顶',
  `state` int(2)  comment '任务状态 0 新增 1 处理中 2 完成',

  `create_time` datetime default null comment '创建时间',
  `last_update_time` datetime default null comment '最后更新时间',
  `opeation_ip`     varchar(50) not null comment '创建用户IP',
  primary key (`id`)
) engine=innodb auto_increment=1 default charset=utf8;

DROP TABLE IF EXISTS `task`;
create table `task` (
  `id` bigint(20) not null auto_increment comment '任务ID',
  `dispatcher` varchar(50) not null  comment   '派发任务用户ID',
  `tasker`     varchar(50)  not null comment   '执行任务用户ID',
  `task_name`  varchar(50) not null  comment    '任务名称',
  `start_date` datetime not null comment '开始日期',
  `end_date`   datetime not null comment '结束日期',
  `task_type`   varchar(50) not null  comment '任务类型 1:开发编码 2:会议讨论 3:设计相关 4:文档编写 5:bug处处理 6:环境部署 ',
  `notice_type` varchar(50) not null comment '通知类型 1 不提醒 2 邮件提醒 3 易信提醒',
  `topping` tinyint(1) not null comment '是否置顶',
  `state` int(2)  comment '任务状态 1:新增 2 处理中 3 完成',

  `create_time` datetime default null comment '创建时间',
  `last_update_time` datetime default null comment '最后更新时间',
  `opeation_ip`     varchar(50) not null comment '创建用户IP',
  primary key (`id`)
) engine=innodb auto_increment=1 default charset=utf8;
