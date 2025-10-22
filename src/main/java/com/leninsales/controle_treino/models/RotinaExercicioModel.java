package com.leninsales.controle_treino.models;

import jakarta.persistence.*;
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


public class RotinaExercicioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRotinaExercicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rotina", nullable = false)
    private RotinaModel rotina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_exercicio", nullable = false)
    private ExercicioModel exercicio;

    private Integer series;

    private String repeticoes;

    private Integer ordem;

}
