package br.com.dev_renan.service;

import br.com.dev_renan.model.Filme;
import br.com.dev_renan.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public Filme save(Filme filme) {
        return repository.save(filme);
    }

    public List<Filme> findAll() {
        return repository.findAll();
    }

    public Filme findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Informe um id válido!");
        }

        return repository.findById(id) // Busca o filme pelo ID. Lança exceção caso não seja encontrado
                .orElseThrow(() -> new RuntimeException("Filme não encontrado!"));
    }

    public Filme update(Filme filme) {
        if (filme.getId() == null) {
            throw new IllegalArgumentException("Informe um id válido!");
        }

      repository.findById(filme.getId())
              .orElseThrow(() -> new RuntimeException("Filme não encontrado!"));
        return repository.save(filme);
    }


    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Informe um id válido!");
        }

     Filme filme = repository.findById(id)
                     .orElseThrow(() -> new RuntimeException("Filme não encontrado!"));

        repository.delete(filme);
    }
}