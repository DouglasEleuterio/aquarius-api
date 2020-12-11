package com.aquarius.aquariusapi.service.impl;

import com.aquarius.aquariusapi.models.Endereco;
import com.aquarius.aquariusapi.repository.EnderecoRepository;
import com.aquarius.aquariusapi.service.EnderecoService;
import com.aquarius.aquariusapi.service.exceptions.EnderecoImcompletoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoImpl implements EnderecoService {

    @Autowired
    EnderecoRepository repository;

    @Override
    public Endereco inserirEndereco(Endereco endereco) { 
        validarEndereco(endereco);
        return repository.save(endereco);
    }

    @Override
    public void apagarEnderecoPorId(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("Id não informado");
        }
        Optional<Endereco> idEndereco = repository.findById(id);
        if(idEndereco.isPresent()){
            repository.deleteById(idEndereco.get().getId());
        }
    }

    @Override
    public List<Endereco> buscarEnderecosPorAluno(Integer alunoId) {
        return repository.findByAluno_Id(alunoId);
    }

    @Override
    public Endereco buscarEnderecoPorCidade(Integer cidadeId) {
        return null;
    }

    private void validarEndereco(Endereco endereco)  {
        try {
            validaLogradouro(endereco.getLogradouro());
            validaNumero(endereco.getNumero());
            validaBairro(endereco.getBairro());
        } catch (EnderecoImcompletoException e) {
            e.printStackTrace();
        }
    }

    private void validaLogradouro(String logradouro) throws EnderecoImcompletoException{
        if(logradouro.isEmpty()){
            throw new EnderecoImcompletoException("Endereço necessita de Logradouro");
        }
    }

    private void validaNumero(String numero) throws EnderecoImcompletoException {
        if(numero.isEmpty()){
            throw new EnderecoImcompletoException("Endereço necessita de Numero");
        }
    }

    private void validaBairro(String bairro) throws EnderecoImcompletoException {
        if(bairro.isEmpty()){
            throw new EnderecoImcompletoException("Endereço necessita de Bairro");
        }
    }
}
