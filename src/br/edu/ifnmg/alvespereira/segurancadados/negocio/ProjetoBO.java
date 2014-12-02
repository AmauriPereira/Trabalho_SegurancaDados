package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.apresentacao.utilitarios.RelatorioProjetos;
import br.edu.ifnmg.alvespereira.segurancadados.dados.ProjetoDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Projeto;
<<<<<<< HEAD
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
=======
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.ExcecaoprojetoExistente;
>>>>>>> origin/master
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoDeletarElemento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjetoBO {

    public void criarProjeto(Projeto projeto) throws SQLException, ExcecaoprojetoExistente {

        ProjetoDAO projetDAO = new ProjetoDAO();
        Projeto projet = new Projeto();
        projet = projetDAO.selectUmProjeto(projeto.getNome());

        if (projet == null) {
            projetDAO.criarProjeto(projeto);
        } else {
            throw new ExcecaoprojetoExistente();
        }

    }

    public void UpdateProjeto(Projeto projeto) throws SQLException, ExcecaoprojetoExistente {

        ProjetoDAO projetDAO = new ProjetoDAO();
        Projeto projet = new Projeto();
        projet = projetDAO.selectUmProjeto(projeto.getNome());

        if (projet == null || projet.getIdProjeto() == projeto.getIdProjeto()) {
            projetDAO.AtualizarProjeto(projeto);
        } else {
            throw new ExcecaoprojetoExistente();
        }

    }

    public void DeleteProjeto(Projeto projeto) throws SQLException, excecaoDeletarElemento {

        ProjetoDAO projetDAO = new ProjetoDAO();
        projetDAO.DeleteProjeto(projeto);

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
    
    public ArrayList<String> ComboBoxEscolhaProjeto(String codDepartamento) throws SQLException {

        ProjetoDAO projetoDAO = new ProjetoDAO();
        ArrayList<String> Projeto = new ArrayList<>();

        Projeto = projetoDAO.cbEscolhaProjetos(codDepartamento);

        return Projeto;

    }

    public ArrayList<String> CMBProjeto(String CodDepartamento) throws SQLException {

        ProjetoDAO projetoDAO = new ProjetoDAO();
        ArrayList<String> Projeto = new ArrayList<>();

        Projeto = projetoDAO.CMBProjetos(CodDepartamento);

        return Projeto;

    }

    public ResultSet preencheTabela(String Departamento) throws SQLException {
        ProjetoDAO projet = new ProjetoDAO();
        ResultSet resultPreencherTabela = projet.preencherTabela(Departamento);

        return resultPreencherTabela;

    }

    public ResultSet pesquisa(String NomeProjeto, String Departamento) throws SQLException {
        ProjetoDAO projet = new ProjetoDAO();
        ResultSet resultPesquisa = projet.pesquisa(NomeProjeto, Departamento);

        return resultPesquisa;

    }

    public ArrayList<RelatorioProjetos> listaProjeto(Usuario usuario) throws SQLException {

        ProjetoDAO projetoDAO = new ProjetoDAO();
        ArrayList<RelatorioProjetos> listaProjeto = new ArrayList<>();

        listaProjeto = projetoDAO.listaProjeto(usuario);

        return listaProjeto;

    }

}
