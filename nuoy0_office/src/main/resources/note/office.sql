mysql -uroot -p123456  -h127.0.0.1 -P3306

create database office default character set utf8;

grant all privileges on office.*  to office identified by 'office';

create table `user` (
  `id` bigint(20) not null auto_increment comment '用户ID',
  `user_name` varchar(50) not null comment '用户名称',
  `email`     varchar(50) not null comment '用户邮箱',
  `phone`     varchar(50) not null comment '用户电话',
  `create_time` datetime default null comment '创建时间',
  `last_update_time` datetime default null comment '最后更新时间',
  `opeation_ip`     varchar(50) not null comment '创建用户IP',
  primary key (`id`)
) engine=innodb auto_increment=1 default charset=utf8

create table `schedule` (
  `id` bigint(20) not null auto_increment comment '任务ID',
  `uid` bigint(20)  comment '任务归属用户ID',
  `leader` bigint(20) comment '分配任务用户ID',
  `schedule_name` varchar(50) not null comment '任务名称',
  `start_date` varchar(50) not null comment '开始日期',
  `end_date` varchar(50) not null comment '结束日期',
  `create_time` datetime default null comment '创建时间',
  `last_update_time` datetime default null comment '最后更新时间',
  `opeation_ip`     varchar(50) not null comment '创建用户IP',
   `status` int(2)  comment '任务状态 0 未分配 1 处理中 2 完成',
  primary key (`id`)
) engine=innodb auto_increment=1 default charset=utf8