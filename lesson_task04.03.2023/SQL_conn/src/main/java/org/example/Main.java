package org.example;
import org.example.Model.Director;
import org.example.DAO.DirectorDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String LOGIN = "postgres";
    public static final String PASSWORD = "1335555";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        DirectorDAO directorDAO = new DirectorDAO(connection);
//        if ((true)) directorDAO.insert(new Director("Stiven Spilberg"));
    }
}