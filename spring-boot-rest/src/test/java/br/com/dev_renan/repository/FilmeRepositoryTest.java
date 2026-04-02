package br.com.dev_renan.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // Cria um ambiente focado em testes de banco
@ActiveProfiles("teste") // Usa configurações específicas para teste: application-test.properties
public class FilmeRepositoryTest {

    
}