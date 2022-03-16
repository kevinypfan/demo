package kevins.fun.demo.controller;

import kevins.fun.demo.entity.User;
import kevins.fun.demo.model.AuthModel;
import kevins.fun.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SecurityTestController {

    @Autowired
    private UserService userService;

    @GetMapping("/public/test")
    public String publicTest() {
        return "OK";
    }

    @PostMapping("/public/signup")
    public User signup(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/private/test")
    public String privateTest() {
        return "OK";
    }

    @GetMapping("/private/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String privateAdmin() {
        return "ADMIN";
    }

    @GetMapping("/private/normal")
    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    public String privateNormal() {
        return "OK";
    }


}
