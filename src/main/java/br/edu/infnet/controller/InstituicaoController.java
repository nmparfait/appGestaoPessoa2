package br.edu.infnet.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.model.negocio.Aluno;
import br.edu.infnet.model.negocio.Instituicao;
import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.service.AdministrativoService;
import br.edu.infnet.model.service.AlunoService;
import br.edu.infnet.model.service.InstituicaoService;
import br.edu.infnet.model.service.ProfessorService;

@Controller
public class InstituicaoController {
	
	@Autowired
	private InstituicaoService instituicaoService;
	@Autowired
	private AlunoService alunoService;
	@Autowired
	private ProfessorService professorService;
	@Autowired
	private AdministrativoService administrativoService;

	@GetMapping(value = "/instituicao/lista")
	public String showLista(Model model, @SessionAttribute("user") Usuario usuario) {

		if (usuario.isAdmin()) {
			model.addAttribute("instituicaos", instituicaoService.obterLista());
		} else {
			model.addAttribute("instituicaos", instituicaoService.obterLista(usuario));
		}
		
		return "instituicao/lista";
	}	
	
	@GetMapping(value = "/instituicao")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {

		if (usuario.isAdmin()) {
			model.addAttribute("alunos", alunoService.obterLista());
			model.addAttribute("professores", professorService.obterLista());
			model.addAttribute("administrativos", administrativoService.obterLista());
		} else {
			model.addAttribute("alunos", alunoService.obterLista(usuario));
			model.addAttribute("professors", professorService.obterLista(usuario));
			model.addAttribute("administrativos", administrativoService.obterLista(usuario));
		}

		return "instituicao/cadastro";
	}
	
	@PostMapping(value = "/instituicao/incluir")
	public String incluir(Model model, Instituicao instituicao, @RequestParam String[] alunosId, @RequestParam String professor, @RequestParam String administrativo, @SessionAttribute("user") Usuario usuario) {

		instituicao.setProfessor(professorService.obterPorId(Integer.valueOf(professor)));
		instituicao.setAdministrativo(administrativoService.obterPorId(Integer.valueOf(administrativo)));

		List<Aluno> alunos = new ArrayList<Aluno>();
		for(String id : alunosId) {
			alunos.add(alunoService.obterPorId(Integer.valueOf(id)));
		}
		
		instituicao.setAlunos(alunos);

		instituicao.setUsuario(usuario);

		instituicaoService.incluir(instituicao);
		
		model.addAttribute("msg", "Instituicao " + instituicao.getNome() + " cadastrado com sucesso!!!");
		
		return showLista(model, usuario);
	}
	
	@GetMapping(value = "/instituicao/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Instituicao instituicao = instituicaoService.obterPorId(id);
		
		instituicaoService.excluir(id);
		
		model.addAttribute("msg", "Instituicao " + instituicao.getNome() + " removido com sucesso!!!");
		
		return showLista(model, usuario);
	}
}