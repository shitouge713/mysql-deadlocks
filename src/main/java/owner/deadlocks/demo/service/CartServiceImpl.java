package owner.deadlocks.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import owner.deadlocks.demo.domain.CartDomain;

@Slf4j
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDomain cartDomain;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void simulateDeadlockMethod1(Long id1, Long id2) {
        try {
            cartDomain.updateById(id1);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            cartDomain.searchById(id2);
        } catch (Exception e) {
            log.error("fatalError,simulateDeadlockMethod1,e:{}", e);
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void searchByIInShareMode(Long id1) {
        try {
            cartDomain.searchByIInShareMode(id1);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            cartDomain.updateById(id1);
        } catch (Exception e) {
            log.error("fatalError,simulateDeadlockMethod1,e:{}", e);
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void simulateDeadlockMethod2(Long id1, Long id2) {
        try {
            cartDomain.searchById(id2);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            cartDomain.updateById(id1);
        } catch (Exception e) {
            log.error("fatalError,simulateDeadlockMethod2,e:{}", e);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer reduceInventory(Long id) {
        Integer result = 0;
        try {
            result = cartDomain.updateById(id);
            /**
             * 直接通过sql扣减库存，利用mysql的行锁，获取到锁的执行减库存操作，未获取到锁的在存储引擎层处于挂起状态，等待被唤醒
             * Thread.sleep(2000);
             * 此操作是模拟数据库层面的耗时操作,上面的程序sleep不生效
             * 获取不到锁的，超时后报错
             * Lock wait timeout exceeded; try restarting transaction; nested exception is
             * com.mysql.cj.jdbc.exceptions.MySQLTransactionRollbackException: Lock wait timeout exceeded; try restarting transaction
             */
            cartDomain.selectSleep(2L);
        } catch (Exception e) {
            log.error("fatalError,reduceInventory,e:{}", e);
        }
        return result;
    }
}
