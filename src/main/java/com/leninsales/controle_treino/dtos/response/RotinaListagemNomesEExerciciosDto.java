package com.leninsales.controle_treino.dtos.response;

import java.util.List;

public record RotinaListagemNomesEExerciciosDto(

         Integer idRotina,

        String nome,

        List<RotinaExerciciosListagemResponseDto> exercicios
) {
}
