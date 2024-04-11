package br.com.fiap.main.controller.dto.materia;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MatterDTO(

        @NotBlank
        @Size(max = 100)
        String nome,

        @Size(max = 500)
        String descricao
) {
}
