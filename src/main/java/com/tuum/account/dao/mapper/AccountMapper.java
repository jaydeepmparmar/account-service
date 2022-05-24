package com.tuum.account.dao.mapper;

import com.tuum.account.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {

    @Insert("insert into accounts(customerId,country,balanceList) values(#{customerId},#{country},#{balanceList})")
    void createAccount(Account account);

    @Select("select accountId, customerId, balanceList from accounts")
    Account findAccount();
}
