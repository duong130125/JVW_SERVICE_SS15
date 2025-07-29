package ra.session_15.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = "Số điện thoại là bắt buộc")
    private String phone;

    @NotBlank(message = "Cần có mật khẩu")
    private String password;

    @Email(message = "Email phải hợp lệ")
    private String email;
}