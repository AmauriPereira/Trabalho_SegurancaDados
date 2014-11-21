package br.edu.ifnmg.alvespereira.segurancadados.entidades;

public class Atividade {

    private String nome;
    private float duração;
    private Usuario encarregado;
    private Projeto projeto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getDuração() {
        return duração;
    }

    public void setDuração(float duração) {
        this.duração = duração;
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
