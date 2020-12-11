package com.aquarius.aquariusapi.service;

import com.aquarius.aquariusapi.models.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoService {
    Aluno inserir(Aluno aluno);
    Optional<Aluno> buscarAlunoPorId(Integer id);
    List<Aluno> buscarTodos();
    void removerAlunoPorId(Integer id);

    Aluno atualizarAluno(Aluno aluno);
}
