package com.aquarius.aquariusapi.service;

import com.aquarius.aquariusapi.models.Endereco;

import java.util.List;
import java.util.Optional;

public interface EnderecoService {

    Endereco inserirEndereco(Endereco endereco);
    void apagarEnderecoPorId(Integer id);
    List<Endereco> buscarEnderecosPorAluno(Integer alunoId);
    Endereco buscarEnderecoPorCidade(Integer cidadeId);
}
