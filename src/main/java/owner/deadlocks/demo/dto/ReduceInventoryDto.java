package owner.deadlocks.demo.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;


@Data
@EqualsAndHashCode
@ApiModel(value = "ReduceInventoryDto", description = "扣减库存入参")
public class ReduceInventoryDto {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "id非空")
    private Long id;
}
