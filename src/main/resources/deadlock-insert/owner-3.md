```
CREATE TABLE `s` (
  `id` int(11) NOT NULL,
  `s_name` varchar(255) DEFAULT NULL,
  `s_age` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  unique key `name_idx` (`s_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```


| Session 1 | Session 2 |Session 3 |
| --- | --- |--- |
| insert into s values (5,'bilibili',5); |  |  |
|  | insert into s values (5,'bilibili',5); |  |
|  |  |insert into s values (5,'bilibili',5);  |
| rollback | | |

## 发生死锁的原因
和本模块2.md原因一致
name_idx为唯一索引，如果是非唯一索引没有问题
三个事务插入相同的数据，事务1回滚后，其他两个事务有一个报死锁
1. T1 插入 加隐式锁
2. T2 插入相同唯一记录，帮T1生成X锁，自己获取S next key，先获取gap（成功），再获取S record（此时被T1的X锁阻塞）；T3 与 T2 相似，获取到gap 再获取S record 时被T1的X阻塞
3. T1 回滚，T2、T3获取S record成功，此时它们都还要获取X record（插入意向锁转化为显示锁X）导致死锁成环（T2要加X锁被T3的GAP阻塞，T3要加X锁被T2的GAP阻塞）

## 验证发生死锁
