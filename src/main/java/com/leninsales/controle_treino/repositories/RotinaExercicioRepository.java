package com.leninsales.controle_treino.repositories;

import com.leninsales.controle_treino.models.RotinaExercicioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RotinaExercicioRepository extends JpaRepository<RotinaExercicioModel, Integer> {

    List<RotinaExercicioModel> findByIdRotina(Integer idRotina);
}
