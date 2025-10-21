package com.leninsales.controle_treino.repositories;

import com.leninsales.controle_treino.models.RotinaExercicioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RotinaExercicioRepository extends JpaRepository<RotinaExercicioModel, Integer> {

    List<RotinaExercicioModel> findByIdRotina(Integer idRotina);
}
