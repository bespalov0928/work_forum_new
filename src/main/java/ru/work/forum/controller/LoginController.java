package ru.work.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest req, HttpServletResponse resp) {

        return "redirect:/auth/login?logout-true";
    }


//    @GetMapping("/login")
//    public String loginPage(@RequestParam(value = "error", required = false) String error,
//                            @RequestParam(value = "logout", required = false) String logout,
//                            Model model) {
//        String errorMessge = null;
//        if (error != null) {
//            errorMessge = "Username or Password id incorrect !!";
//        }
//        if (logout != null) {
//            errorMessge = "You have been successfully logged out !!";
//        }
//        model.addAttribute("errorMessage", errorMessge);
//        return "login";
//    }

//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logoutPage(HttpServletRequest req, HttpServletResponse resp) {
//
//        return "redirect:/login?logout-true";
//    }

}
