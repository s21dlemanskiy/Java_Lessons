package com.buldoser.controllers;

import com.buldoser.daos.SQLiteDAO;
import com.buldoser.error.UserNotFound;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class LoginController {
    static final SQLiteDAO sqlite_dao;

    static {
        try {
            sqlite_dao = new SQLiteDAO();
        } catch (SQLException e) {
            System.out.println("can't connect to SQLite DB");
            throw new RuntimeException(e);
        }
    }

    public LoginController() throws SQLException {
    }

    @GetMapping("/")
    public String login(Model model, @RequestParam(required = false) String error){
        if (error != null) {
            model.addAttribute("error", error);
        }
        return "login_page";
    }

    // Hash function (good idea to move it to utils, but it still here)
    // i do not code it, just copy
    private static String hashPassword(String passwordToHash) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Add password bytes to digest
        md.update(passwordToHash.getBytes());

        // Get the hash's bytes
        byte[] bytes = md.digest();

        // these bytes[] has bytes in decimal format. Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }

        // Get complete hashed password in hex format
        return sb.toString();
    }


    // check login and password
    @PostMapping(value = "login-check")
    public RedirectView  login(Model model, @RequestParam Map<String,String> requestParams, HttpSession session, RedirectAttributes redirectAttributes) throws NoSuchAlgorithmException{
        String login=requestParams.get("login");
        // since we do not use password, we use hash.
        String hash_password=hashPassword(requestParams.get("password"));
        HashMap<String, Object> user_data;
        try {
            user_data = sqlite_dao.getUserInfo(login, hash_password);
        } catch (UserNotFound e) {
            redirectAttributes.addAttribute("error", e.getUser_will_see());
            return new RedirectView("/");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        session.setAttribute("postgres_user", user_data.get("postgres_user"));
        session.setAttribute("postgres_pass", user_data.get("postgres_pass"));
        session.setAttribute("databases", user_data.get("databases"));
        return new RedirectView("/visualisation");
    }
}
