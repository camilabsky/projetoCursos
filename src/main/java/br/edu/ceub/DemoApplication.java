package br.edu.ceub;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.edu.ceub.entities.Aluno;
import br.edu.ceub.entities.Curso;
import br.edu.ceub.entities.Professor;
import br.edu.ceub.repositories.CursoRepository;
import br.edu.ceub.repositories.ProfessorRepository;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Cria professor
        Professor professor1 = new Professor();
        professor1.setNome("Dr. Smith");
        professor1.setEmail("smith@email.com");
        professor1.setDepartamento("Ciências da Computação");


        // Salva o professor no banco de dados
        professorRepository.save(professor1);

        // Cria alunos
        Aluno aluno1 = new Aluno();
        aluno1.setNome("Alice");
        aluno1.setEmail("Alice@email.com");

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Bob");
        aluno2.setEmail("Bob@email.com");

        // Cria curso
        Curso curso1 = new Curso(professor1, List.of(aluno1, aluno2));
        curso1.setNome("Spring Boot");
        curso1.setDescricao("Aprenda a desenvolver aplicações com Spring Boot");

        // Salva o curso no banco de dados
        cursoRepository.save(curso1);

        // Adiciona alunos ao curso
        curso1.getAlunos().add(aluno1);
        curso1.getAlunos().add(aluno2);


        // Exibe informações do curso
        System.out.println("Curso: " + curso1.getNome());
        System.out.println("Descrição: " + curso1.getDescricao());
        System.out.println("Professor: " + curso1.getProfessor().getNome());
        System.out.println("Alunos: ");
        for (Aluno aluno : curso1.getAlunos()) {
            System.out.println(" - " + aluno.getNome());
        }

        System.out.println("Application is running...");
    }
} 