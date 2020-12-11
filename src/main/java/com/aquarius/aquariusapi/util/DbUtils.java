package com.aquarius.aquariusapi.util;

import com.aquarius.aquariusapi.models.Aluno;
import com.aquarius.aquariusapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;

@Service
public class DbUtils {

    @Autowired
    private ModalidadeService modalidadeService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private AlunoService alunoService;


    public void realizarTesteBancoDeDados() throws ParseException{
//        Modalidade modalidade = new Modalidade();
//        modalidade.setNome("Natação");
//        modalidadeService.inserir(modalidade);
//
//        Date dataNascimentoLeonardo = new GregorianCalendar(1997, Calendar.DECEMBER, 04).getTime(); //04/02/1997
//        Professor leonardo = new Professor();
//        leonardo.setDataNascimento(dataNascimentoLeonardo);
//        leonardo.setNome("Leonardo");
//        Random random = new Random();
//        int i = random.nextInt(999);
//        leonardo.setCpf("999.999."+String.valueOf(i) + "-65");
//        professorService.inserir(leonardo);
//
//        Cidade bh = new Cidade();
//        bh.setNome("Belo Horizonte");
//        bh.setEstado(estadoService.buscarEstadoPorNome("Minas Gerais").get());
//        Estado mg = new Estado();
//        mg.setNome("Minas Gerais");
//        estadoService.inserir(mg);
//        estadoService.apgarEstado(estadoService.buscarEstadoPorNome("Mato Grosso do Sul").get().getId());
//
//        Aluno aluno = new Aluno();
//        aluno.setCpf("999." + i + ".999-52");
//        aluno.setCuidadoEspecial(false);
//        aluno.setDataNascimento(dataNascimentoLeonardo);
//        aluno.setEmail("teste@teste.com");
//        aluno.setNome("Joãozinho");
//        aluno.setTipoCuidado("N/A");
//
//
//        Endereco enderecoJoao = new Endereco();
//        enderecoJoao.setLogradouro("Rua ABC");
//        enderecoJoao.setNumero("S/N");
//        enderecoJoao.setBairro("Zona Rural");
//        enderecoJoao.setCidade(bh);
//        enderecoJoao.setCep("99999999");
//        enderecoJoao.setAluno(aluno);
//        enderecoService.inserirEndereco(enderecoJoao);
//
//        List<Endereco> enderecoList = new ArrayList<>();
//        enderecoList.addAll(enderecoService.buscarEnderecosPorAluno(aluno.getId()));
//        System.out.println(enderecoList);

        imprimirDados(alunoService.buscarTodos());
        Optional<Aluno> aluno = alunoService.buscarAlunoPorId(1);
        imprimirDados(enderecoService.buscarEnderecosPorAluno(aluno.get().getId()));


    }

    public void imprimirDados(Object obj){
        System.out.println("\n\n\n##############################################\n\n\n");
        System.out.println(obj.toString());
        System.out.println("\n\n\n##############################################\n\n\n");

    }
}
