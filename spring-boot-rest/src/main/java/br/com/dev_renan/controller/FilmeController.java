package br.com.dev_renan.controller;

import br.com.dev_renan.model.Filme;
import br.com.dev_renan.service.ServiceFilmes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeController {

    @Autowired
    private ServiceFilmes service;

    @PostMapping
    public ResponseEntity<Filme> save(@RequestBody Filme filme){
        Filme filme1 = service.save(filme);

         return ResponseEntity.status(HttpStatus.CREATED).body(filme1);
    }

    @GetMapping
    public ResponseEntity<List<Filme>> findAll(){
        List<Filme> filmes = service.findAll();

        return ResponseEntity.ok(filmes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Filme> findById(@PathVariable Long id){
        Filme filme = service.findById(id);

        return ResponseEntity.ok(filme);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Filme> update(@PathVariable Long id, @RequestBody Filme filme){
        filme.setId(id);
        Filme filme1 = service.update(filme);

        return ResponseEntity.ok(filme1);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build(); /* Retorna HTTP 204 (No Content), indicando que a operação foi bem-sucedida
                                                   porém não há conteúdo para retornar no corpo da resposta */
    }

}