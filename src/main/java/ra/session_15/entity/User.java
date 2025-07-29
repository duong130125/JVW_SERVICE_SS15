package ra.session_15.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 20)
    private String phone;
    @Column(nullable = false, length = 70)
    private String password;
    @Column(unique = true, nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 50)
    private String role; // ROLE_USER hoặc ROLE_ADMIN
}
