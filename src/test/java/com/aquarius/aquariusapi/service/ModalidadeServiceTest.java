package com.aquarius.aquariusapi.service;

import com.aquarius.aquariusapi.models.Modalidade;
import com.aquarius.aquariusapi.repository.ModalidadeRepository;
import com.aquarius.aquariusapi.service.impl.ModalidadeImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ModalidadeServiceTest {

    @Mock
    private ModalidadeRepository repository;

    @InjectMocks
    private ModalidadeImpl service;

    @Test
    public void deveSalvarComSucesso(){
        Modalidade modalidade = new Modalidade();
        modalidade.setId(null);
        modalidade.setNome("Modalidade de Teste");
        service.inserir(modalidade);
        Mockito.verify(repository, Mockito.times(1)).save(modalidade);
    }

    @Test()
    public void naoDeveSalvarSemNome(){
        Modalidade modalidade = new Modalidade();
        modalidade.setNome("Abc");
        try {
            service.inserir(modalidade);
        }catch (Exception e) {
            Assert.assertEquals("Campo nome é obrigatório", e.getMessage());
        }
    }

}
