package com.leninsales.controle_treino.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "rotina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RotinaModel {

    private Integer idRotina;

    private UUID idUsuario;

    private String nome;


}
