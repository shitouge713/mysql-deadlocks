package owner.deadlocks.demo.deadlock;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import owner.deadlocks.demo.dto.ReduceInventoryDto;
import owner.deadlocks.demo.service.CartService;

import javax.validation.Valid;

/**
 * 扣减库存
 */
@Slf4j
@RestController
@RequestMapping("/inventory")
public class ReduceInventoryController {

    @Autowired
    private CartService cartService;

    /**
     * @return
     */
    @GetMapping("/reduceInventory")
    @ApiOperation("扣减库存")
    public boolean reduceInventory(@RequestBody @Valid ReduceInventoryDto dto) {
        Integer result = cartService.reduceInventory(dto.getId());
        return result > 0;
    }
}
