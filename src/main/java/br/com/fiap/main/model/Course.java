package br.com.fiap.main.model;

import br.com.fiap.main.controller.dto.course.CourseDTO;
import br.com.fiap.main.controller.dto.matter.MatterDTO;
import br.com.fiap.main.controller.dto.teacher.TeacherDTO;
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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "matter_id")
    @JsonIgnore
    private Matter matter;

    public Course(CourseDTO courseDTO){
        this.name = courseDTO.name();
        this.description = courseDTO.description();
        this.initDate = courseDTO.initDate();
    }

    public Course(String name, String description, Date initDate) {
        this.name = name;
        this.description = description;
        this.initDate = initDate;
    }
}
