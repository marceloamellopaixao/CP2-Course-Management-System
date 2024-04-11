package br.com.fiap.main.controller.dto.matter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MatterDTO(

        @NotBlank
        @Size(max = 100)
        String name,

        @Size(max = 500)
        String description
) {
}
