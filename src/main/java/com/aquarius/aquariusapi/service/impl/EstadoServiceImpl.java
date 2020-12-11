package com.aquarius.aquariusapi.service.impl;

import com.aquarius.aquariusapi.models.Estado;
import com.aquarius.aquariusapi.repository.EstadoRepository;
import com.aquarius.aquariusapi.service.EstadoService;
import com.aquarius.aquariusapi.service.exceptions.EstadoJaCadastradoException;
import com.aquarius.aquariusapi.service.exceptions.EstadoSemNomeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    EstadoRepository repository;

    @Override
    public Estado inserir(Estado estado) {
        validarEstado(estado);
        return repository.save(estado);
    }

    @Override
    public Estado alterar(Estado estado) {
        Estado novo = new Estado();
        novo.setId(estado.getId());
        novo.setNome(estado.getNome());
        novo.setCidades(estado.getCidades());
       return repository.save(novo);
    }

    @Override
    public List<Estado> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public void apgarEstado(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Estado> buscarEstadoPorNome(String nome) {
        return Optional.ofNullable(repository.findByNomeLike(nome));
    }

    @Override
    public Optional<Estado> buscarEstadoPorId(Integer id) {
        return repository.findById(id);
    }

    private void validarEstado(Estado estado) {
        if(estado.getNome().equals("")){
            throw new  EstadoSemNomeException("Estado deve possuir nome");
        }
    }
}
