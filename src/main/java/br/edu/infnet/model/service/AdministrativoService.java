package br.edu.infnet.model.service;

import java.util.List;
import java.util.Optional;

import br.edu.infnet.model.negocio.Usuario;

import br.edu.infnet.model.negocio.Administrativo;
import br.edu.infnet.model.repository.AdministrativoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AdministrativoService {
	
	@Autowired
	private AdministrativoRepository administrativoRepository;

	public List<Administrativo> obterLista(){
		return (List<Administrativo>) administrativoRepository.findAll();
	}

	public List<Administrativo> obterLista(Usuario usuario){
		return (List<Administrativo>) administrativoRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC,"endereco"));
	}

	public void incluir(Administrativo administrativo) {
		administrativoRepository.save(administrativo);
	}
	
	public void excluir(Integer id) {
		administrativoRepository.deleteById(id);
	}
	
	public Optional<Administrativo> obterPorId(Integer id) {
		return administrativoRepository.findById(id);
	}

	public int ObterQtde() {

		return (int) administrativoRepository.count();
	}

}
