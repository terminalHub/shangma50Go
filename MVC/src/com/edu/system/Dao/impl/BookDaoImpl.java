package com.edu.system.Dao.impl;

import com.edu.Util.JDBCUtil;
import com.edu.system.Dao.BookDao;
import com.edu.system.entity.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl  implements BookDao {
    private QueryRunner runner =  new QueryRunner();
    @Override
    public int addBook(Book book) throws SQLException {
        int row = runner.update(JDBCUtil.getConn(),"INSERT INTO bookmar VALUES (null,?,?,?)" ,
                book.getName(),
                book.getPrice(),
                book.getType());
        return row;
    }

    @Override
    public int delBook(int id) throws SQLException {
        int row = runner.update(JDBCUtil.getConn(), "delete from bookmar where id = ?", id);
        return row;
    }

    @Override
    public int updateBook(Book book) throws SQLException {

        int row = runner.update(JDBCUtil.getConn(), "update bookmar set name = ?,price = ? ,type = ? where id = ?",
                                book.getName(),
                                book.getPrice(),
                                book.getType(),
                                book.getId());
        return row;
    }

    @Override
    public Book selectById(int id) throws SQLException {
        ResultSetHandler<Book> handler = new BeanHandler(Book.class);
        Book book = runner.query(JDBCUtil.getConn(), "select * from bookmar where id = ?", handler, id);
        return  book;
    }

    @Override
    public List<Book> selectAll() throws SQLException {
        ResultSetHandler<List<Book>> handler = new BeanListHandler(Book.class);
        List books = runner.query(JDBCUtil.getConn(), "select * from bookmar", handler );
        return books;
    }
}
