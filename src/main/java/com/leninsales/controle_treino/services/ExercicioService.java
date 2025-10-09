package com.leninsales.controle_treino.services;

import com.leninsales.controle_treino.dtos.ExercicioDto;
import com.leninsales.controle_treino.models.ExercicioModel;
import com.leninsales.controle_treino.repositories.ExercicioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository repository;

    public ExercicioModel salvarExercicio(ExercicioDto exercicioDto) {

        ExercicioModel exercicio = new ExercicioModel();

        BeanUtils.copyProperties(exercicioDto, exercicio);

        return repository.save(exercicio);
    }

    public List<ExercicioModel> listarTodosExercicios() {
        return repository.findAll();
    }

    public ExercicioModel atualizarExercicio(Integer id, ExercicioDto exercicioDto) {
        ExercicioModel exercicio = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Exercício não encontrado."));
        BeanUtils.copyProperties(exercicioDto, exercicio, "id");
        return repository.save(exercicio);
    }

    public void deletaExercicio(Integer id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Exercicio não encontrado para exclusão.");
        }
        repository.deleteById(id);
    }

}
