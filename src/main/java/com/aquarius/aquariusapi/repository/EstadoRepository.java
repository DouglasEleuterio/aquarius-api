package com.aquarius.aquariusapi.repository;

import com.aquarius.aquariusapi.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    Estado findByNomeLike(String nome);
}
