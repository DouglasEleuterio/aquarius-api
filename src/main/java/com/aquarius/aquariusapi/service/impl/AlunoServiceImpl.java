package com.aquarius.aquariusapi.service.impl;

import com.aquarius.aquariusapi.models.Aluno;
import com.aquarius.aquariusapi.repository.AlunoRepository;
import com.aquarius.aquariusapi.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    AlunoRepository repository;

    @Override
    public Aluno inserir(Aluno aluno) {
        return repository.save(aluno);
    }

    @Override
    public Optional<Aluno> buscarAlunoPorId(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Aluno> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public void removerAlunoPorId(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Aluno atualizarAluno(Aluno aluno){
        Optional<Aluno> velho = buscarAlunoPorId(aluno.getId());
        try{
            removerAlunoPorId(velho.get().getId());
            return inserir(aluno);
        }catch (Exception e){
            return inserir(velho.get());
        }
    }
}
