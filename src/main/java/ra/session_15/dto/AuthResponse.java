package ra.session_15.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String accessToken;
    private String refreshToken;
}