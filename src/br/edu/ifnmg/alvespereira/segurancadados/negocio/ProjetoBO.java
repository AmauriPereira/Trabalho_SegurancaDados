package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.ProjetoDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Projeto;
import java.sql.SQLException;

public class ProjetoBO {

    public void criarProjeto(Projeto projeto) throws SQLException {
        
        ProjetoDAO projetDAO = new ProjetoDAO();
        projetDAO.criarProjeto(projeto);

    }

}
