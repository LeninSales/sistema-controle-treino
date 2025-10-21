package com.leninsales.controle_treino.repositories;

import com.leninsales.controle_treino.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioModel, UUID> {
}
