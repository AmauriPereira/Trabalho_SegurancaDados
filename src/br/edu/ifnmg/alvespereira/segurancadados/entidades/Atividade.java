package br.edu.ifnmg.alvespereira.segurancadados.entidades;

public class Atividade {

    private int idAtividade;
    private String nome;
    private Float duracao;
    private Usuario encarregado;
    private Projeto projeto;

    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getDuracao() {
        return duracao;
    }

    public void setDuracao(Float duracao) {
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
