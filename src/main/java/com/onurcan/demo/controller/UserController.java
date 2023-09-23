package com.onurcan.demo.controller;

import com.onurcan.demo.service.VulnerableService;
import com.onurcan.demo.service.SecureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private VulnerableService vulnerableService;

    @Autowired
    private SecureService secureService;

    @GetMapping("/vulnerable-login")
    public String showVulnerableLoginForm() {
        return "vulnerable-login-form";
    }

    @PostMapping("/vulnerable-login")
    public String vulnerableLogin(@RequestParam String username, @RequestParam String password, Model model) {
        boolean isAuthenticated = vulnerableService.loginUser(username, password);
        if (isAuthenticated) {
            model.addAttribute("message", "Login successful (vulnerable method)");
        } else {
            model.addAttribute("message", "Login failed (vulnerable method)");
        }
        return "vulnerable-result";
    }

    @GetMapping("/secure-login")
    public String showSecureLoginForm() {
        return "secure-login-form";
    }

    @PostMapping("/secure-login")
    public String secureLogin(@RequestParam String username, @RequestParam String password, Model model) {
        boolean isAuthenticated = secureService.loginUser(username, password);
        if (isAuthenticated) {
            model.addAttribute("message", "Login successful (secure method)");
        } else {
            model.addAttribute("message", "Login failed (secure method)");
        }
        return "secure-result";
    }
}
