package br.edu.infnet.model.service;

import java.util.List;
import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.negocio.Professor;

import br.edu.infnet.model.negocio.Administrativo;
import br.edu.infnet.model.repository.AdministrativoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministrativoService {
	
	@Autowired
	private AdministrativoRepository administrativoRepository;

	public List<Administrativo> obterLista(Usuario usuario){
		return (List<Administrativo>) administrativoRepository.obterLista(usuario.getId());
	}

	public List<Administrativo> obterLista(){
		return (List<Administrativo>) administrativoRepository.findAll();
	}
	
	public void incluir(Administrativo administrativo) {
		administrativoRepository.save(administrativo);
	}
	
	public void excluir(Integer id) {
		administrativoRepository.deleteById(id);
	}
	
	public Administrativo obterPorId(Integer id) {
		return administrativoRepository.findById(id).orElse(null);
	}

}
