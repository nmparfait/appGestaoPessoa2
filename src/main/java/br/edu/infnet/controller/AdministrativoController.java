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

import java.util.List;
import java.util.Optional;


@Controller
public class AdministrativoController {
	
	@Autowired
	private AdministrativoService administrativoService;

	@GetMapping(value = "/administrativo/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		List<Administrativo> administrativos = administrativoService.obterLista(usuario);

		model.addAttribute("administrativos", administrativos);

		return "/administrativo/lista";
	}	
	
	@GetMapping(value = "/administrativo")
	public String telaCadastro() {
		return "/administrativo/cadastro";
	}
	
	@PostMapping(value = "/administrativo/incluir")
	public String incluir(Model model, Administrativo administrativo, @SessionAttribute("user") Usuario usuario) {

		administrativo.setUsuario(usuario);
		
		administrativoService.incluir(administrativo);
		
		model.addAttribute("msg", "Administrativo " + administrativo.getNome() + " cadastrado com sucesso!!!");
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/administrativo/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Optional<Administrativo> administrativoExcluido = administrativoService.obterPorId(id);


		String msg = null;

		try {

			if(administrativoExcluido.isPresent()) {

				administrativoService.excluir(id);

				Administrativo administrativo = administrativoExcluido.get();

				msg = "Administrativo foi excluída com sucesso!";

			}
		}catch (Exception e) {

			msg = "Administrativo não pode ser excluída";
		}

		model.addAttribute("mensagem", msg);

		return telaLista(model, usuario);
	}

}
