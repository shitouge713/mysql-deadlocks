package owner.deadlocks.demo.deadlock;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import owner.deadlocks.demo.domain.PlayeraccountDomain;
import owner.deadlocks.demo.domain.PlayerclubDomain;
import owner.deadlocks.demo.dto.SimulateDeadlockMethodDto;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/playeraccount")
public class PlayeraccountController {


    @Autowired
    private PlayeraccountDomain playeraccountDomain;

    /**
     * @return
     */
    @GetMapping("/addList")
    @ApiOperation("模拟死锁方法1")
    public String addList() {
        playeraccountDomain.addList();
        return "success";
    }
}
