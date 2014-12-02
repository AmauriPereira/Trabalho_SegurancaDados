/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.alvespereira.segurancadados.apresentacao.utilitarios;

import java.util.Date;

/**
 *
 * @author Amauri
 */
public class RelatorioProjetos {

    private int idProjeto;
    private String nome;
    private String nomeDepartamento;
    private String nomeGerenteDepartamento;
    private Date dataInicioProjeto;
    private Date dataTerminoProjeto;
    private int qtdAtividade;
    private int qtdAtividadeConcluida;
    private float percentualConclusao;

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public String getNomeGerenteDepartamento() {
        return nomeGerenteDepartamento;
    }

    public void setNomeGerenteDepartamento(String nomeGerenteDepartamento) {
        this.nomeGerenteDepartamento = nomeGerenteDepartamento;
    }

    public Date getDataInicioProjeto() {
        return dataInicioProjeto;
    }

    public void setDataInicioProjeto(Date dataInicioProjeto) {
        this.dataInicioProjeto = dataInicioProjeto;
    }

    public Date getDataTerminoProjeto() {
        return dataTerminoProjeto;
    }

    public void setDataTerminoProjeto(Date dataTerminoProjeto) {
        this.dataTerminoProjeto = dataTerminoProjeto;
    }

    public int getQtdAtividade() {
        return qtdAtividade;
    }

    public void setQtdAtividade(int qtdAtividade) {
        this.qtdAtividade = qtdAtividade;
    }

    public int getQtdAtividadeConcluida() {
        return qtdAtividadeConcluida;
    }

    public void setQtdAtividadeConcluida(int qtdAtividadeConcluida) {
        this.qtdAtividadeConcluida = qtdAtividadeConcluida;
    }

    public float getPercentualConclusao() {        
        return 0;
    }

    public void setPercentualConclusao() {
        this.percentualConclusao = (this.getQtdAtividadeConcluida()*100)/this.getQtdAtividade();
        System.out.println(this.percentualConclusao);
    }

}
