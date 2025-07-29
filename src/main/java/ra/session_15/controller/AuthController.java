package ra.session_15.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.session_15.dto.AuthRequest;
import ra.session_15.dto.AuthResponse;
import ra.session_15.dto.RegisterRequest;
import ra.session_15.service.UserService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequest request) {
        userService.register(request);
        return ResponseEntity.ok("Đăng ký thành công");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }
}
