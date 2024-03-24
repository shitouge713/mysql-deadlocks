见项目【owner-code-demo】项目DeadLockController类
多个线程同时执行以下逻辑【同一个事务内】：查询加共享锁，然后执行修改操作
select * from o_cart where id = #{id} lock in share mode
update o_cart set quantity = quantity - 1 where id = #{id} and quantity - 1 > 0