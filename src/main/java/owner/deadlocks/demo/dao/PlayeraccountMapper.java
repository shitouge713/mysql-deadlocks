package owner.deadlocks.demo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import owner.deadlocks.demo.pojo.Playeraccount;
import owner.deadlocks.demo.pojo.PlayeraccountExample;

public interface PlayeraccountMapper {
    long countByExample(PlayeraccountExample example);

    int deleteByExample(PlayeraccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Playeraccount row);

    int insertSelective(Playeraccount row);

    List<Playeraccount> selectByExample(PlayeraccountExample example);

    Playeraccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Playeraccount row, @Param("example") PlayeraccountExample example);

    int updateByExample(@Param("row") Playeraccount row, @Param("example") PlayeraccountExample example);

    int updateByPrimaryKeySelective(Playeraccount row);

    int updateByPrimaryKey(Playeraccount row);
}