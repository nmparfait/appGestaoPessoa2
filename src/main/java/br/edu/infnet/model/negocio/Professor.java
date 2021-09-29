package br.edu.infnet.model.negocio;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "tProfessor")
public class Professor  extends Pessoa{
	
	private String turma;
	private float salario;
	private String diploma;

	public Professor() {
		super();
	}
	
	@Override
	public String toString() {
		StringBuilder pr1 = new StringBuilder();
		pr1.append(super.toString());
		pr1.append("; ");
		pr1.append(this.turma);
		pr1.append("; ");
		pr1.append(this.salario);
		pr1.append("; ");
		pr1.append(this.diploma);
		pr1.append("");
		return pr1.toString();
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getDiploma() {
		return diploma;
	}

	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}


}
