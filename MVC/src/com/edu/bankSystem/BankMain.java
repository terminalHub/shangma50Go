package com.edu.bankSystem;

import com.edu.bankSystem.controller.BankController;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


String answerS = null;
        do {
            System.out.println("请您选择系统：");
            System.out.println("1.银行管理系统");
            System.out.println("2.用户系统");
            int answer = sc.nextInt();
            switch (answer){
                case 1:
                    new BankController().menu(sc);
                    break;
                case 2:
                    System.out.println("用户系统");
                    break;
            }
            System.out.println("是否要继续y/n");
            answerS = sc.next();
        } while ( "y".equalsIgnoreCase(answerS));

    }
}
