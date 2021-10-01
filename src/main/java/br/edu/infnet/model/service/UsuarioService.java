package br.edu.infnet.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> obterLista(){
		return (List<Usuario>) usuarioRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}

	public Optional<Usuario> obterPorId(Integer id){

		return usuarioRepository.findById(id);
	}


	public Usuario validar(String email, String senha) {

		return usuarioRepository.autenticacao(email, senha);
	}

	public void incluir(Usuario usuario) {

		usuarioRepository.save(usuario);
	}
	
	public void excluir(Integer id) {

		usuarioRepository.deleteById(id);
	}

	public int ObterQtde() {
		return (int) usuarioRepository.count();
	}
	

}
