package com.buldoser.daos;

import com.buldoser.vars.VARS;

import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostgresDAO {
    private Connection connection;
    public String URL = VARS.PostgressURL;
    // get all data by place_id in some balance
    public final String get_data_st = """ 
            SELECT
                longitude,
                latitude,
                height_delta,
                datetime
            FROM %s
            WHERE place_id = ?
            ORDER BY datetime
            OFFSET ?
            LIMIT ?
            """;

    // get count of data with some place_id
    public final String get_balance_st = """ 
            SELECT
                count(*) as point_count
            FROM %s
            WHERE place_id = ?
            """;

    // select list of all place id that are in table
    public final String available_place_id_st = """
            SELECT DISTINCT
                place_id
            FROM %s
            """;

    public PostgresDAO(String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(this.URL, user, password);
    }
    public PostgresDAO(String user, String password, String database) throws SQLException {
        // concat path with database
        this.URL = Paths.get(this.URL).resolve(Paths.get(database)).toString();
        // get connection
        this.connection = DriverManager.getConnection(this.URL, user, password);
    }

    // start between 0, len
    // end between start, len
    // get dict as {"heights" : List<Double>, "longitude": List<Double>,"latitude": List<Double>, "datetime": List<String>}
    public HashMap<String, Object> getData(String table, int place_id, int start, int end) throws SQLException {
        PreparedStatement pr_st = this.connection.prepareStatement(String.format(get_data_st, table));
        pr_st.setInt(1, place_id);
        pr_st.setInt(2, start);
        pr_st.setInt(3, end - start);
        ResultSet result = pr_st.executeQuery();
        HashMap<String, Object> result_dict = new HashMap<>();
        List<Double> heights_list = new ArrayList<>();
        List<Double> longitude_list = new ArrayList<>();
        List<Double> latitude_list = new ArrayList<>();
        List<String> datetime_list = new ArrayList<>();

        while(result.next()){
            heights_list.add(result.getDouble("height_delta"));
            longitude_list.add(result.getDouble("longitude"));
            latitude_list.add(result.getDouble("latitude"));
            datetime_list.add(result.getString("datetime"));
        }

        result_dict.put("heights", heights_list);
        result_dict.put("longitude", longitude_list);
        result_dict.put("latitude", latitude_list);
        result_dict.put("datetime", datetime_list);
        return result_dict;
    }

    //  get count of data with some place_id return dict {"point_count":Integer}
    public HashMap<String, Integer> getBalance(String table, int place_id) throws SQLException {
        PreparedStatement pr_st = this.connection.prepareStatement(String.format(get_balance_st, table));
        pr_st.setInt(1, place_id);
        ResultSet result = pr_st.executeQuery();
        HashMap<String, Integer> result_dict = new HashMap<>();
        result.next();
        result_dict.put("point_count", result.getInt("point_count"));
        return result_dict;
    }

    // select list of all place id that are in table return {"place_id_list":List<Integer>}
    public HashMap<String, List<Integer>> availablePlaceId(String table) throws SQLException {
        PreparedStatement pr_st = this.connection.prepareStatement(String.format(available_place_id_st, table));
        ResultSet result = pr_st.executeQuery();
        HashMap<String, List<Integer>> result_dict = new HashMap<>();
        List<Integer> place_id_list = new ArrayList<>();
        while(result.next()){
            place_id_list.add(result.getInt("place_id"));
        }
        result_dict.put("place_id_list", place_id_list);
        return result_dict;
    }
}
