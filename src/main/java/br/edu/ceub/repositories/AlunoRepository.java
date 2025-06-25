package br.edu.ceub.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ceub.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
 
    Aluno findByEmail(String email);
}   
