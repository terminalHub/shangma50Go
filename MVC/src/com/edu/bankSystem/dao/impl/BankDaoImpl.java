package com.edu.bankSystem.dao.impl;

import com.edu.Util.JDBCUtil;
import com.edu.bankSystem.dao.BankDao;
import com.edu.bankSystem.entity.BankAccount;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

public class BankDaoImpl implements BankDao {
    private QueryRunner runner =  new QueryRunner();
    @Override
    public int addBankAccount(BankAccount bankAccount) throws SQLException {
        int row = runner.update(JDBCUtil.getConn(), "insert into tb_bank values(null,?,?,?)",
                bankAccount.getUserName(),
                bankAccount.getPassword(),
                bankAccount.getBalance());
        return row;
    }

    @Override
    public int delBankAccount(int id) throws SQLException {
        int row = runner.update(JDBCUtil.getConn(), "delete from tb_bank where id = ?", id);
        return row;
    }

    @Override
    public int updateBankAccount(BankAccount bankAccount) throws SQLException {
        //id自增
        int row = runner.update(JDBCUtil.getConn(), "update tb_bank set name = ?, password = ? ，balance = ?",
                bankAccount.getUserName(),
                bankAccount.getPassword(),
                bankAccount.getBalance());
        return row;
    }

    @Override
    public BankAccount selectById(int id) throws SQLException {
        ResultSetHandler<BankAccount> beanHandler = new BeanHandler<>(BankAccount.class);
        BankAccount bankAccount =
                runner.query(JDBCUtil.getConn(), "select * from tb_bank where id = ?", beanHandler, id);
        return bankAccount;
    }

    @Override
    public List<BankAccount> selectAll() throws SQLException {
        //解决命名规范不一致
        ResultSetHandler<List<BankAccount>> listHandler = new BeanListHandler(BankAccount.class,new BasicRowProcessor(new GenerousBeanProcessor()));
        List<BankAccount> bankAccounts =
                runner.query(JDBCUtil.getConn(), "select * from tb_bank ", listHandler);
        return bankAccounts;
    }
}
