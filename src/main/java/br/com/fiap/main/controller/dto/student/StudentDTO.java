package br.com.fiap.main.controller.dto.student;

import br.com.fiap.main.controller.dto.course.CourseDTO;
import br.com.fiap.main.model.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record StudentDTO(
        @NotBlank
        @Size(max = 100)
        String name,

        @NotBlank
        @Email
        String email,

        @NotNull
        List<CourseDTO> courses
) {
        public StudentDTO(Student student){
                this(student.getName(), student.getEmail(), null);
        }
}
