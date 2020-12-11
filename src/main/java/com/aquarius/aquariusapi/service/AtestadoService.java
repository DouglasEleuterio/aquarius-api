package com.aquarius.aquariusapi.service;

import com.aquarius.aquariusapi.models.Atestado;

import java.util.List;
import java.util.Optional;

public interface AtestadoService {

    Atestado inserir(Atestado atestado);
    List<Atestado> buscarTodos();
    void removerAtestadoPorId(Integer id);
    Optional<Atestado> buscarAtestadoPorId(Integer id);

}
