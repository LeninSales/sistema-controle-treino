package com.leninsales.controle_treino.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



public record RotinaDto(
        @NotBlank(message = "Nome da rotina não pode ser nulo.")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 a 100 caracteres.")
        String nome
 ) {
}
