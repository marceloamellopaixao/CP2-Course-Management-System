package br.com.fiap.main.controller.dto.registration;

import br.com.fiap.main.model.Course;
import br.com.fiap.main.model.Registration;
import br.com.fiap.main.model.Student;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.util.Date;

public record RegistrationDTO(
        @NotNull
        Course courseId,
        @NotNull
        Student studentId,
        @PastOrPresent
        Date registrationDate

) {
}
