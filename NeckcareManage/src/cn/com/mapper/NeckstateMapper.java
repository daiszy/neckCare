package cn.com.mapper;

import cn.com.model.NeckstateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NeckstateMapper {
    int countByExample(NeckstateExample example);

    int deleteByExample(NeckstateExample example);

    int deleteByPrimaryKey(String id);

}