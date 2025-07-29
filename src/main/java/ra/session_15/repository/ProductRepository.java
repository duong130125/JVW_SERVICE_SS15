package ra.session_15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.session_15.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}