package ra.session_15.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthRequest {

    @Email(message = "Email phải hợp lệ")
    private String email;

    @NotBlank(message = "Cần có mật khẩu")
    private String password;
}