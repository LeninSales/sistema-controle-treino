package com.leninsales.controle_treino.repositories;

import com.leninsales.controle_treino.dtos.RotinaListagemDto;
import com.leninsales.controle_treino.models.RotinaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface RotinaRepository extends JpaRepository<RotinaModel, Integer> {
    List<RotinaListagemDto> findRotinaListagemDtoByIdUsuario(UUID idUsuario);

    List<RotinaModel> findByIdUsuario(UUID idUsuario);
}
