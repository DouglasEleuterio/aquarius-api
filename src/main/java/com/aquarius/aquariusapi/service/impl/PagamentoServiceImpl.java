package com.aquarius.aquariusapi.service.impl;

import com.aquarius.aquariusapi.models.Aluno;
import com.aquarius.aquariusapi.models.Pagamento;
import com.aquarius.aquariusapi.repository.PagamentoRepository;
import com.aquarius.aquariusapi.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    PagamentoRepository repository;

    @Override
    public Pagamento inserir(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    @Override
    public Optional<Pagamento> buscarPagamentoPorId(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Pagamento> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public void removerPagamentoPorId(Integer id) {
        repository.deleteById(id);
    }
}
