package com.leninsales.controle_treino.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ExercicioDto(
        @NotNull(message ="Nome do exercicio não pode ser nulo.")
        @Size(min = 2, max = 100, message = "O exercicio deve ter entre 2 a 100 caracteres.")
        String nome
        ) {
}
