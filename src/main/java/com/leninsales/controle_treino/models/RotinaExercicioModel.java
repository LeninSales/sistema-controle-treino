package com.leninsales.controle_treino.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rotina_exercicio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//adicionar as validaçoes nos atributos para nao ter models anemicos
public class RotinaExercicioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRotinaExercicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rotina", nullable = false)
    private RotinaModel rotina;

    @NotNull(message = "O id do exercicio precisa ser informado.")
    private Integer idExercicio;

    private Integer series;

    private String repeticoes;

    private Integer ordem;

}
