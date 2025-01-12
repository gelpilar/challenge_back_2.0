package com.example.back_challenge.config;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody RequestLoginModel request)
    {

        try {
            return ResponseEntity.ok(authService.login(request));
        }catch (Error e)
        {
            return ResponseEntity.badRequest().body(new AuthResponse("Error en el proceso de autenticación" + e.toString()));
        }



    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterUserModel request)
    {
        return ResponseEntity.ok(authService.register(request));
    }

}
