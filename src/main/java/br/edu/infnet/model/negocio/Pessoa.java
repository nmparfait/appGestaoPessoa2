package br.edu.infnet.model.negocio;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tPessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private Integer idade;
	private boolean sexo;
	private String endereco;
	
	@ManyToOne
	@JoinColumn(name= "idUsuario")
	private Usuario usuario;
	@ManyToMany( mappedBy = "pessoas")
	private List <Instituicao> instituicoes;

	public Pessoa() {
	}

	public Pessoa(Integer id, String nome, String email, int idade, boolean sexo, String endereco,
				  Usuario usuario, List<Instituicao> instituicoes) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.sexo = sexo;
		this.endereco = endereco;
		this.instituicoes = instituicoes;

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


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public boolean isSexo() {
		return sexo;
	}


	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}


	public void setInstituicoes(List<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}


}
