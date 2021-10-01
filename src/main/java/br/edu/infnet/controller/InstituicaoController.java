package br.edu.infnet.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.edu.infnet.model.negocio.*;
import br.edu.infnet.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class InstituicaoController {
	
	@Autowired
	private InstituicaoService instituicaoService;

	@Autowired
	private DiretoriaService diretoriaService;

	@Autowired
	private PessoaService pessoaService;

	@GetMapping(value = "/instituicao/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("instituicoes", instituicaoService.obterLista(usuario));
		return "/instituicao/lista";
	}
	
	@GetMapping(value = "/instituicao")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("diretorias", diretoriaService.obterLista(usuario));

		model.addAttribute("pessoas", pessoaService.obterLista(usuario));

		return "/instituicao/cadastro";
	}

	@PostMapping(value = "/instituicao/incluir")
	public String incluir(Model model, Instituicao instituicao, @RequestParam String[] pessoasId,
						  @SessionAttribute("user") Usuario usuario) {

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		for (String id : pessoasId) {
			pessoas.add(pessoaService.obterPorId(Integer.valueOf(id)));
		}

		instituicao.setPessoas(pessoas);

		instituicao.setUsuario(usuario);

		instituicaoService.incluir(instituicao);

		String mensagem = "A instituição  " + instituicao.getNome() + " foi cadastrada com sucesso!";

		model.addAttribute("msg", mensagem);

		return telaLista(model, usuario);
	}


	@GetMapping(value = "/imobiliaria/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Optional<Instituicao> instituicaoExcluida = instituicaoService.obterPorId(id);

		String msg = "A instituição não pode ser excluída";

		if (instituicaoExcluida.isPresent()) {

			instituicaoService.excluir(id);

			Instituicao instituicao = instituicaoExcluida.get();

			msg = "A instituicao " + instituicao.getNome() + " foi excluída com sucesso!";
		}

		model.addAttribute("mensagem", msg);

		return telaLista(model, usuario);

	}


}