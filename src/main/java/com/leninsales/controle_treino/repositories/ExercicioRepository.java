package com.leninsales.controle_treino.repositories;

import com.leninsales.controle_treino.models.ExercicioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepository extends JpaRepository <ExercicioModel, Integer> {

}
