package springboot.api.app.service;

import java.util.List;

import springboot.api.app.entity.Producto;

public interface ProductoService {

	public List<Producto> listar();
	public Producto save(Producto producto);
	
}
