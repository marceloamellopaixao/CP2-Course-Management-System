package br.com.fiap.main.model;

import br.com.fiap.main.controller.dto.student.StudentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date birthDate;
    private String email;
    private String

    @ManyToMany(mappedBy = "students", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Course> courses = new ArrayList<>();

    public Student(StudentDTO studentDTO) {
        this.name = studentDTO.name();
        this.email = studentDTO.email();
    }
}
