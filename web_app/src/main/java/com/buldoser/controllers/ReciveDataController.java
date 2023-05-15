package com.buldoser.controllers;


import com.buldoser.daos.PostgresDAO;
import com.buldoser.daos.SQLiteDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Controller
public class ReciveDataController {



//    return json {"datetime" : [], "heights" : [], "latitude" : [], "longitude" : []}
//    http://localhost:8080/get-data?postgres_user=test_user&postgres_pass=test&table=points_history&place_id=1&start=1&end=3
    @RequestMapping(value = "/get-data",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object get_data(@RequestParam String postgres_pass, @RequestParam String postgres_user,
                           @RequestParam String table, @RequestParam Integer place_id,
                           @RequestParam Integer start, @RequestParam Integer end){
        System.out.println("[+] Json /get-data formating...");
        PostgresDAO postgre_dao;
        try {
            postgre_dao = new PostgresDAO(postgres_user, postgres_pass);
        } catch (SQLException e) {
            System.out.println("[Error] can't connect to Postgres DB");
            System.out.println(e.getMessage());
            return "{\"datetime\" : [], \"heights\" : [], \"latitude\" : [], \"longitude\" : [], \"error\" : \"connection error\"}";
        }
        HashMap<String, Object> data;
        try {
            data = postgre_dao.getData(table, place_id, start, end);
        } catch (SQLException e) {
            System.out.println("[Error] can't get balance:");
            System.out.println(e.getMessage());
            return "{\"datetime\" : [], \"heights\" : [], \"latitude\" : [], \"longitude\" : [], \"error\" : \"receive data error\"}";
        }
        return data;

    }

//    http://localhost:8080/get-balance?postgres_user=test_user&postgres_pass=test&table=points_history&place_id=1
//    return json {'point_count' : Integer}
    @RequestMapping(value = "/get-balance",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public Object get_balance(@RequestParam String postgres_pass, @RequestParam String postgres_user,
                           @RequestParam String table, @RequestParam Integer place_id){
        System.out.println("[+] Json /get-balance formating...");
        PostgresDAO postgre_dao;
        try {
            postgre_dao = new PostgresDAO(postgres_user, postgres_pass);
        } catch (SQLException e) {
            System.out.println("[Error] can't connect to Postgres DB");
            System.out.println(e.getMessage());
            return "{'point_count' : 0, 'error' : 'connection error'}";
        }
        HashMap<String, Integer> balance;
        try {
            balance = postgre_dao.getBalance(table, place_id);
        } catch (SQLException e) {
            System.out.println("[Error] can't get balance:");
            System.out.println(e.getMessage());
            return "{'point_count' : 0, 'error' : 'receive data error'}";
        }
        return balance;

    }

//  http://localhost:8080/get-place-id?postgres_user=test_user&postgres_pass=test&table=points_history
//    return json {'place_id_list' : List<Integer>}
    @RequestMapping(value = "/get-place-id",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public Object get_place_id_list(@RequestParam String postgres_pass, @RequestParam String postgres_user,
                                    @RequestParam String table){
        System.out.println("[+] Json /get-balance formating...");
        PostgresDAO postgre_dao;
        try {
            postgre_dao = new PostgresDAO(postgres_user, postgres_pass);
        } catch (SQLException e) {
            System.out.println("[Error] can't connect to Postgres DB");
            System.out.println(e.getMessage());
            return "{'place_id_list' : [], 'error' : 'connection error'}";
        }
        HashMap<String, List<Integer>> place_id_list;
        try {
            place_id_list = postgre_dao.availablePlaceId(table);
        } catch (SQLException e) {
            System.out.println("[Error] can't get place_id_list");
            System.out.println(e.getMessage());
            return "{'place_id_list' : [], 'error' : 'receive data error'}";
        }
        return place_id_list;

    }
}
