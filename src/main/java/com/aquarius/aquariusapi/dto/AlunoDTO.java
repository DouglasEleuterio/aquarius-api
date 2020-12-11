package com.aquarius.aquariusapi.dto;

import com.aquarius.aquariusapi.models.Aluno;

import java.io.Serializable;
import java.util.Date;

public class AlunoDTO implements Serializable {

    private Integer id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private Boolean cuidadoEspecial;
    private String tipoCuidado;
    private String email;

    public AlunoDTO() {
    }

    public AlunoDTO(Aluno dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.cpf = dto.getCpf();
        this.dataNascimento = dto.getDataNascimento();
        this.cuidadoEspecial = dto.getCuidadoEspecial();
        this.tipoCuidado = dto.getTipoCuidado();
        this.email = dto.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getCuidadoEspecial() {
        return cuidadoEspecial;
    }

    public void setCuidadoEspecial(Boolean cuidadoEspecial) {
        this.cuidadoEspecial = cuidadoEspecial;
    }

    public String getTipoCuidado() {
        return tipoCuidado;
    }

    public void setTipoCuidado(String tipoCuidado) {
        this.tipoCuidado = tipoCuidado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
