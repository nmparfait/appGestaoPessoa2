package br.edu.infnet.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.negocio.Instituicao;
import br.edu.infnet.model.negocio.Administrativo;

import java.util.List;

@Repository
public interface InstituicaoRepository extends CrudRepository<Instituicao, Integer> {

    @Query("from Instituicao t where t.usuario.id = :userId")
    public List<Instituicao> obterLista(Integer userId);
}
