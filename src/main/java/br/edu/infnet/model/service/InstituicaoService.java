package br.edu.infnet.model.service;

import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.negocio.Instituicao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.edu.infnet.model.repository.InstituicaoRepository;

import java.util.List;
import java.util.Optional;


@Service
public class InstituicaoService {

	@Autowired
	private InstituicaoRepository instituicaoRepository;

	public List<Instituicao> obterLista(Usuario usuario){
		return instituicaoRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC,"nome"));
	}

	public List<Instituicao> obterLista(){
		return (List<Instituicao>) instituicaoRepository.findAll();
	}
	
	public void incluir(Instituicao instituicao) {
		instituicaoRepository.save(instituicao);
	}
	
	public void excluir(Integer id) {
		instituicaoRepository.deleteById(id);
	}

	public Optional<Instituicao> obterPorId(Integer id) {

		return instituicaoRepository.findById(id);
	}

	public int ObterQtde() {

		return (int) instituicaoRepository.count();
	}
}
