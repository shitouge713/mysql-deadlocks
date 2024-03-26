```
CREATE TABLE `order_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` int(11) DEFAULT NULL,
  `status` int(4) DEFAULT NULL,
  `create_date` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_order_status`(`order_no`,`status`) USING BTREE
) ENGINE = InnoDB

```

| Session 1 | Session 2 |
| --- | --- |
| SELECT id FROM demo.order_record where order_no = 4 for update;|  |
|  | SELECT id FROM demo.order_record where order_no = 5 for update; |
| INSERT INTO demo.order_record(order_no, status, create_date) VALUES (4, 1, ‘2019-07-13 10:57:03’);|  |
|  | INSERT INTO demo.order_record(order_no, status, create_date) VALUES (5, 1, ‘2019-07-13 10:57:03’);|

## 发生死锁的原因
以上事务 A 和事务 B 都持有间隙 (4,+∞）的 gap 锁，而接下来的插入操作为了获取到插入意向锁，都在等待对方事务的 gap 锁释放，于是就造成了循环等待，导致死锁。

## 验证发生死锁
