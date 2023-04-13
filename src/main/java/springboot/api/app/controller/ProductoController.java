package springboot.api.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.api.app.entity.Usuario;
import springboot.api.app.entity.Producto;
import springboot.api.app.service.ProductoServiceImpl;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoServiceImpl productoServiceImpl;
	
	@PostMapping("/save")
	public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
		Optional<Producto>newProducto=Optional.of(productoServiceImpl.save(producto));
		if (newProducto.isPresent()) {
			return new ResponseEntity<Producto>(newProducto.get(),HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
