package br.com.dev_renan.controller;

import br.com.dev_renan.dto.FilmeRequestDTO;
import br.com.dev_renan.dto.FilmeResponseDTO;
import br.com.dev_renan.model.Filme;
import br.com.dev_renan.service.ServiceFilmes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeController {

    @Autowired
    private ServiceFilmes service;

   @PostMapping
   public ResponseEntity<FilmeResponseDTO> save(@RequestBody FilmeRequestDTO dto){
       Filme filme = new Filme();

       filme.setTitulo(dto.getTitulo());
       filme.setAnoLancamento(dto.getAnoLancamento());
       filme.setGenero(dto.getGenero());

       Filme filmeSalvo = service.save(filme);

       return ResponseEntity.status(HttpStatus.CREATED).body(new FilmeResponseDTO(filmeSalvo));
   }

   @GetMapping
   public ResponseEntity<List<FilmeResponseDTO>> findAll(){
       List<Filme> filmes = service.findAll();
       List<FilmeResponseDTO> lista = new ArrayList<>();

       for(Filme filme : filmes){
           lista.add(new FilmeResponseDTO(filme));
       }

       return ResponseEntity.ok(lista);
   }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FilmeResponseDTO> findById(@PathVariable Long id){
        Filme filme = service.findById(id);

        FilmeResponseDTO dto = new FilmeResponseDTO(filme);

        return ResponseEntity.ok(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FilmeResponseDTO> update(@PathVariable Long id, @RequestBody FilmeRequestDTO dto){
        Filme filme = new Filme();
        filme.setId(id);

        filme.setTitulo(dto.getTitulo());
        filme.setAnoLancamento(dto.getAnoLancamento());
        filme.setGenero(dto.getGenero());

        Filme response = service.update(filme);

        return ResponseEntity.ok(new FilmeResponseDTO(response));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build(); /* Retorna HTTP 204 (No Content), indicando que a operação foi bem-sucedida
                                                   porém não há conteúdo para retornar no corpo da resposta */
    }
}