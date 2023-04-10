package com.edu.system.service;

import com.edu.system.entity.Book;

import java.util.List;

public interface BookService {
    int addBook(Book book);

    int delBook(int id);
    //更新数据
    int updateBook(Book book);
    //id查找
    Book selectById(int id);
    //查找全部
    List<Book> selectAll();
}
