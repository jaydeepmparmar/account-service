package com.tuum.account.dao.mapper;

import com.tuum.account.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {

    @Insert("insert into accounts(customerId,country,balanceList) " +
            "values(#{customerId},#{country},#{data,jdbcType=OTHER,typeHandler=com.tuum.account.config.JsonbTypeHandler})")
    void createAccount(Account account);

    @Select("select * from accounts")
    Account getAccounts();

    @Select("select * from accounts where accountId = #{accountId}")
    Account getAccountById(String accountId);
}
