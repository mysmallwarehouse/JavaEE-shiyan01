package com.qst.service;

import com.qst.bean.Account;
import com.qst.dao.AccountDao;
import com.qst.dao.AccountDaoImpl;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class AccountServiceImpl implements AccountService {
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public List<Account> findAllAccount() {
		return accountDao.findAllAccount();
	}

	public Account findAccountById(Integer accountId) {
		return accountDao.findAccountById(accountId);
	}

	public void saveAccount(Account account) {
		accountDao.saveAccount(account);
	}

	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

	public void deleteAccount(Integer accountId) {
		accountDao.deleteAccount(accountId);
	}

	@Override
	public void transfer(String outter, String inner, Integer balance) {

		accountDao.in(inner, balance);
		// 断电测试
		// int i=1/0;
		accountDao.out(outter, balance);
	}

}
