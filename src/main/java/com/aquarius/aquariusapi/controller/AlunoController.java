package com.aquarius.aquariusapi.controller;

import com.aquarius.aquariusapi.dto.AlunoDTO;
import com.aquarius.aquariusapi.models.Aluno;
import com.aquarius.aquariusapi.service.AlunoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/aluno")
@CrossOrigin(origins = "*")
public class AlunoController {

    private static final Logger log = LoggerFactory.getLogger(AlunoController.class);

    @Autowired
    private AlunoService service;

    @GetMapping()
    public ResponseEntity<List<AlunoDTO>> listarTodos(){
        List<Aluno> alunos = service.buscarTodos();
        List<AlunoDTO> dtoList = new ArrayList<>();
        for (Aluno aluno : alunos) {
            dtoList.add(paraDto(aluno));
        }
        return ResponseEntity.ok().body(dtoList);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagarAluno(@PathVariable Integer id){
        service.removerAlunoPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Void> salvarAluno(@RequestBody AlunoDTO dto){
        Aluno aluno = new Aluno(dto);
        service.inserir(aluno);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarAluno(@RequestBody AlunoDTO dto){
        Aluno aluno = deDto(dto);
        service.atualizarAluno(aluno);
        return ResponseEntity.noContent().build();
    }

    private AlunoDTO paraDto(Aluno aluno){
        return new AlunoDTO(aluno);
    }

    private Aluno deDto(AlunoDTO dto){
        return new Aluno(dto);
    }

    private Aluno atualizarDadosAluno(AlunoDTO alunoDTO){
        return deDto(alunoDTO);
    }
}
