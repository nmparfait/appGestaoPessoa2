package br.edu.infnet.model.service;

import java.util.List; 

import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.negocio.Professor;
import br.edu.infnet.model.negocio.Administrativo;
import br.edu.infnet.model.negocio.Aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.model.repository.AlunoRepository;
import br.edu.infnet.model.repository.ProfessorRepository;


@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public List<Aluno> obterLista(Usuario usuario){
		return (List<Aluno>) alunoRepository.obterLista(usuario.getId());
	}

	public List<Aluno> obterLista(){
		return (List<Aluno>) alunoRepository.findAll();
	}
	
	public void incluir(Aluno aluno) {
		alunoRepository.save(aluno);
	}
	
	public void excluir(Integer id) {
		alunoRepository.deleteById(id);
	}
	
	public Aluno obterPorId(Integer id) {
		return alunoRepository.findById(id).orElse(null);
	}
}
