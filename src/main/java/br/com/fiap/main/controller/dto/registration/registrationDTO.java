package br.com.fiap.main.controller.dto.registration;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.util.Date;

public record registrationDTO(
        @NotNull
        Long courseId,
        @NotNull
        Long studentId,
        @PastOrPresent
        Date registrationDate

) {
}
