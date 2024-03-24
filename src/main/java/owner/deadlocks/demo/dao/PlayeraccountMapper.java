package owner.deadlocks.demo.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import owner.deadlocks.demo.pojo.Playeraccount;
import owner.deadlocks.demo.pojo.Playerclub;

public interface PlayeraccountMapper  extends BaseMapper<Playeraccount> {
}