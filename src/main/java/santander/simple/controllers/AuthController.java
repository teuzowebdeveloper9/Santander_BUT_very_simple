package santander.simple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import santander.simple.DTOs.AuthDTO;
import santander.simple.entitys.User;
import santander.simple.services.UserServices;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/login")
    public ResponseEntity<?> authUser(@RequestBody AuthDTO authDTO) {
        try {
            User user = userServices.authenticate(authDTO);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Authentication failed"); // 403
        }
    }
}
