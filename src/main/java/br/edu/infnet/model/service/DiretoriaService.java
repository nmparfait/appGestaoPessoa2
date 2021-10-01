package br.edu.infnet.model.service;

import br.edu.infnet.model.negocio.Diretoria;
import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.repository.DiretoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiretoriaService {

    @Autowired
    private DiretoriaRepository diretoriaRepository;

    public List<Diretoria> obterLista(Usuario usuario){
        return diretoriaRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC,"nome"));
    }

    public List<Diretoria> obterLista(){

        return (List<Diretoria>) diretoriaRepository.findAll();
    }

    public void incluir(Diretoria diretoria){

        diretoriaRepository.save(diretoria);

    }

    public void excluir(Integer id){

        diretoriaRepository.deleteById(id);
    }

    public Optional<Diretoria> obterPorId(Integer id){

        return diretoriaRepository.findById(id);
    }

    public int ObterQtde() {

        return (int) diretoriaRepository.count();
    }

}
