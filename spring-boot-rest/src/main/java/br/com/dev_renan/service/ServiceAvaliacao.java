package br.com.dev_renan.service;

import br.com.dev_renan.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAvaliacao {

    @Autowired
    private AvaliacaoRepository repository;
}
