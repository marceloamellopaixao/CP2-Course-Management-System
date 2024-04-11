package br.com.fiap.main.controller.dto.professor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TeacherDTO(
        @NotBlank
        @Size(max = 100)
        String nome,

        @NotBlank
        String especialidade
) {
}
