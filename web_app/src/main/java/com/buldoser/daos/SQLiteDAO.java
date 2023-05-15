package com.buldoser.daos;

import com.buldoser.error.UserNotFound;
import com.buldoser.vars.VARS;

import java.sql.*;
import java.util.*;

public class SQLiteDAO {
    // there is two table: user and databeses. databeses have a list of bases that user can achieve with his account.
    final static String TABLE_USER = VARS.SQLiteTABLE_USER;
    final static String TABLE_DATABASES = VARS.SQLiteTABLE_DATABASES;
    private final String URL;

    // select all necessary info about user : данные для подключания к postgres, а так же базы данных
    final static String select_user_info = " SELECT tm2.data_base, tm1.postgres_user, tm1.postgres_pass FROM " +
            " ( SELECT * FROM " + TABLE_USER + " WHERE user_name = ? AND password_hash = ?) as tm1 " +
            " LEFT JOIN " + TABLE_DATABASES + " as tm2 " +
            " ON tm1.user_id = tm2.user_id ";
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.URL);
    }

    public SQLiteDAO() throws SQLException {
        this.URL = VARS.SQLiteURL;
    }

    public SQLiteDAO(String url) throws SQLException {
        this.URL = url;
    }
    // get dict with info about user {"postgres_user": String, "postgres_pass":String, "databases": List<String>}
    public HashMap<String, Object> getUserInfo(String user_name, String password) throws UserNotFound, SQLException {
        PreparedStatement select_user_info_pr_st = getConnection().prepareStatement(select_user_info);
        select_user_info_pr_st.setString(1,user_name);
        select_user_info_pr_st.setString(2,password);
        ResultSet result = select_user_info_pr_st.executeQuery();
        Set<String> databases;
        String postgres_user;
        String postgres_pass;
        if (!result.next()) {
            throw new UserNotFound("Empty ResultSet", "login or password doesn't match");
        } else {
            databases = new HashSet<>();
            postgres_user = result.getString("postgres_user");
            postgres_pass = result.getString("postgres_pass");
            do {
                databases.add(result.getString("data_base"));
            } while (result.next());
        }
        HashMap<String, Object> h = new HashMap<>();
        h.put("postgres_user", postgres_user);
        h.put("postgres_pass", postgres_pass);
        h.put("databases", databases);
        return h;

    }

}
