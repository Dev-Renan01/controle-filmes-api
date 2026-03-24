package br.com.dev_renan.dto;

import br.com.dev_renan.model.Avaliacao;

public class AvaliacaoResponseDTO{

    private Long id;

    private String usuario;
    private Integer nota;
    private String comentario;

    public AvaliacaoResponseDTO(Avaliacao avaliacao){
        this.id = avaliacao.getId();
        this.usuario = avaliacao.getUsuario();
        this.nota = avaliacao.getNota();
        this.comentario = avaliacao.getComentario();
    }

    public AvaliacaoResponseDTO(){}

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
