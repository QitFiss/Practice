package com.database;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        Student student= new Student(1,"Блідар Микола",65,176,1);
        StudentIJDBCDao studentIJDBCDao=new StudentIJDBCDao();
        studentIJDBCDao.update(student);
        System.out.println(studentIJDBCDao.getAll());
    }

}

