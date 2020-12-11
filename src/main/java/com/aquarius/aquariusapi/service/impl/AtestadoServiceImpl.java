package com.aquarius.aquariusapi.service.impl;

import com.aquarius.aquariusapi.models.Atestado;
import com.aquarius.aquariusapi.repository.AtestadoRepository;
import com.aquarius.aquariusapi.service.AtestadoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AtestadoServiceImpl implements AtestadoService {

    @Autowired
    AtestadoRepository repository;

    @Override
    public Atestado inserir(Atestado atestado) {
        return repository.save(atestado);
    }

    @Override
    public List<Atestado> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public void removerAtestadoPorId(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Atestado> buscarAtestadoPorId(Integer id) {
        return repository.findById(id);
    }
}
