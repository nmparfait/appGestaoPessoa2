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

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private InstituicaoService instituicaoService;

    @GetMapping(value= "/usuario")
    public String showCadastro(){
        return "usuario/cdastro";
    }

    @GetMapping(value="/usuario/lista")
    public String showLista(Model model) {

        model.addAttribute("lista", usuarioService.obterLista());

        model.addAttribute("instituicoes", instituicaoService.obterLista());

        return "usuario/lista";
    }

    @GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {

		usuarioService.excluir(id);
		
		return "redirect:/usuario/lista";
	}
    
    @PostMapping(value = "/usuario")
	public String incluir(Usuario usuario, Endereco endereco) {
		
		usuario.setEndereco(endereco);
		
		usuarioService.incluir(usuario);
		
		return "redirect:/";
	}
}
