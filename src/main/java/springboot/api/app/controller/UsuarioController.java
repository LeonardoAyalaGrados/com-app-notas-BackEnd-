package springboot.api.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.api.app.entity.Usuario;
import springboot.api.app.service.NotaServiceImpl;
import springboot.api.app.service.UsuarioService;
import springboot.api.app.service.UsuarioServiceImpl;

//@CrossOrigin(methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/persona")
public class UsuarioController {
	
	@Autowired
	UsuarioServiceImpl personaServiceImpl;
	
	@Autowired
	NotaServiceImpl notaServiceImpl;
	
	@GetMapping("/listar")
	public List<Usuario> listar(){
		return personaServiceImpl.listPerson();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Usuario> guardar(@RequestBody Usuario persona) {
		Optional<Usuario>newPerson=Optional.of(personaServiceImpl.savePersona(persona));
		if (newPerson.isPresent()) {
			return new ResponseEntity<Usuario>(newPerson.get(),HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		 try {
			 personaServiceImpl.deletePersona(id);
			 return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("ID NO ENCONTRADO",HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id,@RequestBody Usuario persona){
		try {
			Optional<Usuario>personaEncontrada=Optional.of(personaServiceImpl.buscarId(id));
			if (personaEncontrada.isPresent()) {
				personaEncontrada.get().setName(persona.getName());
				personaEncontrada.get().setLastName(persona.getLastName());
				personaEncontrada.get().setCel(persona.getCel());
				personaEncontrada.get().setDni(persona.getDni());	
				personaServiceImpl.savePersona(personaEncontrada.get());
				return new ResponseEntity<Usuario>(HttpStatus.OK);
			}else {
				return new ResponseEntity("NO ENCONTRADO",HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/buscar/{id}")
	public Usuario findById(@RequestBody Long id){
		Optional<Usuario>personaEncontrada=Optional.of(personaServiceImpl.buscarId(id));
		return personaEncontrada.get();
	}
	
	@GetMapping("/buscar")
	public Usuario buscarPorEmail(@RequestParam String email){
		 Optional<Usuario> user=Optional.of(personaServiceImpl.buscarPorEmail(email));
		 return user.get();
	}
}
