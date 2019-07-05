package cn.com.mapper;

import cn.com.model.Accounts;
import cn.com.model.AccountsExample;
import cn.com.model.Doctor;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountsMapper {
    int countByExample(AccountsExample example);

    int deleteByExample(AccountsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Accounts record);

    int insertSelective(Accounts record);

    List<Accounts> selectByExample(AccountsExample example);

    Accounts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Accounts record, @Param("example") AccountsExample example);

    int updateByExample(@Param("record") Accounts record, @Param("example") AccountsExample example);

    int updateByPrimaryKeySelective(Accounts record);

    int updateByPrimaryKey(Accounts record);
    
    List<Accounts> selectAllUsers();
   
}