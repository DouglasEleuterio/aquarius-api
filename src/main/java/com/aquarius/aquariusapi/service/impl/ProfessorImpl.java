package com.aquarius.aquariusapi.service.impl;

import com.aquarius.aquariusapi.models.Professor;
import com.aquarius.aquariusapi.repository.ProfessorRepository;
import com.aquarius.aquariusapi.service.ProfessorService;
import com.aquarius.aquariusapi.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    @Override
    public Professor inserir(Professor obj) {
        obj.setId(null);
        validarDados(obj);
        return repository.save(obj);
    }

    @Override
    public List<Professor> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public void apagarProfessor(Integer id) {
        try {
            repository.deleteById(buscarProfessor(id).getId());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possível apagar Professor que esteja vinculado a uma turma.");
        }
    }

    @Override
    public Professor atualizarProfessor(Professor obj) {
        Professor novo = buscarProfessor(obj.getId());
        novo.setDataNascimento(obj.getDataNascimento());
        novo.setNome(obj.getNome());
        return inserir(novo);
    }

    @Override
    public Professor buscarProfessor(Integer id) {
        Optional<Professor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Professor não encontrado ! Id: " + id + ", Tipo: " + Professor.class.getName()));

    }

    private void validarDados(Professor obj) {
        if (obj.getNome().isEmpty() || obj.getDataNascimento() == null) {
            throw new RuntimeException("Campo nome e data de nascimento é obrigatório");
        }
    }

    @Override
    public Professor buscaPorCPF(String cpf) {
        if(!cpf.isEmpty()){
            return repository.findByCpf(cpf);
        }
        return null;
    }

    @Override
    public Professor buscaPorNome(String nome) {
        if(!nome.isEmpty()){
            return repository.findByNome(nome);
        }
        return null;
    }
}
