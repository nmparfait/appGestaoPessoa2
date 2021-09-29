package br.edu.infnet.model.negocio;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "TInstituicao")
public class Instituicao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	private String telefone;
	private String endereco;
	
	@OneToOne (cascade = CascadeType.DETACH)
	@JoinColumn(name = "idProfessor")
	private Professor professor;
	
	@OneToOne (cascade = CascadeType.DETACH)
	@JoinColumn(name = "idAdministrativo")
	private Administrativo administrativo;
	
	@OneToMany (cascade = CascadeType.DETACH)
	private List<Aluno> alunos;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	public List<Pessoa> pessoas;
	@ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

	public Instituicao() {
		// TODO Auto-generated constructor stub
	}
	
	public Instituicao(String nome) {
		this();
        this.nome = nome;
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

	public Professor getProfessor() {
        return professor;
    }
	public void setProfessor(Professor obterPorId) {
		// TODO Auto-generated method stub
		this.professor = professor;
		
	}

	public Administrativo getAdministrativo() {
        return administrativo;
    }
	
	public void setAdministrativo(Administrativo obterPorId) {
		// TODO Auto-generated method stub
		this.administrativo = administrativo;
	}

	public List<Aluno> getAlunos() {
        return alunos;
    }
	
	public void setAlunos(List<Aluno> alunos) {
		// TODO Auto-generated method stub
		this.alunos = alunos;
		
	}

	
}
