```
CREATE TABLE `s` (
  `id` int(11) NOT NULL,
  `s_name` varchar(255) DEFAULT NULL,
  `s_age` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  unique key `name_idx` (`s_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```


| Session 1 | Session 2 |
| --- | --- |
| insert into s values (5,'bilibili',5); |  |
|  | insert into s values (7,'bilibili',7); |
| insert into s values (6,'balibali',6); |  |
|  | |

## 发生死锁的原因
和本模块15.md原因一致
name_idx为唯一索引，如果是非唯一索引没有问题
1. T1插入bilibili（隐式锁）
2. T2插入bilibili发生冲突，T2帮T1生成锁结构（隐式锁转化为显示锁，T1获得X record），T2要加S临键锁，先获取GAP锁（成功），再获取S锁（被T1的X record阻塞）
3. T1插入balibali，插入意向锁被T2的GAP锁阻塞（死锁成环：T1等待T2的GAP，T2等待T1的X）

## 验证发生死锁
