package owner.deadlocks.demo.domain;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import owner.deadlocks.demo.dao.CartDao;
import owner.deadlocks.demo.dto.UpdateCartParams;
import owner.deadlocks.demo.pojo.Cart;

/**
 * @Title CartDomain
 * @Copyright: Copyright (c) 2021
 * @Description:
 * @Auther: zgd
 * @Created on 2022/7/08
 */
@Slf4j
@Component
public class CartDomain extends ServiceImpl<CartDao, Cart> implements IService<Cart> {
    @Autowired
    private CartDao cartDao;

    public int reduceKu(UpdateCartParams param) {
        return cartDao.reduceKu(param);
    }

    public Cart searchById(Long id) {
        return cartDao.searchById(id);
    }

    public Cart searchByIInShareMode(Long id) {
        return cartDao.searchByIInShareMode(id);
    }


    public Integer updateById(Long id) {
        return cartDao.updateById(id);
    }

    public Integer selectSleep(Long times) {
        return cartDao.selectSleep(times);
    }

}
