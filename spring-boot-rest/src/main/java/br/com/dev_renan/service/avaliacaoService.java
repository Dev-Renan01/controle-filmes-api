package br.com.dev_renan.service;

import br.com.dev_renan.model.Avaliacao;
import br.com.dev_renan.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class avaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    public Avaliacao save(Avaliacao avaliacao){
        return repository.save(avaliacao);
    }

    public List<Avaliacao> findAll(){
        return repository.findAll();
    }

    public Avaliacao findById(Long id){
        if(id == null){
            throw new IllegalArgumentException("Informe um id válido!");
        }
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada!"));
    }

    public Avaliacao update(Avaliacao avaliacao) {
        if (avaliacao.getId() == null) {
            throw new IllegalArgumentException("Informe um id válido!");
        }

      repository.findById(avaliacao.getId())
              .orElseThrow(() -> new RuntimeException("Avaliação não encontrada!"));

        return repository.save(avaliacao);
    }

    public void delete(Long id){
        if(id == null){
            throw new IllegalArgumentException("informe um id válido!");
            }

        Avaliacao avaliacao = repository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Avaliação não encontrada!"));

        repository.deleteById(id);
    }
}
