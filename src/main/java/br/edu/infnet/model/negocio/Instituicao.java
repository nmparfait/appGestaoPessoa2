package br.edu.infnet.model.negocio;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "tInstituicao")
public class Instituicao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	private String telefone;
	private String endereco;
	
	@OneToOne (cascade = CascadeType.DETACH)
	@JoinColumn(name = "idDiretoria")
	private Diretoria diretoria;

	@ManyToMany(cascade = CascadeType.DETACH)
	public List<Pessoa> pessoas;

	@ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

	public Instituicao() {
		// TODO Auto-generated constructor stub
	}
	
	public Instituicao(Integer id, String nome, String telefone, String endereco, Diretoria diretoria,
					   List<Pessoa> pessoas, Usuario usuario ) {
		this.id = id;
        this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.diretoria = diretoria;
		this.pessoas = pessoas;
		this.usuario = usuario;
	}

	public List<Pessoa> getPessoas() {
        return pessoas;
    }
	
	public void setPessoas(List<Pessoa> pesoas) {
        this.pessoas = pessoas;
    }
	
	public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Diretoria getDiretoria() {
		return diretoria;
	}

	public void setDiretoria(Diretoria diretoria) {
		this.diretoria = diretoria;
	}


	
}
