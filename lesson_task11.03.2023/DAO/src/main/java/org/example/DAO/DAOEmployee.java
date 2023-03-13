package org.example.DAO;
import org.example.Model.Empoloyee;

import java.sql.*;


public class DAOEmployee {
    private final Connection connection;
    private static final String URL = "jdbc:sqlite:C:\\Users\\vniiz\\Desktop\\java_lessons\\lesson_task11.03.2023\\DAO\\src\\main\\resources\\Base.db";

    public DAOEmployee() throws SQLException {
        this.connection = DriverManager.getConnection(URL);
    }


    public boolean insert (Empoloyee empoloyee) throws SQLException{
        String querty = "INSERT INTO employee (surname, name, third_name, job_title, department, salary) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = this.connection.prepareStatement(querty);
        pst.setString(1, empoloyee.getSurname());
        pst.setString(2, empoloyee.getName());
        pst.setString(3, empoloyee.getThird_name());
        pst.setString(4, empoloyee.getJob_title());
        pst.setString(5, empoloyee.getDepartment());
        pst.setDouble(6,  empoloyee.getSalary());
        pst.execute();
        return true;
    }

    public Empoloyee getById(int id) throws SQLException{
        String selectAll = String.format("SELECT * FROM employee WHERE id = %d", id);
        PreparedStatement pst = connection.prepareStatement(selectAll);
        ResultSet resultSet = pst.executeQuery();
        return new Empoloyee(resultSet);
    }

    @Override
    protected void finalize() throws Throwable {
        this.connection.close();
        super.finalize();
    }

    public boolean updateById(Empoloyee empoloyee) throws SQLException {
        String updateStatement = String.format("""
                         UPDATE employee 
                         SET surname = '%s', name = '%s', third_name = '%s', job_title = '%s', department = '%s', salary = %s
                         WHERE id = %d""",  empoloyee.getSurname(), empoloyee.getName(),
                empoloyee.getThird_name(), empoloyee.getJob_title(),
                empoloyee.getDepartment(), Double.toString(empoloyee.getSalary()), empoloyee.getId());
//        System.out.println(updateStatement);
        PreparedStatement pst = this.connection.prepareStatement(updateStatement);
        pst.execute();
        return true;
    }

    public boolean deleteById(int id) throws SQLException {
        String sql = String.format("DELETE FROM employee " +
                "WHERE id = %d", id);
        PreparedStatement pst = this.connection.prepareStatement(sql);
        pst.execute();
        return true;
    }
}