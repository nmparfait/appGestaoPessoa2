package br.edu.infnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.service.ProfessorService;

@Controller
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;

	@GetMapping(value = "/professor/lista")
	public String showLista(Model model, @SessionAttribute("user") Usuario usuario) {

		if (usuario.isAdmin()) {
			model.addAttribute("professores", professorService.obterLista());
			
		} else {
			model.addAttribute("professores", professorService.obterLista(usuario));
		}
		return "professor/lista";
	}	
	
	@GetMapping(value = "/professor")
	public String showCadastro() {
		return "professor/cadastro";
	}
	
	
}
