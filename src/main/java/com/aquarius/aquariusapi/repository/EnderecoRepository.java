package com.aquarius.aquariusapi.repository;

import com.aquarius.aquariusapi.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    List<Endereco> findByAluno_Id(Integer idAluno);
}
