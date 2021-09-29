package br.edu.infnet.controller;

import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.negocio.Administrativo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.model.service.AdministrativoService;


@Controller
public class AdministrativoController {
	
	@Autowired
	private AdministrativoService administrativoService;

	@GetMapping(value = "/administrativo/lista")
	public String showLista(Model model, @SessionAttribute("user") Usuario usuario) {

		if (usuario.isAdmin()) {
			model.addAttribute("administrativo", administrativoService.obterLista());
		} else {
			model.addAttribute("administrativos", administrativoService.obterLista(usuario));
		}
		
		return "administrativo/lista";
	}	
	
	@GetMapping(value = "/administrativo")
	public String showCadastro() {
		return "administrativo/cadastro";
	}
	
	@PostMapping(value = "/administrativo/incluir")
	public String incluir(Model model, Administrativo administrativo, @SessionAttribute("user") Usuario usuario) {

		administrativo.setUsuario(usuario);
		
		administrativoService.incluir(administrativo);
		
		model.addAttribute("msg", "Administrativo " + administrativo.getNome() + " cadastrado com sucesso!!!");
		
		return showLista(model, usuario);
	}
	
	@GetMapping(value = "/administrativo/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Administrativo  administrativo = administrativoService.obterPorId(id);
		
		administrativoService.excluir(id);
		
		model.addAttribute("msg", "administrativo " + administrativo.getNome() + " removido com sucesso!!!");
		
		return showLista(model, usuario);
	}
	
}
