package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.AtividadeDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Atividade;
import java.sql.SQLException;

public class AtividadeBO {
    
     public void criarAtividade(Atividade atividade) throws SQLException {
        
        AtividadeDAO atividadeDAO = new AtividadeDAO();
        atividadeDAO.criarAtividade(atividade);

    }

}
