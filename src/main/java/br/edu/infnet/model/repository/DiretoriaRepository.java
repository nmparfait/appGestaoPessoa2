package br.edu.infnet.model.repository;

import br.edu.infnet.model.negocio.Diretoria;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiretoriaRepository extends CrudRepository<Diretoria, Integer> {

    @Query("from Diretoria d where d.usuario.id = :userId ORDER BY d.nome ASC ")
    List<Diretoria> obterLista(Integer userId, Sort sort);
}
