package com.aquarius.aquariusapi.service;

import com.aquarius.aquariusapi.models.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModalidadeService {

    /**
     * Salvar modalidade no banco de dados
     */
    Modalidade inserir(Modalidade obj);

    /**
     * Recuperar todas as modalidades do banco de dados
     */
    List<Modalidade> buscarTodas();

    /**
     * Apagar uma modalidade no Banco de dados
     */

    void apagarModalidade(Integer id);

    /**
     * Atualizar uma modalidae no banco de dados
     */

    Modalidade atualizarModalidade(Modalidade obj);

    /**
     * Buscar uma modalidade especifica no banco de dados
     */
    Modalidade buscarModalidade(Integer id);
}
