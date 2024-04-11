package br.com.fiap.main.model;

import br.com.fiap.main.controller.dto.aluno.StudentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;

    @ManyToMany
    private List<Course> courses = new ArrayList<>();

    public Student(StudentDTO studentDTO) {
        this.nome = studentDTO.nome();
        this.email = studentDTO.email();
    }
}
