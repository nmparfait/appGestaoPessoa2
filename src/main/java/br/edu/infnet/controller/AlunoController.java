package br.edu.infnet.controller;

import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.service.AlunoService;
import br.edu.infnet.model.negocio.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;

	@GetMapping(value = "/aluno/lista")
	public String showLista(Model model, @SessionAttribute("user") Usuario usuario) {

		if (usuario.isAdmin()) {
			model.addAttribute("alunos", alunoService.obterLista());
		} else {
			model.addAttribute("alunos", alunoService.obterLista(usuario));
		}
		
		return "aluno/lista";
	}	
	
	@GetMapping(value = "/aluno")
	public String telaCadastro() {
		return "aluno/cadastro";
	}
	
	@PostMapping(value = "/aluno/incluir")
	public String incluir(Model model, Aluno aluno, @SessionAttribute("user") Usuario usuario) {

		aluno.setUsuario(usuario);
		
		alunoService.incluir(aluno);
		
		model.addAttribute("msg", "Aluno " + aluno.getNome() + " cadastrado com sucesso!!!");
		
		return showLista(model, usuario);
	}
	
	
	

}
