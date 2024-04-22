```
CREATE TABLE `business` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '',
`c_id` int(11) NOT NULL DEFAULT '0' COMMENT '',
`business_id` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '',
PRIMARY KEY (`id`),
UNIQUE KEY `uniq_idx_c_id_business_id` (`c_id`,`business_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='业务表';
```
insert into business (id, c_id, business_id) values (20,1,2);
insert into business (id, c_id, business_id) values (21,1,3);
insert into business (id, c_id, business_id) values (23,1,4);
insert into business (id, c_id, business_id) values (22,1,5);
insert into business (id, c_id, business_id) values (10,2,1);
insert into business (id, c_id, business_id) values (11,2,2);
insert into business (id, c_id, business_id) values (5,3,1);
insert into business (id, c_id, business_id) values (6,4,1);
insert into business (id, c_id, business_id) values (7,5,1);

| Session 1 | Session 2 |
| --- | --- |
| delete from business where c_id = 6; |  |
|  | delete from business where c_id = 7; |
| insert into business (c_id, business_id) values (6, 1); |  |
|  | insert into business (c_id, business_id) values (7, 1); |

## 发生死锁的原因
第一条sql，where c_id = 6， 6是索引最大的值，不是的话，不会生效

## 验证发生死锁

1. [一个死锁问题](http://xiaobaoqiu.github.io/blog/2016/07/22/%5B%3F%5D-ge-si-suo-wen-ti/)