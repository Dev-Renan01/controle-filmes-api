package br.com.dev_renan.service;

import br.com.dev_renan.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFilmes {

    @Autowired
    private FilmeRepository repository;
}
