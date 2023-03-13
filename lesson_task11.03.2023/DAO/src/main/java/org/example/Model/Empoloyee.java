package org.example.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Empoloyee {
    int id;
    String surname;
    String name;
    String third_name;
    String job_title;
    String department;
    double salary;

    public Empoloyee(int id, String surname, String name, String third_name, String job_title, String department, double salary) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.third_name = third_name;
        this.job_title = job_title;
        this.department = department;
        this.salary = salary;
    }
    public Empoloyee(ResultSet result) throws SQLException {
        this.id = result.getInt("id");
        this.surname = result.getString("surname");
        this.name =  result.getString("name");
        this.third_name =  result.getString("third_name");
        this.job_title =  result.getString("job_title");
        this.department =  result.getString("department");
        this.salary =  result.getDouble("salary");
    }

    @Override
    public String toString() {
        return "Empoloyee{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", third_name='" + third_name + '\'' +
                ", job_title='" + job_title + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static Empoloyee parse(){
        Scanner sc = new Scanner(System.in);
        System.out.print("id:");
        int id = Integer.parseInt(sc.next());
        System.out.print("\nsurname:");
        String surname = sc.next();
        System.out.print("\nname:");
        String name =  sc.next();
        System.out.print("\nthird_name:");
        String third_name =  sc.next();
        System.out.print("\njob_title:");
        String job_title =  sc.next();
        System.out.print("\ndepartment:");
        String department =  sc.next();
        System.out.print("\nsalary(double):");
        double salary =  Double.parseDouble(sc.next());
        System.out.print("\n");
        return new Empoloyee(id, surname, name, third_name, job_title, department, salary);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThird_name() {
        return third_name;
    }

    public void setThird_name(String third_name) {
        this.third_name = third_name;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
