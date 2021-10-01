package br.edu.infnet.model.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.negocio.Aluno;
import java.util.List;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
	
	@Query("FROM Aluno a WHERE a.usuario.id = :userId ORDER BY a.endereco ASC")

	List<Aluno> obterLista(Integer userId, Sort sort);
}
