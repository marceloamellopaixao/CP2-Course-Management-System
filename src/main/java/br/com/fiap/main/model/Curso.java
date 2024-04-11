package br.com.fiap.main.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private final LocalDate data_inicio = LocalDate.now();

    @ManyToMany(mappedBy = "professores", cascade = CascadeType.MERGE)
    private List<Professor> professores = new ArrayList<>();

    @ManyToMany(mappedBy = "cursos", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Aluno> alunos = new ArrayList<>();

    @OneToMany(mappedBy = "curso", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Materia> materias = new ArrayList<>();
}
