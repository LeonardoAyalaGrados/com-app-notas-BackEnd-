package springboot.api.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.api.app.entity.Usuario;
import springboot.api.app.repository.UsuarioRespository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	 private UsuarioRespository personaRespository;
	
	@Override
	public List<Usuario> listPerson() {
		return personaRespository.findAll();
	}

	@Override
	public Usuario savePersona (Usuario persona) {
		return personaRespository.save(persona);
	}

	@Override
	public void deletePersona(Long id) {
		personaRespository.deleteById(id);
		
	}

	@Override
	public Usuario buscarId(Long id) {
		return personaRespository.findById(id).get();
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return personaRespository.findByEmail(email).get();
	}

}
