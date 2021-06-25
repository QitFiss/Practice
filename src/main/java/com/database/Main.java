package com.database;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        StudentIJDBCDao studentIJDBCDao=new StudentIJDBCDao();
        GroupIJDBCDao groupIJDBCDao = new GroupIJDBCDao();
        System.out.println(groupIJDBCDao.getAll());
        System.out.println(studentIJDBCDao.getAll());
    }

}

