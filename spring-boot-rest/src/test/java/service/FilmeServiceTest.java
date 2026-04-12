package service;

import br.com.dev_renan.model.Filme;
import br.com.dev_renan.repository.FilmeRepository;
import br.com.dev_renan.service.FilmeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class) // Ativa o Mockito dentro do JUnit 5.
public class FilmeServiceTest {


    @Mock // Cria um objeto FALSO (mock) do repositório
    private FilmeRepository filmeRepository;


    /* Cria uma instância REAL do FilmeService
     E injeta automaticamente o filmeRepository (mock) dentro dele */
    @InjectMocks
    private FilmeService filmeService;


    @Nested // AGRUPAR todos os testes relacionados a criação de filme
    public class createFilme{

        @Test
        @DisplayName("Filme criado com sucesso!") // Define um nome para o teste
        public void salvarFilmeComSucesso(){

            //Arrange (preparar)
            Filme filme = new Filme();

            filme.setTitulo("A menina dos olhos encantados");
            filme.setAnoLancamento(2019);
            filme.setGenero("Conto de fadas");

            doReturn(filme) // Define o valor que será retornado quando o método for chamado
                    .when(filmeRepository) // Indica em QUAL objeto (mock) esse comportamento será aplicado
                    .save(any()); // Define QUAL método será interceptado
            // any() significa: aceita qualquer parâmetro

            //Act (executar)
           Filme resultado =  filmeService.save(filme);

            //Assert (verificar)
            assertEquals("A menina dos olhos encantados", resultado.getTitulo());
            assertEquals(2019, resultado.getAnoLancamento());
            assertEquals("Conto de fadas", resultado.getGenero());
        }
    }
}