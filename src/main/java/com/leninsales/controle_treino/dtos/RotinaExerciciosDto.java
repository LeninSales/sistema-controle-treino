package com.leninsales.controle_treino.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record RotinaExerciciosDto(

        @NotNull(message = "Necessário informar o ID da rotina.")
        Integer idRotina,

        @NotNull(message = "Necessário informar o ID do exercício.")
        Integer idExercicio,

        @NotNull(message = "Necessário informar quantas séries por exercício.")
        @Min(value = 1, message = "Deve ter no mínimo uma série.")
        Integer series,

        @NotBlank(message = "As repetições são obrigatórias.")
        String repeticoes,

        @NotNull(message = "A ordem de execução é obrigatória.")
        @Min(value = 1, message = "A ordem deve ser um número positivo.")
        Integer ordem
) {
}
// idrotina, idExercicio, series, repeticoes, e ordem