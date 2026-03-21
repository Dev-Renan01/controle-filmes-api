package br.com.dev_renan.controller;

import br.com.dev_renan.model.Avaliacao;
import br.com.dev_renan.service.ServiceAvaliacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private ServiceAvaliacao service;

    @PostMapping
    public ResponseEntity<Avaliacao> save(@RequestBody Avaliacao avaliacao){
        Avaliacao avaliacao1 = service.save(avaliacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacao1);
    }

    @GetMapping
    public ResponseEntity<List<Avaliacao>> findAll(){
        List<Avaliacao> avaliacoes = service.findAll();
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Avaliacao> findById(@PathVariable Long id){
        Avaliacao avaliacao = service.findById(id);
        return ResponseEntity.ok(avaliacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> update(@PathVariable Long id, @RequestBody Avaliacao avaliacao){
        avaliacao.setId(id);
        Avaliacao avaliacao1 = service.update(avaliacao);
        return ResponseEntity.ok(avaliacao1);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
