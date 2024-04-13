package br.com.fiap.main.controller.dto.teacher;

import br.com.fiap.main.controller.dto.course.CourseDTO;
import br.com.fiap.main.model.Teacher;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record TeacherDTO(
        @NotNull
        Long id,
        @NotBlank
        @Size(max = 100)
        String name,

        @NotBlank
        String specialty,

        @NotNull
        List<CourseDTO> courses
) {
        public TeacherDTO(Teacher teacher){
                this(teacher.getId(), teacher.getName(), teacher.getSpecialty(), null);
        }
}
