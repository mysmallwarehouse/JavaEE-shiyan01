package com.qst.bean;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer id;
    private String uname;
    private Integer balance;


    public Account() {

    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", unname='" + uname + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
