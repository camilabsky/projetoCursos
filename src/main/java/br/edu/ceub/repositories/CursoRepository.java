package br.edu.ceub.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ceub.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}

