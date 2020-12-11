package com.aquarius.aquariusapi.service;

import com.aquarius.aquariusapi.models.Estado;
import com.aquarius.aquariusapi.repository.EstadoRepository;
import com.aquarius.aquariusapi.service.impl.EstadoServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EstadoServiceImplTest {

   @Mock
   private EstadoRepository repository;

   @InjectMocks
   private EstadoServiceImpl service;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        service = new EstadoServiceImpl();
    }

    @Test()
    public void naoDeveAdicionarEstadoComMemsoNome(){
        Estado estado = new Estado();
        estado.setNome("Goias");
        estado.setCidades(null);
        repository.save(estado);
    }
}
