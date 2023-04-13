package springboot.api.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.api.app.entity.Producto;
import springboot.api.app.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public List<Producto> listar() {
		return productoRepository.findAll();
	}

	@Override
	public Producto save(Producto producto) {
		
		return productoRepository.save(producto);
	}

}
