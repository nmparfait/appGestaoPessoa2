package br.edu.infnet.model.service;

import br.edu.infnet.client.IEnderecoClient;
import br.edu.infnet.model.negocio.Endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EnderecoService {

    @Autowired
    IEnderecoClient enderecoClient;

    public Endereco obterCep(String cep) {

        return enderecoClient.obterCep(cep);
    }

}
