package br.com.dev_renan.controller;

import br.com.dev_renan.dto.AvaliacaoRequestDTO;
import br.com.dev_renan.dto.AvaliacaoResponseDTO;
import br.com.dev_renan.model.Avaliacao;
import br.com.dev_renan.service.ServiceAvaliacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private ServiceAvaliacao service;

    @PostMapping
    public ResponseEntity<AvaliacaoResponseDTO> save(@RequestBody AvaliacaoRequestDTO dto){
        Avaliacao avaliacao = new Avaliacao();

        avaliacao.setUsuario(dto.getUsuario());
        avaliacao.setNota(dto.getNota());
        avaliacao.setComentario(dto.getComentario());

        Avaliacao avaliacaoSalva = service.save(avaliacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(new AvaliacaoResponseDTO(avaliacaoSalva));
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoResponseDTO>> findAll() {
        List<Avaliacao> avaliacoes = service.findAll();

        List<AvaliacaoResponseDTO> listar = new ArrayList<>();

        for(Avaliacao avaliacao : avaliacoes){
            listar.add(new AvaliacaoResponseDTO(avaliacao));
        }
        return ResponseEntity.ok(listar);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoResponseDTO> findById(@PathVariable Long id){
        Avaliacao avaliacao = service.findById(id);

        return ResponseEntity.ok(new AvaliacaoResponseDTO(avaliacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoResponseDTO> update(@PathVariable Long id, @RequestBody AvaliacaoRequestDTO dto){
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setId(id);

        avaliacao.setUsuario(dto.getUsuario());
        avaliacao.setNota(dto.getNota());
        avaliacao.setComentario(dto.getComentario());

        Avaliacao salvar = service.update(avaliacao);
        return ResponseEntity.ok(new AvaliacaoResponseDTO(avaliacao));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
