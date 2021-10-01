package br.edu.infnet.controller;

import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.service.AlunoService;
import br.edu.infnet.model.negocio.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;
import java.util.Optional;


@Controller
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;

	@GetMapping(value = "/aluno/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		List<Aluno> alunos = alunoService.obterLista(usuario);

		model.addAttribute("alunos", alunos);

		return "/aluno/lista";
	}
	
	@GetMapping(value = "/aluno")
	public String telaCadastro() {
		return "/aluno/cadastro";
	}
	
	@PostMapping(value = "/aluno/incluir")
	public String incluir(Model model, Aluno aluno, @SessionAttribute("user") Usuario usuario) {

		aluno.setUsuario(usuario);
		
		alunoService.incluir(aluno);
		
		model.addAttribute("msg", "Aluno " + aluno.getNome() + " cadastrado com sucesso!!!");
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/aluno/{id}/excluir")
	public String excluir (Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Optional<Aluno> alunoExcluido = alunoService.obterPorId(id);

		String msg = null;

			try {

				if(alunoExcluido.isPresent()) {
					alunoService.excluir(id);
					Aluno aluno = alunoExcluido.get();
					msg = "aluno excluido com sucesso!";

				}

			} catch (Exception e) {
					msg = "O aluno nao pode ser excluido";
				}
				model.addAttribute("mensagem", msg);
				return telaLista(model, usuario);
			}
	}
	


