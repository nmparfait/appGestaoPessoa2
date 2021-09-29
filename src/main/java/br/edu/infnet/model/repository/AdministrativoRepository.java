package br.edu.infnet.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.negocio.Administrativo;
import br.edu.infnet.model.negocio.Professor;


import java.util.List;

public interface AdministrativoRepository extends CrudRepository<Administrativo, Integer> {

    @Query("from Administrativo t where t.usuario.id = :userId")
    public List<Administrativo> obterLista(Integer userId);
	

}
