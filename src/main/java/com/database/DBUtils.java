package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Optional;

public class DBUtils {
    public static void close(Connection connection){
        if(connection == null) return;
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void close(ResultSet resultSet){
        if(resultSet == null) return;
        try {
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void dropDBTable(Connection connection) throws SQLException {
        Statement  stmt = connection.createStatement();
        executeQuery(stmt,
                "drop table if exists group;drop table if exists students;");
    }
    public static void executeQuery(Statement stmt, String query) throws SQLException {
        stmt.executeUpdate(query);
    }
    public static Optional<Group> getGroup(ResultSet rs) throws SQLException {

        Group group = new Group();

        group.setId(rs.getInt("idgroup"));
        group.setName(rs.getString("groupcol"));
        return Optional.of(group);
    }
    public static Optional<Student> getStudent(ResultSet rs) throws SQLException {

        Student student = new Student();

        student.setId(rs.getInt("idstudent"));
        student.setName(rs.getString("studentname"));
        student.setWeight(rs.getInt("studentweight"));
        student.setHeight(rs.getInt("studentheight"));
        student.setGroup_Id(rs.getInt("group_id"));
        return Optional.of(student);
    }
}