package br.edu.infnet.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.negocio.Professor;
import java.util.List;

@Repository
public interface ProfessorRepository  extends CrudRepository<Professor, Integer>{
	
	@Query("from Professor d where d.usuario.id = :userId")
	public List<Professor> obterLista(Integer userId);
	
	

}
