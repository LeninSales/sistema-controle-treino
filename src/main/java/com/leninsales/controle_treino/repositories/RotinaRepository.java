package com.leninsales.controle_treino.repositories;

import com.leninsales.controle_treino.dtos.RotinaListagemDto;
import com.leninsales.controle_treino.models.RotinaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RotinaRepository extends JpaRepository<RotinaModel, Integer> {
    List<RotinaListagemDto> findRotinaListagemDtoByIdUsuario(UUID idUsuario);
}
