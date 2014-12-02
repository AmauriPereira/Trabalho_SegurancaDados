package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.apresentacao.utilitarios.RelatorioAtividadeProjeto;
import br.edu.ifnmg.alvespereira.segurancadados.dados.AtividadeDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Atividade;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Projeto;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.atividadeExistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AtividadeBO {

    public void criarAtividade(Atividade atividade) throws SQLException, atividadeExistente {

        AtividadeDAO atividadeDAO = new AtividadeDAO();

        Atividade atividadeExistente = null;
        atividadeExistente = atividadeDAO.SelectATividadePorNome(atividade.getNome());

        if (atividadeExistente == null) {
            atividadeDAO.criarAtividade(atividade);
        } else {
            throw new atividadeExistente();
        }
    }

    public void andamentoAtividade(Atividade atividade, String atividadeSelecionada) throws SQLException {

        AtividadeDAO atividadeDAO = new AtividadeDAO();
        atividadeDAO.andamentoAtividade(atividade, atividadeSelecionada);

    }

    public void UpdateAtividade(Atividade atividade) throws SQLException, atividadeExistente {
        AtividadeDAO atividadeDAO = new AtividadeDAO();

        Atividade atividadeExistente = null;
        atividadeExistente = atividadeDAO.SelectATividadePorNome(atividade.getNome());

        if (atividadeExistente == null || atividadeExistente.getIdAtividade() == atividade.getIdAtividade()) {
            atividadeDAO.UpdateAtividade(atividade);
        } else {
            throw new atividadeExistente();
        }

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

    public ResultSet preencherTabelaAtividadeGESTAO(String codDepartamento) throws SQLException {
        AtividadeDAO atividadeDAO = new AtividadeDAO();
        ResultSet resultPreencherTabela = atividadeDAO.preencherTabelaATividadeGESTAO(codDepartamento);

        return resultPreencherTabela;

    }

    public ResultSet preencherTabelaAtividadesPesquisadasGESTAO(String NomeAtividade, String codDepartamento) throws SQLException {
        AtividadeDAO atividadeDAO = new AtividadeDAO();
        ResultSet resultPreencherTabela = atividadeDAO.preencherTabelaATividadePesquisadasGESTAO(NomeAtividade, codDepartamento);

        return resultPreencherTabela;

    }

    public void deleteAtividade(int IDatividade) throws SQLException {

        AtividadeDAO atividadeDAO = new AtividadeDAO();
        atividadeDAO.DeleteAtividade(IDatividade);

    }

}
