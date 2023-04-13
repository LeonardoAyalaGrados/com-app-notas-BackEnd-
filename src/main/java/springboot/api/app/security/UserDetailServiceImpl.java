package springboot.api.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springboot.api.app.entity.Usuario;
import springboot.api.app.repository.UsuarioRespository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRespository usuarioRespository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario= usuarioRespository.findByEmail(email)
		.orElseThrow(()->new UsernameNotFoundException("El email "+email+"no se encuentra registrada"));
		
		return new UserDetailsImpl(usuario);
	}

}
