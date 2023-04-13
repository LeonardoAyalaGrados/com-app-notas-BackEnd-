package springboot.api.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.api.app.entity.Usuario;

@Repository
public interface UsuarioRespository  extends JpaRepository<Usuario, Long>{
	
	@Query(name = "SELECT u FROM Usuario u WHERE u.email=?1", nativeQuery = true)
	Optional<Usuario> findByEmail(String email);
}
