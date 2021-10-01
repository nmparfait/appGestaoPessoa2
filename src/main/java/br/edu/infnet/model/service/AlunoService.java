package br.edu.infnet.model.service;

import java.util.List;
import java.util.Optional;

import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.negocio.Aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.model.repository.AlunoRepository;


@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;


	public List<Aluno> obterLista(){

		return (List<Aluno>) alunoRepository.findAll();
	}

	public List<Aluno> obterLista(Usuario usuario){

		return (List<Aluno>) alunoRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC,"endereco"));
	}

	public void incluir(Aluno aluno) {

		alunoRepository.save(aluno);
	}


	public void excluir(Integer id) {

		alunoRepository.deleteById(id);
	}


	public Optional<Aluno> obterPorId(Integer id) {

		return alunoRepository.findById(id);

	}

	public int ObterQtde() {

		return (int) alunoRepository.count();
	}

}
