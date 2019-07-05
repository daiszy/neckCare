package cn.com.mapper;

import cn.com.model.Activitystate;
import cn.com.model.ActivitystateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivitystateMapper {
    int countByExample(ActivitystateExample example);

    int deleteByExample(ActivitystateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Activitystate record);

    int insertSelective(Activitystate record);

    List<Activitystate> selectByExample(ActivitystateExample example);

    Activitystate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Activitystate record, @Param("example") ActivitystateExample example);

    int updateByExample(@Param("record") Activitystate record, @Param("example") ActivitystateExample example);

    int updateByPrimaryKeySelective(Activitystate record);

    int updateByPrimaryKey(Activitystate record);
}