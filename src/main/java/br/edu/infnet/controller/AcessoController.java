package br.edu.infnet.controller;

import javax.servlet.http.HttpSession;

import br.edu.infnet.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.model.negocio.Usuario;

@SessionAttributes("user")
@Controller
public class AcessoController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private DiretoriaService diretoriaService;

	@Autowired
	private ProfessorService professorService;

	@Autowired
	private InstituicaoService instituicaoService;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private AdministrativoService administrativoService;

	@Autowired
	private PessoaService pessoaService;

	@GetMapping(value = "/")
	public String telaHome() {
		return "/index";
	}

	@GetMapping(value = "/login")
	public String telaLogin() {
		return "/login";
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("user");
		return "redirect:/";
	}

	@PostMapping(value = "/login")
	public String telaHome(Model model, @RequestParam String email, @RequestParam String senha) {

		Usuario usuario = usuarioService.validar(email, senha);

		if (usuario != null) {
			model.addAttribute("user", usuario);
			return "/index";
		} else {
			model.addAttribute("mensagem", "Autenticação inválida para o usuario " + email + "!");
			return "/login";
		}
	}
}
