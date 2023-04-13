package springboot.api.app.service;

import java.util.Collection;
import java.util.List;

import springboot.api.app.entity.Nota;
import springboot.api.app.entity.Usuario;

public interface NotaService {

	public List<Nota> findAll();
	//public Nota save(Nota nota, Usuario idPersona);
	public Nota save(Nota nota);
	public void deleteById(Long id);
}
