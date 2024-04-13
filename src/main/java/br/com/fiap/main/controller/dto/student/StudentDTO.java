package br.com.fiap.main.controller.dto.student;

import br.com.fiap.main.controller.dto.course.CourseDTO;
import br.com.fiap.main.model.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;
import java.util.List;

public record StudentDTO(
        @NotBlank
        @Size(max = 100)
        String name,

        @NotNull
        Date birthDate,
        @NotBlank
        @Email
        String email,

        @NotNull
        Boolean residenceCountry,
        @NotBlank
        @CPF
        String cpf,
        @NotBlank
        String graduation,
        @NotNull
        Boolean fluencyLanguage,

        @NotNull
        List<CourseDTO> courses
) {
        public StudentDTO(Student student){
                this(student.getName(), student.getBirthDate(), student.getEmail(), student.getResidenceCountry(),
                        student.getCpf(), student.getGraduation(), student.getFluencyLanguage(),null);
        }
}
