package com.edu.system.Dao;

import com.edu.system.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    int addBook(Book book) throws SQLException;

    int delBook(int id) throws SQLException;
    //更新数据
    int updateBook(Book book) throws SQLException;
    //id查找
    Book selectById(int id) throws SQLException;
    //查找全部
    List<Book> selectAll() throws SQLException;

}
