package com.leninsales.controle_treino.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record RotinaCadastroDto(
        @NotBlank(message = "Nome da rotina não pode ser nulo.")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 a 100 caracteres.")
        String nome,



        @NotNull(message = "A lista de exercicio não pode ser nula.")
        @Size(min = 1, message = "A lista deve conter no minimo um exercicio.")
        List<RotinaExerciciosCadrastoDto> exercicios) {
}