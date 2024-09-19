package br.senac.dto;

import java.sql.Date;

public class ConteudoDTO {

    private int id;
    private String usuario;
    private String titulo;
    private String lancamento;
    private String descricao;
    private String imagem;
    private String tipo;

    public ConteudoDTO(String usuario, String titulo, String lancamento, String descricao, String imagem, String tipo){
        this.usuario = usuario;
        this.titulo = titulo;
        this.lancamento = lancamento;
        this.descricao = descricao;
        this.imagem = imagem;
        this.tipo = tipo;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
