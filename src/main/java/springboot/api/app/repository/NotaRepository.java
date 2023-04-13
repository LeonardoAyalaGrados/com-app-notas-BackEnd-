package springboot.api.app.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import springboot.api.app.entity.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long>{

	
}
