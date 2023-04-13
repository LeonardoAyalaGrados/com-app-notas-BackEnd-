package springboot.api.app;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springboot.api.app.entity.Nota;
import springboot.api.app.entity.Producto;
import springboot.api.app.entity.Usuario;
import springboot.api.app.service.UsuarioService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	
	@Autowired
	private UsuarioService usuarioService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		/*Usuario estudiante1=new Usuario();
		estudiante1.setName("Leonardo");
		
		Nota nota1=new Nota();
		nota1.setTitulo("SPRING BOOT");
		
		Nota nota2=new Nota();
		nota2.setTitulo("MOCKITO");
		
		
		
		usuarioService.savePersona(estudiante1);*/
	}
}
