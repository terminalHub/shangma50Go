package com.edu.bankSystem.dao;

import com.edu.bankSystem.entity.BankAccount;

import java.sql.SQLException;
import java.util.List;

public interface BankDao {
    int addBankAccount(BankAccount bankAccount) throws SQLException;

    int delBankAccount(int id) throws SQLException;
    //更新数据
    int updateBankAccount(BankAccount bankAccount) throws SQLException;
    //id查找
    BankAccount selectById(int id) throws SQLException;
    //查找全部
    List<BankAccount> selectAll() throws SQLException;

}
