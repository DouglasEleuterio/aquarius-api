package com.aquarius.aquariusapi.repository;

import com.aquarius.aquariusapi.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    Professor findByNome(String nome);
    Professor findByCpf(String cpf);
}
