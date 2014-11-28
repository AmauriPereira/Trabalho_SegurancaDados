package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.AtividadeDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Atividade;
import java.sql.SQLException;
import java.util.ArrayList;

public class AtividadeBO {

    public void criarAtividade(Atividade atividade) throws SQLException {

        AtividadeDAO atividadeDAO = new AtividadeDAO();
        atividadeDAO.criarAtividade(atividade);

    }

    public ArrayList<String> ComboBoxAtividades(String usuario) throws SQLException {

        AtividadeDAO atividadeDAO = new AtividadeDAO();
        ArrayList<String> Atividades = new ArrayList<>();

        Atividades = atividadeDAO.cbAtividades(usuario);

        return Atividades;

    }
}
