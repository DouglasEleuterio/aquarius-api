package com.aquarius.aquariusapi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity(name = "pagamento")
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "data_vencimento")
    private Date dataVencimento;
    @Column(name = "forma_pagamento")
    private String formaPagamento;
    private Double valor;
    private Boolean pago;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Pagamento(Integer id, Date dataVencimento, String formaPagamento, Double valor, Boolean pago, Aluno aluno) {
        this.id = id;
        this.dataVencimento = dataVencimento;
        this.formaPagamento = formaPagamento;
        this.valor = valor;
        this.pago = pago;
        this.aluno = aluno;
    }

    public Pagamento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

