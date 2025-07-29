package ra.session_15.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ra.session_15.dto.AuthRequest;
import ra.session_15.dto.AuthResponse;
import ra.session_15.dto.RegisterRequest;
import ra.session_15.entity.User;
import ra.session_15.exception.EmailAlreadyExistsException;
import ra.session_15.repository.UserRepository;
import ra.session_15.securiry.JwtUtils;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public void register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already in use");
        }

        User user = User.builder()
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("ROLE_USER")
                .build();

        userRepository.save(user);
    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtUtils.generateToken(user);
        String refresh = jwtUtils.generateRefreshToken(user);

        return new AuthResponse(token, refresh);
    }
}
