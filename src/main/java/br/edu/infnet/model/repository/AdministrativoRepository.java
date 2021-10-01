package br.edu.infnet.model.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.negocio.Administrativo;



import java.util.List;

@Repository
public interface AdministrativoRepository extends CrudRepository<Administrativo, Integer> {

    @Query("FROM Administrativo a WHERE a.usuario.id = :userId ORDER BY a.endereco ASC")
    List<Administrativo> obterLista(Integer userId, Sort sort);
	

}
