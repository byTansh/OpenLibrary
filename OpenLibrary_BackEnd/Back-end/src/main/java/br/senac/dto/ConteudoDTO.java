package br.senac.dto;

import java.sql.Date;

public class ConteudoDTO {

    private int id;
    private UsuarioDTO usuario;
    private String titulo;
    private String lancamento;
    private String descricao;

    public ConteudoDTO(String titulo, String lancamento, String descricao){
        this.titulo = titulo;
        this.lancamento = lancamento;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
