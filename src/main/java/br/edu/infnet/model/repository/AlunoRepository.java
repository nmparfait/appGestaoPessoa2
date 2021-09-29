package br.edu.infnet.model.repository;

import br.edu.infnet.model.negocio.Professor;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.negocio.Aluno;
import java.util.List;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
	
	@Query("from Aluno j where j.usuario.id = :userId")
	public List<Aluno> obterLista(Integer userId);
	

}
