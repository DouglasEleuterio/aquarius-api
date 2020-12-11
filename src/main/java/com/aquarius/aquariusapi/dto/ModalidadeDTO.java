package com.aquarius.aquariusapi.dto;

import com.aquarius.aquariusapi.models.Modalidade;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Optional;

public class ModalidadeDTO {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @Length(min = 3, message = "Nome da categoria deve conter no minimo 3 caracteres")
    @NotEmpty(message = "O nome da modalidade deve ser inserido")
    private String nome;

    public ModalidadeDTO(Modalidade obj) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "LancamentoDto [id=" + id + ", nome=" + nome + "]";
    }
}
