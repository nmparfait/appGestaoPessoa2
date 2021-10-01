package br.edu.infnet.model.service;

import br.edu.infnet.model.negocio.Pessoa;
import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> obterLista(Usuario usuario){
        return (List<Pessoa>) pessoaRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC,"endereco"));
    }
    public List<Pessoa> obterLista(){
        return (List<Pessoa>) pessoaRepository.findAll();
    }

    public void excluir(Integer id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa obterPorId(Integer id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public int ObterQtde() {

        return (int) pessoaRepository.count();
    }
}

