package br.edu.infnet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import br.edu.infnet.model.negocio.Administrativo;
import br.edu.infnet.model.negocio.Aluno;
import br.edu.infnet.model.negocio.Professor;
import br.edu.infnet.model.service.AdministrativoService;
import br.edu.infnet.model.service.AlunoService;
import br.edu.infnet.model.service.ProfessorService;

public class GestaoLoader implements ApplicationRunner {
	
	@Autowired
	private ProfessorService professorService;
	@Autowired
	private AdministrativoService administrativoService;
	@Autowired
	private AlunoService alunoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		Professor prof1 = new Professor();
		prof1.setNome("Elberth ");
		professorService.incluir(prof1);
		
		Professor prof2 = new Professor();
		prof2.setNome("Armenio ");
		professorService.incluir(prof2);

		Administrativo escritorio1 = new Administrativo ();
		escritorio1.setNome("Luana");
		administrativoService.incluir(escritorio1);
		
		Administrativo escritorio2 = new Administrativo ();
		escritorio2.setNome("Bruna");
		administrativoService.incluir(escritorio2);
		
		
		Aluno al1 = new Aluno();
		al1.setNome("Ruth");
		alunoService.incluir(al1);
		
		Aluno al2 = new Aluno();
		al2.setNome("Stephane");
		alunoService.incluir(al2);
		
		Aluno al3 = new Aluno();
		al3.setNome("Rodrigo");
		alunoService.incluir(al3);
		
		Aluno al4 = new Aluno();
		al4.setNome("Gabriela");
		alunoService.incluir(al4);
		
		Aluno al5 = new Aluno();
		al5.setNome("Alfonso");
		alunoService.incluir(al5);
		


		System.out.println(" Pessoas incluidas com sucesso:");
		for(Aluno j : alunoService.obterLista()) {
			System.out.println(j.getNome());
		}
		System.out.println(escritorio1.getNome());
		System.out.println(prof1.getNome());
		System.out.println(al5.getNome());

	}


}
