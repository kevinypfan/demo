package kevins.fun.demo.controller;

import kevins.fun.demo.dto.UserDTO;
import kevins.fun.demo.entity.User;
import kevins.fun.demo.enums.CaseStyles;
import kevins.fun.demo.repository.UserRepository;
import kevins.fun.demo.service.UserService;
import kevins.fun.demo.utils.PageSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/core")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> find() {
        List<UserDTO> users = new ArrayList<>();
        Iterable<User> userIterable = userRepository.findAll();
        userIterable.forEach(user -> {
            users.add(new UserDTO(user));
        });
        return users;
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
}
