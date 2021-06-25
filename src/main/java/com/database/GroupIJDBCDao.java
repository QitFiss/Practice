package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class GroupIJDBCDao implements IDAO<Group> {
    Connection connection;
    Statement statement;

    public GroupIJDBCDao() throws SQLException  {
        connection = ConnectionFactory.getConnection();
        statement = connection.createStatement();
    }

    @Override
    public Optional<Group> get(int id) {
        Optional<Group> result = Optional.empty();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM university.group WHERE idgroup=" + id);

            if (rs.next()) {
                result = DBUtils.getGroup(rs);
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
    public List<Optional<Group>> getAll() {
        List<Optional<Group>> groups = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM university.group;");

            while (rs.next()) {
                groups.add(DBUtils.getGroup(rs));
            }

            DBUtils.close(rs);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return groups;
    }

    @Override
    public boolean insert(Group group) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            result = statement.execute(
                    "INSERT INTO university.group(groupcol) VALUES(" + group.getName()+");");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Group inserted");
        return result;
    }

    @Override
    public boolean update(Group group) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            result = statement.execute(
                    "UPDATE university.group" +
                            "SET groupcol = '" + group.getName() +
                            "WHERE id = " + group.getId() + ";");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Group group) {
        boolean result = false;
        try {
            result = statement.execute(
                    "DELETE FROM university.group WHERE idgroup=" + group.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Group deleted");
        return result;
    }

    @Override
    public boolean clearData() {
        boolean result = false;
        try {
            result = statement.execute(
                    "DELETE FROM university.group");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
