package br.com.fiap.main.model;

import br.com.fiap.main.controller.dto.course.CourseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Date initDate;

    @ManyToMany
    @JoinColumn(name = "teacher_id")
    @JsonIgnore
    private Teacher teacher;

    @ManyToMany
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Student student;

    @OneToMany
    @JoinColumn(name = "matter_id")
    @JsonIgnore
    private Matter matter;

    public Course(CourseDTO courseDTO){
        this.name = courseDTO.name();
        this.description = courseDTO.description();
        this.initDate = courseDTO.initDate();
        this.teacher = new Teacher(courseDTO.teacher());
        this.student = new Student(courseDTO.student());
        this.matter = new Matter(courseDTO.matter());
    }

    // Construtor
    public Course(String name, String description, Date initDate) {
        this.name = name;
        this.description = description;
        this.initDate = initDate;
    }
}
