package owner.deadlocks.demo.domain;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import owner.deadlocks.demo.dao.PlayeraccountMapper;
import owner.deadlocks.demo.pojo.Playeraccount;

import javax.annotation.Resource;

/**
 * @Title PlayerclubDomain
 * @Copyright: Copyright (c) 2021
 * @Description:
 * @Auther: zgd
 * @Created on 2024/3/28
 */
@Slf4j
@Component
public class PlayeraccountDomain extends ServiceImpl<PlayeraccountMapper, Playeraccount> implements IService<Playeraccount> {
    @Resource
    private PlayeraccountMapper playeraccountMapper;


    public void addList() {
        try {
            for (int i = 1; i < 1001; i++) {
                Playeraccount club = new Playeraccount();
                club.setName(i+"");
                playeraccountMapper.insert(club);
            }
        } catch (Exception e) {
            log.error("e:{}", e);
        }
    }
}
