package br.com.fiap.main.model;

import br.com.fiap.main.controller.dto.course.CourseDTO;
import br.com.fiap.main.controller.dto.teacher.TeacherDTO;
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
public class Teacher {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String specialty;

    @ManyToMany(mappedBy = "teachers", cascade = CascadeType.MERGE)
    private List<Course> courses = new ArrayList<>();

    public Teacher(TeacherDTO teacherDTO){
        this.name = teacherDTO.name();
        this.specialty = teacherDTO.specialty();

        List<CourseDTO> coursesDTO = teacherDTO.courses();

        for (CourseDTO courseDTO : coursesDTO){
            Course course = new Course(courseDTO.name(), courseDTO.description(), courseDTO.initDate());
            course.setTeacher(this);
            courses.add(course);
        }
    }
}

