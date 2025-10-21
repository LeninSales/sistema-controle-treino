package com.leninsales.controle_treino.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "rotina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RotinaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRotina;

    private UUID idUsuario;

    private String nome;

    @OneToMany(
            cascade = CascadeType.ALL, // <<< ESTE É O SEGREDO
            fetch = FetchType.LAZY,
            mappedBy = "rotina",
            orphanRemoval = true
    )
    private List<RotinaExercicioModel> exercicios;
}
