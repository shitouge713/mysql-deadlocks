package owner.deadlocks.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import owner.deadlocks.demo.pojo.Playerclub;

public interface PlayerclubMapper extends BaseMapper<Playerclub> {


    @Delete("delete from playerclub where account_id = #{id}")
    void deleteByAccountId(@Param("id") Long id);

    @Insert("insert into playerclub (modifiedBy, timeCreated, currentClubId, endingLevelPosition,  nextClubId, account_id) values (0, '2014-12-23 15:47:11.596', 180, 4, 181, #{id})")
    void insertByAccountId(@Param("id") Long id);
}