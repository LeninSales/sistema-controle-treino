package com.leninsales.controle_treino.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record RotinaDto(
        @NotBlank(message = "Nome da rotina não pode ser nulo.")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 a 100 caracteres.")
        String nome,

        List<RotinaExerciciosDto> exercicios) {
}
