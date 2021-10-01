package br.edu.infnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.model.negocio.Endereco;
import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.service.InstituicaoService;
import br.edu.infnet.model.service.UsuarioService;

import java.util.Optional;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value= "/usuario")
    public String telaCadastro(){
        return "/usuario/cadastro";
    }

    @PostMapping(value = "/usuario")
    public String incluir(Usuario usuario, Endereco endereco) {
        usuario.setEndereco(endereco);
        usuarioService.incluir(usuario);
        return "/index";
    }


    @GetMapping(value="/usuario/lista")
    public String telaLista(Model model) {

        model.addAttribute("lista", usuarioService.obterLista());
        return "usuario/lista";
    }

    @GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {

        Optional<Usuario> usuarioExcluido = usuarioService.obterPorId(id);
        String msg = "A diretoria não pode ser excluida";
        if(usuarioExcluido.isPresent()){
            usuarioService.excluir(id);
            Usuario usuario = usuarioExcluido.get();
            msg = "O (a) usuario (a) " + usuario.getNome() + " foi excluído(a) com sucesso!";
        }
        model.addAttribute("mensagem", msg);
        return telaLista(model);

    }
    

}
