package org.example.DAO;

import org.example.Model.Deprtment;
import org.example.Model.Empoloyee;

import java.sql.*;

public class DAODepartment {

    private final Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String LOGIN = "postgres";
    public static final String PASSWORD = "1335555";

    public DAODepartment() throws SQLException {
        this.connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }
    public DAODepartment(Connection connection) {
        this.connection = connection;
    }
    @Override
    protected void finalize() throws Throwable {
        this.connection.close();
        super.finalize();
    }

    public Deprtment createIfNotExists(String department) throws SQLException {
        String insert = String.format("""
                                       INSERT INTO departments (department)
                                       SELECT '%s'
                                       WHERE NOT EXISTS (SELECT * FROM departments WHERE department = '%s')
                                               """, department, department);
        PreparedStatement pst = connection.prepareStatement(insert);
         pst.execute();
         pst = connection.prepareStatement(String.format("SELECT id, department FROM departments WHERE department = '%s' ", department));
        ResultSet resultSet = pst.executeQuery();
        resultSet.next();
        return new Deprtment(resultSet);

    }

    public Deprtment getById(int id) throws SQLException {
        String selectAll = String.format("SELECT * FROM departments WHERE id = %d", id);
        PreparedStatement pst = connection.prepareStatement(selectAll);
        ResultSet resultSet = pst.executeQuery();
        resultSet.next();
        return new Deprtment(resultSet);
    }
}
