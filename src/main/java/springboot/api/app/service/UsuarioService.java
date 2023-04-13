package springboot.api.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import springboot.api.app.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> listPerson();
	public Usuario savePersona(Usuario persona);
	public void deletePersona(Long id);
	public Usuario buscarId(Long id);
	public Usuario buscarPorEmail(String email);
}
