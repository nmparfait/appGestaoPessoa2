package br.edu.infnet.model.negocio;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="tAluno")
public class Aluno extends Pessoa{
	
	
	private float mensalidade;
	private String turma;
	private String atividadeFisica;

	public Aluno() {
	}

	public float getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(float mensalidade) {
		this.mensalidade = mensalidade;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getAtividadeFisica() {
		return atividadeFisica;
	}

	public void setAtividadeFisica(String atividadeFisica) {
		this.atividadeFisica = atividadeFisica;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(this.mensalidade);
		sb.append(";");
		sb.append(this.turma);
		sb.append(";");
		sb.append(this.atividadeFisica);
		sb.append(";");

		return sb.toString();
	}

}
