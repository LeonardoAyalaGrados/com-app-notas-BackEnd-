package springboot.api.app.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.api.app.entity.Nota;
import springboot.api.app.entity.Usuario;
import springboot.api.app.repository.NotaRepository;


@Service
public class NotaServiceImpl implements NotaService{

	@Autowired
	NotaRepository notaRepository;
	
	@Override
	public List<Nota> findAll() {
		
		return notaRepository.findAll();
	}

	@Override
	public Nota save(Nota nota) {
		return notaRepository.save(nota);
	}

	@Override
	public void deleteById(Long id) {
		notaRepository.deleteById(id);
		
	}


}
