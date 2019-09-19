package com.qst.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;


import com.qst.bean.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;
import java.util.List;


public class AccountDaoImpl implements AccountDao {


    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public void in(String inner, Integer balance) {
        try{
            runner.update("update  account set balance =balance+ ? where uname = ? ", balance,inner);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public void out(String outter, Integer balance) {
        try{
            runner.update("update  account set balance =balance- ? where uname = ? ", balance,outter);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }




    public List<Account> findAllAccount() {
        try{
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountId) {
        try{
            return runner.query("select * from account where id = ? ", new BeanHandler<Account>(Account.class), accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try{
            runner.update("insert into account (uname, balance) values (?, ?) ", account.getUname(), account.getBalance());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try{
            runner.update("update  account set uname = ?,  balance = ? where id = ? ", account.getUname(), account.getBalance(), account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountId) {
        try{
            runner.update("delete from account where id = ? ", accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
