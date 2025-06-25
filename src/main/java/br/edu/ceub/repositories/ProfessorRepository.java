package br.edu.ceub.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ceub.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    // Métodos adicionais de consulta podem ser definidos aqui, se necessário
    // Por exemplo, para buscar professores por nome ou email
    Professor findByEmail(String email);
}
