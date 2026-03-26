package br.com.dev_renan.dto;

import br.com.dev_renan.model.Avaliacao;

public class AvaliacaoResponseDTO{

    private Long id;

    private String usuario;
    private Integer nota;
    private String comentario;

    // O que será mostrado do filme
    private Long filmeId;
    private String titulo;
    private String genero;

    public AvaliacaoResponseDTO(Avaliacao avaliacao){
        this.id = avaliacao.getId();
        this.usuario = avaliacao.getUsuario();
        this.nota = avaliacao.getNota();
        this.comentario = avaliacao.getComentario();

        // Relacionamento controlado
        this.filmeId = avaliacao.getFilme().getId();
        this.titulo = avaliacao.getFilme().getTitulo();
        this.genero = avaliacao.getFilme().getGenero();

    }

    public AvaliacaoResponseDTO(){}

    public Long getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Long filmeId) {
        this.filmeId = filmeId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
