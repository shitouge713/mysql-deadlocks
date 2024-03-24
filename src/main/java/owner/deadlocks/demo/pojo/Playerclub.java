package owner.deadlocks.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
@TableName("playerclub")
public class Playerclub implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long modifiedby;

    private Date timecreated;

    private Long accountId;

    private Long currentclubid;

    private Integer endinglevelposition;

    private Long nextclubid;

    private static final long serialVersionUID = 1L;
}