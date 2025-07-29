package ra.session_15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.session_15.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}