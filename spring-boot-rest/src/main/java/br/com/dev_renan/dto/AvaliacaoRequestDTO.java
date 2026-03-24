package br.com.dev_renan.dto;

public class AvaliacaoRequestDTO {

    private String usuario;
    private Integer nota;
    private String comentario;

    public AvaliacaoRequestDTO(){}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}
