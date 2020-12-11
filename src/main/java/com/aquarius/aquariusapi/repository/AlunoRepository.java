package com.aquarius.aquariusapi.repository;

import com.aquarius.aquariusapi.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
