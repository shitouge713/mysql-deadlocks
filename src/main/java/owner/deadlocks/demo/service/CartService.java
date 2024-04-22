package owner.deadlocks.demo.service;

public interface CartService {

    void simulateDeadlockMethod1(Long id1, Long id2);

    void simulateDeadlockMethod2(Long id1, Long id2);

    void searchByIInShareMode(Long id1);

    /**
     * 扣减库存
     *
     * @param id1
     */
    Integer reduceInventory(Long id1);
}
