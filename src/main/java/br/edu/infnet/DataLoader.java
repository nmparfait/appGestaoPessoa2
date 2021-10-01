package br.edu.infnet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.service.UsuarioService;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNome("parfait");
		usuario.setEmail("parfait@nmp.com");
		usuario.setSenha("12345");
		usuario.setAdmin(true);
		
		usuarioService.incluir(usuario);

		System.out.println("Incluir usuario " + usuario.getNome() + " realizada!");
	}
}
