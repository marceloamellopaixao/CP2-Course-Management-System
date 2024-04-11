package br.com.fiap.main.controller.dto.aluno;

import br.com.fiap.main.model.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StudentDTO(
        @NotBlank
        @Size(max = 100)
        String nome,

        @NotBlank
        @Email
        String email
) {
}
