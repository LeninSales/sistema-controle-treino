package com.leninsales.controle_treino.services;

import com.leninsales.controle_treino.dtos.UsuarioDto;
import com.leninsales.controle_treino.models.UsuarioModel;
import com.leninsales.controle_treino.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioModel salvarUsuario(UsuarioDto userDto) {

        UsuarioModel user = new UsuarioModel();

        BeanUtils.copyProperties(userDto, user);

        return repository.save(user);
    }

    public List<UsuarioModel> listarTodosUsuarios() {
        return repository.findAll();
    }

    public UsuarioModel atualizarUsuario(UUID id, UsuarioDto usuarioDto) {
        UsuarioModel user = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado."));
        BeanUtils.copyProperties(usuarioDto, user, "id");
        return repository.save(user);
    }

    public void deletaUsuario(UUID id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Usuário não encontrado para exclusão.");
        }
        repository.deleteById(id);
    }

}
