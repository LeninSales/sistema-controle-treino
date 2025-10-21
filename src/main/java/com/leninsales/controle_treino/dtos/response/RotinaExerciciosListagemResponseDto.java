package com.leninsales.controle_treino.dtos.response;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record RotinaExerciciosListagemResponseDto(



       String nomeexercicio,


        Integer series,

        String repeticoes,

        Integer ordem
) {
}