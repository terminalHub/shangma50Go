package com.edu.bankSystem.entity;

import java.math.BigDecimal;

public class BankAccount {
    //银行账户
    Integer id;
    String userName;
    String password;
    BigDecimal balance;

    public BankAccount() {
    }

    public BankAccount(Integer id, String userName, String password, BigDecimal balance) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.balance = balance;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置
     * @param balance
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String toString() {
        return "BankAccount{id = " + id + ", userName = " + userName + ", password = " + password + ", balance = " + balance + "}";
    }
}


