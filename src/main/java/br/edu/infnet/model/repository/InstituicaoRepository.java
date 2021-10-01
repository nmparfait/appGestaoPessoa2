package br.edu.infnet.model.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.model.negocio.Instituicao;


import java.util.List;


public interface InstituicaoRepository extends CrudRepository<Instituicao, Integer> {

    @Query("FROM Instituicao i where i.usuario.id = :userId ORDER BY i.nome ASC")
    List<Instituicao> obterLista(Integer userId, Sort sort);
}
