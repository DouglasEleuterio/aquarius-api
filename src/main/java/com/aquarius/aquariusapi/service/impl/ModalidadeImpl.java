package com.aquarius.aquariusapi.service.impl;

import com.aquarius.aquariusapi.models.Modalidade;
import com.aquarius.aquariusapi.repository.ModalidadeRepository;
import com.aquarius.aquariusapi.service.ModalidadeService;
import com.aquarius.aquariusapi.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModalidadeImpl  implements ModalidadeService {

    @Autowired
    private ModalidadeRepository repository;

    @Override
    public Modalidade inserir(Modalidade obj) {
        validarDados(obj);
        return repository.save(obj);
    }

    @Override
    public List<Modalidade> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public void apagarModalidade(Integer id) {
        buscarModalidade(id);
        try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possível apagar uma modalidade que possua turmas");
        }
    }

    @Override
    public Modalidade atualizarModalidade(Modalidade obj) {
        Modalidade nova = buscarModalidade(obj.getId());
        atualizarDados(nova, obj);
        return repository.save(nova);
    }

    @Override
    public Modalidade buscarModalidade(Integer id) {
        Optional<Modalidade> obj = repository.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException(
                "Modalidade não encontrada! Id: " + id + ", Tipo: " + Modalidade.class.getName()
        ));
    }

    private void atualizarDados(Modalidade nova, Modalidade antiga){
        nova.setNome(antiga.getNome());
    }

    private void validarDados(Modalidade obj){
            if(obj.getNome().isEmpty()){
                throw new RuntimeException("Campo nome é obrigatório");
            }
    }
}
