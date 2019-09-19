package com.qst.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.qst.bean.Account;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public interface AccountDao  {
    public void in(String inner,Integer balance);
    public void out(String outter,Integer balance);
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存操作
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);




}
