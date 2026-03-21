package br.com.dev_renan.dto;

import br.com.dev_renan.model.Filme;

public class FilmeResponseDTO {

    private Long id;

    private String titulo;
    private Integer anoLancamento;
    private String genero;

    public FilmeResponseDTO(Filme filme) {
        this.id = filme.getId();
        this.titulo = filme.getTitulo();
        this.anoLancamento = filme.getAnoLancamento();
        this.genero = filme.getGenero();
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

