package ru.titov.taskmanagerserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.titov.taskmanagerserver.api.service.UserService;
import ru.titov.taskmanagerserver.util.PasswordHashUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordHashUtil passwordHashUtil;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(
            @RequestParam("username") final String username,
            @RequestParam("password") final String password,
            final HttpServletResponse httpServletResponse,
            final Model model
    ) {
        try {
            final String passwordHash = passwordHashUtil.md5(password);
            final String token = userService.signIn(username, passwordHash);
            httpServletResponse.addCookie(new Cookie("token", token));
            return "redirect:/project-list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }

}
