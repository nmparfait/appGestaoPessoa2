package br.edu.infnet.model.negocio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tUsuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
		private Integer id;
		private String nome;
		private String email;
		private String senha;
		private boolean admin;
		
		@OneToOne(cascade = CascadeType.PERSIST)
		@JoinColumn(name = "idEndereco")
		private Endereco endereco;
		@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
		@JoinColumn(name = "idUsuario")
		private List<Diretoria> diretorias;
		@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
		@JoinColumn(name = "idUsuario")
		private List<Pessoa> pessoas;
		@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
		@JoinColumn(name = "idUsuario")
		private List<Instituicao> instituicoes;
		
		public Usuario(){
			
		}
		
		public Usuario(String email, String senha) {
			this.email = email;
			this.senha = senha;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}
		
		public Endereco getEndereco() {
			return endereco;
		}
		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}

		public boolean isAdmin() {
			return admin;
		}

		public void setAdmin(boolean admin) {
			this.admin = admin;
		}

		public List<Diretoria> getPDiretorias() {
			return diretorias;
		}

		public void setDiretorias(List<Diretoria> diretoria) {
			this.diretorias = diretorias;
		}

		public List<Pessoa> getPessoas() {
			return pessoas;
		}

		public void setPessoas(List<Pessoa> pessoas) {
			this.pessoas = pessoas;
		}


		public List<Instituicao> getInstituicoes() {
			return instituicoes;
		}

		public void setInstituicoes(List<Instituicao> instituicoes) {
			this.instituicoes = instituicoes;
		}
	
	
}
