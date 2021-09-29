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
	private String idade;
	private boolean sexo;
	
	@ManyToOne
	@JoinColumn(name= "idUsuario")
	private Usuario usuario;
	
	@ManyToMany( mappedBy = "pessoas")
	private List <Instituicao> instituicao;

	public Pessoa() {
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


	public String getIdade() {
		return idade;
	}


	public void setIdade(String idade) {
		this.idade = idade;
	}


	public boolean isSexo() {
		return sexo;
	}


	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Instituicao> getInstituicao() {
		return instituicao;
	}


	public void setInstituicao(List<Instituicao> instituicao) {
		this.instituicao = instituicao;
	}
	
	

}
