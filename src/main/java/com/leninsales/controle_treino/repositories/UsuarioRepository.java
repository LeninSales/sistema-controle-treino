package com.leninsales.controle_treino.repositories;

import com.leninsales.controle_treino.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository <UsuarioModel, UUID> {
}
