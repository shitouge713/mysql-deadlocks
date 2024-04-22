package owner.deadlocks.demo.deadlock;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owner.deadlocks.demo.domain.PlayeraccountDomain;
import owner.deadlocks.demo.domain.PlayerclubDomain;
import owner.deadlocks.demo.dto.SimulateDeadlockMethodDto;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/playerclub")
public class PlayerclubController {

    @Autowired
    private PlayerclubDomain playerclubDomain;

    /**
     * @return
     */
    @GetMapping("/addList")
    @ApiOperation("模拟死锁方法1")
    public String addList() {
        playerclubDomain.addList();
        return "success";
    }

    /**
     * 这种死锁，会导致两个线程一直在等待，直到获取锁超时（默认50s）
     * 异常信息：
     * Lock wait timeout exceeded; try restarting transaction
     *
     * @param dto
     * @return
     */
    @GetMapping("/method1")
    @ApiOperation("playerclub-模拟死锁方法")
    public String method1(@RequestBody @Valid SimulateDeadlockMethodDto dto) {
        playerclubDomain.method(dto.getId1());
        return "success";
    }


}
