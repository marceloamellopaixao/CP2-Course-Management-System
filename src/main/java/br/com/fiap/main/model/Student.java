package br.com.fiap.main.model;

import br.com.fiap.main.controller.dto.course.CourseDTO;
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
    private Boolean residenceCountry;
    private String cpf;
    private String graduation;
    private Boolean fluencyLanguage;


    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();

    public Student(StudentDTO studentDTO) {
        this.name = studentDTO.name();
        this.birthDate = studentDTO.birthDate();
        this.email = studentDTO.email();
        this.residenceCountry = studentDTO.residenceCountry();
        this.cpf = studentDTO.cpf();
        this.graduation = studentDTO.graduation();
        this.fluencyLanguage = studentDTO.fluencyLanguage();

        List<CourseDTO> coursesDTO = studentDTO.courses();

        for (CourseDTO courseDTO : coursesDTO) {
            Course course = new Course(courseDTO.name(), courseDTO.description(), courseDTO.initDate());
            course.setStudent(this);
            courses.add(course);
        }
    }
}
