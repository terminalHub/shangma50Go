package com.edu.bankSystem.service.impl;

import com.edu.bankSystem.dao.BankDao;
import com.edu.bankSystem.dao.impl.BankDaoImpl;
import com.edu.bankSystem.entity.BankAccount;
import com.edu.bankSystem.service.BankService;

import java.sql.SQLException;
import java.util.List;

public class BankServiceImpl implements BankService {
      BankDao bankDao = new BankDaoImpl();
    @Override
    public int addBankAccount(BankAccount bankAccount){
        int row = 0;
        try {
            row = bankDao.addBankAccount(bankAccount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row ;
    }

    @Override
    public int delBankAccount(int id) {
        int row = 0;
        try {
            row = bankDao.delBankAccount(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  row;
    }

    @Override
    public int updateBankAccount(BankAccount bankAccount) {
        int row =0;
        try {
             row = bankDao.updateBankAccount(bankAccount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  row;
    }

    @Override
    public BankAccount selectById(int id) {
        BankAccount bankAccount = null;
        try {
           bankAccount = bankDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  bankAccount;
    }

    @Override
    public List<BankAccount> selectAll() {
        List<BankAccount> bankAccounts =null;
        try {
            bankAccounts = bankDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bankAccounts;
    }
}
