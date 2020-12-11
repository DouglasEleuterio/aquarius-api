package com.aquarius.aquariusapi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Atestado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "data_inicio")
    private Date dataInicio;
    @Column(name = "data_fim")
    private Date dataFim;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Atestado(Integer id, Date dataInicio, Date dataFim, Aluno aluno) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.aluno = aluno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atestado atestado = (Atestado) o;
        return id.equals(atestado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
