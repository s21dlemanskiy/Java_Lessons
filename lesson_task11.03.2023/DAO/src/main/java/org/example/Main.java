package org.example;

import org.example.DAO.DAOEmployee;
import org.example.Model.Empoloyee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        DAOEmployee DAO1 = new DAOEmployee();
        Scanner sc = new Scanner(System.in);
        String data = sc.next();
        while (!data.equals("end")){
            System.out.println(data);
            if (data.equals("get")){
                int id = Integer.parseInt(sc.next());
                System.out.println(DAO1.getById(id));
                data = sc.next();
                continue;
            }
            if (data.equals("update")){
                Empoloyee emp = Empoloyee.parse();
                System.out.println(DAO1.updateById( emp));
                data = sc.next();
                continue;
            }
            if (data.equals("delete")){
                System.out.print("id:");
                data = sc.next();
                System.out.println(DAO1.deleteById(Integer.parseInt(data)));
                data = sc.next();
                continue;
            }
            if (data.equals("insert")){
                Empoloyee emp = Empoloyee.parse();
                System.out.println(DAO1.insert(emp));
                data = sc.next();
            }
            System.out.println("Command not found please try again");
            data = sc.next();

        }
    }
}