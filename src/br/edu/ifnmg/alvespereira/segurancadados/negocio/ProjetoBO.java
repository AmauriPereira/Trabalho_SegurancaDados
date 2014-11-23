package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.ProjetoDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Projeto;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjetoBO {

    public void criarProjeto(Projeto projeto) throws SQLException {

        ProjetoDAO projetDAO = new ProjetoDAO();
        projetDAO.criarProjeto(projeto);

    }

    public Projeto selectUmProjeto(String NomeProjeto) throws SQLException {

        ProjetoDAO projetDAO = new ProjetoDAO();
        Projeto projet = new Projeto();
        projet = projetDAO.selectUmProjeto(NomeProjeto);

        return projet;

    }

    public Projeto selectTodosProjeto() throws SQLException {

        ProjetoDAO projetDAO = new ProjetoDAO();
        Projeto projet = new Projeto();
        projet = projetDAO.selectTodosProjetos();

        return projet;

    }

    public ArrayList<String> ComboBoxProjeto() throws SQLException {

        ProjetoDAO projetoDAO = new ProjetoDAO();
        ArrayList<String> Projeto = new ArrayList<>();

        Projeto = projetoDAO.cbProjetos();

        return Projeto;

    }

}
