package br.com.fiap.main.model;

import br.com.fiap.main.controller.dto.curso.CourseDTO;
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
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private final LocalDate data_inicio = LocalDate.now();

    @ManyToMany(mappedBy = "cursos", cascade = CascadeType.MERGE)
    private List<Teacher> professores = new ArrayList<>();

    @ManyToMany(mappedBy = "cursos", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "curso", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Matter> matters = new ArrayList<>();

    public Course(CourseDTO courseDTO){
        this.nome = courseDTO.nome();
        this.descricao = courseDTO.descricao();
    }
}
