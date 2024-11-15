package fr.projet.duo.optimisation.Controller;

import fr.projet.duo.optimisation.Entity.Users;
import fr.projet.duo.optimisation.Service.UsersService;
import fr.projet.duo.optimisation.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsersService userService;

    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@RequestBody Users user) {
        Users registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestParam String username, @RequestParam String password) {
        Users user = userService.loginUser(username, password);
        String token = JwtUtil.generateToken(user.getId(), user.getUsername());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("username", user.getUsername());
        response.put("userId", String.valueOf(user.getId()));

        return ResponseEntity.ok(response);
    }
}
