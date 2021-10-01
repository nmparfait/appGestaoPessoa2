package br.edu.infnet.model.service;

import java.util.List;
import java.util.Optional;

import br.edu.infnet.model.negocio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.model.negocio.Professor;
import br.edu.infnet.model.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;

	public List<Professor> obterLista(){
		return (List<Professor>) professorRepository.findAll();
	}

	public List<Professor> obterLista(Usuario usuario){
		return (List<Professor>) professorRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC,"endereco"));
	}
	
	public void incluir(Professor professor) {
		professorRepository.save(professor);
	}

	public void excluir(Integer id) {

		professorRepository.deleteById(id);
	}

	public Optional<Professor> obterPorId(Integer id) {

		return professorRepository.findById(id);
	}
}
