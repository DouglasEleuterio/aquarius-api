package com.aquarius.aquariusapi.controller;

import com.aquarius.aquariusapi.dto.ModalidadeDTO;
import com.aquarius.aquariusapi.models.Modalidade;
import com.aquarius.aquariusapi.service.ModalidadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/modalidade")
@CrossOrigin(origins = "*")
public class ModalidadeController {

    private static final Logger log = LoggerFactory.getLogger(ModalidadeController.class);

    @Autowired
    private ModalidadeService service;

    @GetMapping()
    public ResponseEntity<List<ModalidadeDTO>> listarTodos() {
        List<Modalidade> modalidades = service.buscarTodas();
        List<ModalidadeDTO> listDto = modalidades.stream().map(ModalidadeDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

}
