package com.edu.bankSystem.controller;

import com.edu.bankSystem.entity.BankAccount;
import com.edu.bankSystem.service.BankService;
import com.edu.bankSystem.service.impl.BankServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class BankController {

    private BankService bankService = new BankServiceImpl();

    public void menu(Scanner sc) {
        String answer;
        do {
            System.out.println("1.添加用户");
            System.out.println("2.删除用户");
            System.out.println("3.修改用户信息");
            System.out.println("4.查询用户");
            System.out.println("5.退出银行管理系统");
            int in = sc.nextInt();
            switch (in) {
                case 1:
                    tianjia(sc);
                    break;
                case 2:
                    shanchu(sc);
                    break;
                case 3:
                    xiugai(sc);
                    break;
                case 4:
                    chaxun(sc);
                    break;
                case 5:
                    return;
                default:
                    break;
            }
            System.out.println("是否继续银行用户管理系统y/n");
            answer = sc.next();
        } while ("y".equalsIgnoreCase(answer));
    }

    private void tianjia(Scanner sc) {

        System.out.println("添加的name");
        String username = sc.next();
        System.out.println("添加的password");
        String password = sc.next();
        System.out.println("添加的balance");
        BigDecimal balance = sc.nextBigDecimal();
        //传入添加的对象，因为id是主键，所以不需要赋值
        BankAccount bankAccount = new BankAccount(null, username, password, balance);
        int row = bankService.addBankAccount(bankAccount);
        System.out.println("row:" + row);
        if (row > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }


    private void shanchu(Scanner sc) {

        System.out.println("请输入你要删除的ID：");
        int id = sc.nextInt();
        BankAccount bankAccount = bankService.selectById(id);
        if (null == bankAccount) {
            System.out.println("删除的ID不存在");
            return;
        }
        int row = bankService.delBankAccount(id);
        if (row > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

    }

    private void xiugai(Scanner sc) {
        System.out.println("请输入你要修改的ID：");
        int id = sc.nextInt();
        //查询id是否真实有效
        BankAccount bankAccount = bankService.selectById(id);
        if (null == bankAccount) {
            System.out.println("修改的ID不存在");
            return;
        }
        System.out.println("请输入你要修改的name：");
        String userName = sc.next();
        System.out.println("请输入你要修改的password：");
        String password = sc.next();
        System.out.println("请输入你要修改的balance：");
        BigDecimal balance = sc.nextBigDecimal();
        BankAccount bankAccount1 = new BankAccount(id, userName, password, balance);
        int row = bankService.updateBankAccount(bankAccount1);
        if (row > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    private void chaxun(Scanner sc) {
        System.out.println("请输入选择的查询模式：");
        System.out.println("1.全部查询");
        System.out.println("2.根据ID进行查询");
        int answer = sc.nextInt();
        switch (answer) {
            case 1:
                List<BankAccount> bankAccounts = bankService.selectAll();
                bankAccounts.forEach(bankAccount -> System.out.println(bankAccount));
                break;
            case 2:
                System.out.println("请输入ID，用于查询");
                int id = sc.nextInt();
                BankAccount bankAccount = bankService.selectById(id);
                if (null == bankAccount) {
                    System.out.println("不存在该ID的用户");
                }
                break;
        }
    }
}

