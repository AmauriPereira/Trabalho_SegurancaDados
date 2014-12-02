package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.apresentacao.utilitarios.RelatorioAtividadeProjeto;
import br.edu.ifnmg.alvespereira.segurancadados.dados.AtividadeDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Atividade;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Projeto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AtividadeBO {

    public void criarAtividade(Atividade atividade) throws SQLException {

        AtividadeDAO atividadeDAO = new AtividadeDAO();
        atividadeDAO.criarAtividade(atividade);

    }

    public void andamentoAtividade(Atividade atividade, String atividadeSelecionada) throws SQLException {

        AtividadeDAO atividadeDAO = new AtividadeDAO();
        atividadeDAO.andamentoAtividade(atividade, atividadeSelecionada);

    }

    public ArrayList<String> ComboBoxAtividades(String nomeUsuario) throws SQLException {

        AtividadeDAO atividadeDAO = new AtividadeDAO();
        ArrayList<String> Atividades = new ArrayList<>();

        Atividades = atividadeDAO.cbAtividades(nomeUsuario);

        return Atividades;

    }

    public ResultSet preencherTabelaAtividadeAtrasadas(String codDepartamento) throws SQLException {
        AtividadeDAO atividadeDAO = new AtividadeDAO();
        ResultSet resultPreencherTabela = atividadeDAO.preencherTabelaAtividadeAtrasadas(codDepartamento);

        return resultPreencherTabela;

    }
    
    public ArrayList<RelatorioAtividadeProjeto> listaAtividade(String nomeProjeto) throws SQLException {

        AtividadeDAO atividadeDAO = new AtividadeDAO();
        ArrayList<RelatorioAtividadeProjeto> listaAtividade = new ArrayList<>();

        listaAtividade = atividadeDAO.listaAtividade(nomeProjeto);

        return listaAtividade;

    }

}
