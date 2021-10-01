package br.edu.infnet.controller;

import br.edu.infnet.model.negocio.Aluno;
import br.edu.infnet.model.negocio.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.service.ProfessorService;

import java.util.List;
import java.util.Optional;

@Controller
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;

	@GetMapping(value = "/professor/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		List<Professor> professores = professorService.obterLista(usuario);

		model.addAttribute("professores", professorService);

		return "/professor/lista";
	}	


	@GetMapping(value = "/professor")
	public String telaCadastro() {
		return "/professor/cadastro";
	}

	@PostMapping(value = "/professor/incluir")
	public String incluir(Model model, Professor professor, @SessionAttribute("user") Usuario usuario) {

		professor.setUsuario(usuario);

		professorService.incluir(professor);

		model.addAttribute("mensagem", "professor foi cadastrado com sucesso!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/escritorio/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Optional<Professor> professorExcluido = professorService.obterPorId(id);

		String msg = null;

		try {
			if(professorExcluido.isPresent()) {

				professorService.excluir(id);

				Professor professor = professorExcluido.get();

				msg = "professor  foi excluído com sucesso!";

			}
		} catch(Exception e){

			msg = "O professor não pode ser excluído";
		}

		model.addAttribute("mensagem", msg);

		return telaLista(model, usuario);
	}

}
