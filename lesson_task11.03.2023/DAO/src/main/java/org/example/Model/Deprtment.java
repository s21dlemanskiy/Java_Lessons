package org.example.Model;

import org.example.DAO.DAODepartment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Deprtment {
    final int id;
    final String name;

    public Deprtment(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Deprtment(ResultSet result) throws SQLException {
        this.id = result.getInt("id");
        this.name =  result.getString("department");
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Deprtment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
