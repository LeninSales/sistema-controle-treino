package com.leninsales.controle_treino.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ExercicioDto(
        @NotBlank(message ="Nome do exercicio não pode ser nulo.")
        @Size(min = 2, max = 100, message = "O exercicio deve ter entre 2 a 100 caracteres.")
        String nome
        ) {
}
