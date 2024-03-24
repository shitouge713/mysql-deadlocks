package owner.deadlocks.demo.domain;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import owner.deadlocks.demo.dao.PlayerclubMapper;
import owner.deadlocks.demo.pojo.Playerclub;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Title PlayerclubDomain
 * @Copyright: Copyright (c) 2021
 * @Description:
 * @Auther: zgd
 * @Created on 2024/3/28
 */
@Slf4j
@Component
public class PlayerclubDomain extends ServiceImpl<PlayerclubMapper, Playerclub> implements IService<Playerclub> {
    @Resource
    private PlayerclubMapper playerclubMapper;


    public void addList() {
        try {
            for (int i = 1; i < 1001; i++) {
                Playerclub club = new Playerclub();
                club.setTimecreated(new Date());
                club.setAccountId(Long.valueOf(i));
                club.setEndinglevelposition(1);
                playerclubMapper.insert(club);
            }
        } catch (Exception e) {
            log.error("e:{}", e);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void method(Long id) {
        try {
            playerclubMapper.deleteByAccountId(id);
            Thread.sleep(3000);
            playerclubMapper.insertByAccountId(id);
        } catch (Exception e) {
            log.error("e:{}", e);
        }
    }

}
