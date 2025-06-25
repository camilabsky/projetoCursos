
package br.edu.ceub.entities;

import java.util.List;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nome;
    private String Descricao;
    

    @ManyToOne
    private Professor professor;
    private List<Aluno> alunos;

    public Curso(Professor professor, List<Aluno> alunos) {
        if (professor == null) {
            throw new IllegalArgumentException("Professor não pode ser nulo.");
        }
        if (alunos == null || alunos.isEmpty()) {
            throw new IllegalArgumentException("Deve haver pelo menos um aluno.");
        }
        this.professor = professor;
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setProfessor(Professor professor) {
        this.professor = Objects.requireNonNull(professor);
    }

    public void setAlunos(List<Aluno> alunos) {
        if (alunos == null || alunos.isEmpty()) {
            throw new IllegalArgumentException("Deve haver pelo menos um aluno.");
        }
        this.alunos = alunos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}