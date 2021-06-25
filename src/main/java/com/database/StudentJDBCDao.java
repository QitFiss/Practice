package com.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
class StudentIJDBCDao implements IDAO<Student>  {
    Connection connection;
    Statement statement;

    public StudentIJDBCDao() throws SQLException  {
        connection = ConnectionFactory.getConnection();
        statement = connection.createStatement();
    }

    @Override
    public Optional<Student> get(int id) {
        Optional<Student> result = Optional.empty();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM university.student WHERE idstudent=" + id);

            if (rs.next()) {
                result = DBUtils.getStudent(rs);
                if(result.isEmpty()){
                    return Optional.empty();
                }
            }
            DBUtils.close(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Optional<Student>> getAll() {
        List<Optional<Student>> students = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM university.student;");

            while (rs.next()) {
                students.add(DBUtils.getStudent(rs));
            }

            DBUtils.close(rs);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean insert(Student student) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            String sql="insert into university.student(studentname,studentweight,studentheight,group_Id) values(?,?,?,?);";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,student.name);
            preparedStatement.setInt(2,student.weight);
            preparedStatement.setInt(3,student.height);
            preparedStatement.setInt(4,student.group_Id);
            result= preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        System.out.println("Group inserted");
        return result;
    }

    @Override
    public boolean update(Student student) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            String sql="update university.student set studentname = (?),studentweight=(?),studentheight=(?),group_Id=(?) where idstudent=(?);";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,student.name);
            preparedStatement.setInt(2,student.weight);
            preparedStatement.setInt(3,student.height);
            preparedStatement.setInt(4,student.group_Id);
            preparedStatement.setInt(5,student.id);
            result= preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Student student) {
        boolean result = false;
        try {
            result = statement.execute(
                    "DELETE FROM university.student WHERE idstudent=" + student.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Student deleted");
        return result;
    }

    @Override
    public boolean clearData() {
        boolean result = false;
        try {
            result = statement.execute(
                    "DELETE FROM university.student");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}

