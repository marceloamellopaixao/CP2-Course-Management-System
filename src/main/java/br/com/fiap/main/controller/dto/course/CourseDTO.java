package br.com.fiap.main.controller.dto.course;

import br.com.fiap.main.controller.dto.student.StudentDTO;
import br.com.fiap.main.controller.dto.matter.MatterDTO;
import br.com.fiap.main.controller.dto.teacher.TeacherDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record CourseDTO(

        @NotBlank
        @Size(max = 150)
        String name,

        @Size(max = 1000)
        String description,
        @FutureOrPresent
        Date initDate,

        @NotNull @JsonIgnore
        TeacherDTO teacher,

        @NotNull @JsonIgnore
        StudentDTO student,

        @NotNull @JsonIgnore
        MatterDTO matter
) {
}
