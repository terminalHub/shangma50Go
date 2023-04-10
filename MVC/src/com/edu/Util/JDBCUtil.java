package com.edu.Util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtil {
    //泛型的定义，在方法前面进行声明定义
    public static <T> List<T> executeQuery(Class<T> aClass , String sql ,Object...args) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        /*
         *思路
         * 因为查询需要的不是在该方法中输出其所得结果集，所以要将所得结果集放到集合中
         * 利用泛型和反射进行赋值，不涉及其具体类型！！！！
         * 反射用到的；类对象根据传参传入
         * JAVA getMetaData（）获取数据库表名，视图名，表对应的列名。
         */
        //创建集合，存储数据库数据
        List<T> ts = new ArrayList<>();
        //1.连接数据库
        Connection conn = getConn();
        //2.预编译SQL语句:传参
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //3.给占位符赋值
        for (int i = 0; i < args.length; i++) {
            //setObject的索引从1开始,若0个参数直接结束
            //setObject:给参数设值
            preparedStatement.setObject(i + 1, args[i]);
        }
        //4.执行语句executeQuery：返回结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        //获取字段的个数
        int columnCount = resultSet.getMetaData().getColumnCount();
        //5.将结果集赋值给集合返回
        while (resultSet.next()) {
            //反射创建新对象
            //试一试？？？？？？？？？？？？有参构造
            Constructor<T> constructor = aClass.getConstructor();
           T t = constructor.newInstance();


            //因为下面的大多数函数索引值是从1开始的，所以i的初始值设为1
            for (int i = 1; i <= columnCount; i++) {
                //获取第i个字段的字段名
                String columnName = resultSet.getMetaData().getColumnName(i);
                //利用字段名进行拼接函数名，从而达到设置集合中对象的成员变量值
                String funName = "set" + columnName.substring(0,1).toUpperCase() + columnName.substring(1);
                //获取该字段的类型名称,获取的类对象
                String columnClassName = resultSet.getMetaData().getColumnClassName(i);
                //反射获取其set方法
                Method aClassDeclaredMethod = aClass.getDeclaredMethod(funName, Class.forName(columnClassName));
                //运行setXX方法
                //resultSet.getObject(i)：返回第i个字段的值
                //参数可以是字段的姓名
                aClassDeclaredMethod.invoke(t, resultSet.getObject(columnName));
            }
            //每轮完一次字段，就表示读取完一次记录，添加到集合
            ts.add(t);
        }
        //函数结束，返回集合
        return ts;
    }
    //类加载是加载静态代码块
      private  static Properties properties = new Properties();
    static  {

        try {
            properties.load(new FileReader("./res/pro.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int  update( String sql, Object... args) throws SQLException {
        //1. 连接数据据库
        Connection conn = getConn();
        //2.预编译语句对象 preparestatemrent，用来执行SQL语句
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //3.因为sql语句中存在占位符，所以要先为占位符进行赋值
        for (int i = 0;i < args.length;i++) {
            preparedStatement.setObject(i+1,args[i]);
        }
        //4.执行语句：executeUpdate（）数据的更新，返回int值
        int row = preparedStatement.executeUpdate();
        return row;
    }

    public static Connection getConn() {
        Connection connection = null;
        String name = (String) properties.getProperty("name");
        String password = (String) properties.getProperty("password");
        String url  = (String) properties.getProperty("url");
        try {
            connection = DriverManager.getConnection(url,name,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  connection;
    }

}
