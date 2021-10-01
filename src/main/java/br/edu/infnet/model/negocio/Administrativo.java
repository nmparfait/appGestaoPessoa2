package br.edu.infnet.model.negocio;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tAdministrativo")
public class Administrativo extends Pessoa{
	
	private String departamento;
	private float salario;
	private Integer tempoEmpresa;
	

	public Administrativo() {
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Integer getTempoEmpresa() {
		return tempoEmpresa;
	}

	public void setTempoEmpresa(Integer tempoEmpresa) {
		this.tempoEmpresa = tempoEmpresa;
	}
	
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append(this.departamento);
		sb.append(";");
		sb.append(this.salario);
		sb.append(";");
		sb.append(this.tempoEmpresa);
		sb.append(";");

		return sb.toString();
	}
}
