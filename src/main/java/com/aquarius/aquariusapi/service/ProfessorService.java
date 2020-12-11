package com.aquarius.aquariusapi.service;

import com.aquarius.aquariusapi.models.Professor;

import java.util.List;

public interface ProfessorService {

    /**
     * Salvar professor no banco de dados
     */
    Professor inserir(Professor obj);

    /**
     * Recuperar todos as Professores do banco de dados
     */
    List<Professor> buscarTodas();

    /**
     * Apagar um Professor no Banco de dados
     */
    void apagarProfessor(Integer id);

    /**
     * Atualizar um professor no banco de dados
     */
    Professor atualizarProfessor(Professor obj);

    /**
     * Buscar um Professor especifico no banco de dados
     */
    Professor buscarProfessor(Integer id);

    /**
     * Busca Professor por CPF.
     * @param cpf
     * @return Professor
     */
    Professor buscaPorCPF(String cpf);

    /**
     * Busca professor pelo nome
     * @param nome
     * @return Professor
     */
    Professor buscaPorNome(String nome);
}
