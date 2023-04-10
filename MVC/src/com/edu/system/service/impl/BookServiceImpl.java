package com.edu.system.service.impl;

import com.edu.system.Dao.BookDao;
import com.edu.system.Dao.impl.BookDaoImpl;
import com.edu.system.entity.Book;
import com.edu.system.service.BookService;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService  {
    //业务层对异常进行捕捉
    //私有变量本类使用
     private BookDao bookDao =  new BookDaoImpl();
    @Override
    public int addBook(Book book) {
        int row = 0;
        try {
            row = bookDao.addBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;

    }

    @Override
    public int delBook(int id) {
        int row = 0;
        try {
            row = bookDao.delBook(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int updateBook(Book book) {
        int row = 0;
        try {
            row = bookDao.updateBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Book selectById(int id) {
        Book book  = null;
        try {
            book = bookDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public List<Book> selectAll() {
        List<Book> books = null;
        try {
            books = bookDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

}
