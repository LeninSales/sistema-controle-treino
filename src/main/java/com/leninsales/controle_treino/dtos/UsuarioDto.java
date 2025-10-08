package com.leninsales.controle_treino.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record UsuarioDto(
        @NotNull(message = "Nome não pode ser nulo.")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 a 100 caracteres.")
        String nome
) {
}
