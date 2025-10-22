package com.leninsales.controle_treino.services;

import com.leninsales.controle_treino.dtos.request.RotinaCadastroDto;
import com.leninsales.controle_treino.dtos.request.RotinaDto;
import com.leninsales.controle_treino.dtos.response.RotinaExerciciosListagemResponseDto;
import com.leninsales.controle_treino.dtos.response.RotinaListagemDto;
import com.leninsales.controle_treino.dtos.response.RotinaListagemNomesEExerciciosDto;
import com.leninsales.controle_treino.models.ExercicioModel;
import com.leninsales.controle_treino.models.RotinaExercicioModel;
import com.leninsales.controle_treino.models.RotinaModel;
import com.leninsales.controle_treino.repositories.RotinaExercicioRepository;
import com.leninsales.controle_treino.repositories.RotinaRepository;
import com.leninsales.controle_treino.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class RotinaService {

    @Autowired
    private RotinaRepository repository;

    @Autowired
    private RotinaExercicioRepository rotinaExercicioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public RotinaModel salvaRotina(RotinaCadastroDto rotinaCadastroDto, UUID userId) {
        if (!usuarioRepository.existsById(userId)) {
            throw new NoSuchElementException("Usuario não encontrado.");
        }

        RotinaModel rotina = new RotinaModel();
        rotina.setNome(rotinaCadastroDto.nome());
        rotina.setIdUsuario(userId);

        List<RotinaExercicioModel> exerciciosModel = rotinaCadastroDto.exercicios().stream().map(dto -> {
            RotinaExercicioModel exercicioModel = new RotinaExercicioModel();
            ExercicioModel e = new ExercicioModel();

            exercicioModel.setExercicio(e);
            exercicioModel.setSeries(dto.series());
            exercicioModel.setRepeticoes(dto.repeticoes());
            exercicioModel.setOrdem(dto.ordem());

            exercicioModel.setRotina(rotina);
            return exercicioModel;
        }).collect(Collectors.toList());

        rotina.setExercicios(exerciciosModel);

        return repository.save(rotina);
    }

    public List<RotinaListagemDto> listarTodosNomesEIdrotinaDasRotinas(UUID userId) {
        if (!usuarioRepository.existsById(userId)) {
            throw new NoSuchElementException("Usuario não encontrado.");
        }

        return repository.findRotinaListagemDtoByIdUsuario(userId);
    }

    public List<RotinaListagemNomesEExerciciosDto> listarTodosNomesEExercicioDasRotinas(UUID userId) {
        if (!usuarioRepository.existsById(userId)) {
            throw new NoSuchElementException("Usuario não encontrado.");
        }

        List<RotinaModel> rotinas = repository.findByIdUsuario(userId);
        List<RotinaListagemNomesEExerciciosDto> repostas = new ArrayList<>();

        for (RotinaModel rotina : rotinas) {
            List<RotinaExercicioModel> exercicios = rotinaExercicioRepository.findByIdRotina(rotina.getIdRotina());

            List<RotinaExerciciosListagemResponseDto> exerciciosDto = exercicios.stream()
                    .map(e -> new RotinaExerciciosListagemResponseDto(
                            e.getExercicio().getNome(),
                            e.getSeries(),
                            e.getRepeticoes(),
                            e.getOrdem()))
                    .toList();

            repostas.add(new RotinaListagemNomesEExerciciosDto(rotina.getIdRotina(), rotina.getNome(), exerciciosDto));
        }
        return repostas;
    }


    public RotinaListagemNomesEExerciciosDto listarNomeEExerciciosDeUmaRotina(Integer idRotina) {
        RotinaModel rotina = repository.findById(idRotina)
                .orElseThrow(() -> new NoSuchElementException("Rotina não encontrada."));

        List<RotinaExerciciosListagemResponseDto> exerciciosDto = rotina.getExercicios().stream()
                .map(e -> new RotinaExerciciosListagemResponseDto(
                        e.getExercicio().getNome(),
                        e.getSeries(),
                        e.getRepeticoes(),
                        e.getOrdem()))
                .toList();


        return new RotinaListagemNomesEExerciciosDto(rotina.getIdRotina(), rotina.getNome(), exerciciosDto);
    }

    public RotinaModel atualizarRotina(Integer idRotina, RotinaDto rotinaDto) {
        RotinaModel rotina = repository.findById(idRotina).orElseThrow(() -> new NoSuchElementException("Rotina não encontrada."));

        BeanUtils.copyProperties(rotinaDto, rotina, "id_rotina");

        return repository.save(rotina);
    }


    public void deletarRotina(Integer id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Rotina não encontrada para exclusão.");
        }

        repository.deleteById(id);
    }

}