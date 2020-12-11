package com.aquarius.aquariusapi.service;

import com.aquarius.aquariusapi.models.Estado;

import java.util.List;
import java.util.Optional;

public interface EstadoService {

    Estado inserir(Estado estado);
    Estado alterar(Estado estado);
    List<Estado> buscarTodos();
    void apgarEstado(Integer id);
    Optional<Estado> buscarEstadoPorNome(String nome);
    Optional<Estado> buscarEstadoPorId(Integer id);
}
