package com.edu.system.controller;

import com.edu.system.entity.Book;
import com.edu.system.service.BookService;
import com.edu.system.service.impl.BookServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class BookContorller {
    //引入业务层
    private  BookService bookService  = new BookServiceImpl();
    //主菜单
    public  void menu(Scanner sc){
        String answer ;
        do {
            System.out.println("1.添加图书");
            System.out.println("2.删除图书");
            System.out.println("3.修改图书");
            System.out.println("4.查询图书");
            System.out.println("5.退出图书管理系统");
            int in = sc.nextInt();
            switch (in){
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
                case 5 :
                    return;
                default:
                    break;
            }
            System.out.println("是否继续图书管理系统y/n");
            answer= sc.next();
        } while ( "y".equalsIgnoreCase(answer));
    }

    private  void  chaxun( Scanner sc){
        System.out.println("请输入查询到的类型：");
        System.out.println("1.全部查询");
        System.out.println("2.根据ID进行查询");
        int choose = sc.nextInt();
        String sql = null ;
        switch (choose){
            case 1:
                sql = "SELECT * FROM bookmar ; ";
                List<Book> books = bookService.selectAll();
                //集合的foreach查询
                //匿名内部类
                //lambda
                books.forEach(book-> System.out.println(book));
                break;
            case 2:
                System.out.println("键入id值，用于查询");
                int id = sc.nextInt();
                Book book = bookService.selectById(id);
                System.out.println(book);
                break;
        }
    }

    private  void tianjia(Scanner sc ){
        System.out.println("添加的name" );
        String name = sc.next();
        System.out.println("添加的price" );
        BigDecimal price  = sc.nextBigDecimal();
        System.out.println("添加的type" );
        String type = sc.next();
        Book book = new Book(null, name, price, type);
        int row = bookService.addBook(book);
        System.out.println("row:" + row);
    }
    private  void shanchu(Scanner sc ) {
        System.out.println("删除的id" );
        int id = sc.nextInt();
        int row = bookService.delBook(id);
        System.out.println("row:"+row);
    }

    private  void xiugai(Scanner sc ){

        System.out.println("修改的id");
        int id = sc.nextInt();
        //校验id是否合法
        Book book1 = bookService.selectById(id);
        if (book1 ==  null){
            System.out.println("ID 非法");
            return ;
        }
        System.out.println("添加的name" );
        String name = sc.next();
        System.out.println("添加的price" );
        BigDecimal  price  = sc.nextBigDecimal();
        System.out.println("添加的type" );
        String type = sc.next();
        Book book = new Book(id, name, price, type);
        int row = bookService.updateBook(book);
        System.out.println("row:"+ row);

    }

}
