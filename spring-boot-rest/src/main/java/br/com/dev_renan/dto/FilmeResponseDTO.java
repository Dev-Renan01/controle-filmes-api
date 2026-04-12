package br.com.dev_renan.dto;

import br.com.dev_renan.model.Avaliacao;
import br.com.dev_renan.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeResponseDTO {

    private Long id;

    private String titulo;
    private Integer anoLancamento;
    private String genero;

    // numero de avaliações
    private List<String> avaliacoes;


    public FilmeResponseDTO(Filme filme) {
        this.id = filme.getId();
        this.titulo = filme.getTitulo();
        this.anoLancamento = filme.getAnoLancamento();
        this.genero = filme.getGenero();

        // Contando o numero de avaliações em cada filme

        // Inicializa a lista antes de adicionar elementos
        this.avaliacoes = new ArrayList<>();

        if(filme.getAvaliacoes() != null) {
            for (Avaliacao avaliacao : filme.getAvaliacoes()) {
                avaliacoes.add("ID: " + avaliacao.getId() + " - "
                        + avaliacao.getUsuario() + " - Nota: "
                        + avaliacao.getNota());
            }
        }
    }

    public List<String> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<String> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

