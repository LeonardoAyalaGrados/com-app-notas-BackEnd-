package springboot.api.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.api.app.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
