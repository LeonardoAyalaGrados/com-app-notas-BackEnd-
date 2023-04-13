package springboot.api.app.controller;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.Getter;
import springboot.api.app.entity.Nota;
import springboot.api.app.entity.Usuario;
import springboot.api.app.service.NotaService;
import springboot.api.app.service.NotaServiceImpl;
import springboot.api.app.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/nota")
public class NotaController {

	@Autowired
	NotaServiceImpl notaServiceImpl;
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	@GetMapping("/listar")
	public List<Nota> listar(){
		return notaServiceImpl.findAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Nota> saveNota(@RequestBody Nota nota){
		Optional<Usuario> usuario=Optional.of(usuarioServiceImpl.buscarId(nota.getUser().getIdPersona()));
		if (!usuario.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		nota.setUser(usuario.get());
		Nota notaGuardada=notaServiceImpl.save(nota);
		URI ubicacion=ServletUriComponentsBuilder.fromCurrentRequest().path("{/{id}}")
				.buildAndExpand(notaGuardada.getIdNota()).toUri();
		
		return ResponseEntity.created(ubicacion).body(notaGuardada);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteNota(@PathVariable Long id) {
		notaServiceImpl.deleteById(id);
	}
}
