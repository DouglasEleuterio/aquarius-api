package com.aquarius.aquariusapi.models;

import com.aquarius.aquariusapi.dto.AlunoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "aluno")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @Column(name = "cuidado_especial")
    private Boolean cuidadoEspecial;
    private String nome;
    @Column(name = "tipo_cuidado")
    private String tipoCuidado;
    @Column(nullable = false, unique = true)
    private String email;

    @ElementCollection
    @CollectionTable(name="telefone")
    private Set<String> telefones = new HashSet<>();

    @OneToMany(mappedBy = "aluno")
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "aluno")
    private List<Pagamento> pagamentos = new ArrayList<>();

    @OneToMany(mappedBy = "aluno")
    private List<Atestado> atestados = new ArrayList<>();

    public Aluno(Integer id, String cpf, Date dataNascimento, Boolean cuidadoEspecial, String nome, String tipoCuidado, String email) {
        this.id = id;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.cuidadoEspecial = cuidadoEspecial;
        this.nome = nome;
        this.tipoCuidado = tipoCuidado;
        this.email = email;
    }

    public Aluno(AlunoDTO dto){
        this.id = dto.getId();
        this.cpf = dto.getCpf();
        this.dataNascimento = dto.getDataNascimento();
        this.cuidadoEspecial = dto.getCuidadoEspecial();
        this.nome = dto.getNome();
        this.tipoCuidado = dto.getTipoCuidado();
        this.email = dto.getEmail();
    }

    public Aluno() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Set<String> getTelefones() {
        return telefones;
    }

    public void addTelefone(String telefone){
        this.telefones.add(telefone);
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void addEndereco(Endereco endereco){
        this.enderecos.add(endereco);
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void addPagamento(Pagamento pagamento){
        this.pagamentos.add(pagamento);
    }

    public List<Atestado> getAtestados() {
        return atestados;
    }

    public void addAtestado(Atestado atestado){
        this.atestados.add(atestado);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return id.equals(aluno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Aluno: [" +
                "\nid=" + id +
                ", \ncpf='" + cpf + '\'' +
                ", \ndataNascimento=" + dataNascimento +
                ", \ncuidadoEspecial=" + cuidadoEspecial +
                ", \nnome='" + nome + '\'' +
                ", \ntipoCuidado='" + tipoCuidado + '\'' +
                ", \nemail='" + email + '\'' +
                ", \nendereços='" + getEnderecos() + '\'' +
                '}';
    }
}
