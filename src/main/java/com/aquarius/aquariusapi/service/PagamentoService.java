package com.aquarius.aquariusapi.service;

import com.aquarius.aquariusapi.models.Aluno;
import com.aquarius.aquariusapi.models.Pagamento;

import java.util.List;
import java.util.Optional;

public interface PagamentoService {
    Pagamento inserir(Pagamento aluno);
    Optional<Pagamento> buscarPagamentoPorId(Integer id);
    List<Pagamento> buscarTodos();
    void removerPagamentoPorId(Integer id);
}
