package br.edu.infnet.model.repository;


import br.edu.infnet.model.negocio.Pessoa;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {

    @Query("from Pessoa p where p.usuario.id = :userId ORDER BY p.endereco ASC")
    public List<Pessoa> obterLista(Integer userId, Sort sort);

}
