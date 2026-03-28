package br.com.dev_renan.controller;

import br.com.dev_renan.dto.AvaliacaoRequestDTO;
import br.com.dev_renan.dto.AvaliacaoResponseDTO;
import br.com.dev_renan.model.Avaliacao;
import br.com.dev_renan.model.Filme;
import br.com.dev_renan.service.avaliacaoService;
import br.com.dev_renan.service.filmeService;
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
    private avaliacaoService avaliacaoService;

    @Autowired
    private filmeService filmeService;

    @PostMapping
    public ResponseEntity<AvaliacaoResponseDTO> save(@RequestBody AvaliacaoRequestDTO dto){
        Avaliacao avaliacao = new Avaliacao();

        avaliacao.setUsuario(dto.getUsuario());
        avaliacao.setNota(dto.getNota());
        avaliacao.setComentario(dto.getComentario());

        Filme filmeId = filmeService.findById(dto.getFilmeId()); // Busca o filme no banco pelo ID informado no DTO
        avaliacao.setFilme(filmeId);

        Avaliacao avaliacaoSalva = avaliacaoService.save(avaliacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(new AvaliacaoResponseDTO(avaliacaoSalva));
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoResponseDTO>> findAll() {
        List<Avaliacao> avaliacoes = avaliacaoService.findAll();

        List<AvaliacaoResponseDTO> listar = new ArrayList<>();

        for(Avaliacao avaliacao : avaliacoes){
            listar.add(new AvaliacaoResponseDTO(avaliacao));
        }
        return ResponseEntity.ok(listar);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoResponseDTO> findById(@PathVariable Long id){
        Avaliacao avaliacao = avaliacaoService.findById(id);

        return ResponseEntity.ok(new AvaliacaoResponseDTO(avaliacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoResponseDTO> update(@PathVariable Long id, @RequestBody AvaliacaoRequestDTO dto){
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setId(id);

        avaliacao.setUsuario(dto.getUsuario());
        avaliacao.setNota(dto.getNota());
        avaliacao.setComentario(dto.getComentario());

        Filme filmeId = filmeService.findById(dto.getFilmeId()); // Busca o filme no banco pelo ID informado no DTO
        avaliacao.setFilme(filmeId);

        Avaliacao salvar = avaliacaoService.update(avaliacao);
        return ResponseEntity.ok(new AvaliacaoResponseDTO(avaliacao));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        avaliacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}