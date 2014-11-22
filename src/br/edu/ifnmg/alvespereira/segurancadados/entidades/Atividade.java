package br.edu.ifnmg.alvespereira.segurancadados.entidades;

import java.sql.Time;

public class Atividade {

    private String nome;
    private Time duracao;
    private Usuario encarregado;
    private Projeto projeto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getDuracao() {
        return duracao;
    }

    public void setDuracao(Time duracao) {
        this.duracao = duracao;
    }

    public Usuario getEncarregado() {
        return encarregado;
    }

    public void setEncarregado(Usuario encarregado) {
        this.encarregado = encarregado;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

}
