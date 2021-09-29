package br.edu.infnet.model.service;

import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.negocio.Instituicao;
import br.edu.infnet.model.negocio.Administrativo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.model.repository.InstituicaoRepository;

import java.util.List;

@Service
public class InstituicaoService {

	@Autowired
	private InstituicaoRepository InstituicaoRepository;

	public List<Instituicao> obterLista(Usuario usuario){
		return (List<Instituicao>) InstituicaoRepository.obterLista(usuario.getId());
	}

	public List<Instituicao> obterLista(){
		return (List<Instituicao>) InstituicaoRepository.findAll();
	}
	
	public void incluir(Instituicao Instituicao) {
		InstituicaoRepository.save(Instituicao);
	}
	
	public void excluir(Integer id) {
		InstituicaoRepository.deleteById(id);
	}

	public Instituicao obterPorId(Integer id) {
		return InstituicaoRepository.findById(id).orElse(null);
	}
}
