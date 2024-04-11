package br.com.fiap.main.controller.dto.curso;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CourseDTO(

        @NotBlank
        @Size(max = 150)
        String nome,

        @Size(max = 1000)
        String descricao,
        @FutureOrPresent
        LocalDate data_inicio
) {
}
