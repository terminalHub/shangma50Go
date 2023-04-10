package com.edu.bankSystem.service;

import com.edu.bankSystem.entity.BankAccount;

import java.sql.SQLException;
import java.util.List;

public interface BankService {
    int addBankAccount(BankAccount bankAccount);

    int delBankAccount(int id) ;
    //更新数据
    int updateBankAccount(BankAccount bankAccount) ;
    //id查找
    BankAccount selectById(int id) ;
    //查找全部
    List<BankAccount> selectAll();
}
