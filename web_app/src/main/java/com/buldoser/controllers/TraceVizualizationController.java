package com.buldoser.controllers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TraceVizualizationController {
    @GetMapping("/visualisation")
    public String visualization(Model model, HttpSession session){
        // check if user is not login
        if (session.getAttribute("postgres_user") == null ||
                session.getAttribute("postgres_pass") == null ||
                session.getAttribute("databases") == null
                ){
                    return "redirect:/";
        }
        // if user is login and have all necessary attributes, provide him visualisation
        model.addAttribute("tables", session.getAttribute("databases"));
        model.addAttribute("postgres_user", session.getAttribute("postgres_user"));
        model.addAttribute("postgres_pass", session.getAttribute("postgres_pass"));
        return "chart";
    }

}
